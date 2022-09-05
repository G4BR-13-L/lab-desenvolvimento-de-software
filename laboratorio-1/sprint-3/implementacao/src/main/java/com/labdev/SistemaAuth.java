package com.labdev;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class SistemaAuth {
    private static SistemaAuth instance;
    private static final int TAMANHO_MIN_SENHA = 6;
    private static final int TAMANHO_MAX_SENHA = 15;
    private Usuario usuario;
    private final SistemaPermanencia<Usuario> usuarios;

    private SistemaAuth() {
        this.usuarios = new SistemaPermanencia<>("usuarios.bin");
        this.usuarios.carregar();
    }

    public static SistemaAuth getInstance() {
        if(instance == null)
            instance = new SistemaAuth();
        return instance;
    }

    public boolean estaLogado() {
        return this.usuario != null;
    }

    public Usuario getUsuario(){
        return this.usuario;
    }

    public List<Usuario> getUsuarios(){
        return usuarios.getItems();
    }

    private boolean emailValido(String email) {
        String regex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";;
        return email.matches(regex);
    }

    private boolean senhaValida(String senha) {
        return senha.length() >= TAMANHO_MIN_SENHA && senha.length() <= TAMANHO_MAX_SENHA;
    }

    public Optional<Usuario> procurarPorEmail(String email) {
        if(!emailValido(email)) {
            System.out.println("Email invalido!");
            return Optional.empty();
        }

        var listaUsuarios = this.usuarios.getItems();
        return listaUsuarios.stream().filter(x -> x.getEmail().equals(email)).findFirst();
    }

    public boolean entrar(String email, String senha) {
        var usuarioOptional = procurarPorEmail(email);
        if(usuarioOptional.isEmpty()) {
            System.out.println("Email não encontrado!");
            return false;
        }

        if(!senhaValida(senha)) {
            System.out.println("Senha invalida!");
            return false;
        }

        var usuario = usuarioOptional.get();
        if(!Objects.equals(usuario.getSenha(), senha)) {
            System.out.println("Senha invalida!");
            return false;
        }

        this.usuario = usuario;
        return true;
    }

    public boolean sair() {
        if(!estaLogado()) {
            System.out.println("Operação invalida!");
            return false;
        }

        this.usuario = null;
        return true;
    }

    public boolean cadastrar(String nome, String email, String senha, TipoUsuario tipoUsuario) {
        var usuarioOptional = procurarPorEmail(email);
        if(usuarioOptional.isPresent()) {
            System.out.println("Email já cadastrado!");
            return false;
        }

        if(!senhaValida(senha)) {
            System.out.println("Senha invalida!");
            return false;
        }

        Usuario usuario;
        if(tipoUsuario == TipoUsuario.ALUNO)
            usuario = new Aluno(nome, email, senha);
        else if (tipoUsuario == TipoUsuario.PROFESSOR)
            usuario = new Professor(nome, email, senha);
        else
            usuario = new Secretaria(nome, email, senha);

        this.usuarios.adicionar(usuario);
        this.usuarios.salvar();
        return true;
    }
}
