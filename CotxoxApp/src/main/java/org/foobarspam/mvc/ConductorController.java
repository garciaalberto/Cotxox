/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foobarspam.mvc;

import java.util.ArrayList;
import java.util.List;
import org.foobarspam.repository.Conductor;
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

    private List<Conductor> poolConductores;

    public ConductorController() {
        poolConductores = new ArrayList<>();

        poolConductores.add(new Conductor("001", "Rick Sánchez", "CBV 4005", "Seat Panda", true, 5.4));
        poolConductores.add(new Conductor("002", "Mortimer Smith", "JGB 4475", "Peugeot 307 HDI", true, 7.8));
        poolConductores.add(new Conductor("003", "Leia Organa", "FHD 6416", "Toyota Corolla", true, 6.7));
        poolConductores.add(new Conductor("004", "Hann Solo", "FBK 7645", "Ford Europa", true, 8.9));
        poolConductores.add(new Conductor("005", "Hernando Alphonse", "JSD 4567", "Honda McLaren", true, 0.5));

    }
    
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Conductor> getAll(){
        return this.poolConductores;
    }

}
