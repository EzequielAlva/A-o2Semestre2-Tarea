package ar.edu.unlp.info.oo1.ejercicio15;

import java.time.LocalDate;

public class Factura {
    private String nombreUsuario;
    private String domicilioUsuario;
    private LocalDate fechaEmision;
    private double bonificacion;
    private double montoFinal;

    public Factura(String nombreUsuario, String domicilioUsuario, double bonificacion, double montoFinal) {
        this.nombreUsuario = nombreUsuario;
        this.domicilioUsuario = domicilioUsuario;
        this.fechaEmision = LocalDate.now();
        this.montoFinal = montoFinal;
        this.bonificacion = bonificacion;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getDomicilioUsuario() {
        return domicilioUsuario;
    }

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public double getBonificacion() {
        return bonificacion;
    }

    public double getMontoFinal() {
        return montoFinal;
    }
}
