package com.labdev;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

public class MenuSecretaria extends Menu {
    private static MenuSecretaria instance;

    private MenuSecretaria() {
        super(true);
    }

    public static MenuSecretaria getInstance() {
        if(instance == null)
            instance = new MenuSecretaria();
        return instance;
    }

    public void iniciar() {
        adicionarOpcao("Listar Cursos", MenuSecretaria::menuListarCurso);
        adicionarOpcao("Adicionar curso", MenuSecretaria::menuAdicionarCurso);
        adicionarOpcao("Adicionar disciplina", MenuSecretaria::menuAdicionarDisciplina);
        adicionarOpcao("Editar disciplina", MenuSecretaria::menuEditarDisciplina);
        adicionarOpcao("Remover disciplina", MenuSecretaria::menuRemoverDisciplina);

        mostrarOpcoes();
    }

    private static void menuListarCurso( Menu menu, Scanner scanner ){
        SistemaSecretaria.getInstance()
        .getCursos().
        stream().
        forEach(c -> System.out.println("- "+c.getNome() ));
    }
    private static void menuAdicionarCurso(Menu menu, Scanner scanner) {
        System.out.print("Nome: ");
        var nome = scanner.nextLine();
        System.out.print("Creditos: ");
        var creditos = scanner.nextInt();
        scanner.nextLine();

        SistemaSecretaria.getInstance().adicionarCurso(nome, creditos);
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
        menuTipo.mostrarOpcoes();

        System.out.print("Curso: ");
        var nomeCurso = scanner.nextLine();

        var sistemaSecretaria = SistemaSecretaria.getInstance();
        var cursoOptional = sistemaSecretaria.procurarCurso(nomeCurso);
        if(cursoOptional.isEmpty()) {
            System.out.println("Curso não encontrado!");
            return;
        }

        SistemaSecretaria.getInstance().adicionarDisciplina(nome, cursoOptional.get(), tipoDisciplina.get());
    }

    private static void menuEditarDisciplina(Menu menu, Scanner scanner) {

    }

    private static void menuRemoverDisciplina(Menu menu, Scanner scanner) {

    }
}
