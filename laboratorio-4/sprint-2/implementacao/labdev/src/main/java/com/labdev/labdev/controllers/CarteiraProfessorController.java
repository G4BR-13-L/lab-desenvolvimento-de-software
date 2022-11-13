
package com.labdev.labdev.controllers;

import java.util.List;

import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.labdev.labdev.model.Aluno;
import com.labdev.labdev.model.Professor;
import com.labdev.labdev.model.Usuario;
import com.labdev.labdev.model.transacao.Transacao;
import com.labdev.labdev.model.transacao.TransacaoRequest;
import com.labdev.labdev.repository.AlunoRepository;
import com.labdev.labdev.repository.CarteiraProfessorRepository;
import com.labdev.labdev.repository.ProfessorRepository;
import com.labdev.labdev.repository.UsuarioRepository;

@Controller
@RequestMapping("/carteira-professor")
public class CarteiraProfessorController {
    private final CarteiraProfessorRepository carteiraProfessorRepository;
    private final UsuarioRepository usuarioRepository;
    private final ProfessorRepository professorRepository;
    private final AlunoRepository alunoRepository;

    @Autowired
    public CarteiraProfessorController(
            CarteiraProfessorRepository carteiraProfessorRepository,
            UsuarioRepository usuarioRepository,
            ProfessorRepository professorRepository,
            AlunoRepository alunoRepository
            ) {
        this.carteiraProfessorRepository = carteiraProfessorRepository;
        this.usuarioRepository = usuarioRepository;
        this.professorRepository = professorRepository;
        this.alunoRepository = alunoRepository;
    }

    @PostMapping(path = "/transferir")
    public ResponseEntity<TransacaoRequest> transferir(@RequestBody TransacaoRequest transacaoRequest) {
        // System.out.println(transacaoRequest.getRemetente_id());
        // System.out.println(transacaoRequest.getDestinatario_id());
        // System.out.println(transacaoRequest.getValor());
        Professor professor = professorRepository.getReferenceById(transacaoRequest.getRemetente_id());
        Aluno aluno = alunoRepository.getReferenceById(transacaoRequest.getDestinatario_id());
        
        Transacao transacao = new Transacao(professor.getCarteira(), aluno.getCarteira(), transacaoRequest.getValor());
        
        professor.getCarteira().descontarSaldo(transacao.getValor());
        aluno.getCarteira().incrementarSaldo(transacao.getValor());

        professor.getCarteira().addTransacao(transacao);
        aluno.getCarteira().addTransacao(transacao);

        System.out.println("Aluno Notificado por email");

        return new ResponseEntity<>(transacaoRequest, HttpStatus.OK);
    }

}
