/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foobarspam.mvc;

import static antlr.Utils.error;
import java.awt.Dimension;
import java.awt.Image;
import maps.java.MapsJava;
import maps.java.Route;
import maps.java.StaticMaps;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sergi
 */
public class MapsToolsTest {

    public MapsToolsTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testCalcularRuta() {
        Route ruta = new Route();
        double distanciaTotal = 0;
        double tiempoTotal = 0;
        try {
            String[][] resultado = ruta.getRoute("Inca", "Selva", null, Boolean.TRUE, Route.mode.driving, Route.avoids.nothing);

        } catch (Exception e) {
            error("Ruta no válida");
        }
        for (double tiempo : ruta.getTotalTime()) {
            tiempoTotal += tiempo;
        }

        System.out.println("Tiempo total: " + tiempoTotal + " segundos.");

        for (double distancia : ruta.getTotalDistance()) {
            distanciaTotal += distancia;
        }

        System.out.println("Distancia total: " + distanciaTotal + " metros.");

    }

    @Test
    public void testObtenerMapaDestino() {
        StaticMaps ObjStatMap = new StaticMaps();
        try {
            Image resultadoMapa = ObjStatMap.getStaticMap("Selva", 15, new Dimension(1000, 1000),
                    1, StaticMaps.Format.png, StaticMaps.Maptype.roadmap);
            System.out.println("La URL asociada al mapa es: " + MapsJava.getLastRequestURL());
        } catch (Exception e) {
            error("Mapas estáticos");
        }

    }

}
