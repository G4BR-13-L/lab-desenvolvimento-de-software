package com.labdev.labdev.carteira;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import com.labdev.labdev.aluno.Aluno;
import com.labdev.labdev.empresa.Vantagem;

@Entity
public class CarteiraAluno extends Carteira {

    @OneToOne( mappedBy = "carteira" )
    private Aluno aluno;

    public void trocarMoedas( Vantagem vantagem ){

    }
}
