package com.labdev.labdev.repository;

import org.springframework.stereotype.Repository;

import com.labdev.labdev.model.CarteiraAluno;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CarteiraAlunoRepository extends JpaRepository<CarteiraAluno, Long> {

}
