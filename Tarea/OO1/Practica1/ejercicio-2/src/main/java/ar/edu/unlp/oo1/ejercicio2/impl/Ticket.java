package ar.edu.unlp.oo1.ejercicio2.impl;

import java.time.LocalDate;

public class Ticket {
    private LocalDate fecha;
    private Integer cantidadDeProductos;
    private double pesoTotal;
    private double precioTotal;

    public Ticket(Integer cantidadProductos, double pesoTotal, double precioTotal) {
        setFecha(LocalDate.now());
        setCantidadDeProductos(cantidadProductos);
        setPesoTotal(pesoTotal);
        setPrecioTotal(precioTotal);
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Integer getCantidadDeProductos() {
        return cantidadDeProductos;
    }

    public void setCantidadDeProductos(Integer cantidadDeProductos) {
        this.cantidadDeProductos = cantidadDeProductos;
    }

    public double getPesoTotal() {
        return pesoTotal;
    }

    public void setPesoTotal(double pesoTotal) {
        this.pesoTotal = pesoTotal;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public double impuesto() {
        return this.precioTotal * 0.21;
    }
}
