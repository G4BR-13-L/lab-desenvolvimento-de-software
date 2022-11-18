package com.labdev.labdev.aluno;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {
    private final AlunoRepository alunoRepository;

    @Autowired
    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public List<Aluno> getAllAlunos() {
        return this.alunoRepository.findAll();
    }

    public void save(Aluno aluno) {
        this.alunoRepository.save(aluno);
    }

    public Aluno findAlunoById(long id) {
        return this.alunoRepository.findAlunoById(id);
    }

    public void deleteAluno(long id) {
        if (!alunoRepository.existsById(id))
            throw new IllegalStateException("Aluno do id:" + id + " não encontrado");
        alunoRepository.deleteById(id);
    }

    @Transactional
    public void updateAluno(
        long id, 
        String nome, 
        String email, 
        String senha, 
        String cpf, 
        String rg ) {
            if (!alunoRepository.existsById(id))
                throw new IllegalStateException("Aluno do id:" + id + " não encontrado");
            Aluno aluno = alunoRepository.findAlunoById(id);
            if (alunoStringVerification(nome, aluno.getNome())) {
                aluno.setNome(nome);
            }
            if (alunoStringVerification(email, aluno.getEmail())) {
                aluno.setEmail(email);
            }
            if (alunoStringVerification(senha, aluno.getSenha())) {
                aluno.setSenha(senha);
            }
            if (alunoStringVerification(cpf, aluno.getCpf())) {
                if (cpfVerification(cpf)) {
                    throw new IllegalStateException("cpf em uso ou inexitente");
                }
                aluno.setCpf(cpf);
            }
            if (alunoStringVerification(rg, aluno.getRg())) {
                aluno.setRg(rg);
            }
        

    }

    private String cpfFormatter(String cpf) {
        return cpf;
    }

    private boolean alunoStringVerification(String newStr, String actual) {
        return (newStr != null && newStr.length() > 0 && !newStr.equals(actual));
    }

    private boolean cpfVerification(String cpf) {
        Optional<Aluno> alunoOptional = alunoRepository.findAlunoByCpf(cpf);
        return (alunoOptional.isPresent());
    }
}
