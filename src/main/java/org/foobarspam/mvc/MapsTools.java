/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foobarspam.mvc;

import static antlr.Utils.error;
import java.awt.Dimension;
import java.awt.Image;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import maps.java.*;

/**
 *
 * @author Sergi
 */
public class MapsTools extends Route {

    private double distanciaTotal;
    private double tiempoTotal;
    private String origen, destino;
    private StaticMaps ObjStatMap = new StaticMaps();
    private Route ruta = new Route();

    public MapsTools() {

    }

    public MapsTools(String origen, String destino) {
        this.origen = origen;
        this.destino = destino;
    }

    public void calcularRuta() {
        try {
            String[][] resultado = this.ruta.getRoute(this.origen, this.destino, null, Boolean.TRUE, Route.mode.driving, Route.avoids.nothing);

        } catch (Exception e) {
            error("Ruta no válida");
        }

    }

    public void calcularRuta(String origen, String destino) {
        this.origen = origen;
        this.destino = destino;
        try {
            String[][] resultado = this.ruta.getRoute(this.origen, this.destino, null, Boolean.TRUE, Route.mode.driving, Route.avoids.nothing);

        } catch (Exception e) {
            error("Ruta no válida");
        }

    }

    public void obtenerMapaDestino() {
        try {
            Image resultadoMapa = ObjStatMap.getStaticMap(this.destino, 15, new Dimension(1000, 1000),
                    1, StaticMaps.Format.png, StaticMaps.Maptype.roadmap);
            System.out.println("La URL asociada al mapa es: " + MapsJava.getLastRequestURL());
        } catch (Exception e) {
            error("Mapas estáticos");
        }

    }

    public double getDistanciaTotal() {
        return distanciaTotal;
    }

    public double getTiempoTotal() {
        return tiempoTotal;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Route getRuta() {
        return ruta;
    }

    public void setRuta(Route ruta) {
        this.ruta = ruta;
    }

}
