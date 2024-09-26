package ar.edu.unlp.info.oo1.ejercicio9;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CajaDeAhorroTest {
    private CajaDeAhorro caja1;
    private CajaDeAhorro caja2;

    @BeforeEach
    void setup() {
        caja1 = new CajaDeAhorro();
        caja2 = new CajaDeAhorro();
        caja1.depositar(5000);
        caja2.depositar(5000);
    }

    @Test
    public void depositarTest() {
        assertEquals(caja1.getSaldo(), 5000);
        assertEquals(caja2.getSaldo(), 5000);
    }

    @Test
    public void testPuedeExtraer() {
        assertTrue(caja1.puedeExtraer(4000));
        assertFalse(caja1.puedeExtraer(8000));
    }

    @Test
    public void testExtraer() {
        boolean extraccion1 = caja1.extraer(5000);
        boolean extraccion2 = caja1.extraer(3000);
        assertFalse(extraccion1);
        assertTrue(extraccion2);
        assertEquals(caja1.getSaldo(), 2000);
    }

    @Test
    public void testTransferirACuenta() {
        caja1.transferirACuenta(3000, caja2);
        assertEquals(caja1.getSaldo(), 2000);
        assertEquals(caja2.getSaldo(), 8000);
    }

    @Test
    public void testTransferirACuentaDiferente() {
        CuentaCorriente cuenta = new CuentaCorriente();
        cuenta.depositar(5000);
        boolean resultado = caja1.transferirACuenta(3000, cuenta);
        assertTrue(resultado);
        assertEquals(caja1.getSaldo(), 2000);
        assertEquals(cuenta.getSaldo(), 8000);
    }
}
