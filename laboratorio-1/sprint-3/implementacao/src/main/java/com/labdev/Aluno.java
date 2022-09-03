package com.labdev;

import java.util.List;

public class Aluno extends Usuario {
    private Curso curso;
    private List<Disciplina> disciplinas;

    public Aluno(String nome, String email, String senha) {
        super(nome, email, senha, TipoUsuario.ALUNO);
    }

    public Curso getCurso() {
        return curso;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void matricularEmCurso(Curso curso) {
        this.curso = curso;
    }

    public void matricularEmDisciplina(Disciplina disciplina) {
        this.disciplinas.add(disciplina);
    }
}
