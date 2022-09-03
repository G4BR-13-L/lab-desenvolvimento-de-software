package com.labdev;

public class Usuario {
    private String nome;
    private String email;
    private String senha;
    private int id;
    public Usuario() {
        this.id = 0;
        this.nome = "";
        this.email = "";
        this.senha = "";
    }

    public Usuario(String nome, String email, String senha) {
        this.id = 0;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    private void registrar() {
    }

    private void login() {
    }
}
