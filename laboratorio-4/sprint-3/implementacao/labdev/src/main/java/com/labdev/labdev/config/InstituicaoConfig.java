package com.labdev.labdev.config;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.labdev.labdev.instituicao.InstituicaoRepository;
import com.labdev.labdev.instituicao.InstituicaoService;
import com.labdev.labdev.professor.Professor;
import com.labdev.labdev.professor.ProfessorRepository;

@Configuration
public class InstituicaoConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            InstituicaoRepository instituicaoRepository,
            ProfessorRepository professorRepository,
            InstituicaoService instituicaoService) {
        return args -> {
            Professor p1 = new Professor("p1", "p1@rmail.com", "12345678", "MG 12-345.678", "123.456.789-10");
            Professor p2 = new Professor("p2", "p2@rmail.com", "12345678", "MG 12-345.678", "123.456.789-10");
            Professor p3 = new Professor("p3", "p3@rmail.com", "12345678", "MG 12-345.678", "123.456.789-10");
            Professor p4 = new Professor("p4", "p4@rmail.com", "12345678", "MG 12-345.678", "123.456.789-10");
            p1.getCarteira().incrementarSaldo(200);
            p2.getCarteira().incrementarSaldo(200);
            p3.getCarteira().incrementarSaldo(200);
            p4.getCarteira().incrementarSaldo(200);
            professorRepository.saveAll(List.of(p1, p2, p3, p4));
            // instituicaoService.distribuirMoedas(1234);
            // Instituicao ins = new Instituicao("PUC Minas", "puc@rmail.com", "12345678",
            // "1235.456.45789-14530");
            // ins.setProfessores(List.of(p1, p2, p3, p4));
            // instituicaoRepository.save(ins);
        };
    }
}