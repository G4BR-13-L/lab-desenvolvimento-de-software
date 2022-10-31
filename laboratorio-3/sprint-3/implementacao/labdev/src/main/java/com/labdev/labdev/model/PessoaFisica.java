package com.labdev.labdev.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class PessoaFisica extends Usuario {
    @Column
    private String cpf;

    @Column
    private String rg;
}
