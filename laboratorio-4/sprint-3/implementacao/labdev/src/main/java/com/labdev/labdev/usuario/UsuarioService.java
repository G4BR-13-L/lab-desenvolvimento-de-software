package com.labdev.labdev.usuario;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository, BCryptPasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<Usuario> getAllUsuarios() {
        return this.usuarioRepository.findAll();
    }

    public Usuario buscarPorEmail(String email) {
        return this.usuarioRepository.findByEmail(email).orElseThrow(EntityNotFoundException::new);
    }

    public Usuario criarUsuario(UserCreateRequest userCreateRequest) {
        Usuario usuario = new Usuario();
        Optional<Usuario> email = this.usuarioRepository.findByEmail(userCreateRequest.getEmail());

        if (email.isPresent()) {
            throw new RuntimeException("Usuario ja cadastrado!");
        }

        usuario.setEmail(userCreateRequest.getEmail());
        usuario.setSenha(passwordEncoder.encode(userCreateRequest.getSenha()));

        return this.usuarioRepository.save(usuario);
    }
}
