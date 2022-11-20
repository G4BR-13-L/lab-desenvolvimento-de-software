package com.labdev.labdev.aluno;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/aluno")
public class AlunoController {
    private final AlunoService alunoService;

    @Autowired
    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }
    @GetMapping
    public ResponseEntity<List<Aluno>> getAllAlunos(){
        return new ResponseEntity<>(this.alunoService.getAllAlunos(), HttpStatus.OK);
    }

    @RequestMapping(value = "/cadastrar", method = RequestMethod.GET)
    public String cadastrar( 
        @RequestParam(required = false) String nome, 
        @RequestParam(required = false) String email, 
        @RequestParam(required = false) String senha, 
        @RequestParam(required = true) String cpf,
        @RequestParam(required = true) String rg
    ) {
        Aluno aluno = new Aluno(nome, email, senha, cpf, rg);
        this.alunoService.save(aluno);
        return "redirect:/usuario/logar";
    }


    @GetMapping(path = "{alunoId}")
    public Aluno getAluno(@PathVariable("alunoId") long id) {
        return alunoService.findAlunoById(id);
    }

    @DeleteMapping(path = "{alunoId}")
    public void deleteAluno(@PathVariable("alunoId") long id) {
        alunoService.deleteAluno(id);
    }

    @PutMapping(path = "{alunoId}")
    public void updateAluno(@PathVariable("alunoId") long alunoId,
            @RequestParam(required = false) String nome, @RequestParam(required = false) String email,
            @RequestParam(required = false) String senha, @RequestParam(required = false) String cpf,
            @RequestParam(required = false) String rg, @RequestParam(required = false) String curso,
            @RequestParam(required = false) double saldo) {
        alunoService.updateAluno(alunoId, nome, email, senha, cpf, rg);
    }
}
