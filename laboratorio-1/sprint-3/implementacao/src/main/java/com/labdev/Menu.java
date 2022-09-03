package com.labdev;

import java.util.*;

public class Menu {

    interface OpcaoHandler {
        void handler(Menu menu, Scanner scanner);
    }

    static class Opcao {
        private final String nome;
        private final OpcaoHandler handler;

        private boolean visivel;

        public Opcao(String nome, OpcaoHandler handler) {
            this.nome = nome;
            this.handler = handler;
            this.visivel = true;
        }

        public void desabilitar() {
            this.visivel = false;
        }

        public void habilitar() {
            this.visivel = true;
        }
    }

    private final Scanner scanner;
    private final HashMap<Integer, Opcao> opcaoList;
    private int proximoId;
    private boolean sairAoSelecionar;

    public Menu(boolean adicionarSair) {
        this.scanner = new Scanner(System.in);
        this.opcaoList = new HashMap<>();
        this.proximoId = 0;
        this.sairAoSelecionar = false;

        if(adicionarSair)
            this.adicionarOpcao("Sair", null);
    }

    public void sairAoSelecionar(boolean habilitar) {
        this.sairAoSelecionar = habilitar;
    }

    public Opcao adicionarOpcao(String nome, OpcaoHandler handler) {
        var opcao = new Opcao(nome, handler);
        this.opcaoList.put(gerarProximoId(), opcao);
        return opcao;
    }

    public void mostrarOpcoes() {
        int opcao;
        do {
            for(var key : this.opcaoList.keySet()) {
                var value = this.opcaoList.get(key);
                if(value.visivel)
                    System.out.printf("%d - %s\n", key, value.nome);
            }

            System.out.print("Opção: ");
            opcao = this.scanner.nextInt();
            this.scanner.nextLine();

            int finalOpcao = opcao;
            var itemKey = this.opcaoList.keySet().stream().filter(x -> x.equals(finalOpcao)).findFirst();
            if(itemKey.isPresent()) {
                var itemValue = this.opcaoList.get(itemKey.get());
                var handler = itemValue.handler;
                if(handler != null)
                    handler.handler(this, this.scanner);

                if(sairAoSelecionar)
                    return;
            } else {
                System.out.println("Opção invalida!");
            }
        } while(opcao != 0);
    }

    public Opcao procurarOpcao(String nome) {
        for(var key : this.opcaoList.keySet()) {
            var value = this.opcaoList.get(key);
            if(value.nome.equals(nome))
                return value;
        }
        return null;
    }

    private int gerarProximoId() {
        return this.proximoId++;
    }
}
