package com.labdev.Business.Autenticacao;

import java.io.Serializable;

public class Usuario implements Serializable {
    private int id;
    private final String nome;
    private final String email;
    private final String senha;
    private final TipoUsuario tipoUsuario;

    public Usuario(String nome, String email, String senha, TipoUsuario tipoUsuario) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.tipoUsuario = tipoUsuario;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public TipoUsuario getTipo() {
        return tipoUsuario;
    }
}
