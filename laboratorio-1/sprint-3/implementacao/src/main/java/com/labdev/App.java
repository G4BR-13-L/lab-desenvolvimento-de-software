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

        menu.adicionarOpcao("Salvar", (Scanner scanner) -> {
            System.out.println("Salvando todos os dados");
        });

        menu.adicionarOpcao(ENTRAR_MENU, (Scanner scanner) -> {
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
        });

        menu.adicionarOpcao(CADASTRAR_MENU, (Scanner scanner) -> {
            System.out.println("Tipo de usuario: ");

            var menu = new Menu(false);
            menu.sairAoSelecionar(true);

            var tipoUsuario = new AtomicReference<TipoUsuario>();
            menu.adicionarOpcao("Aluno", (Scanner) -> {
                tipoUsuario.set(TipoUsuario.ALUNO);
            });
            menu.adicionarOpcao("Professor", (Scanner) -> {
                tipoUsuario.set(TipoUsuario.PROFESSOR);
            });
            menu.mostrarOpcoes();

            System.out.print("Nome: ");
            var nome = scanner.nextLine();
            System.out.print("Email: ");
            var email = scanner.nextLine();
            System.out.print("Senha: ");
            var senha = scanner.nextLine();

            var sistemaAuth = SistemaAuth.getInstance();
            sistemaAuth.cadastrar(nome, email, senha, tipoUsuario.get());
        });

        var sairMenu = menu.adicionarOpcao(SAIR_MENU, (Scanner scanner) -> {
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
