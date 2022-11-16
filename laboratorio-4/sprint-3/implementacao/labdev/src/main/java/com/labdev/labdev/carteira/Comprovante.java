package com.labdev.labdev.carteira;

import java.time.LocalDateTime;

public class Comprovante {

    private LocalDateTime data;
    private String remetente;
    private String destinatario;
    private int valor;

    public Comprovante(
            LocalDateTime data,
            String remetente,
            String destinatario,
            int valor
    ) {
        this.data = data;
        this.remetente = remetente;
        this.destinatario = destinatario;
        this.valor = valor;
    }

    public String relatorio() {
        return ""+this.data+this.remetente+this.destinatario+this.valor;
    }
}
