/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foobarspam.databases;

import org.foobarspam.repository.Conductor;
import org.foobarspam.repository.ConductorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sergi
 */


@Component
public class DatabaseSeeder implements CommandLineRunner {

    private ConductorRepository conductorRepository;

    @Autowired
    public DatabaseSeeder(ConductorRepository conductorRepository) {
        this.conductorRepository = conductorRepository;
    }

    @Override
    public void run(String... strings) throws Exception {

        List<Conductor> poolConductores = new ArrayList<>();

        poolConductores.add(new Conductor("Rick Sánchez", "CBV 4005", "Space crusher", false, 3.7));
        poolConductores.add(new Conductor("Morty Smith", "JGB 4475", "Morty Smith", false, 4.2));
        poolConductores.add(new Conductor("Leia Organa", "FHD 6416", "Tantive IV", true, 3.2));
        poolConductores.add(new Conductor("Hann Solo", "FBK 7645", "Halcón milenario", false, 4.8));
        poolConductores.add(new Conductor("Hernando Alphonse", "JSD 4567", "Honda McLaren", false, 1.2));

        conductorRepository.save(poolConductores);

    }

}
