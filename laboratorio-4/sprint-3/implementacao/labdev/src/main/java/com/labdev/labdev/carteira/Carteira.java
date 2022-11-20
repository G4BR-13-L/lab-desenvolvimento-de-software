package com.labdev.labdev.carteira;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.labdev.labdev.carteira.resgate.ResgateVantagem;
import com.labdev.labdev.carteira.transacao.Transacao;
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

    @OneToMany(fetch = FetchType.LAZY, 
     cascade=CascadeType.ALL)
    @JoinTable( 
        name="vantagens_resgatadas",
        joinColumns = @JoinColumn(name = "resgate_fk", nullable = true),
        inverseJoinColumns = @JoinColumn( name="carteira_fk")
        )
    private List<ResgateVantagem> vantagens_resgatadas;

    
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

    public void addResgateVantagem(ResgateVantagem vantagem_resgatada){
        this.vantagens_resgatadas.add(vantagem_resgatada);
    }

    public List<ResgateVantagem> getVantagensResgatadas(){
        return this.vantagens_resgatadas;
    }
}
