package com.labdev.labdev.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Aluno extends PessoaFisica {
    @Column
    private int semestre;

    @OneToOne
    @JoinTable(
        name="carteira_aluno",
        joinColumns = @JoinColumn( name="carteira_id" ),
        inverseJoinColumns = @JoinColumn( name="aluno_id" )
    )
    private CarteiraAluno carteira;
}
