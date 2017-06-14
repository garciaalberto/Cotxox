
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

    //Conductores con la valoracion indicada
    @RequestMapping(value = "/fiables/{valoracionMedia}", method = RequestMethod.GET)
    public List<Conductor> getFiables(@PathVariable double valoracionMedia) {
        return conductorRepository.findByValoracionMediaGreaterThan(valoracionMedia);
    }

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

    @RequestMapping(value = "/random", method = RequestMethod.GET)
    public List<Conductor> getRandom() {
        List<Conductor> conductores = conductorRepository.findByOcupadoFalse();
        List<Conductor> randomConductor = new ArrayList<Conductor>();
        randomConductor.add(conductores.get(ThreadLocalRandom.current().nextInt(0, conductores.size())));
        return randomConductor;
    }

    //Crear
    @RequestMapping(value = "/crear", method = RequestMethod.POST)

    public List<Conductor> crearConductor(@RequestBody Conductor conductor) {

        conductorRepository.save(conductor);
        return this.conductorRepository.findAll();

    }

    //Eliminar
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public List<Conductor> remove(@PathVariable long id) {
        conductorRepository.delete(id);

        return conductorRepository.findAll();
    }

}
