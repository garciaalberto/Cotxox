package org.foobarspam.repository;

import java.util.ArrayList;
import javax.persistence.*;

@Entity
public class Conductor {
    // Propiedades privadas

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id = null;
    private String nombre = null;
    private String matricula = null;
    private String modelo = null;
    private ArrayList<Byte> valoraciones = new ArrayList<Byte>();
    private Boolean ocupado = false;
    private double valoracionMedia = 0d;

    // Constructores
    public Conductor() {

    }

    public Conductor(String nombre, String matricula, String modelo, Boolean ocupado, double valoracionMedia) {

        this.nombre = nombre;
        this.matricula = matricula;
        this.modelo = modelo;
        this.ocupado = ocupado;
        this.valoracionMedia = valoracionMedia;

    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public ArrayList<Byte> getValoraciones() {
        return valoraciones;
    }

    public Boolean getOcupado() {
        return ocupado;
    }

    public double getValoracionMedia() {
        return valoracionMedia;
    }
    
    

}
