package com.labdev.labdev.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Aluno extends PessoaFisica {
    @Column
    private int semestre;
}
