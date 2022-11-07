package com.labdev.labdev.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Transacao implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private LocalDateTime data;

    @Column
    private BigInteger valor;

    @OneToOne
    private Usuario remetente;

    @OneToOne
    private Usuario destinatario;

    public Transacao(Usuario remetente, Usuario destinatario, BigInteger valor) {
        this.valor = valor;
        this.remetente = remetente;
        this.destinatario = destinatario;
    }

    public String relatorio() {
        return "";
    }

}
