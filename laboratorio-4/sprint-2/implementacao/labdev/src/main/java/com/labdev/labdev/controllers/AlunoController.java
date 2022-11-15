package com.labdev.labdev.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.labdev.labdev.aluno.Aluno;
import com.labdev.labdev.carteira.CarteiraAluno;
import com.labdev.labdev.repository.AlunoRepository;

@Controller
@RequestMapping("/aluno")
public class AlunoController {
    private final AlunoRepository alunoRepository;

    @Autowired
    public AlunoController(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }
    @GetMapping
    public List<Aluno> getAlunos(){
        return this.alunoRepository.findAll();
    }

    @RequestMapping(value = "/cadastrar", method = RequestMethod.GET)
    public String cadastrar(Model model) {
        var aluno = new Aluno();
        model.addAttribute("aluno", aluno);
        return "aluno/cadastrar";
    }

    @RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
    public String cadastrar(@ModelAttribute("aluno") Aluno aluno) {
        this.alunoRepository.save(aluno);
        return "redirect:/usuario/logar";
    }
}
