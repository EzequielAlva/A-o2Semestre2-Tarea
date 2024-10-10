package ar.edu.unlp.info.oo1.ejercicio15;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UsuarioTest {
    private Usuario usuario1;
    private Usuario usuario2;

    @BeforeEach
    void setup() {
        usuario1 = new Usuario("Carlos", "Calle 9, N° 373");
        usuario2 = new Usuario("Federico", "Calle 134, N° 2432");
    }

    @Test
    public void agregarConsumoTest() {
        Consumo unConsumo = new Consumo(23.5, 20.4);
        usuario2.agregarConsumo(unConsumo);

        assertEquals(0, usuario1.getListaConsumos().size());
        assertEquals(1, usuario2.getListaConsumos().size());
    }

    @Test
    public void quitarConsumoTest() {
        Consumo unConsumo = new Consumo(23.5, 20.4);
        usuario2.agregarConsumo(unConsumo);

        usuario1.quitarConsumo(unConsumo);
        usuario2.quitarConsumo(unConsumo);

        assertEquals(0, usuario1.getListaConsumos().size());
        assertEquals(0, usuario2.getListaConsumos().size());
    }
}
