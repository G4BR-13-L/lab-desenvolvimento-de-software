package com.labdev;

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
        adicionarOpcao("Pesquisar disciplina", (Menu, Scanner) -> {});

        mostrarOpcoes();
    }
}
