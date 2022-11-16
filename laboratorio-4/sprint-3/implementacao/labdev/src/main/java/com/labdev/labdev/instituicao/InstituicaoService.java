package com.labdev.labdev.instituicao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.labdev.labdev.carteira.CarteiraRepository;
import com.labdev.labdev.professor.Professor;
import com.labdev.labdev.professor.ProfessorRepository;
import com.labdev.labdev.usuario.UsuarioRepository;

@Service
public class InstituicaoService {
    
    private final UsuarioRepository usuarioRepository;
    private final ProfessorRepository professorRepository;
    
    @Autowired
    public InstituicaoService(
            CarteiraRepository carteiraRepository,
            UsuarioRepository usuarioRepository,
            ProfessorRepository professorRepository
            ) {
        this.usuarioRepository = usuarioRepository;
        this.professorRepository = professorRepository;
    }


    @Transactional
    public void distribuirMoedas( int moedas) {
        List<Professor> professores = professorRepository.findAll();
        for( int i = 0 ; i < professores.size(); i++){
            professores.get(i).getCarteira().incrementarSaldo(moedas);
        }
        //professores.stream().forEach((p) -> p.getCarteira().incrementarSaldo(moedas));
    }
}
