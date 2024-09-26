package ar.edu.unlp.info.oo1.ejercicio11;

public class InversionEnAcciones implements Inversion{
    private String nombre;
    private int cantidad;
    private double valorUnitario;

    public InversionEnAcciones() {
        this.cantidad = 0;
        this.valorUnitario = 1;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    @Override
    public double valorActual() {
        return cantidad * valorUnitario;
    }
}
