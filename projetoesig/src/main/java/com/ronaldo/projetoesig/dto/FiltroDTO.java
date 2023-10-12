package com.ronaldo.projetoesig.dto;

import com.ronaldo.projetoesig.enums.Situacao;
import com.ronaldo.projetoesig.model.Responsavel;

public class FiltroDTO {

    public Long id;
    public String titulo;
    public Responsavel responsavel;
    public Situacao situacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Responsavel getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Responsavel responsavel) {
        this.responsavel = responsavel;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }
}
