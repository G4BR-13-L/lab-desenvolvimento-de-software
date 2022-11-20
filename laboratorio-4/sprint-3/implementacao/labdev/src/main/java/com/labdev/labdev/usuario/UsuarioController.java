package com.labdev.labdev.usuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins="*")
public class UsuarioController {
    private final UsuarioRepository usuarioRepository;
    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(
        UsuarioRepository usuarioRepository,
        UsuarioService usuarioService
    ) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsuarios(){
        return new ResponseEntity<>(this.usuarioService.getAllUsuarios(), HttpStatus.OK);
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
        Usuario user = this.usuarioRepository.findByEmailAndSenha(email, senha);
        if (user != null) {
            return "redirect:/";
        }
        return "redirect:/usuario/painel";
    }
}