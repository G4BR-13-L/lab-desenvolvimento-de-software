package com.labdev.labdev.config;

import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.labdev.labdev.carteira.CarteiraProfessor;
import com.labdev.labdev.carteira.CarteiraProfessorRepository;
import com.labdev.labdev.instituicao.Instituicao;
import com.labdev.labdev.instituicao.InstituicaoRepository;
import com.labdev.labdev.professor.Professor;
import com.labdev.labdev.professor.ProfessorRepository;

@Configuration
public class InstituicaoConfig {

    @Bean
    CommandLineRunner commandLineRunner(ProfessorRepository professorRepository,
            InstituicaoRepository instituicaoRepository, CarteiraProfessorRepository carteiraProfessorRepository) {
        return args -> {
            Professor p1 = new Professor();
            Professor p2 = new Professor();
            Professor p3 = new Professor();
            Professor p4 = new Professor();
            CarteiraProfessor c1 = new CarteiraProfessor();
            CarteiraProfessor c2 = new CarteiraProfessor();
            CarteiraProfessor c3 = new CarteiraProfessor();
            CarteiraProfessor c4 = new CarteiraProfessor();
            p1.setCarteira(c1);
            p2.setCarteira(c2);
            p3.setCarteira(c3);
            p4.setCarteira(c4);
            Instituicao ins = new Instituicao();
            ins.setProfessores(List.of(p1, p2, p3, p4));
            ins.distribuirMoedas(1234);
            //instituicaoRepository.save(ins);
            carteiraProfessorRepository.saveAll(List.of(c1,c2,c3,c4));
            professorRepository.saveAll(List.of(p1, p2, p3, p4));
        };
    }
}