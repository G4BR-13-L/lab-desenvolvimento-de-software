package com.labdev.labdev.empresa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.labdev.labdev.usuario.UsuarioRepository;

@Controller
@RequestMapping("/empresa")
public class EmpresaController {
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public EmpresaController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @RequestMapping(value = "/cadastrar", method = RequestMethod.GET)
    public String cadastrar( 
        @RequestParam(required = false) String nome, 
        @RequestParam(required = false) String email, 
        @RequestParam(required = false) String senha, 
        @RequestParam(required = true) String cnpj
    ) {
        Empresa empresa = new Empresa(nome, email, senha, cnpj);
        this.usuarioRepository.save(empresa);
        return "redirect:/usuario/logar";
    }
}
