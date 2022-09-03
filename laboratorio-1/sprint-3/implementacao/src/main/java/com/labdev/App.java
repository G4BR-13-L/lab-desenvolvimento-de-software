package com.labdev;

import java.util.Scanner;

public class App {
    private final Menu menu;

    public App(){
        this.menu = new Menu(false);

        menu.adicionarOpcao("Salvar", (Scanner scanner) -> {
            System.out.println("Salvando todos os dados");
        });

        menu.adicionarOpcao("Entrar", (Scanner scanner) -> {
            System.out.print("Email: ");
            var email = scanner.nextLine();
            System.out.print("Senha: ");
            var senha = scanner.nextLine();

            var sistemaAuth = SistemaAuth.getInstance();
            if(sistemaAuth.entrar(email, senha)) {
                var menuEntrar = menu.procurarOpcao("Entrar");
                menuEntrar.desabilitar();

                var menuCadastrar = menu.procurarOpcao("Cadastrar");
                menuCadastrar.desabilitar();

                var menuSair = menu.procurarOpcao("Sair");
                menuSair.habilitar();

                System.out.printf("Bem vindo %s\n", sistemaAuth.getUsuario().getNome());
            }
        });

        menu.adicionarOpcao("Cadastrar", (Scanner scanner) -> {
            System.out.print("Nome: ");
            var nome = scanner.nextLine();
            System.out.print("Email: ");
            var email = scanner.nextLine();
            System.out.print("Senha: ");
            var senha = scanner.nextLine();

            var sistemaAuth = SistemaAuth.getInstance();
            sistemaAuth.cadastrar(nome, email, senha);
        });

        var sairMenu = menu.adicionarOpcao("Sair", (Scanner scanner) -> {
            var sistemaAuth = SistemaAuth.getInstance();
            var usuario = sistemaAuth.getUsuario().getNome();
            if(sistemaAuth.sair()) {
                var menuEntrar = menu.procurarOpcao("Entrar");
                menuEntrar.habilitar();

                var menuCadastrar = menu.procurarOpcao("Cadastrar");
                menuCadastrar.habilitar();

                var menuSair = menu.procurarOpcao("Sair");
                menuSair.desabilitar();

                System.out.printf("Até a próxima %s\n", usuario);
            }
        });
        sairMenu.desabilitar();
    }

    public void iniciar() {
        menu.mostrarOpcoes();
    }

    public static void main(String[] args) {
        var app = new App();
        app.iniciar();
    }
}
