package org.acme.Model.Pessoa;

import java.util.List;

import org.acme.Model.Departamento.DepartamentoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    @Query(
            "SELECT p.nome, p.departamento"
            + "SUM(t.duracao)"
            + "FROM Pessoa p "
            + "LEFT JOIN p.tarefas t"
            + "GROUP BY p.id"
    )
    List<PessoaResponseDTO> listPessoaHoraTarefa();

    @Query(
            "SELECT p.nome, p.departamento, AVG(t.duracao)"
            + "FROM Pessoa p "
            + "JOIN p.tarefas "
            + "WHERE p.nome = :nome "
            + "AND :inicio > t.prazo AND t.prazo > :fim "
            + "GROUP BY p.id"
    )
    List<PessoaResponseDTO> getMediaTarefa(@Param("nome") String nome, @Param("inicio") Long inicio, @Param("fim") Long fim);

    @Query(
            "SELECT p"
            + "FROM Pessoa p"
            + "WHERE p.departamento = :departamento"
    )
    List<Pessoa> findByDepartamento(String departamento);

    @Query("SELECT p.departamento, COUNT(DISTINCT p), COUNT(t) "
            + "FROM Pessoa p "
            + "LEFT JOIN p.tarefas t "
            + "GROUP BY p.departamento")
    List<DepartamentoDTO> listarDepartamentos();
}
