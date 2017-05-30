package FooBarSpam.Cotxox.repository;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class PoolConductores implements PoolConductoresRepository {
	private ArrayList<Conductor> conductores = null;
	
	public PoolConductores(){
		
	}
	
	public PoolConductores(ArrayList<Conductor> conductores){
		this.conductores = conductores;
	}

	public ArrayList<Conductor> getConductores() {
		return this.conductores;
	}
	
	public Conductor asignarConductor(){
		int indice = elegirConductor();
		getConductores().get(indice).setOcupado(true);
		return getConductores().get(indice);
	}
	
	// He elegido TheradLocalRandom para dar aleatoriedad a los conductores 
	//y que no vaya cogiendo siempre los del principio de la lista
	private int elegirConductor(){
		int indice = ThreadLocalRandom.current().nextInt(0, getConductores().size());
		while (getConductores().get(indice).isOcupado() == true){
			indice = ThreadLocalRandom.current().nextInt(0, getConductores().size());
		}
		return indice;
	}
}