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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Sergi
 */
@Controller
public class VistaController {

    private String appMode;
    private double costeTotal;

    @Autowired
    public VistaController(Environment environment) {
        appMode = environment.getProperty("app-mode");
    }

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("datetime", new Date());
        model.addAttribute("username", "John");
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
    @RequestMapping("/setpickup")
    public String setpickup(Model model) {
        this.costeTotal = calculatePrecio(randomizeDistance(), randomizeTime());
        model.addAttribute("costeTotal", this.costeTotal);
        return "setpickup";
    }
    
    @RequestMapping("/payment")
    public String payment(Model model) {
        model.addAttribute("costeTotal", this.costeTotal);
        return "payment";
    }
    
    @RequestMapping("/rate")
    public String rate(Model model) {
        
        return "rate";
    }

    private int randomizeCost() {
        int cost = ThreadLocalRandom.current().nextInt(0, 100);
        return cost;

    }

    private double randomizeDistance() {
        double distance = ThreadLocalRandom.current().nextInt(0, 30);
        return distance;
    }

    private double randomizeTime() {
        double time = ThreadLocalRandom.current().nextInt(0, 30);
        return time;
    }

    private double calculatePrecio(double distancia, double tiempo) {
        tiempo = tiempo * 0.35;
        distancia = distancia * 1.35;
        if ((tiempo + distancia) > 5) {
            return tiempo + distancia;
        } else {
            return 5;
        }
    }
}
