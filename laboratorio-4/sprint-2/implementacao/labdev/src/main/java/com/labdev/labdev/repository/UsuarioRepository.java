package com.labdev.labdev.repository;

import org.springframework.stereotype.Repository;
import com.labdev.labdev.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByEmailAndSenha(String email, String senha);
}
