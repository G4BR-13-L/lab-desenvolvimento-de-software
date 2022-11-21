package com.labdev.labdev.email;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class Email {

    private String remetente;
    private String destinatario;
    private String assunto;
    private String conteudo;

    public Email(
            String remetente,
            String destinatario,
            String assunto,
            String conteudo) {
        this.remetente = remetente;
        this.destinatario = destinatario;
        this.assunto = assunto;
        this.conteudo = conteudo;
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
     * @return String return the assunto
     */
    public String getAssunto() {
        return assunto;
    }

    /**
     * @param assunto the assunto to set
     */
    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    /**
     * @return String return the conteudo
     */
    public String getConteudo() {
        return conteudo;
    }

    /**
     * @param conteudo the conteudo to set
     */
    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

}
