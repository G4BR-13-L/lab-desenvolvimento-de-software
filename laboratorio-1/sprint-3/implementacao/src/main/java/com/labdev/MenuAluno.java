package com.labdev;

public class MenuAluno extends Menu {
    private static MenuAluno instance;

    private MenuAluno() {
        super(true);
    }

    public static MenuAluno getInstance() {
        if(instance == null)
            instance = new MenuAluno();
        return instance;
    }

    public void iniciar() {
        adicionarOpcao("Matricular em disciplina", (Menu, Scanner) -> {});
        adicionarOpcao("Cancelar matricula em disciplina", (Menu, Scanner) -> {});
        adicionarOpcao("Confirmar matricula", (Menu, Scanner) -> {});

        mostrarOpcoes();
    }
}
