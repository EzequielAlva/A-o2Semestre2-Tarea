package ar.edu.unlp.info.oo1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class ContratoTest {
    private Contrato contrato1;
    private Contrato contrato2;
    private Contrato contrato3;
    private Empleado empleado1;
    private Empleado empleado2;

    @BeforeEach
    void setup() {
        empleado1 = new Empleado("Roberto", "Castro", "20-37825229/7", "23-09-1993", false, false);
        empleado2 = new Empleado("Matias", "Alvarez", "20-36233859/8", "15-04-1990", true, true);
        contrato1 = new ContratoDePlanta(LocalDate.parse("2021-05-11"), 2000, 150, 200, empleado1);
        contrato2 = new ContratoDePlanta(LocalDate.parse("2020-07-23"), 2000, 150, 200, empleado2);
        contrato3 = new ContratoPorHoras(LocalDate.parse("2022-01-03"), LocalDate.parse("2024-07-17"), 68, 48*4);
    }

    @Test
    public void contratosGeneradosTest() {
        assertEquals(LocalDate.parse("2021-05-11"), contrato1.getFechaInicio());
    }

    @Test
    public void montoMensualTest() {
        assertEquals(2000, contrato1.montoMensual());
        assertEquals((2000 + 150 + 200), contrato2.montoMensual());
        assertEquals((68 * 48 * 4), contrato3.montoMensual());
    }

    @Test
    public void antiguedadEnMesesTest() {
        assertEquals(41, contrato1.antiguedadEnMeses());
        assertEquals(30, contrato3.antiguedadEnMeses());
    }

    @Test
    public void estaVigente() {
        assertTrue(contrato1.estaVigente());
        assertFalse(contrato3.estaVigente());
    }


}
