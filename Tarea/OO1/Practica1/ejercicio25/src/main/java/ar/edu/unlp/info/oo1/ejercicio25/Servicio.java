package ar.edu.unlp.info.oo1.ejercicio25;

import java.time.LocalDate;

public abstract class Servicio {
    protected Mascota mascota;
    protected LocalDate fechaAtencion;
    protected double costo;

    public Servicio(Mascota mascota) {
        this.mascota = mascota;
        this.fechaAtencion = LocalDate.now();
    }

    public Mascota getMascota() {
        return this.mascota;
    }

    public LocalDate getFechaAtencion() {
        return this.fechaAtencion;
    }

    public double getCosto() {
        return this.costo;
    }

    protected abstract double calcularCosto();
}
