package ar.edu.unlp.info.oo1.ejercicio11;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class PlazoFijo implements Inversion{
    private LocalDate fechaDeConstitucion;
    private double montoDepositado;
    private double porcentajeDeInteresDiario;

    @Override
    public double valorActual() {
        long cantDias = DAYS.between(fechaDeConstitucion, LocalDate.now());
        return montoDepositado + montoDepositado * porcentajeDeInteresDiario * cantDias;
    }
}
