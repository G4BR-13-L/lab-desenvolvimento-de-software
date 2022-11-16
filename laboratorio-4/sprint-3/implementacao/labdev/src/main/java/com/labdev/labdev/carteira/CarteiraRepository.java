package com.labdev.labdev.carteira;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CarteiraRepository extends JpaRepository<Carteira, Long> {

}
