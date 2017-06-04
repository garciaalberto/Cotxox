/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foobarspam.mvc;

import java.util.List;
import org.foobarspam.repository.Conductor;
import org.foobarspam.repository.ConductorRepository;
import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiPathParam;
import org.jsondoc.core.pojo.ApiStage;
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
@Api(
        name = "Cotxox API",
        description = "Lista de metodos para manejar cotxox",
        stage = ApiStage.RC)
public class ConductorController {

    private ConductorRepository conductorRepository;

    @Autowired
    public ConductorController(ConductorRepository conductorRepository) {
        this.conductorRepository = conductorRepository;
    }

    //Todos Conductores
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ApiMethod(description = "Obtener todos los conductores")
    public List<Conductor> getAll() {
        return this.conductorRepository.findAll();
    }

    //Conductores con la valoracion indicada
    @RequestMapping(value = "/fiables/{valoracionMedia}", method = RequestMethod.GET)
    @ApiMethod(description = "Obtener todos los conductores con más de 5 de media")
    public List<Conductor> getFiables(@ApiPathParam(name = "valoracionMedia") @PathVariable double valoracionMedia) {
        return this.conductorRepository.findByValoracionMediaLessThan(valoracionMedia);

    }

    /*
    @RequestMapping(value = "/disponibles/{ocupado}", method = RequestMethod.GET) 
    public List<Conductor> getDisponibles(@PathVariable boolean ocupado) { 
        return this.poolConductores.stream().filter(x -> x.isOcupado() == ocupado).collect(Collectors.toList()); 
    } 
     */
    //Conductores disponibles o ocupados
    @RequestMapping(value = "/disponibles/{ocupado}", method = RequestMethod.GET)
    @ApiMethod(description = "Obtener todos los conductores disponibles")
    public List<Conductor> getDisponibles(@ApiPathParam(name = "ocupado") @PathVariable Boolean ocupado) {

        return this.conductorRepository.findByOcupadoTrue(ocupado);
        

    }

    //Crear
    @RequestMapping(value = "/crear", method = RequestMethod.POST)
    @ApiMethod(description = "Crear conductor en la base de datos")
    public List<Conductor> crearConductor(@RequestBody Conductor conductor) {

        conductorRepository.save(conductor);
        return this.conductorRepository.findAll();

    }

    //Eliminar
    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.POST)
    @ApiMethod(description = "Eliminar por id a un conductor")
    public List<Conductor> eliminarConductor(@RequestBody Long id) {

        conductorRepository.delete(id);
        return this.conductorRepository.findAll();

    }

}
