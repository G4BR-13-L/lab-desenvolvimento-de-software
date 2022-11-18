package com.labdev.labdev.professor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/professor")
public class ProfessorController {
    private final ProfessorRepository professorRepository;

    @Autowired
    public ProfessorController(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    @RequestMapping(value = "/cadastrar", method = RequestMethod.GET)
    public String cadastrar( 
        @RequestParam(required = false) String nome, 
        @RequestParam(required = false) String email, 
        @RequestParam(required = false) String senha, 
        @RequestParam(required = true) String cpf,
        @RequestParam(required = true) String rg
    ) {
        Professor professor = new Professor(nome, email, senha, cpf, rg);
        this.professorRepository.save(professor);
        return "redirect:/usuario/logar";
    }
}
