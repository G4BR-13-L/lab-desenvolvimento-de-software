package com.labdev.labdev.model;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Instituicao extends PessoaJuridica {

    public static int MOEDAS_POR_SEMESTRE = 1000;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "professor_id")
    private List<Professor> professores = new ArrayList<>();

    public void cadastrarProfessores(List<Professor> professores){

    }

    public void distribuirMoedas(int moedas) {
        this.professores.stream().forEach( (p) -> p.getCarteira().incrementarSaldo(moedas));
    }

    public void distribuirMoedas(int moedas, Professor Professor) {

    }

    public void setProfessores(List<Professor> professores) {
        this.professores = professores;
    }
}
