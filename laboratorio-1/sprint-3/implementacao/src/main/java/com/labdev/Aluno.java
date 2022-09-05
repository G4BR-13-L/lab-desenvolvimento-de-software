package com.labdev;

import java.util.List;

public class Aluno extends Usuario {
    private Curso curso;

    public Aluno(String nome, String email, String senha) {
        super(nome, email, senha, TipoUsuario.ALUNO);
    }

    public Curso getCurso() {
        return curso;
    }

    public void matricularEmCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return String.format("Nome: %s\nCurso: %s\n", this.getNome(), this.curso.getNome());
    }
}
