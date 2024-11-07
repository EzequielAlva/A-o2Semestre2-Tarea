package ar.edu.unlp.info.oo1.ejercicio25;

import java.time.DayOfWeek;
import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.YEARS;

public class Veterinario {
    private String nombre;
    private LocalDate fechaIngreso;
    private double honorarios;

    public Veterinario(String nombre, LocalDate fechaIngreso, double honorarios) {
        this.nombre = nombre;
        this.fechaIngreso = fechaIngreso;
        this.honorarios = honorarios;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public double getHonorarios() {
        return honorarios;
    }

    public int calcularAntiguedad() {
        return (int) YEARS.between(fechaIngreso, LocalDate.now());
    }

    public ServicioConsulta altaConsultaMedica(Mascota mascota, int cantidadMateriales) {
        boolean esDomingo = LocalDate.now().getDayOfWeek() == DayOfWeek.SUNDAY;
        ServicioConsulta servicio = new ServicioConsulta(mascota
                , this
                , cantidadMateriales
                , esDomingo);
        mascota.agregarServicio(servicio);
        return servicio;
    }

    public ServicioVacunacion altaVacunacion(Mascota mascota, int cantidadMateriales, double precioVacuna) {
        boolean esDomingo = LocalDate.now().getDayOfWeek() == DayOfWeek.MONDAY;
        ServicioVacunacion servicio = new ServicioVacunacion(mascota
                , this
                , cantidadMateriales
                , esDomingo
                , precioVacuna);
        mascota.agregarServicio(servicio);
        return servicio;
    }

    public ServicioGuarderia altaGuarderia(Mascota mascota, int cantDias) {
        ServicioGuarderia servicio = new ServicioGuarderia(mascota, cantDias);
        mascota.agregarServicio(servicio);
        return servicio;
    }
}
