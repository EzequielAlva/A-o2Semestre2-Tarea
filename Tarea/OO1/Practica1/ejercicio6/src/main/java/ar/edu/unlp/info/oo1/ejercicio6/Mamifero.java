package ar.edu.unlp.info.oo1.ejercicio6;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Mamifero {
	 private String identificador;
	 private String especie;
	 private LocalDate fechaNacimiento;
	 private Mamifero padre;
	 private Mamifero madre;
	 private static List<Mamifero> familiares;

	 public Mamifero() {
		 familiares = new ArrayList<Mamifero>();
	 }

	 public Mamifero(String identificador) {
		 this();
		 this.identificador = identificador;
	 }

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Mamifero getPadre() {
		return padre;
	}

	public void setPadre(Mamifero padre) {
		this.padre = padre;
		familiares.add(padre);
	}

public Mamifero getMadre() {
	return madre;
}

public void setMadre(Mamifero madre) {
	this.madre = madre;
	familiares.add(madre);
}

	public Mamifero getAbueloMaterno() {
		 if(tieneMadre())
			 return this.madre.getPadre();
		 return null;
	}

	public void setAbueloMaterno(Mamifero abueloMaterno) {
		this.madre.setPadre(abueloMaterno);
	}

	public Mamifero getAbuelaMaterna() {
		 if(tieneMadre())
			 return this.madre.getMadre();
		 return null;
	 }

	public void setAbuelaMaterna(Mamifero abuelaMaterna) {
		this.madre.setMadre(abuelaMaterna);
	}

	public Mamifero getAbueloPaterno() {
		 if(tienePadre())
			 return this.padre.getPadre();
		 return null;
	}

	public void setAbueloPaterno(Mamifero abueloPaterno) {
		this.padre.setPadre(abueloPaterno);
	}

	public Mamifero getAbuelaPaterna() {
		if(tienePadre())
	 		return this.padre.getMadre();
		return null;
	}

	public void setAbuelaPaterna(Mamifero abuelaPaterna) {
		this.padre.setMadre(abuelaPaterna);
	}
 
	 public boolean tieneComoAncestroA(Mamifero unMamifero) {
		 Mamifero ancestro = this.familiares.stream()
				 .filter(familiar -> familiar.getIdentificador().equals(unMamifero.getIdentificador()))
				 .findFirst()
				 .orElse(null);
		 return ancestro != null;
	 }

	 private boolean tieneMadre() {
	 	return this.madre != null;
	 }

	 private boolean tienePadre() {
	 	return this.padre != null;
	 }
}
