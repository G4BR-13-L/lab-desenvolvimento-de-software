package com.labdev.labdev.repository;

import org.springframework.stereotype.Repository;

import com.labdev.labdev.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
