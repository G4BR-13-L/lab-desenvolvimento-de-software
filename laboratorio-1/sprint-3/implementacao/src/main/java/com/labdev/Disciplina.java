package com.labdev;

import java.io.Serializable;

public class Disciplina implements Serializable{
    private final String nome;
    private final Curso curso;
    private final TipoDisciplina tipoDisciplina;
    private boolean isLecionada;

    public Disciplina(String nome, Curso curso, TipoDisciplina tipoDisciplina) {
        this.nome = nome;
        this.curso = curso;
        this.tipoDisciplina = tipoDisciplina;
        this.isLecionada = true;
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

    public boolean isLecionada() {
        return this.isLecionada;
    }

    public void suspenderDisciplina(){
        this.isLecionada = false;
    }

    public void ofertarDisciplina(){
        this.isLecionada = true;
    }

}
