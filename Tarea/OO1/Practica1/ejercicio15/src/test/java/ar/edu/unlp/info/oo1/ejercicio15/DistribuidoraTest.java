package ar.edu.unlp.info.oo1.ejercicio15;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DistribuidoraTest {
    private Usuario usuario;
    private CuadroTarifario cuadroTarifario;
    private Distribuidora distribuidora;

    @BeforeEach
    void setup() {
        cuadroTarifario = new CuadroTarifario();
        cuadroTarifario.setPrecioDeKW(10);

        distribuidora = new Distribuidora(cuadroTarifario);

        usuario = new Usuario("Ezequiel", "Calle 9, N° 1381");
        usuario.agregarConsumo(new Consumo(34.55, 2.1));
        usuario.agregarConsumo(new Consumo(42.32, 1.9));
        usuario.agregarConsumo(new Consumo(24.4, 2.3));
    }

    @Test
    public void emitirFacturaConBonificacion() {
        Factura factura = distribuidora.emitirFactura(usuario);
        double montoTotal = 24.4 * 10;
        double bonificacion = 0.1; // 10%

        assertEquals(usuario.getNombre(), factura.getNombreUsuario());
        assertEquals(usuario.getDomicilio(), factura.getDomicilioUsuario());
        assertEquals(bonificacion, factura.getBonificacion());
        assertEquals((montoTotal - montoTotal * bonificacion), factura.getMontoFinal());
    }

    @Test
    public void emitirFacturaSinBonificacion() {
        usuario.agregarConsumo(new Consumo(25.0, 100));
        Factura factura = distribuidora.emitirFactura(usuario);

        assertEquals(usuario.getNombre(), factura.getNombreUsuario());
        assertEquals(usuario.getDomicilio(), factura.getDomicilioUsuario());
        assertEquals(0, factura.getBonificacion());
        assertEquals(250, factura.getMontoFinal());
    }
}
