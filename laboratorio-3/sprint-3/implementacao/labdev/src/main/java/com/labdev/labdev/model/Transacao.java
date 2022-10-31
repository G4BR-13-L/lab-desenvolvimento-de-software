package com.labdev.labdev.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;

import javax.persistence.Entity;

@Entity
public class Transacao implements Serializable{

    private LocalDateTime data;
    private BigInteger valor;
    private Usuario remetente;
    private Usuario destinatario;

    public Transacao(Usuario remetente)


}
