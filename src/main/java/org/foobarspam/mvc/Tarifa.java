package org.foobarspam.mvc;

import java.util.concurrent.ThreadLocalRandom;

public class Tarifa{
	
    private double tiempo = 0d;
    private double distancia = 0d;
    private final double minimo = 5.0;
    private final double costeTiempo = 0.35;
    private final double costeMilla = 1.35;

    Tarifa(){

    }

    Tarifa(double distancia, double tiempo){
            this.tiempo = tiempo;
            this.distancia = distancia;
    }



    public double getTiempo() {
            return this.tiempo;
    }

    public void setTiempo(double tiempo) {
            this.tiempo = tiempo;
    }

    public double getDistancia() {
            return this.distancia;
    }

    public void setDistancia(double distancia) {
            this.distancia = distancia;
    }

    public double getMinimo() {
            return this.minimo;
    }

    public double getCosteTiempo() {
            return this.costeTiempo;
    }

    public double getCosteMilla() {
            return this.costeMilla;
    }

    public double calculatePrecio(double distancia, double tiempo) {
    tiempo = tiempo * getCosteTiempo();
    distancia = distancia * getCosteMilla();
        if ((tiempo + distancia) > getMinimo()) {
            return Redondear(tiempo + distancia);
        } else {
            return getMinimo();
        }
    }
        
    public double Redondear(double numero)
    {
          return Math.rint(numero*100)/100;
    }

    public double randomizeDistance() {
    double distance = ThreadLocalRandom.current().nextInt(0, 30);
    return distance;
    }

    public double randomizeTime() {
        double time = ThreadLocalRandom.current().nextInt(0, 30);
        return time;
    }
	
}