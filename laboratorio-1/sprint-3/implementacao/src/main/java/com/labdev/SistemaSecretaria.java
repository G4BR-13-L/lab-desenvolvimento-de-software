package com.labdev;

import java.util.List;
import java.util.Optional;

public class SistemaSecretaria {
    private static SistemaSecretaria instance;
    private final SistemaPermanencia<Disciplina> disciplinas;
    private final SistemaPermanencia<Curso> cursos;

    public SistemaSecretaria() {
        this.disciplinas = new SistemaPermanencia<>("disciplinas.bin");
        this.disciplinas.carregar();

        this.cursos = new SistemaPermanencia<>("cursos.bin");
        this.cursos.carregar();
    }

    public static SistemaSecretaria getInstance() {
        if(instance == null)
            instance = new SistemaSecretaria();
        return instance;
    }

    public List<Curso> getCursos() {
        return cursos.getItems();
    }
    public List<Disciplina> getDisciplinas() {
        return disciplinas.getItems();
    }

    public Optional<Curso> procurarCurso(String nome) {
        return this.cursos.getItems().stream().filter(x -> x.getNome().equals(nome)).findFirst();
    }

    public Optional<Disciplina> procurarDisciplina(String nome) {
        return this.disciplinas.getItems().stream().filter(x -> x.getNome().equals(nome)).findFirst();
    }

    public void adicionarCurso(String nome, int creditos) {
        if(SistemaAuth.getInstance().getUsuario().getTipo() != TipoUsuario.SECRETARIA) {
            System.out.println("Você não tem permissão!");
            return;
        }

        if(nome.isEmpty()) {
            System.out.println("Nome invalido");
            return;
        }

        if(creditos <= 0) {
            System.out.println("Os creditos não podem ser negativos ou nulos!");
            return;
        }

        var curso = new Curso(nome, creditos);
        this.cursos.adicionar(curso);
        this.cursos.salvar();
    }

    public void cadastrarEmCurso(Aluno aluno, Curso curso) {
        if(aluno.getCurso() != null) {
            System.out.println("Aluno já cadastrado em curso!");
            return;
        }

        if(!this.cursos.getItems().contains(curso)) {
            System.out.print("Curso não cadastrado!");
            return;
        }

        aluno.matricularEmCurso(curso);
        curso.matricularAluno(aluno);
    }

    public void adicionarDisciplina(String nome, Curso curso, TipoDisciplina tipoDisciplina, Professor professor) {
        if(nome.isEmpty()) {
            System.out.println("Nome invalido!");
            return;
        }

        if(!this.cursos.getItems().contains(curso)) {
            System.out.print("Curso não cadastrado");
            return;
        }

        var disciplina = new Disciplina(nome, curso, tipoDisciplina);
        this.disciplinas.adicionar(disciplina);
        curso.adicionarDisciplina(disciplina);
        professor.lecionarDisciplina(disciplina);
        this.disciplinas.salvar();
    }

    public void matricularEmDisciplina(Aluno aluno, Disciplina disciplina) {
        if(!this.disciplinas.getItems().contains(disciplina)) {
            System.out.println("Disciplina não cadastrada!");
            return;
        }

        disciplina.matricularAluno(aluno);
    }

    public void finalizar() {
        this.cursos.salvar();
        this.disciplinas.salvar();
    }
}
