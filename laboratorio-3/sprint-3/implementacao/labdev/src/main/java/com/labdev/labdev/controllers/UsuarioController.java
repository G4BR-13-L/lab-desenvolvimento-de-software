package com.labdev.labdev.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
    @RequestMapping(value = "/cadastrar", method = RequestMethod.GET)
    public String cadastrar() {
        return "usuario/cadastrar";
    }

    @RequestMapping(value = "/logar", method = RequestMethod.GET)
    public String logar() {
        return "usuario/logar";
    }
}
