package com.labdev.App;

import java.util.Scanner;

import com.labdev.Business.Academico.SistemaSecretaria;
import com.labdev.Business.Autenticacao.Aluno;
import com.labdev.Business.Autenticacao.SistemaAuth;

public class MenuAluno extends Menu {
    private static MenuAluno instance;
    private static final String CADASTRAR_CURSO_MENU = "Cadastrar em curso";

    private MenuAluno() {
        super(true);
    }

    public static MenuAluno getInstance() {
        if(instance == null)
            instance = new MenuAluno();
        return instance;
    }

    public void iniciar() {
        var aluno = (Aluno) SistemaAuth.getInstance().getUsuario();
        if(aluno.getCurso() == null) {
            adicionarOpcao(CADASTRAR_CURSO_MENU, MenuAluno::menuCadastrarEmCurso);
        } else {
            adicionarOpcao("Listar disciplinas", MenuAluno::menuListarDisciplinas);
            adicionarOpcao("Matricular em disciplina", MenuAluno::menuMatricular);
            adicionarOpcao("Cancelar matricula em disciplina", (Menu, Scanner) -> {});
            adicionarOpcao("Confirmar matricula", (Menu, Scanner) -> {});
        }

        mostrarOpcoes();
    }

    private static void menuCadastrarEmCurso(Menu menu, Scanner scanner) {
        var cursosMenu = new Menu(true);
        cursosMenu.adicionarOpcao("Listar cursos", (Menu, Scanner) -> {
            var cursos = SistemaSecretaria.getInstance().getCursos();
            cursos.forEach(System.out::println);
        });

        cursosMenu.adicionarOpcao("Cadastrar", (Menu, Scanner) -> {
            System.out.print("Nome: ");
            var nome = scanner.nextLine();
            var cursoOptional = SistemaSecretaria.getInstance().procurarCurso(nome);
            if(cursoOptional.isEmpty()) {
                System.out.println("Curso não encontrado!");
                return;
            }

            var aluno = (Aluno) SistemaAuth.getInstance().getUsuario();
            SistemaSecretaria.getInstance().cadastrarEmCurso(aluno, cursoOptional.get());

            menu.procurarOpcao(CADASTRAR_CURSO_MENU).desabilitar();
        });

        cursosMenu.mostrarOpcoes();
    }

    private static void menuListarDisciplinas(Menu menu, Scanner scanner) {
        var usuario = (Aluno) SistemaAuth.getInstance().getUsuario();
        var disciplinas = usuario.getCurso().getDisciplinas();

        System.out.println("Disciplinas: ");
        disciplinas.forEach(System.out::println);
    }

    private static void menuMatricular(Menu menu, Scanner scanner) {
        System.out.print("Nome disciplina: ");
        var nomeDisciplina = scanner.nextLine();

        var sistemaSecretaria = SistemaSecretaria.getInstance();
        var disciplina = sistemaSecretaria.procurarDisciplina(nomeDisciplina);
        if(disciplina.isEmpty()) {
            System.out.println("Disciplina não encontrada!");
            return;
        }

        var aluno = (Aluno) SistemaAuth.getInstance().getUsuario();
        sistemaSecretaria.matricularEmDisciplina(aluno, disciplina.get());
    }
}
