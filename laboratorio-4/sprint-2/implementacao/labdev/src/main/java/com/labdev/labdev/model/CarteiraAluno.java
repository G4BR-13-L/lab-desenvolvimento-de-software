package com.labdev.labdev.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class CarteiraAluno extends Carteira {

    @OneToOne( mappedBy = "carteira" )
    private Aluno aluno;

    public void trocarMoedas( Vantagem vantagem ){

    }
}
