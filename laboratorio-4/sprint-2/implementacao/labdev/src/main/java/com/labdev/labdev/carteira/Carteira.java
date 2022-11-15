package com.labdev.labdev.carteira;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;

import com.labdev.labdev.model.transacao.Transacao;

@Entity
public class Carteira {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private long id;
    private int saldo;

    @OneToMany
    @JoinTable(
        name="transacao",
        joinColumns = @JoinColumn(name = "transacao_id"),
        inverseJoinColumns = @JoinColumn( name="carteira_id" )
    )
    private List<Transacao> transacoes;

    public Extrato consultarExtrato() {
        Extrato e = new Extrato();
        return e;
    }

    public void descontarSaldo(int valor) {

    }

    public void incrementarSaldo(int valor) {
        this.saldo  += valor;
    }

    public int totalMoedas() {
        return this.saldo;
    }

    public void addTransacao(Transacao transacao){
        this.transacoes.add(transacao);
    }

}
