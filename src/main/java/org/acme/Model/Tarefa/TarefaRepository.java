package org.acme.Model.Tarefa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

    // @Query(
    //         "SELECT t"
    //         + "FROM tarefa t"
    //         + "WHERE t.pessoa IS NULL"
    //         + "ORDER BY t.prazo ASC"
    // )
    // List<Tarefa> getPendentes(Pageable pageable);
    // default List<Tarefa> get3Pendentes() {
    //     return getPendentes(PageRequest.of(0, 3));
    // }
}
