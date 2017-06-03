/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foobarspam.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Sergi
 */
@Repository
public interface ConductorRepository extends JpaRepository<Conductor, Long>  {
    
    List<Conductor> findByValoracionMediaLessThan(double valoracionMedia);
    List<Conductor> findByOcupadoTrue(Boolean ocupado);
    
}
