package com.labdev.labdev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.labdev.labdev.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

}
