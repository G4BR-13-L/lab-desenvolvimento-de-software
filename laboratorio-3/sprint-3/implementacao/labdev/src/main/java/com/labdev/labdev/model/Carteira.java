package com.labdev.labdev.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.ManyToAny;


@Entity
public class Carteira implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private long id;
    private BigInteger saldo;

    @ManyToMany
    private List<Transacao> transacoes;

    public Extrato consultarExtrato(){
        Extrato e = new Extrato();
        return e;
    }
    private void descontarSaldo(int valor){

    }
    public BigInteger totalMoedas(){
        return this.saldo;
    }

}
