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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;
import org.springframework.lang.Nullable;

import com.labdev.labdev.carteira.Carteira;
import com.labdev.labdev.usuario.Usuario;
import javax.persistence.JoinColumn;
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
    private long remetente_id; 
    private long destinatario_id;
    
    /*@ManyToMany(mappedBy = "transacoes")
    private List<Carteira> carteiras = new ArrayList<Carteira>();*/

    public Transacao(){

    }
    public Transacao(long remetente_id, long destinatario_id, int valor) {
        this.data = LocalDateTime.now();
        this.valor = valor;
        this.remetente_id = remetente_id;
        this.destinatario_id = destinatario_id;
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
    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    


    /**
     * @return long return the remetente_id
     */
    public long getRemetente_id() {
        return remetente_id;
    }

    /**
     * @param remetente_id the remetente_id to set
     */
    public void setRemetente_id(long remetente_id) {
        this.remetente_id = remetente_id;
    }

    /**
     * @return long return the destinatario_id
     */
    public long getDestinatario_id() {
        return destinatario_id;
    }

    /**
     * @param destinatario_id the destinatario_id to set
     */
    public void setDestinatario_id(long destinatario_id) {
        this.destinatario_id = destinatario_id;
    }

}
