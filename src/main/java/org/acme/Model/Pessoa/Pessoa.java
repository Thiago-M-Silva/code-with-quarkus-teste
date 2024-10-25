package org.acme.Model.Pessoa;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

import org.acme.Model.Tarefa.Tarefa;

@Table(name = "pessoa")
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pessoa_id")
    private Long id;
    private String nome;
    private String departamento;
    @OneToMany
    @JoinColumn(name = "tarefa_id")
    private List<Tarefa> tarefas = new ArrayList<>();

    public Pessoa(PessoaRequestDTO data) {
        this.nome = data.nome();
        this.departamento = data.departamento();
        this.tarefas = data.tarefas();
    }

    public void addPessoa(Tarefa tarefa) {
        tarefas.add(tarefa);
        tarefa.setPessoa(this);
    }

    public void removePessoa(Tarefa tarefa) {
        this.tarefas.remove(tarefa);
        tarefa.setPessoa(null);
    }
}
