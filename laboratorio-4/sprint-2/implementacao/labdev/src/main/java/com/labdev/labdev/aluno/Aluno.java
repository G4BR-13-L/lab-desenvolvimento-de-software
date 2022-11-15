package com.labdev.labdev.aluno;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;

import com.labdev.labdev.carteira.CarteiraAluno;
import com.labdev.labdev.usuario.Usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Aluno extends Usuario {
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
