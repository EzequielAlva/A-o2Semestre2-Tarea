package ar.edu.unlp.info.oo1.ejercicio5;

public class Circulo implements Figura2D{
	private double radio;
	
	public Circulo() {}
	
	public void setRadio(double radio) {
		this.radio = radio;
	}
	
	public double getRadio() {
		return this.radio;
	}
	
	public double getDiametro() {
		return this.radio * 2;
	}
	
	public void setDiametro(double diametro) {
		this.radio = diametro / 2;
	}
	
	@Override
	public double getPerimetro() {
		return Math.PI * this.getDiametro();
	}
	
	@Override
	public double getArea() {
		return Math.PI * Math.pow(this.radio, 2);
	}
}
