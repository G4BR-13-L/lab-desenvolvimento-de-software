package com.labdev.labdev.empresa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

    Empresa findEmpresaById( Long id );

    @Query("SELECT p FROM Empresa p WHERE p.cpf = ?1")
    Optional<Empresa> findEmpresaByCpf(String cpf);
}
