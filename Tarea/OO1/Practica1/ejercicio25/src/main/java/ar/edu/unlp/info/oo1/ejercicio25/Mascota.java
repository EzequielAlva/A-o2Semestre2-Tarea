package ar.edu.unlp.info.oo1.ejercicio25;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Mascota {
    private String nombre;
    private LocalDate fechaNacimiento;
    private String especie;
    private List<Servicio> serviciosRecibidos;

    public Mascota(String nombre, LocalDate fechaNacimiento, String especie) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.especie = especie;
        this.serviciosRecibidos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getEspecie() {
        return especie;
    }

    public int getCantidadServicios() {
        return serviciosRecibidos.size();
    }

    public void agregarServicio(Servicio servicio) {
        serviciosRecibidos.add(servicio);
    }

    public double recaudacionGenerada(LocalDate fechaAtencion) {
        if(getCantidadServicios() == 0)
            return 0;
        return serviciosRecibidos.stream()
                .filter(serv -> serv.fechaAtencion.isEqual(fechaAtencion))
                .mapToDouble(Servicio::getCosto)
                .sum();
    }
}
