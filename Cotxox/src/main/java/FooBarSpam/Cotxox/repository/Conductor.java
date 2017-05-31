package FooBarSpam.Cotxox.repository;

import java.util.ArrayList;
import javax.persistence.*;

@Entity
@Table
public class Conductor{
    // Propiedades privadas

    @Id
    @Column
    private String id = null;
    @Column
    private String nombre = null;
    @Column
    private String matricula = null;
    @Column
    private String modelo = null;
    private ArrayList<Byte> valoraciones = new ArrayList<Byte>();
    @Column
    private boolean ocupado = false;
    @Column
    private double valoracionMedia = 0d;

    // Constructores
    public Conductor() {

    }

    public Conductor(String id) {
        this.id = id;
    }

    // Metodos
    public void actualizarMedia() {

        double suma = 0.0;

        for (Byte valoracion : this.getValoraciones()) {
            suma += valoracion;
        }

        double media = suma / this.getValoraciones().size();
        this.setValoracionMedia(media);
    }

    // Setters y Getters
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the matricula
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * @param matricula the matricula to set
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the valoraciones
     */
    public ArrayList<Byte> getValoraciones() {
        return valoraciones;
    }

    /**
     * @param valoraciones the valoraciones to set
     */
    public void setValoraciones(ArrayList<Byte> valoraciones) {
        this.valoraciones = valoraciones;
    }

    /**
     * @return the ocupado
     */
    public boolean isOcupado() {
        return ocupado;
    }

    /**
     * @param ocupado the ocupado to set
     */
    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    /**
     * @return the valoracionMedia
     */
    public double getValoracionMedia() {
        return valoracionMedia;
    }

    /**
     * @param valoracionMedia the valoracionMedia to set
     */
    public void setValoracionMedia(double valoracionMedia) {
        this.valoracionMedia = valoracionMedia;
    }
    

}
