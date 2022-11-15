package com.labdev.labdev.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.labdev.labdev.usuario.Usuario;

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
    public String logar(Model model) {
        var usuario = new Usuario();
        model.addAttribute("usuario", usuario);
        return "usuario/logar";
    }

    @RequestMapping(value = "/logar", method = RequestMethod.POST)
    public String logar(@ModelAttribute("usuario") Usuario usuario) {
        var user = this.usuarioRepository.findByEmailAndSenha(usuario.getEmail(), usuario.getSenha());
        if (user != null) {
            return "redirect:/";
        }
        return "redirect:/usuario/logar";
    }
}
