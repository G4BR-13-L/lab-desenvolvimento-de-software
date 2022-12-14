package com.labdev.App;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

import com.labdev.Business.Academico.SistemaSecretaria;
import com.labdev.Business.Academico.TipoDisciplina;
import com.labdev.Business.Autenticacao.Professor;
import com.labdev.Business.Autenticacao.SistemaAuth;

public class MenuSecretaria extends Menu {
    private static MenuSecretaria instance;

    private MenuSecretaria() {
        super(true);
    }

    public static MenuSecretaria getInstance() {
        if (instance == null)
            instance = new MenuSecretaria();
        return instance;
    }

    public void iniciar() {
        
        
        adicionarOpcao("Listar Cursos", MenuSecretaria::menuListarCurso);
        adicionarOpcao("Adicionar curso", MenuSecretaria::menuAdicionarCurso);
        adicionarOpcao("Listar disciplinas", MenuSecretaria::menuListarDisciplina);
        adicionarOpcao("Adicionar disciplina", MenuSecretaria::menuAdicionarDisciplina);
        adicionarOpcao("Remover disciplina", MenuSecretaria::menuSuspenderDisciplina);
        mostrarOpcoes();
    }

    private static void menuListarCurso(Menu menu, Scanner scanner) {
        SistemaSecretaria.getInstance()
                .getCursos().stream().forEach(c -> System.out.println("- " + c.getNome()));
    }

    private static void menuAdicionarCurso(Menu menu, Scanner scanner) {
        System.out.print("Nome: ");
        var nome = scanner.nextLine();
        System.out.print("Creditos: ");
        var creditos = scanner.nextInt();
        scanner.nextLine();

        SistemaSecretaria.getInstance().adicionarCurso(nome, creditos);
    }

    private static void menuListarDisciplina(Menu menu, Scanner scanner) {
        System.out.print("--- Disciplinas ---");
        SistemaSecretaria.getInstance()
                .getDisciplinas().stream().forEach(d -> System.out.println("- " + d.getNome()));
    }

    private static void menuAdicionarDisciplina(Menu menu, Scanner scanner) {
        System.out.print("Nome: ");
        var nome = scanner.nextLine();

        var tipoDisciplina = new AtomicReference<TipoDisciplina>();
        var menuTipo = new Menu(false);
        menuTipo.adicionarOpcao("Optativa", (Menu, Scanner) -> {
            tipoDisciplina.set(TipoDisciplina.OPTATIVA);
        });
        menuTipo.adicionarOpcao("Obrigatoria", (Menu, Scanner) -> {
            tipoDisciplina.set(TipoDisciplina.OBRIGATORIA);
        });
        menuTipo.sairAoSelecionar(true);
        menuTipo.mostrarOpcoes();

        var sistemaAuth = SistemaAuth.getInstance();
        System.out.print("Nome do Professor: ");
        var nomeProfessor = scanner.nextLine();
        var professor = sistemaAuth.procurarPorNome(nomeProfessor);
        if(professor.isEmpty()){
            System.out.print("Professor inexistente");
            return;
        }

        System.out.print("Curso: ");
        var nomeCurso = scanner.nextLine();

        var sistemaSecretaria = SistemaSecretaria.getInstance();
        var cursoOptional = sistemaSecretaria.procurarCurso(nomeCurso);
        if (cursoOptional.isEmpty()) {
            System.out.println("Curso n??o encontrado!");
            return;
        }

        SistemaSecretaria.getInstance().adicionarDisciplina(nome, cursoOptional.get(), tipoDisciplina.get(), (Professor)(professor.get()));
    }

    private static void menuSuspenderDisciplina(Menu menu, Scanner scanner) {

        System.out.print("Disciplina: ");
        var nomeDisciplina = scanner.nextLine();
        var sistemaSecretaria = SistemaSecretaria.getInstance();
        var disciplina = sistemaSecretaria.procurarDisciplina(nomeDisciplina);
        if( disciplina.isEmpty() ){
            System.out.println("Disciplina inv??lida");
            return;
        }
        disciplina.get().suspenderDisciplina();
            System.out.println("Suspendida com sucesso");
                
    }
}
