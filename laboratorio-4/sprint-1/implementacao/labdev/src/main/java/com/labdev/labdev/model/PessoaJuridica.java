package com.labdev.labdev.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class PessoaJuridica extends Usuario {
    @Column
    private String cnpj;
}
