package FooBarSpam.Cotxox.Conductor;

import java.util.ArrayList;

public class Conductor {
	// Propiedades privadas
	private String nombre = null;
	private String matricula = null;
	private String modelo = null;
	private ArrayList<Byte> valoraciones = new ArrayList<Byte>();
	private boolean ocupado = false;
	private double valoracionMedia = 0d;
	
	// Constructores
	public Conductor() {
		
	}
	
	public Conductor(String nombre) {
		this.nombre = nombre;
	}

	// Setters y Getters
	public String getNombre() {
		return this.nombre;
	}

	public String getMatricula() {
		return this.matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getModelo() {
		return this.modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public void setValoracion(Byte valoracion) {
		this.valoraciones.add(valoracion);
		this.actualizarMedia();
	}

	public ArrayList<Byte> getValoraciones() {
		return this.valoraciones;
	}

	public boolean isOcupado() {
		return ocupado;
	}

	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}
	
	public void actualizarMedia() {

		double suma = 0.0;

		for (Byte valoracion : this.getValoraciones()) {
			suma += valoracion;
		}
		
		double media = suma / this.getValoraciones().size();
		this.setValoracionMedia(media);
	}

	public double getValoracionMedia() {
		return valoracionMedia;
	}

	public void setValoracionMedia(double valoracionMedia) {
		this.valoracionMedia = valoracionMedia;
	}
	
	public double getValoracion() {
		return this.valoracionMedia;
	}
	
	
}