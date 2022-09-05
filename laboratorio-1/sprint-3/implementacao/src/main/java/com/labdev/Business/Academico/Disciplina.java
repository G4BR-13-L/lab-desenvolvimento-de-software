package com.labdev.Business.Academico;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.labdev.Business.Autenticacao.Aluno;

public class Disciplina implements Serializable{
    private final String nome;
    private final Curso curso;
    private final TipoDisciplina tipoDisciplina;
    private boolean isLecionada;
    private final List<Aluno> alunos;

    public Disciplina(String nome, Curso curso, TipoDisciplina tipoDisciplina) {
        this.nome = nome;
        this.curso = curso;
        this.tipoDisciplina = tipoDisciplina;
        this.isLecionada = true;
        this.alunos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipoDisciplina.toString();
    }

    public List<Aluno> getAlunos() {
        return alunos;
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

    public void matricularAluno(Aluno aluno) {
        if(this.alunos.contains(aluno))
            return;

        this.alunos.add(aluno);
    }

}
