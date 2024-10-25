package org.acme.Model.Tarefa;

import java.util.Date;
import java.util.List;

import org.acme.Model.Pessoa.Pessoa;

public record TarefaResponseDTO(Long id, String titulo, String descricao, Date prazo, String Departamento,
        Float duracao, Pessoa pessoa, Boolean status) {

    public TarefaResponseDTO(Tarefa tarefa) {
        this(
                tarefa.getId(),
                tarefa.getTitulo(),
                tarefa.getDescricao(),
                tarefa.getPrazo(),
                tarefa.getDepartamento(),
                tarefa.getDuracao(),
                tarefa.getPessoa(),
                tarefa.getStatus()
        );
    }
}
