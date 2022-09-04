package com.labdev;

import java.util.Scanner;
public class MenuProfessor extends Menu {
    private static MenuProfessor instance;

    private MenuProfessor() {
        super(true);
    }

    public static MenuProfessor getInstance() {
        if(instance == null)
            instance = new MenuProfessor();
        return instance;
    }

    public void iniciar() {
        adicionarOpcao("Pesquisar disciplina", MenuProfessor::menuListarDisciplina);

        mostrarOpcoes();
    }

    private static void menuListarDisciplina( Menu menu, Scanner scanner ){
        System.out.println("\n--- Disciplinas ---\n");
        var sistemaAuth = SistemaAuth.getInstance();
        String professor = sistemaAuth.getUsuario().getNome();
        SistemaSecretaria.getInstance()
        .getDisciplinas().
        stream().
        filter(d -> d.getProfessor().getNome() == professor)
        .forEach(d -> System.out.println("- "+d.getNome() ));
        System.out.println("\n------------------\n");

    }
}
