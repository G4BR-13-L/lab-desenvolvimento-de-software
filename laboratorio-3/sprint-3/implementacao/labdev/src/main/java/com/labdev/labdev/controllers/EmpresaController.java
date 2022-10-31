package com.labdev.labdev.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.labdev.labdev.model.Empresa;
import com.labdev.labdev.repository.EmpresaRepository;

@Controller
@RequestMapping("/empresa")
public class EmpresaController {
    private final EmpresaRepository empresaRepository;

    @Autowired
    public EmpresaController(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    @RequestMapping(value = "/cadastrar", method = RequestMethod.GET)
    public String cadastrar(Model model) {
        var empresa = new Empresa();
        model.addAttribute("empresa", empresa);
        return "empresa/cadastrar";
    }

    @RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
    public String cadastrar(@ModelAttribute("empresa") Empresa empresa) {
        this.empresaRepository.save(empresa);
        return "usuario/logar";
    }
}
