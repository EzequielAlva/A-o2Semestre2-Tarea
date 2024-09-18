package ar.edu.unlp.info.oo1.ejercicio7;

import java.util.ArrayList;
import java.util.List;

public class Farola {
	private boolean encendida;
	private List<Farola> neighbors;
	
	public Farola() {
		this.encendida = false;
		this.neighbors = new ArrayList<Farola>();
	}
	
	public void pairWithNeighbor( Farola otraFarola ) {
		if(!this.neighbors.contains(otraFarola)) {
			this.neighbors.add(otraFarola);
			otraFarola.pairWithNeighbor(this);
		}
	}
	
	public List<Farola> getNeighbors () {
		return this.neighbors;
	}
	
	public void turnOn() {
		if(!this.encendida) {
			this.encendida = true;
			this.neighbors.stream().forEach(farola -> farola.turnOn());
		}
	}
	
	public void turnOff() {
		if(this.encendida) {
			this.encendida = false;
			this.neighbors.stream().forEach(farola -> farola.turnOff());
		}
	}
	
	public boolean isOn() {
		return this.encendida;
	}
	
	public boolean isOff() {
		return !this.encendida;
	}
}
