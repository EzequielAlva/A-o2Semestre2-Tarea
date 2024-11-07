package ar.edu.unlp.info.oo1.ejercicio25;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;

import static org.junit.jupiter.api.Assertions.*;

public class MascotaTest {
    private Mascota mascota;
    private Mascota otraMascota;
    private Veterinario veterinario;

    @BeforeEach
    void setup() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        mascota = new Mascota("Toto", LocalDate.parse("22/11/2022", formatter), "Labrador");
        otraMascota = new Mascota("Talon", LocalDate.parse("25/11/2015", formatter), "Cruza");
        veterinario = new Veterinario("Tomas", LocalDate.parse("25/06/2012", formatter), 5000);

        ServicioConsulta servConsulta = veterinario.altaConsultaMedica(mascota, 2);
        ServicioVacunacion servVacunacion = veterinario.altaVacunacion(mascota, 3, 1500);
        ServicioGuarderia servGuarderia = veterinario.altaGuarderia(mascota,7);
        ServicioVacunacion servVacunacion2 = veterinario.altaVacunacion(mascota, 1, 2000);
        ServicioGuarderia servGuarderia2 = veterinario.altaGuarderia(mascota,14);
    }

    @Test
    public void recaudacionGeneradaTest() {
        assertEquals(32000, mascota.recaudacionGenerada(LocalDate.now()));
        assertEquals(0, otraMascota.recaudacionGenerada(LocalDate.now()));
        assertEquals(0, mascota.recaudacionGenerada(LocalDate.now().minusDays(10)));
    }
}
