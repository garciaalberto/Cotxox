/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foobarspam.mvc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import org.foobarspam.repository.Conductor;
import org.foobarspam.repository.ConductorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Sergi
 */
@RestController
@RequestMapping("/poolConductores")
public class ConductorController {

    private ConductorRepository conductorRepository;

    @Autowired
    public ConductorController(ConductorRepository conductorRepository) {
        this.conductorRepository = conductorRepository;
    }

    //Todos Conductores
    @RequestMapping(value = "/all", method = RequestMethod.GET)

    public List<Conductor> getAll() {
        return this.conductorRepository.findAll();
    }

    @RequestMapping(value = "/setpickup", method = RequestMethod.GET)
    public Conductor getRandomConductor() {
        Conductor c = null;
        ArrayList<Conductor> listaConductores = (ArrayList<Conductor>) this.conductorRepository;
        do {
            c = listaConductores.get(ThreadLocalRandom.current().nextInt(0, listaConductores.size()));
        } while (!c.getOcupado());
        return c;
    }

    //Conductores con la valoracion indicada
    @RequestMapping(value = "/fiables/{valoracionMedia}", method = RequestMethod.GET)
    public List<Conductor> getAffordable(@PathVariable double valoracionMedia) {
        return conductorRepository.findByValoracionMediaLessThan(valoracionMedia);
    }


    /*
    @RequestMapping(value = "/disponibles/{ocupado}", method = RequestMethod.GET) 
    public List<Conductor> getDisponibles(@PathVariable boolean ocupado) { 
        return this.poolConductores.stream().filter(x -> x.isOcupado() == ocupado).collect(Collectors.toList()); 
    } 
     */
    //Conductores disponibles o ocupados
    @RequestMapping(value = "/disponibles/{ocupado}", method = RequestMethod.GET)
    public List<Conductor> getDisponibles(@PathVariable int ocupado) {
        switch (ocupado) {
            case 0:
                return conductorRepository.findByOcupadoTrue();
            case 1:
                return conductorRepository.findByOcupadoFalse();
            default:
                return null;
        }

    }

    //Crear
    @RequestMapping(value = "/crear", method = RequestMethod.POST)

    public List<Conductor> crearConductor(@RequestBody Conductor conductor) {

        conductorRepository.save(conductor);
        return this.conductorRepository.findAll();

    }

    //Eliminar
    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.POST)

    public List<Conductor> eliminarConductor(@RequestBody Long id) {

        conductorRepository.delete(id);
        return this.conductorRepository.findAll();

    }

}
