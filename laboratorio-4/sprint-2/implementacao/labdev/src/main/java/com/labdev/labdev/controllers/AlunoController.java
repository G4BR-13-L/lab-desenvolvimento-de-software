package com.labdev.labdev.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.labdev.labdev.model.Aluno;
import com.labdev.labdev.model.CarteiraAluno;
import com.labdev.labdev.repository.AlunoRepository;

@Controller
@RequestMapping("/aluno")
public class AlunoController {
    private final AlunoRepository alunoRepository;

    @Autowired
    public AlunoController(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    @RequestMapping(value = "/cadastrar", method = RequestMethod.GET)
    public String cadastrar(Model model) {
        var aluno = new Aluno();
        var carteira = new CarteiraAluno();
        aluno.setCarteira(carteira);
        model.addAttribute("aluno", aluno);
        return "aluno/cadastrar";
    }

    @RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
    public String cadastrar(@ModelAttribute("aluno") Aluno aluno) {
        this.alunoRepository.save(aluno);
        return "redirect:/usuario/logar";
    }
}
