package com.labdev;

import com.labdev.Usuario;

public class Aluno extends Usuario {
    private final int MAX_DISC_OBRIGATORIAS = 4;
    private final int MAX_DISC_OPTATIVAS = 2;

    public Aluno() {
        super();
    }

    public Aluno(String nome, String email, String senha) {
        super(nome, email, senha);
    }

    public void matricular() {
    }

    public void cancelarMatricula() {
    }

    public void pagarMensalidade() {
    }
}
