package com.labdev.labdev.carteira.extrato;

import java.util.List;

import com.labdev.labdev.carteira.transacao.Transacao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@AllArgsConstructor
public class Extrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int saldo;
    private List<Transacao> transacoes;

    public Extrato( List<Transacao> transacoes, int saldo ){
        this.transacoes = transacoes;
        this.saldo = saldo;
    }
}
