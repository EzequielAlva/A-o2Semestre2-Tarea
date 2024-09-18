package ar.edu.unlp.info.oo1.ejercicio5;

public class Cuerpo3D {
	protected double altura;
	protected Figura2D cara;
	
	public Cuerpo3D() {}
	
	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	public double getAltura() {
		return this.altura;
	}
	
	public void setCaraBasal(Figura2D cara) {
		this.cara = cara;
	}
	
	public double getVolumen() {
		return this.cara.getArea() * this.altura;
	}
	
	public double getSuperficieExterior() {
		return 2 * this.cara.getArea() + this.cara.getPerimetro() * this.altura;
	}
}
