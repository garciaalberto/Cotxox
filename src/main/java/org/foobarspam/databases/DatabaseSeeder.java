
package org.foobarspam.databases;

import org.foobarspam.repository.Conductor;
import org.foobarspam.repository.ConductorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;



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
        ArrayList<Byte> valoracionesBatman = new ArrayList<>();
        valoracionesBatman.add((byte)3); valoracionesBatman.add((byte)2); valoracionesBatman.add((byte)5); valoracionesBatman.add((byte)3); valoracionesBatman.add((byte)4);
        
        poolConductores.add(new Conductor("Rick Sánchez", "CBV 4005", "Space cruiser", false, valoracionesRick, "./img/ConductorRick.jpg", "./img/VehiculoRick.jpg"));
        poolConductores.add(new Conductor("Morty Smith", "JGB 4475", "Morty Smith", false, valoracionesMorty, "./img/ConductorMorty.jpg", "./img/VehiculoMorty.jpg"));
        poolConductores.add(new Conductor("Leia Organa", "FHD 6416", "Tantive IV", true, valoracionesLeia, "./img/ConductorLeia.jpg", "./img/VehiculoLeia.jpg"));
        poolConductores.add(new Conductor("Han Solo", "FBK 7645", "Halcón milenario", false, valoracionesHan, "./img/ConductorHan.jpg", "./img/VehiculoHan.jpg"));
        poolConductores.add(new Conductor("Hernando Alphonse", "JSD 4567", "Honda McLaren", false, valoracionesAlphonse, "./img/ConductorAlphonse.jpg", "./img/VehiculoAlphonse.jpg"));
        poolConductores.add(new Conductor("Batman", "BAT 0202", "Batcotxox", false, valoracionesBatman, "./img/ConductorBatman.jpg", "./img/VehiculoBatman.jpg"));
        
        conductorRepository.save(poolConductores);

    }

}
