package com.labdev.labdev.carteira;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import com.labdev.labdev.aluno.Aluno;
import com.labdev.labdev.professor.Professor;

@Entity
public class CarteiraProfessor extends Carteira {

    @OneToOne( mappedBy = "carteira" )
    private Professor professor;

    public void transferir(Professor professor, Aluno aluno, BigInteger valor, String motivo) {

    }
}
