package com.labdev.labdev.model;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Entity;

@Entity
public class CarteiraProfessor extends Carteira {

    public void transferir(Professor professor, Aluno aluno, BigInteger valor, String motivo){

    }
}
