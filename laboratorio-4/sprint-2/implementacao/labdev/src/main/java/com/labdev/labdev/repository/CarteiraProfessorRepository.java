package com.labdev.labdev.repository;

import org.springframework.stereotype.Repository;

import com.labdev.labdev.model.CarteiraProfessor;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CarteiraProfessorRepository extends JpaRepository<CarteiraProfessor, Long> {

}
