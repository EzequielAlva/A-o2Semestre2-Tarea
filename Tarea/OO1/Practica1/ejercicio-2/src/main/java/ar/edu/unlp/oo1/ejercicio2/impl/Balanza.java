package ar.edu.unlp.oo1.ejercicio2.impl;

import java.util.ArrayList;
import java.util.List;

public class Balanza {
    private Integer cantidadDeProductos;
    private double precioTotal;
    private double pesoTotal;
    private List<Producto> productos;

    public Balanza() {
        productos = new ArrayList<Producto>();
        this.setCantidadDeProductos(0);
        this.setPesoTotal(0);
        this.setPrecioTotal(0);
    }

    public Integer getCantidadDeProductos() {
        return this.cantidadDeProductos;
    }

    public void setCantidadDeProductos(Integer cantidadDeProductos) {
        this.cantidadDeProductos = cantidadDeProductos;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public double getPesoTotal() {
        return pesoTotal;
    }

    public void setPesoTotal(double pesoTotal) {
        this.pesoTotal = pesoTotal;
    }

    public void ponerEnCero() {
        this.setPesoTotal(0);
        this.setPrecioTotal(0);
        this.setCantidadDeProductos(0);
        this.productos.clear();
    }

    public void agregarProducto(Producto producto) {
        this.productos.add(producto);
        this.setPesoTotal(this.getPesoTotal() + producto.getPeso());
        this.setPrecioTotal(this.getPrecioTotal() + producto.getPrecio());
        this.setCantidadDeProductos(this.getCantidadDeProductos() + 1);
    }

    public Ticket emitirTicket() {
        return new Ticket(this.getCantidadDeProductos(),this.getPesoTotal(),this.getPrecioTotal());
    }
}
