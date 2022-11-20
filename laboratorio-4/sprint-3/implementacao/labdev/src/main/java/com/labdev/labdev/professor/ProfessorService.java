package com.labdev.labdev.professor;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessorService {
    private final ProfessorRepository professorRepository;

    @Autowired
    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public List<Professor> getAllProfessores() {
        return this.professorRepository.findAll();
    }

    public void save(Professor professor) {
        this.professorRepository.save(professor);
    }

    public Professor findProfessorById(long id) {
        return this.professorRepository.findProfessorById(id);
    }

    public void deleteProfessor(long id) {
        if (!professorRepository.existsById(id))
            throw new IllegalStateException("Professor do id:" + id + " não encontrado");
        professorRepository.deleteById(id);
    }

    @Transactional
    public void updateProfessor(
        long id, 
        String nome, 
        String email, 
        String senha, 
        String cpf, 
        String rg ) {
            if (!professorRepository.existsById(id))
                throw new IllegalStateException("Professor do id:" + id + " não encontrado");
            Professor professor = professorRepository.findProfessorById(id);
            if (professorStringVerification(nome, professor.getNome())) {
                professor.setNome(nome);
            }
            if (professorStringVerification(email, professor.getEmail())) {
                professor.setEmail(email);
            }
            if (professorStringVerification(senha, professor.getSenha())) {
                professor.setSenha(senha);
            }
            if (professorStringVerification(cpf, professor.getCpf())) {
                if (cpfVerification(cpf)) {
                    throw new IllegalStateException("cpf em uso ou inexitente");
                }
                professor.setCpf(cpf);
            }
            if (professorStringVerification(rg, professor.getRg())) {
                professor.setRg(rg);
            }
        

    }

    private String cpfFormatter(String cpf) {
        return cpf;
    }

    private boolean professorStringVerification(String newStr, String actual) {
        return (newStr != null && newStr.length() > 0 && !newStr.equals(actual));
    }

    private boolean cpfVerification(String cpf) {
        Optional<Professor> alunoOptional = professorRepository.findProfessorByCpf(cpf);
        return (alunoOptional.isPresent());
    }
}
