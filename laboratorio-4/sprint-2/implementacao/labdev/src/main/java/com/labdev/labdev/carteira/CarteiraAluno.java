package com.labdev.labdev.carteira;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.labdev.labdev.aluno.Aluno;
import com.labdev.labdev.model.Vantagem;

@Entity
public class CarteiraAluno extends Carteira {

    @OneToOne( mappedBy = "carteira" )
    private Aluno aluno;

    public void trocarMoedas( Vantagem vantagem ){

    }
}
