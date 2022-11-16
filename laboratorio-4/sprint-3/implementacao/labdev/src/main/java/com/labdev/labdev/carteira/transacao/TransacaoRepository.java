package com.labdev.labdev.carteira.transacao;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

}
