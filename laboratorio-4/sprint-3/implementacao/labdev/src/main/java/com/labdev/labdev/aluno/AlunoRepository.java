package com.labdev.labdev.aluno;

import org.springframework.stereotype.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {


    Aluno findAlunoById( Long id );

    @Query("SELECT p FROM Aluno p WHERE p.cpf = ?1")
    Optional<Aluno> findAlunoByCpf(String cpf);
}
