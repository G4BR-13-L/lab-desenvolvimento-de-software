package com.labdev.labdev.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.labdev.labdev.model.Aluno;

@Controller
@RequestMapping("/aluno")
public class AlunoController {
    @RequestMapping(value = "/cadastrar", method = RequestMethod.GET)
    public String cadastrar(Model model) {
        var aluno = new Aluno();
        model.addAttribute("aluno", aluno);
        return "aluno/cadastrar";
    }

    @RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
    public String cadastrar(@ModelAttribute("aluno") Aluno aluno) {
        return "usuario/logar";
    }
}
