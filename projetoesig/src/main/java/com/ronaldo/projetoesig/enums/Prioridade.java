package com.ronaldo.projetoesig.enums;

public enum Prioridade {
    ALTA(1, "ALTA"),
    MEDIA(2, "MEDIA"),
    BAIXA(3, "BAIXA");

    private final int valorNumerico;
    private final String prioridadeMensagem;

    Prioridade(int valorNumerico, String prioridadeMensagem) {
        this.valorNumerico = valorNumerico;
        this.prioridadeMensagem = prioridadeMensagem;
    }

    public static Prioridade fromValorNumerico(int valorNumerico) {
        for (Prioridade prioridade : Prioridade.values()) {
            if (prioridade.valorNumerico == valorNumerico) {
                return prioridade;
            }
        }
        throw new IllegalArgumentException("Valor numérico inválido: " + valorNumerico);
    }

}
