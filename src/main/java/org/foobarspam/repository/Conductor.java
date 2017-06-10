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

    public Conductor(String nombre, String matricula, String modelo, Boolean ocupado, ArrayList<Byte> valoraciones){

        this.nombre = nombre;
        this.matricula = matricula;
        this.modelo = modelo;
        this.ocupado = ocupado;
        this.valoraciones = valoraciones;

    }

    public Long getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getMatricula() {
        return this.matricula;
    }

    public String getModelo() {
        return this.modelo;
    }

    public ArrayList<Byte> getValoraciones() {
        return this.valoraciones;
    }
    
    public ArrayList<Byte> appendValoracion(Byte valoracion) {
        getValoraciones().add(valoracion);
        return getValoraciones();
    }

    public Boolean getOcupado() {
        return this.ocupado;
    }

    public double getValoracionMedia() {
        double valoracionMedia = 0;
        for (Byte valoracion : getValoraciones()){
            valoracionMedia += valoracion;
        }
        valoracionMedia = valoracionMedia/getValoraciones().size();
        return valoracionMedia;
    }
    
    

}
