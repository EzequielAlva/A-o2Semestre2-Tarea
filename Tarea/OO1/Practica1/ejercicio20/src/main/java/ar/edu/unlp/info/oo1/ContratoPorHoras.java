package ar.edu.unlp.info.oo1;


import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.MONTHS;

public class ContratoPorHoras extends Contrato {
    private double valorHora;
    private double cantHorasAlMes;
    private LocalDate fechaFin;

    public ContratoPorHoras(LocalDate fechaInicio, LocalDate fechaFin, double valorHora, double cantHorasAlMes) {
        super(fechaInicio);
        this.fechaFin = fechaFin;
        this.valorHora = valorHora;
        this.cantHorasAlMes = cantHorasAlMes;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    @Override
    public double montoMensual() {
        return valorHora * cantHorasAlMes;
    }

    @Override
    public int antiguedadEnMeses() {
        return (int) MONTHS.between(this.getFechaInicio(), this.getFechaFin());
    }

    @Override
    public boolean estaVigente() {
        return LocalDate.now().compareTo(this.getFechaFin()) <= 0;
    }
}
