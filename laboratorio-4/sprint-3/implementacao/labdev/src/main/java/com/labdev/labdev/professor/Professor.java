package com.labdev.labdev.professor;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.labdev.labdev.usuario.Usuario;
import lombok.ToString;

@ToString
@Entity
public class Professor extends Usuario{

    @Column
    private String departamento;

    public Professor(){
        
    }
    public Professor(
            String nome, String email, String senha,
            String cpf, String rg) {
        super(nome, email, senha, cpf, rg);
    }

}
