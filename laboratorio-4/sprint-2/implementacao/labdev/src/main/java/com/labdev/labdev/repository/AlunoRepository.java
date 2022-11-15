package com.labdev.labdev.repository;

import org.springframework.stereotype.Repository;

import com.labdev.labdev.aluno.Aluno;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
