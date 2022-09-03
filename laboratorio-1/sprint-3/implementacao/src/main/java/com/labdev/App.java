package com.labdev;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

public class App {
    private static final String ENTRAR_MENU = "Entrar na sua conta";
    private static final String CADASTRAR_MENU = "Cadastrar novo usuario";
    private static final String SAIR_MENU = "Sair da sua conta";
    private final Menu menu;

    public App(){
        this.menu = new Menu(false);
    }

    private void iniciarMenuGlobal() {
        menu.adicionarOpcao("Salvar", (Menu, Scanner) -> {
            System.out.println("Salvando todos os dados");
        });

        menu.adicionarOpcao(ENTRAR_MENU, App::menuEntrar);
        menu.adicionarOpcao(CADASTRAR_MENU, App::menuCadastrar);

        var sairMenu = menu.adicionarOpcao(SAIR_MENU, App::menuSair);
        sairMenu.desabilitar();
    }

    private static void menuEntrar(Menu menu, Scanner scanner) {
        System.out.print("Email: ");
        var email = scanner.nextLine();
        System.out.print("Senha: ");
        var senha = scanner.nextLine();

        var sistemaAuth = SistemaAuth.getInstance();
        if(sistemaAuth.entrar(email, senha)) {
            var menuEntrar = menu.procurarOpcao(ENTRAR_MENU);
            menuEntrar.desabilitar();

            var menuCadastrar = menu.procurarOpcao(CADASTRAR_MENU);
            menuCadastrar.desabilitar();

            var menuSair = menu.procurarOpcao(SAIR_MENU);
            menuSair.habilitar();

            System.out.printf("Bem vindo %s\n", sistemaAuth.getUsuario().getNome());
        }
    }

    private static void menuCadastrar(Menu menu, Scanner scanner) {
        System.out.println("Tipo de usuario: ");

        var menuTipo = new Menu(false);
        menuTipo.sairAoSelecionar(true);

        var tipoUsuario = new AtomicReference<TipoUsuario>();
        menuTipo.adicionarOpcao("Aluno", (Menu, Scanner) -> {
            tipoUsuario.set(TipoUsuario.ALUNO);
        });
        menuTipo.adicionarOpcao("Professor", (Menu, Scanner) -> {
            tipoUsuario.set(TipoUsuario.PROFESSOR);
        });
        menuTipo.mostrarOpcoes();

        System.out.print("Nome: ");
        var nome = scanner.nextLine();
        System.out.print("Email: ");
        var email = scanner.nextLine();
        System.out.print("Senha: ");
        var senha = scanner.nextLine();

        var sistemaAuth = SistemaAuth.getInstance();
        sistemaAuth.cadastrar(nome, email, senha, tipoUsuario.get());
    }

    private static void menuSair(Menu menu, Scanner scanner) {
        var sistemaAuth = SistemaAuth.getInstance();
        var usuario = sistemaAuth.getUsuario().getNome();
        if(sistemaAuth.sair()) {
            var menuEntrar = menu.procurarOpcao(ENTRAR_MENU);
            menuEntrar.habilitar();

            var menuCadastrar = menu.procurarOpcao(CADASTRAR_MENU);
            menuCadastrar.habilitar();

            var menuSair = menu.procurarOpcao(SAIR_MENU);
            menuSair.desabilitar();

            System.out.printf("Até a próxima %s\n", usuario);
        }
    }

    public void iniciar() {
        iniciarMenuGlobal();
        menu.mostrarOpcoes();
    }

    public static void main(String[] args) {
        var app = new App();
        app.iniciar();
    }
}
