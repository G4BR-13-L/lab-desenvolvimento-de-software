package com.labdev.labdev.carteira;

import org.springframework.beans.factory.annotation.Autowired;

import com.labdev.labdev.aluno.Aluno;
import com.labdev.labdev.aluno.AlunoRepository;
import com.labdev.labdev.carteira.transacao.Transacao;
import com.labdev.labdev.carteira.transacao.TransacaoRequest;
import com.labdev.labdev.professor.Professor;
import com.labdev.labdev.professor.ProfessorRepository;

public class CarteiraProfessorService {

    private final ProfessorRepository professorRepository;
    private final AlunoRepository alunoRepository;

    @Autowired
    public CarteiraProfessorService(
            CarteiraProfessorRepository carteiraProfessorRepository,
            ProfessorRepository professorRepository,
            AlunoRepository alunoRepository) {
        this.professorRepository = professorRepository;
        this.alunoRepository = alunoRepository;
    }

    public Comprovante transferir(TransacaoRequest transacaoRequest) {
        Professor professor = professorRepository.getReferenceById(transacaoRequest.getRemetente_id());
        Aluno aluno = alunoRepository.getReferenceById(transacaoRequest.getDestinatario_id());

        Transacao transacao = new Transacao(professor.getCarteira(), aluno.getCarteira(), transacaoRequest.getValor());

        if (consultarSaldo(professor.getCarteira().totalMoedas(), transacaoRequest.getValor())) {
            professor.getCarteira().descontarSaldo(transacao.getValor());
            aluno.getCarteira().incrementarSaldo(transacao.getValor());

            professor.getCarteira().addTransacao(transacao);
            aluno.getCarteira().addTransacao(transacao);

            System.out.println("Aluno Notificado por email");
            return new Comprovante(
                transacao.getData(),
                    professor.getNome(),
                    aluno.getNome(),
                    transacao.getValor()
                    );
        } else {
            return null;
        }

    }

    private boolean consultarSaldo(int saldo, int valor) {
        if (saldo > valor) {
            return true;
        }
        return false;
    }
}
