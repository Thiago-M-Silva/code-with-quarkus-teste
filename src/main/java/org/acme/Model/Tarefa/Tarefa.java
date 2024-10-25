package org.acme.Model.Tarefa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

import org.acme.Model.Pessoa.Pessoa;

@Table(name = "tarefa")
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tarefa_id")
    private Long id;
    private String titulo;
    private String descricao;
    private Date prazo;
    private String departamento;
    private Float duracao;
    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;
    private Boolean status; //true = ativo e false = finalizado

    public Tarefa(TarefaRequestDTO data) {
        this.titulo = data.titulo();
        this.descricao = data.descricao();
        this.departamento = data.Departamento();
        this.prazo = data.prazo();
        this.duracao = data.duracao();
        this.pessoa = data.pessoa();
        this.status = data.status();
    }
}
