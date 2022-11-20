package com.labdev.labdev.carteira.resgate;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ResgateVantagemRepository extends JpaRepository<ResgateVantagem, Long> {

}
