package ar.edu.unlp.oo1.ejercicio2.impl;

public class Producto {
    private double peso;
    private double precioPorKilo;
    private String descripcion;

    public Producto() { }

    public double getPeso() {
        return this.peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getPrecioPorKilo() {
        return this.precioPorKilo;
    }

    public void setPrecioPorKilo(double precioPorKilo) {
        this.precioPorKilo = precioPorKilo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return getPrecioPorKilo() * getPeso();
    }
}
