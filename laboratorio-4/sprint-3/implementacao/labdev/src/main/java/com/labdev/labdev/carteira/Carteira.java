package com.labdev.labdev.carteira;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.labdev.labdev.carteira.extrato.Extrato;
import com.labdev.labdev.carteira.transacao.Transacao;
import com.labdev.labdev.usuario.Usuario;

import javax.persistence.JoinColumn;

@Entity
@Table( name="carteiras" )
public class Carteira {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int saldo;
    
    @OneToMany(fetch = FetchType.LAZY, 
     cascade=CascadeType.ALL)
    @JoinTable( 
        name="transacoes",
        joinColumns = @JoinColumn(name = "transacao_fk", nullable = true),
        inverseJoinColumns = @JoinColumn( name="carteira_fk")
        )
    private List<Transacao> transacoes;

    
    /*@OneToOne( mappedBy = "carteira" )
    private Usuario proprietario;*/


    public String getId(){
        return this.id+"";
    }
    public void descontarSaldo(int valor) {
        this.saldo -= valor;
    }

    public void incrementarSaldo(int valor) {
        this.saldo  += valor;
    }

    public int getSaldo() {
        return this.saldo;
    }


    public void addTransacao(Transacao transacao){
        this.transacoes.add(transacao);
    }

    /*public Usuario getProprietario(){
        return this.proprietario;
    }*/

    public List<Transacao> getTransacoes(){
        return this.transacoes;
    }

}
