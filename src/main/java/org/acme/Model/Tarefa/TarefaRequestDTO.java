package org.acme.Model.Tarefa;

import java.util.Date;

import org.acme.Model.Pessoa.Pessoa;

public record TarefaRequestDTO(Long id, String titulo, String descricao, Date prazo, String Departamento,
        Float duracao, Pessoa pessoa, Boolean status) {

}
