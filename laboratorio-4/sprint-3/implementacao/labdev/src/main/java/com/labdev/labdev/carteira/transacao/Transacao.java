package com.labdev.labdev.carteira.transacao;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;
import org.springframework.lang.Nullable;

import com.labdev.labdev.carteira.Carteira;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Entity
@Data
@Table
public class Transacao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    @Nullable
    private LocalDateTime data;

    @Column
    private int valor = 0;

    /*@ManyToMany(mappedBy = "transacoes")
    private List<Carteira> carteiras = new ArrayList<Carteira>();*/

    public Transacao(){

    }
    public Transacao(Carteira remetente, Carteira destinatario, int valor) {
        this.data = LocalDateTime.now();
        this.valor = valor;
        //this.carteiras.add(remetente);
        //this.carteiras.add(destinatario);
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

    /*public Carteira getRemetente() {
        return this.carteiras.get(0);
    }

    public void setRemetente(Carteira remetente) {
        this.carteiras.add(0, remetente);
    }

    public Carteira getDestinatario() {
        return this.carteiras.get(1);
    }

    public void setDestinatario(Carteira destinatario) {
        this.carteiras.add(1, destinatario);
    }*/

}
