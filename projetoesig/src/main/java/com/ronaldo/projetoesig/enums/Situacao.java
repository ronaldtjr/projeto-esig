package com.ronaldo.projetoesig.enums;

public enum Situacao {

    EM_ANDAMENTO("Em andamento"),
    CONCLUIDO("Concluído");

    private final String situacaoMensagem;

    Situacao(String situacaoMensagem) {
        this.situacaoMensagem = situacaoMensagem;
    }
}
