package com.labdev.labdev.carteira.resgate;

import java.time.LocalDateTime;

import com.labdev.labdev.carteira.Cupom;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private LocalDateTime data;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "cupom", joinColumns = @JoinColumn(name = "cupom_fk", nullable = true))
    private Cupom cupom;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "vantagen_resgatada", joinColumns = @JoinColumn(name = "vantagem_fk", nullable = true))
    private Vantagem vantagem;

    public ResgateVantagem(Vantagem vantagem) {
        this.vantagem = vantagem;
        this.data = LocalDateTime.now();
        this.cupom = new Cupom();
    }

}
