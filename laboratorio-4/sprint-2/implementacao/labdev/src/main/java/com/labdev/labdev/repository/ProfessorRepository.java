package com.labdev.labdev.repository;

import org.springframework.stereotype.Repository;

import com.labdev.labdev.model.Professor;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {

}
