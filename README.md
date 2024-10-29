# API de Tarefas - wip

## Sobre:
Uma API de alocação de tarefas à colaboradores, permite adicionar tarefas novas, alocá-las à um colaborador 
cadastrado, verificar tarefas pendentes, alterar status de uma tarefa além de permitir a execução de um CRUD
(criar, ler, atualizar e deletar) de colaboradores.
## Objetivo:
Projeto realizado como parte de um processo seletivo para desenvolvedor backend Java e uso como forma de
estudar o framework Quarkus
## Tecnologias:
Java, Quarkus (com os modulos, Rest, Spring web, hibernate orm, spring data jpa), Docker
## Como executar:
Voce pode executar o seguinte comando ´´´mvn compile quarkus:dev´´´ no terminal. Mas é importante que possua
a versão 17 do JDK instalado em sua máquina.
## Funcionalidades:
- CRUD de pessoas
- Tempo médio de execução de uma tarefa por pessoa
- CRUD de tarefas
- Listagem de tarefas pendentes
- Listagem de departamentos
- Adicionar tarefa a uma pessoa
## TODO:
- Corrigir as consultas
- Corrigir os arquivos docker