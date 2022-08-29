package com.labdev;

public class Professor extends Usuario {
    private double salario;

    public Professor() {
        super();
        this.salario = 0;
    }

    public Professor(String nome, String email, String senha, double salario) {
        super(nome, email, senha);
        this.salario = salario;
    }
}
