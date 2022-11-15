package com.labdev.labdev.carteira.transacao;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.labdev.labdev.carteira.Carteira;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transacao implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private LocalDateTime data;

    @Column
    private int valor;

    @OneToOne(mappedBy = "transacoes")
    private Carteira remetente;

    @OneToOne(mappedBy = "transacoes")
    private Carteira destinatario;

    public Transacao(Carteira remetente, Carteira destinatario, int valor) {
        this.valor = valor;
        this.remetente = remetente;
        this.destinatario = destinatario;
    }

    public String relatorio() {
        return "";
    }



    public long getId() {
        return id;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Carteira getRemetente() {
        return remetente;
    }

    public void setRemetente(Carteira remetente) {
        this.remetente = remetente;
    }

    public Carteira getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Carteira destinatario) {
        this.destinatario = destinatario;
    }

}
