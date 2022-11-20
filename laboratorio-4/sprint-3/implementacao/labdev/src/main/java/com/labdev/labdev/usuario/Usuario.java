package com.labdev.labdev.usuario;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;

import com.labdev.labdev.carteira.Carteira;
import lombok.ToString;

@ToString
@Entity
@Inheritance
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String nome;

    @Column
    private String email;

    @Column
    private String senha;

    @Column
    private String cpf;

    @Column
    private String rg;

    @Column
    private String cnpj;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinTable(
        name="carteira_usuario",
        joinColumns = @JoinColumn( name="carteira_id" ),
        inverseJoinColumns = @JoinColumn( name="usuario_id" )
    )
    private Carteira carteira;

    public Usuario(){
        
    }
    public Usuario(
            String nome, String email, String senha,
            String cpf, String rg) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cpf = cpf;
        this.rg = rg;
        this.carteira = new Carteira();
    }

    public Usuario(
            String nome, String email, String senha,
            String cnpj) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cnpj = cnpj;
        this.carteira = new Carteira();
    }

    public String getNome(){
        return this.nome;
    }
    public Carteira getCarteira(){
        return this.carteira;
    }

    public long getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
