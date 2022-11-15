package com.labdev.labdev.professor;
import javax.persistence.JoinColumn;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;

import com.labdev.labdev.carteira.CarteiraProfessor;
import com.labdev.labdev.usuario.PessoaFisica;
import com.labdev.labdev.usuario.Usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Professor extends Usuario{

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
