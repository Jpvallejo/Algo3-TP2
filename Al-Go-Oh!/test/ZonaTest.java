import modelo.*;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ZonaTest {

    @Test
    public void testCrearCementerioGeneraCementerioVacio() {

        ZonaCementerio cementerio = new ZonaCementerio();
        assertTrue(cementerio.estaVacio());

    }

    @Test
    public void testCementerioNoEstaVacioSiSeDestruyeUnaCarta() {

        Carta carta = new CartaMonstruo();
        ZonaCementerio cementerio = new ZonaCementerio();

        cementerio.enviarCarta(carta);
        // carta.destruir;  ¿?

        assertFalse(cementerio.estaVacio());

    }

    @Test
    public void testBuscarCartaEnCementerioObtieneLaMismaCartaSiEstaSeEncuentraAhi() {

        // A correjir: ¿Se debe buscar la carta monstruo por nombre?
        Carta carta = new Monstruo();

        ZonaCementerio cementerio = new ZonaCementerio();

        cementerio.enviarCarta(carta);

        assertEquals(cementerio.buscarCarta(carta), carta);

    }

}
