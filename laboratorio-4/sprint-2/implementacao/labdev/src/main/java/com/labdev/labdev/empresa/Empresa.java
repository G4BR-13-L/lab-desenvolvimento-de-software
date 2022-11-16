package com.labdev.labdev.empresa;

import javax.persistence.Entity;

import com.labdev.labdev.usuario.Usuario;

@Entity
public class Empresa extends Usuario {

    public Empresa(
            String nome, String email, String senha,
            String cnpj) {
        super(nome, email, senha,
                cnpj);
    }

    public void cadastrarVantagem() {

    }
}
