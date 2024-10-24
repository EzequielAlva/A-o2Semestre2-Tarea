package ar.edu.unlp.info.oo1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class EmpleadoTest {
    private Contrato contPorHora1;
    private Contrato contPorHora2;
    private Empleado empleado;
    private Empleado otroEmpleado;

    @BeforeEach
    void setup() {
        empleado = new Empleado("Ezequiel", "Alvarez", "20-40382185/7",
                "25-02-2001", true, false);
        otroEmpleado = new Empleado("Matias", "Feininger", "20-40516783/7",
                "02-06-2001", true, true);
        contPorHora1 = new ContratoPorHoras(LocalDate.parse("2015-02-22"),
                LocalDate.parse("2016-02-22"), 100, 48*4);
        contPorHora2 = new ContratoPorHoras(LocalDate.parse("2023-12-15"),
                LocalDate.parse("2024-12-15"), 120, 48*4);

    }

    @Test
    public void empleadoCreadoTest() {
        assertEquals("Ezequiel", empleado.getNombre());
        assertEquals("Alvarez", empleado.getApellido());
        assertEquals("20-40382185/7", empleado.getCuil());
        assertEquals("25-02-2001", empleado.getFechaNac());
        assertTrue(empleado.tieneHijos());
        assertFalse(empleado.tieneConyuge());
    }

    @Test
    public void agregarContratoTest() {
        empleado.agregarContrato(contPorHora1);
        empleado.agregarContrato(contPorHora2);
        empleado.agregarContrato(new ContratoDePlanta(LocalDate.parse("2015-06-01"),
                5000, 250, 500, empleado));

        assertEquals(3, empleado.getContratos().size());
    }

    @Test
    public void getAntiguedadTest() {
        empleado.agregarContrato(contPorHora1);
        empleado.agregarContrato(contPorHora2);

        assertEquals(24, empleado.getAntiguedad());
        assertEquals(0, otroEmpleado.getAntiguedad());
    }

    @Test
    public void calcularMontoTotalActivoTest() {
        empleado.agregarContrato(contPorHora1); //monto total = 100 * 48 * 4
        empleado.agregarContrato(contPorHora2); //monto total = 120 * 48 * 4, antiguedad 2 años
        otroEmpleado.agregarContrato(new ContratoDePlanta(LocalDate.parse("2015-06-01"),
                5000, 250, 500, otroEmpleado)); // monto total = 5000 + 250 + 500 | antiguedad 9 años -> bono  30%

        int sueldoBasicoPlanta = 5000+250+500;

        assertEquals((120*48*4), empleado.calcularMontoTotal());
        assertEquals((sueldoBasicoPlanta+(sueldoBasicoPlanta*0.3)), otroEmpleado.calcularMontoTotal());
    }

    @Test
    public void calcularMontoTotalInactivoTest() {
        empleado.agregarContrato(contPorHora1);

        assertEquals(0, empleado.calcularMontoTotal());
    }

    @Test
    public void emitirReciboDeSueldoTest() {
        empleado.agregarContrato(contPorHora1);
        empleado.agregarContrato(contPorHora2);

        ReciboDeSueldo rs = empleado.emitirReciboDeSueldo();

        assertEquals(empleado.getNombre(), rs.getNombre());
        assertEquals(empleado.getApellido(), rs.getApellido());
        assertEquals(empleado.getCuil(), rs.getCuil());
        assertEquals(empleado.getAntiguedad(), rs.getAntiguedad());
        assertEquals(LocalDate.now(), rs.getFecha());
        assertEquals(empleado.calcularMontoTotal(), rs.getSueldoTotal());
    }
}
