package com.labdev.labdev.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/usuario")
public class UsuarioController {
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @RequestMapping(value = "/cadastrar", method = RequestMethod.GET)
    public String cadastrar() {
        return "usuario/cadastrar";
    }

    @RequestMapping(value = "/logar", method = RequestMethod.GET)
    public String logar(
        @RequestParam(required = true) String email, 
        @RequestParam(required = true) String senha
    ) {
        var user = this.usuarioRepository.findByEmailAndSenha(email, senha);
        if (user != null) {
            return "redirect:/";
        }
        return "redirect:/usuario/painel";
    }
}
