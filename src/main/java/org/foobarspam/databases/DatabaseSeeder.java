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
        ArrayList<Byte> valoracionesRick = new ArrayList<>();
        valoracionesRick.add((byte)3); valoracionesRick.add((byte)4); valoracionesRick.add((byte)2); valoracionesRick.add((byte)4); valoracionesRick.add((byte)4);
        ArrayList<Byte> valoracionesMorty = new ArrayList<>();
        valoracionesMorty.add((byte)5); valoracionesMorty.add((byte)4); valoracionesMorty.add((byte)4); valoracionesMorty.add((byte)3); valoracionesMorty.add((byte)4);
        ArrayList<Byte> valoracionesLeia = new ArrayList<>();
        valoracionesLeia.add((byte)5); valoracionesLeia.add((byte)4); valoracionesLeia.add((byte)4); valoracionesLeia.add((byte)4); valoracionesLeia.add((byte)4);
        ArrayList<Byte> valoracionesHan = new ArrayList<>();
        valoracionesHan.add((byte)5); valoracionesHan.add((byte)5); valoracionesHan.add((byte)4); valoracionesHan.add((byte)5); valoracionesHan.add((byte)5);
        ArrayList<Byte> valoracionesAlphonse = new ArrayList<>();
        valoracionesAlphonse.add((byte)1); valoracionesAlphonse.add((byte)2); valoracionesAlphonse.add((byte)1); valoracionesAlphonse.add((byte)1); valoracionesAlphonse.add((byte)1);
        
        poolConductores.add(new Conductor("Rick Sánchez", "CBV 4005", "Space crusher", false, valoracionesRick, "ConductorRick.jpg", "VehiculoRick.jpg"));
        poolConductores.add(new Conductor("Morty Smith", "JGB 4475", "Morty Smith", false, valoracionesMorty, "ConductorMorty.jpg", "VehiculoMorty.jpg"));
        poolConductores.add(new Conductor("Leia Organa", "FHD 6416", "Tantive IV", true, valoracionesLeia, "ConductorLeia.jpg", "VehiculoLeia.jpg"));
        poolConductores.add(new Conductor("Han Solo", "FBK 7645", "Halcón milenario", false, valoracionesHan, "ConductorHan.jpg", "VehiculoHan.jpg"));
        poolConductores.add(new Conductor("Hernando Alphonse", "JSD 4567", "Honda McLaren", false, valoracionesAlphonse, "ConductorAlphonse.jpg", "VehiculoAlphonse.jpg"));

        conductorRepository.save(poolConductores);

    }

}
