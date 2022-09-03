package com.labdev;

import java.util.List;

public class Curso {
    private final String nome;
    private final int creditos;
    private List<Disciplina> disciplinas;

    private List<Aluno> alunos;

    public Curso(String nome, int creditos) {
        this.nome = nome;
        this.creditos = creditos;
    }

    public String getNome() {
        return nome;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void matricularAluno(Aluno aluno) {
        this.alunos.add(aluno);
    }

    public void adicionarDisciplina(Disciplina disciplina) {
        this.disciplinas.add(disciplina);
    }

    @Override
    public String toString() {
        return String.format("Nome: %s\nCréditos: %d\n", this.nome, this.creditos);
    }
}
