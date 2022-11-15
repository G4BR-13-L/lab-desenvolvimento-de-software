
package com.labdev.labdev.carteira;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.labdev.labdev.aluno.Aluno;
import com.labdev.labdev.aluno.AlunoRepository;
import com.labdev.labdev.carteira.exception.SaldoInsuficienteException;
import com.labdev.labdev.carteira.transacao.Transacao;
import com.labdev.labdev.carteira.transacao.TransacaoRequest;
import com.labdev.labdev.professor.Professor;
import com.labdev.labdev.professor.ProfessorRepository;
import com.labdev.labdev.usuario.UsuarioRepository;

@Controller
@RequestMapping("/carteira-professor")
public class CarteiraProfessorController {

        
    private final ProfessorRepository professorRepository;
    private final AlunoRepository alunoRepository;

    private final CarteiraProfessorService carteiraProfessorService;
    @Autowired
    public CarteiraProfessorController(
            ProfessorRepository professorRepository,
            AlunoRepository alunoRepository,
            CarteiraProfessorService carteiraProfessorService
            ) {
        this.professorRepository = professorRepository;
        this.alunoRepository = alunoRepository;
        this.carteiraProfessorService = carteiraProfessorService;
    }

    @PostMapping(path = "/transferir")
    public ResponseEntity<Comprovante> transferir(@RequestBody TransacaoRequest transacaoRequest) throws SaldoInsuficienteException {

        Comprovante comprovante = carteiraProfessorService.transferir(transacaoRequest);
        if( comprovante == null ){
            throw new SaldoInsuficienteException("Id not found in the request");
        }
        return new ResponseEntity<>(comprovante, HttpStatus.OK);
    }

}
