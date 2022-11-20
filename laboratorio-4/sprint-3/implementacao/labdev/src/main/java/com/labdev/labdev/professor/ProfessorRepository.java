package com.labdev.labdev.professor;

import org.springframework.stereotype.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {

    Professor findProfessorById(Long id);

    @Query("SELECT p FROM Professor p WHERE p.cpf = ?1")
    Optional<Professor> findProfessorByCpf(String cpf);
}
