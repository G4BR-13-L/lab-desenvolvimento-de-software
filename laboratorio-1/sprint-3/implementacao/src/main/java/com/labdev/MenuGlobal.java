package com.labdev;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

public class MenuGlobal extends Menu {
    private static final String ENTRAR_MENU = "Entrar na sua conta";
    private static final String CADASTRAR_MENU = "Cadastrar novo usuario";
    private static final String SAIR_MENU = "Sair da sua conta";
    private static MenuGlobal instance;

    private MenuGlobal() {
        super(false);
    }

    public static MenuGlobal getInstance() {
        if(instance == null)
            instance = new MenuGlobal();
        return instance;
    }

    public void iniciar() {
        adicionarOpcao("Salvar", (Menu, Scanner) -> {
            System.out.println("Salvando todos os dados");
        });

        adicionarOpcao(ENTRAR_MENU, MenuGlobal::menuEntrar);
        adicionarOpcao(CADASTRAR_MENU, MenuGlobal::menuCadastrar);

        var sairMenu = adicionarOpcao(SAIR_MENU, MenuGlobal::menuSair);
        sairMenu.desabilitar();

        mostrarOpcoes();
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

            var tipoUsuario = sistemaAuth.getUsuario().getTipo();
            if(tipoUsuario == TipoUsuario.ALUNO) {
                MenuAluno.getInstance().iniciar();
            } else if(tipoUsuario == TipoUsuario.PROFESSOR) {
                MenuProfessor.getInstance().iniciar();
            } else if(tipoUsuario == TipoUsuario.SECRETARIA) {
                MenuSecretaria.getInstance().iniciar();
            }
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
        menuTipo.adicionarOpcao("Secretaria", (Menu, Scanner) -> {
            tipoUsuario.set(TipoUsuario.SECRETARIA);
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
}
