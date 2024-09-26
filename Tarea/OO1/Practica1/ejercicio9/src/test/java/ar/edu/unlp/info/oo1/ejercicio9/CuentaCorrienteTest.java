package ar.edu.unlp.info.oo1.ejercicio9;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CuentaCorrienteTest {
	private CuentaCorriente cuenta1;
	private CuentaCorriente cuenta2;
	
	@BeforeEach
	void setup() throws Exception {
		cuenta1 = new CuentaCorriente();
		cuenta2 = new CuentaCorriente();
		cuenta1.setDescubierto(2000);
		cuenta1.depositar(5000);
		cuenta2.depositar(5000);
	}

	@Test
	public void depositarTest() {
		assertEquals(cuenta1.getSaldo(), 5000);
		assertEquals(cuenta2.getSaldo(), 5000);
	}

	@Test
	public void testPuedeExtraer() {
		assertTrue(cuenta1.puedeExtraer(6500));
		assertFalse(cuenta1.puedeExtraer(8000));
		assertTrue(cuenta2.puedeExtraer(5000));
		assertFalse(cuenta2.puedeExtraer(6500));
	}
	
	@Test
	public void testExtraccion() {
		cuenta1.extraer(6000);
		cuenta2.extraer(3000);
		assertEquals(cuenta1.getSaldo(), 5000 - 6000);
		assertEquals(cuenta2.getSaldo(), 5000 - 3000);
	}

	@Test
	public void testTransferirACuenta() {
		cuenta1.transferirACuenta(3000, cuenta2);
		assertEquals(cuenta1.getSaldo(), 2000);
		assertEquals(cuenta2.getSaldo(), 8000);
	}

	@Test
	public void testTransferirACuentaDiferente() {
		CajaDeAhorro caja = new CajaDeAhorro();
		caja.depositar(5000);
		boolean resultado = cuenta1.transferirACuenta(3000, caja);
		assertTrue(resultado);
		assertEquals(cuenta1.getSaldo(), 2000);
		assertEquals(caja.getSaldo(), 8000);
	}
}
