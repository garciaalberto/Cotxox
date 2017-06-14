/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foobarspam.mvc;

import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;
import org.foobarspam.databases.DatabaseSeeder;
import org.foobarspam.repository.Conductor;
import org.foobarspam.repository.ConductorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VistaController {

    private String appMode;
    private double costeTotal;
    private String destino;

    @Autowired
    public VistaController(Environment environment , ConductorRepository conductorRepository) {
        appMode = environment.getProperty("app-mode");
    }

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("datetime", new Date());
        model.addAttribute("username", "Admin");
        model.addAttribute("mode", appMode);

        return "index";
    }

    /*
    @RequestMapping(value = "/setpickup/{destino}", method = RequestMethod.GET)
    public String setpickup(Model model, @RequestBody String destino) {

        MapsTools ruta = new MapsTools();
        ruta.calcularRuta("IES Borja Moll", destino);
        double distancia = ruta.getDistanciaTotal();
        double tiempo = ruta.getTiempoTotal();
        String url = ruta.getUrlMapaDesino();
        model.addAttribute("costeTotal", distancia);
        return "setpickup";
    }
     */
    @RequestMapping("/app")
    public String setpickup(Model model) {
    	Tarifa tarifa = new Tarifa();
        this.costeTotal = tarifa.calculatePrecio(tarifa.randomizeDistance(), tarifa.randomizeTime());
        model.addAttribute("costeTotal", this.costeTotal);
        return "app";
    }
}
