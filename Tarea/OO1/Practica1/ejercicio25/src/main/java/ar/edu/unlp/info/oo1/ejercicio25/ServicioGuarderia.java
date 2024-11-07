package ar.edu.unlp.info.oo1.ejercicio25;

import java.time.LocalDate;

public class ServicioGuarderia extends Servicio{
    private int cantidadDias;
    private LocalDate fechaInicio;
    private final double COSTO_DIARIO = 500;

    public ServicioGuarderia(Mascota mascota, int cantidadDias) {
        super(mascota);
        this.cantidadDias = cantidadDias;
        this.fechaInicio = LocalDate.now();
        this.costo = calcularCosto();
    }

    public int getCantidadDias() {
        return this.cantidadDias;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    @Override
    protected double calcularCosto() {
        double costoBase = this.cantidadDias * COSTO_DIARIO;
        if(mascota.getCantidadServicios() >= 5)
            return costoBase - costoBase * 0.1;
        return costoBase;
    }
}
