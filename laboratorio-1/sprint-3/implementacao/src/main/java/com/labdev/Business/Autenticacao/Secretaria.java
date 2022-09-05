package com.labdev.Business.Autenticacao;

public class Secretaria extends Usuario {
    public Secretaria(String nome, String email, String senha) {
        super(nome, email, senha, TipoUsuario.SECRETARIA);
    }
}
