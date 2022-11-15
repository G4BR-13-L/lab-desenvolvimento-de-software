package com.labdev.labdev.carteira;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CarteiraAlunoRepository extends JpaRepository<CarteiraAluno, Long> {

}
