package ar.edu.unlp.info.oo1;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.MONTHS;

public class ContratoDePlanta extends Contrato {
    private double sueldo;
    private double montoConyuge;
    private double montoHijos;
    private Empleado empleado;

    public ContratoDePlanta(LocalDate fechaInicio, double sueldo, double montoConyuge, double montoHijos, Empleado empleado) {
        super(fechaInicio);
        this.sueldo = sueldo;
        this.montoConyuge = montoConyuge;
        this.montoHijos = montoHijos;
        this.empleado = empleado;
    }

    @Override
    public double montoMensual() {
        double total = sueldo;
        if (empleado.tieneConyuge())
            total += montoConyuge;
        if (empleado.tieneHijos())
            total += montoHijos;
        return total;
    }

    @Override
    public int antiguedadEnMeses() {
        return (int) MONTHS.between(this.getFechaInicio(), LocalDate.now());
    }

    @Override
    public boolean estaVigente() {
        return true;
    }

}
