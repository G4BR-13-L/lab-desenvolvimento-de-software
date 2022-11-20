package com.labdev.labdev.professor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/professor")
public class ProfessorController {
    private final ProfessorRepository professorRepository;
    private final ProfessorService professorService;

    @Autowired
    public ProfessorController(ProfessorRepository professorRepository,
            ProfessorService professorService) {
        this.professorRepository = professorRepository;
        this.professorService = professorService;
    }

    @GetMapping
    public ResponseEntity<List<Professor>> getAllProfessores() {
        return new ResponseEntity<>(this.professorService.getAllProfessores(), HttpStatus.OK);
    }

    @RequestMapping(value = "/cadastrar", method = RequestMethod.GET)
    public String cadastrar(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String senha,
            @RequestParam(required = true) String cpf,
            @RequestParam(required = true) String rg) {
        Professor professor = new Professor(nome, email, senha, cpf, rg);
        this.professorRepository.save(professor);
        return "redirect:/usuario/logar";
    }
}
