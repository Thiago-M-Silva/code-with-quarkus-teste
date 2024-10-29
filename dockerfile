# Etapa 1: Construção da aplicação
FROM maven:3.8.6-openjdk-17 AS build
WORKDIR /app

# Copiar o arquivo pom.xml e as dependências para a camada de build
COPY pom.xml ./
RUN mvn dependency:go-offline

# Copiar o código-fonte e compilar
COPY src ./src
RUN mvn package -DskipTests

# Etapa 2: Imagem final para execução da aplicação
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copiar o JAR construído
COPY --from=build /app/target/*-runner.jar app.jar

# Definir as variáveis de ambiente
ENV quarkus.datasource.db-kind=postgresql \
    quarkus.datasource.username=postgres \
    quarkus.datasource.password=admin \
    quarkus.datasource.jdbc.url=jdbc:postgresql://postgres:5432/postgres \
    quarkus.datasource.jdbc.max-size=8 \
    quarkus.datasource.jdbc.min-size=2 \
    quarkus.hibernate-orm.database.generation=drop-and-create

# Expor a porta da aplicação
EXPOSE 8080

# Comando para iniciar a aplicação
CMD ["java", "-jar", "app.jar"]
