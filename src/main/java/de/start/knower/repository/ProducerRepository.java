package de.start.knower.repository;

import de.start.knower.model.Producer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProducerRepository extends JpaRepository<Producer, Long>{
    
}
