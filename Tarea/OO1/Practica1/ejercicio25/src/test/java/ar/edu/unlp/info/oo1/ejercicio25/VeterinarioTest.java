package ar.edu.unlp.info.oo1.ejercicio25;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

public class VeterinarioTest {
    private Mascota mascota;
    private Veterinario veterinario;

    @BeforeEach
    void setup() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        mascota = new Mascota("Toto", LocalDate.parse("22/11/2022", formatter), "Labrador");
        veterinario = new Veterinario("Tomas", LocalDate.parse("25/06/2012", formatter), 5000);
    }

    @Test
    public void instanciaTest() {
        assertEquals("Tomas", veterinario.getNombre());
        assertEquals("2012-06-25", veterinario.getFechaIngreso().toString());
        assertEquals(5000, veterinario.getHonorarios());
    }

    @Test
    public void altaConsultaMedicaTest() {
        int cantidadMateriales = 2;
        ServicioConsulta servConsulta = veterinario.altaConsultaMedica(mascota, cantidadMateriales);
        assertEquals(1, mascota.getCantidadServicios());
        assertEquals(mascota, servConsulta.getMascota());
        assertEquals(veterinario, servConsulta.getVeterinario());
    }

    @Test
    public void altaVacunacionTest() {
        int cantidadMateriales = 2;
        double precioVacuna = 1500;
        ServicioVacunacion servVacunacion = veterinario.altaVacunacion(mascota, cantidadMateriales, precioVacuna);
        assertEquals(1, mascota.getCantidadServicios());
        assertEquals(mascota, servVacunacion.getMascota());
        assertEquals(veterinario, servVacunacion.getVeterinario());
    }

    @Test
    public void altaGuarderiaTest() {
        int cantDias = 7;
        ServicioGuarderia servGuarderia = veterinario.altaGuarderia(mascota,cantDias);
        assertEquals(1, mascota.getCantidadServicios());
        assertEquals(mascota, servGuarderia.getMascota());
    }
}
