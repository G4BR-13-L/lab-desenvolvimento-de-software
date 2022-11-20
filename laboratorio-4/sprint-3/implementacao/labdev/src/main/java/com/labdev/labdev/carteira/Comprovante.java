package com.labdev.labdev.carteira;

import java.time.LocalDateTime;

public class Comprovante {

    private LocalDateTime data;
    private String remetente;
    private String destinatario;
    private int valor;

    public Comprovante(){}
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

    /**
     * @return LocalDateTime return the data
     */
    public LocalDateTime getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(LocalDateTime data) {
        this.data = data;
    }

    /**
     * @return String return the remetente
     */
    public String getRemetente() {
        return remetente;
    }

    /**
     * @param remetente the remetente to set
     */
    public void setRemetente(String remetente) {
        this.remetente = remetente;
    }

    /**
     * @return String return the destinatario
     */
    public String getDestinatario() {
        return destinatario;
    }

    /**
     * @param destinatario the destinatario to set
     */
    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    /**
     * @return int return the valor
     */
    public int getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(int valor) {
        this.valor = valor;
    }

}
