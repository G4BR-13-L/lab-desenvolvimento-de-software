package com.labdev.labdev.model;
import javax.persistence.JoinColumn;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;

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

    @OneToOne
    @JoinTable(
        name="carteira_professor",
        joinColumns = @JoinColumn( name="carteira_id" ),
        inverseJoinColumns = @JoinColumn( name="aluno_id" )
    )
    private CarteiraProfessor carteira;
}
