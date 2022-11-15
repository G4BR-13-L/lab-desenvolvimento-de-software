package com.labdev.labdev.professor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/professor")
public class ProfessorController {
    private final ProfessorRepository professorRepository;

    @Autowired
    public ProfessorController(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    @RequestMapping(value = "/cadastrar", method = RequestMethod.GET)
    public String cadastrar(Model model) {
        var professor = new Professor();
        model.addAttribute("professor", professor);
        return "professor/cadastrar";
    }

    @RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
    public String cadastrar(@ModelAttribute("professor") Professor professor) {
        this.professorRepository.save(professor);
        return "redirect:/usuario/logar";
    }
}
