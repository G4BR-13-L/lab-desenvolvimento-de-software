package com.labdev.labdev.config;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.labdev.labdev.aluno.Aluno;
import com.labdev.labdev.aluno.AlunoRepository;
import com.labdev.labdev.empresa.Empresa;
import com.labdev.labdev.empresa.EmpresaRepository;
import com.labdev.labdev.instituicao.InstituicaoRepository;
import com.labdev.labdev.instituicao.InstituicaoService;
import com.labdev.labdev.professor.Professor;
import com.labdev.labdev.professor.ProfessorRepository;
import com.labdev.labdev.vantagem.Vantagem;
import com.labdev.labdev.vantagem.VantagemRepository;

@Configuration
public class InstituicaoConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            InstituicaoRepository instituicaoRepository,
            ProfessorRepository professorRepository,
            InstituicaoService instituicaoService,
            AlunoRepository alunoRepository,
            EmpresaRepository empresaRepository,
            VantagemRepository vantagemRepository
            ) {
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
            

            Aluno a1 = new Aluno("a1", "a1@rmail.com", "12345678", "MG 12-345.678", "123.456.789-10");
            Aluno a2 = new Aluno("a2", "a2@rmail.com", "12345678", "MG 12-345.678", "123.456.789-10");
            Aluno a3 = new Aluno("a3", "a3@rmail.com", "12345678", "MG 12-345.678", "123.456.789-10");
            Aluno a4 = new Aluno("a4", "a4@rmail.com", "12345678", "MG 12-345.678", "123.456.789-10");
            a1.getCarteira().incrementarSaldo(100);
            a2.getCarteira().incrementarSaldo(100);
            a3.getCarteira().incrementarSaldo(100);
            a4.getCarteira().incrementarSaldo(100);
            alunoRepository.saveAll(List.of(a1, a2, a3, a4));

            Empresa e1 = new Empresa("Empresa A", "empresaa@email.com", "12345678", "06.990.590/0001-23");
            Vantagem v1 = new Vantagem("Biscoito Recheado", "Um biscoito recheado", "https:linkdafoto", 10);
            vantagemRepository.save(v1);
            empresaRepository.save(e1);

            empresaRepository.findEmpresaById(e1.getId()).cadastrarVantagem(vantagemRepository.findVantagemById(v1.getId()));;

        };
    }
}