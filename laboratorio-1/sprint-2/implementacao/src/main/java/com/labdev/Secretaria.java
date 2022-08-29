package com.labdev;

import java.util.List;

public class Secretaria extends Usuario {
    private double salario;

    public Secretaria() {
        super();
        this.salario = 0;
    }

    public Secretaria(String nome, String email, String senha, double salario) {
        super(nome, email, senha);
        this.salario = salario;
    }

    public void adicionarDisciplina(Disciplina disciplina) {
    }

    public void editarDisciplina(Disciplina disciplina) {
    }

    public void removerDisciplina(Disciplina disciplina) {
    }

    public void gerarCurriculo(List<Disciplina> disciplinas) {
    }
}
