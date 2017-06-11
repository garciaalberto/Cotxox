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
        String origen = "Selva";
        String destino = "Manacor";
        MapsTools ruta = new MapsTools();
        ruta.calcularRuta(origen, destino);
        System.out.println("#####CALULANDO RUTA... De " + origen + " a " + destino + " ##########");
        System.out.println("Tiempo: " + ruta.getTiempoTotal() + " segundos\n"
                + "Distancia: " + ruta.getDistanciaTotal() + " metros\nUrl Imagen: " + ruta.getUrlMapaDesino());

    }
     @Test
    public void testObtenerMapaDestino2() {
        String origen = "Ies Borja Moll";
        String destino = "Manacor";
        MapsTools ruta = new MapsTools();
        ruta.calcularRuta(origen, destino);
        System.out.println("#####CALULANDO RUTA... De " + origen + " a " + destino + " ##########");
        System.out.println("Tiempo: " + ruta.getTiempoTotal() + " segundos\n"
                + "Distancia: " + ruta.getDistanciaTotal() + " metros\nUrl Imagen: " + ruta.getUrlMapaDesino());

    }

}
