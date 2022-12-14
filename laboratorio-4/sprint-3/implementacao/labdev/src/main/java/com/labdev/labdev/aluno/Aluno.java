package com.labdev.labdev.aluno;

import javax.persistence.Column;
import javax.persistence.Entity;
//
import com.labdev.labdev.usuario.Usuario;
import lombok.ToString;

@ToString
@Entity
public class Aluno extends Usuario {
    @Column
    private int semestre;

    public Aluno(){}
    public Aluno(
            String nome, String email, String senha,
            String cpf, String rg) {
        super(nome, email, senha, cpf, rg);
    }
}
