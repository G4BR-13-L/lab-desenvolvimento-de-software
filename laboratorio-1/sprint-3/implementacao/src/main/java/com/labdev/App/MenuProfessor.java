package com.labdev.App;

import java.util.Scanner;

import com.labdev.Business.Academico.SistemaSecretaria;
import com.labdev.Business.Autenticacao.Professor;
import com.labdev.Business.Autenticacao.SistemaAuth;
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
        adicionarOpcao("Listar alunos", MenuProfessor::menuListarAlunos);

        mostrarOpcoes();
    }

    private static void menuListarDisciplina( Menu menu, Scanner scanner ){
        System.out.println("\n--- Disciplinas ---\n");
        
        var sistemaAuth = SistemaAuth.getInstance();
        Professor professor = (Professor)(sistemaAuth.getUsuario());
        
        professor.getDisciplinas().stream()
        .forEach(d -> System.out.println("- "+d.getNome() ));
        
        System.out.println("\n------------------\n");

    }

    private static void menuListarAlunos(Menu menu, Scanner scanner) {
        System.out.print("Disciplina: ");
        var disciplina = scanner.nextLine();

        var sistemaSecretaria = SistemaSecretaria.getInstance();
        var disciplinaOptional = sistemaSecretaria.procurarDisciplina(disciplina);
        if(disciplinaOptional.isEmpty()) {
            System.out.println("Disciplina não existe!");
            return;
        }

        var alunos = disciplinaOptional.get().getAlunos();
        alunos.forEach(System.out::println);
    }
}
