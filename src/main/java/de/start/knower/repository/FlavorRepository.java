package de.start.knower.repository;

import de.start.knower.model.Flavor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlavorRepository extends JpaRepository<Flavor, Long>{ 

}
