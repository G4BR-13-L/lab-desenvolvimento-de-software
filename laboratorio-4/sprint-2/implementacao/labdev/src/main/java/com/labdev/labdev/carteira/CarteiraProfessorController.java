
package com.labdev.labdev.carteira;

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

import com.labdev.labdev.aluno.Aluno;
import com.labdev.labdev.model.transacao.Transacao;
import com.labdev.labdev.model.transacao.TransacaoRequest;
import com.labdev.labdev.professor.Professor;
import com.labdev.labdev.professor.ProfessorRepository;
import com.labdev.labdev.repository.AlunoRepository;
import com.labdev.labdev.usuario.Usuario;
import com.labdev.labdev.usuario.UsuarioRepository;

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
    public ResponseEntity<String> transferir(@RequestBody TransacaoRequest transacaoRequest) {
        // System.out.println(transacaoRequest.getRemetente_id());
        // System.out.println(transacaoRequest.getDestinatario_id());
        // System.out.println(transacaoRequest.getValor());
        Professor professor = professorRepository.getReferenceById(transacaoRequest.getRemetente_id());
        Aluno aluno = alunoRepository.getReferenceById(transacaoRequest.getDestinatario_id());
        
        Transacao transacao = new Transacao(professor.getCarteira(), aluno.getCarteira(), transacaoRequest.getValor());
        
        if( consultarSaldo(professor.getCarteira().totalMoedas(),transacaoRequest.getValor()) ){
            professor.getCarteira().descontarSaldo(transacao.getValor());
            aluno.getCarteira().incrementarSaldo(transacao.getValor());
            
            professor.getCarteira().addTransacao(transacao);
            aluno.getCarteira().addTransacao(transacao);
            
            System.out.println("Aluno Notificado por email");
            
            return new ResponseEntity<>((transacaoRequest).toString(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Saldo de Professor Insuficiente", HttpStatus.OK);
        }
        
    }

    private boolean consultarSaldo(int saldo, int valor){
        if( saldo > valor){
            return true;
        }
        return false;
    }

}
