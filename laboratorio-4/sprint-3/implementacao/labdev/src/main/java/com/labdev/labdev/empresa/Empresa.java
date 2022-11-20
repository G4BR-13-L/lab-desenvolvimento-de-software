package com.labdev.labdev.empresa;

import javax.persistence.Entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import com.labdev.labdev.usuario.Usuario;

@Entity
public class Empresa extends Usuario {

    @OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinTable( 
        name="vantagens",
        joinColumns = @JoinColumn(name = "vantagem_fk", nullable = true),
        inverseJoinColumns = @JoinColumn( name="empresa_fk"))
    private List<Vantagem> vantagens;

    public Empresa(
            String nome, String email, String senha,
            String cnpj) {
        super(nome, email, senha,
                cnpj);
    }

    public void cadastrarVantagem() {

    }
}
