package com.labdev.labdev.carteira.cupom;


import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CupomRepository extends JpaRepository<Cupom, Long> {

}
