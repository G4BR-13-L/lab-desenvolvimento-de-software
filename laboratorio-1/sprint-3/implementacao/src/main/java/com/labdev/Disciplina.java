package com.labdev;

public class Disciplina {
    private final String nome;
    private final Curso curso;
    private final TipoDisciplina tipoDisciplina;

    public Disciplina(String nome, Curso curso, TipoDisciplina tipoDisciplina) {
        this.nome = nome;
        this.curso = curso;
        this.tipoDisciplina = tipoDisciplina;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipoDisciplina.toString();
    }

    @Override
    public String toString() {
        return String.format("Nome: %s\nTipo: %s", this.nome, this.getTipo());
    }
}
