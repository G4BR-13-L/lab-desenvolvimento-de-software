package com.labdev.labdev.vantagem;




import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VantagemRepository extends JpaRepository<Vantagem, Long>{
    
    Vantagem findVantagemById( Long id );
}
