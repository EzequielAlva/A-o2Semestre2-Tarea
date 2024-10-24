package ar.edu.unlp.info.oo1;

import java.time.LocalDate;

public abstract class Contrato {
    private LocalDate fechaInicio;

    public Contrato(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public abstract double montoMensual();

    public abstract int antiguedadEnMeses();

    public abstract boolean estaVigente();
}
