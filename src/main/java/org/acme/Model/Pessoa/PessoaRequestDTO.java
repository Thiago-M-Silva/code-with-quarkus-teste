package org.acme.Model.Pessoa;

import java.util.List;

import org.acme.Model.Tarefa.Tarefa;

public record PessoaRequestDTO(Long id, String nome, String departamento, List<Tarefa> tarefas) {

}
