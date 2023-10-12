package com.ronaldo.projetoesig.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ronaldo.projetoesig.dto.TarefaDTO;
import com.ronaldo.projetoesig.enums.Prioridade;
import com.ronaldo.projetoesig.enums.Situacao;
import jakarta.persistence.*;
import lombok.Builder;

import java.util.Date;

@Builder
@Entity
public class Tarefa {
    @Id
    @GeneratedValue
    private Long id;
    private String titulo;
    private String descricao;

    @Column
    @Enumerated(EnumType.STRING)
    private Prioridade prioridade;

    private Date deadline;

    @Column
    @Enumerated(EnumType.STRING)
    private Situacao situacao;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "responsavel_id", nullable = false)
    private Responsavel responsavel;

    public static Tarefa from(TarefaDTO dto) {
        return Tarefa.builder()
                .id(dto.getId())
                .deadline(dto.getDeadline())
                .descricao(dto.getDescricao())
                .titulo(dto.getTitulo())
                .prioridade(Prioridade.fromValorNumerico(dto.getPrioridade()))
                .responsavel(null)
                .situacao(null)
                .build();
    }

    public Tarefa(Long id, String titulo, String descricao, Prioridade prioridade, Date deadline, Situacao situacao, Responsavel responsavel) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.deadline = deadline;
        this.situacao = situacao;
        this.responsavel = responsavel;
    }

    public Tarefa() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String nome) {
        this.titulo = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Responsavel getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Responsavel responsavel) {
        this.responsavel = responsavel;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }
}
