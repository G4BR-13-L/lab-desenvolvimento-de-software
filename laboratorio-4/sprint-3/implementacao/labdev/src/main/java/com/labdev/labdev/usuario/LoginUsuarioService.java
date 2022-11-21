package com.labdev.labdev.usuario;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginUsuarioService implements UserDetailsService {
    private final UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = this.usuarioService.buscarPorEmail(email);
        if (usuario == null) {
            throw new UsernameNotFoundException(email);
        }
        return new User(usuario.getEmail(), usuario.getSenha(), Collections.emptyList());
    }
}
