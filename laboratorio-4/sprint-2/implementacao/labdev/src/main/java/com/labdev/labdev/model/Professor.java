package com.labdev.labdev.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Professor extends PessoaFisica{

    @Column
    private String departamento;

    @Column
    private CarteiraProfessor carteira;
}
