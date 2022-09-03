package com.labdev;

public enum TipoDisciplina {
    OBRIGATORIA("Obrigatoria"),
    OPTATIVA("Optativa");

    private final String nome;

    TipoDisciplina(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return this.nome;
    }
}
