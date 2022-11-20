package com.labdev.labdev.carteira.extrato;

import java.util.List;

import com.labdev.labdev.carteira.transacao.Transacao;

public class Extrato {
    private int saldo;
    private List<Transacao> transacoes;

    public Extrato( List<Transacao> transacoes, int saldo ){
        this.transacoes = transacoes;
        this.saldo = saldo;
    }
}
