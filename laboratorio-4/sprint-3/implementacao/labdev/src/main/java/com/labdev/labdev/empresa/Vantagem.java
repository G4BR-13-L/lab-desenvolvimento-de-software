package com.labdev.labdev.empresa;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vantagem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private long id;


    private String nome;
    private String descricao;
    private String foto;
    private int custo;

    public Vantagem(String nome, String descricao, String foto, int custo) {
        this.nome = nome;
        this.descricao = descricao;
        this.foto = foto;
        this.custo = custo;
    }

    

}
