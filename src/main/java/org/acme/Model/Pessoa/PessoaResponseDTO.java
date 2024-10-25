package org.acme.Model.Pessoa;

import java.util.List;

import org.acme.Model.Tarefa.Tarefa;

public record PessoaResponseDTO(Long id, String nome, String departamento, List<Tarefa> tarefa) {

    public PessoaResponseDTO(Pessoa pessoa) {
        this(
                pessoa.getId(),
                pessoa.getNome(),
                pessoa.getDepartamento(),
                pessoa.getTarefas()
        );
    }

}
