
package org.foobarspam.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConductorRepository extends JpaRepository<Conductor, Long>  {
    
    List<Conductor> findByValoracionMediaGreaterThan(double valoracionMedia);
    List<Conductor> findByOcupadoTrue();
    List<Conductor> findByOcupadoFalse();
    
}
