package com.labdev.labdev.carteira.resgate;

import java.time.LocalDateTime;

import com.labdev.labdev.carteira.cupom.Cupom;
import com.labdev.labdev.vantagem.Vantagem;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class ResgateVantagem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private LocalDateTime data;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinTable(
        name="cupom_resgate_vantagem",
        joinColumns = @JoinColumn( name="cupom_id", nullable = true ),
        inverseJoinColumns = @JoinColumn( name="resgate_vantagem_id")

    )
    private Cupom cupom;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "vantagen_resgatada", joinColumns = @JoinColumn(name = "vantagem_fk", nullable = true))
    private Vantagem vantagem;

    public ResgateVantagem(Vantagem vantagem, Cupom cupom) {
        this.vantagem = vantagem;
        this.data = LocalDateTime.now();
        this.cupom = cupom;
    }


    /**
     * @return long return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
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
     * @return Cupom return the cupom
     */
    public Cupom getCupom() {
        return cupom;
    }

    /**
     * @param cupom the cupom to set
     */
    public void setCupom(Cupom cupom) {
        this.cupom = cupom;
    }

    /**
     * @return Vantagem return the vantagem
     */
    public Vantagem getVantagem() {
        return vantagem;
    }

    /**
     * @param vantagem the vantagem to set
     */
    public void setVantagem(Vantagem vantagem) {
        this.vantagem = vantagem;
    }

}
