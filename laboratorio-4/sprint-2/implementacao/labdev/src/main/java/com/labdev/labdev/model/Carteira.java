package com.labdev.labdev.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Carteira {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private long id;
    private int saldo;

    @ManyToMany
    private List<Transacao> transacoes;

    public Extrato consultarExtrato() {
        Extrato e = new Extrato();
        return e;
    }

    private void descontarSaldo(int valor) {

    }

    public void incrementarSaldo(int valor) {
        this.saldo  += valor;
    }

    public int totalMoedas() {
        return this.saldo;
    }

}
