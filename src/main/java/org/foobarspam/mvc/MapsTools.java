/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.foobarspam.mvc;

import static antlr.Utils.error;
import java.awt.Dimension;
import java.awt.Image;
import maps.java.*;

/**
 *
 * @author Sergi
 */
public class MapsTools extends Route {

    private double distanciaTotal;
    private double tiempoTotal;
    private String origen, destino;
    private String UrlMapaDesino;
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

            StaticMaps ObjStatMap = new StaticMaps();
            String[][] resultado = this.ruta.getRoute(this.origen, this.destino, null, Boolean.TRUE, Route.mode.driving, Route.avoids.nothing);
            Image resultadoMapa = ObjStatMap.getStaticMap(this.destino, 15, new Dimension(1000, 1000),
                    1, StaticMaps.Format.png, StaticMaps.Maptype.roadmap);

            this.UrlMapaDesino = MapsJava.getLastRequestURL();
        } catch (Exception e) {
            error("Ruta no válida");
        }

        parsearResultado();

    }

    private void parsearResultado() {
        double dTotal = 0;
        double tTotal = 0;

        for (double distancia : ruta.getTotalDistance()) {
            dTotal += distancia;
        }

        this.distanciaTotal = dTotal;
        for (double tiempo : ruta.getTotalTime()) {
            tTotal += tiempo;
        }

        this.tiempoTotal = tTotal;

    }

    //Per si volem sa imatge en local
    /*
    public void obtenerMapaDestino() {

        try {
            Image resultadoMapa = ObjStatMap.getStaticMap(this.destino, 15, new Dimension(1000, 1000),
                    1, StaticMaps.Format.png, StaticMaps.Maptype.roadmap);
            this.UrlMapaDesino = MapsJava.getLastRequestURL();
        } catch (Exception e) {
            error("Mapas estáticos");
        }

    }
     */
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

    public String getUrlMapaDesino() {
        return UrlMapaDesino;
    }

}
