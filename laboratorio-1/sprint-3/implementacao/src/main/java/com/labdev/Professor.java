package com.labdev;

import java.util.ArrayList;
import java.util.List;

public class Professor extends Usuario {
    private final List<Disciplina> disciplinas;
    
    public Professor(String nome, String email, String senha) {
        super(nome, email, senha, TipoUsuario.PROFESSOR);
        this.disciplinas = new ArrayList<>();
    }

    public void lecionarDisciplina( Disciplina disciplina ){
            this.disciplinas.add(disciplina);
    }

    public List<Disciplina> getDisciplinas(){
        return this.disciplinas.stream()
        .filter(d -> d.isLecionada()).toList();
    }
}
