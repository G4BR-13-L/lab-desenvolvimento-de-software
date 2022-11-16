package com.labdev.labdev.aluno;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String cadastrar( 
        @RequestParam(required = false) String nome, 
        @RequestParam(required = false) String email, 
        @RequestParam(required = false) String senha, 
        @RequestParam(required = true) String cpf,
        @RequestParam(required = true) String rg
    ) {
        var aluno = new Aluno(nome, email, senha, cpf, rg);
        this.alunoRepository.save(aluno);
        return "redirect:/usuario/logar";
    }
}
