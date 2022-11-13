package com.labdev.labdev.model;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class CarteiraProfessor extends Carteira {

    @OneToOne( mappedBy = "carteira" )
    private Professor professor;

    public void transferir(Professor professor, Aluno aluno, BigInteger valor, String motivo) {

    }
}
