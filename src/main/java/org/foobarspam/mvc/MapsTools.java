/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foobarspam.mvc;

import static antlr.Utils.error;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import maps.java.*;

/**
 *
 * @author Sergi
 */
public class MapsTools {

    private double distanciaTotal;

    Route ruta = new Route();

    public void calcularRuta() {
        try {
            String[][] resultado = ruta.getRoute("Inca", "Selva", null, Boolean.TRUE, Route.mode.driving, Route.avoids.nothing);

        } catch (Exception e) {
            error("Ruta no válida");
        }

    }

}
