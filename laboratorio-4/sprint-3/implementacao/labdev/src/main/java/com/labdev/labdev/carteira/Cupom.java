package com.labdev.labdev.carteira;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@AllArgsConstructor
@Entity
@Table
public class Cupom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String codigo;

    public Cupom() {
        this.codigo = UUID.randomUUID().toString();
    }

    public String getCodigo() {
        return this.codigo;
    }
}
