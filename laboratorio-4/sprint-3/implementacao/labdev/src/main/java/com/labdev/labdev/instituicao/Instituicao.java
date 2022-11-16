package com.labdev.labdev.instituicao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.labdev.labdev.professor.Professor;
import com.labdev.labdev.usuario.Usuario;

@Entity
public class Instituicao extends Usuario {
    
    public static int MOEDAS_POR_SEMESTRE = 1000;

    public Instituicao(
            String nome, String email, String senha,
            String cnpj) {
        super(nome, email, senha,
                cnpj);
    }


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "professor_id")
    private List<Professor> professores = new ArrayList<>();

    public void cadastrarProfessores(List<Professor> professores) {

    }

    

    public void distribuirMoedas(int moedas, Professor Professor) {

    }

    public void setProfessores(List<Professor> professores) {
        this.professores = professores;
    }
}
