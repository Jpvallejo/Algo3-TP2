package fiuba.algo3.tp2;

import org.junit.Test;

import static org.junit.Assert.*;

public class ZonaTest {

    @Test
    public void testCrearCementerioGeneraCementerioVacio() {

        ZonaCementerio cementerio = new ZonaCementerio();
        assertTrue(cementerio.estaVacio());

    }

    @Test
    public void testCrearCementerioNoEstaVacioSiSeEnviaUnaCarta() {

        Carta carta = new CartaMonstruo();
        ZonaCementerio cementerio = new ZonaCementerio();

        cementerio.enviarCarta(carta);
        assertFalse(cementerio.estaVacio());

    }

    @Test
    public void testBuscarCartaEnCementerioObtieneLaMismaCartaSiEstaSeEncuentraAhi() {

        // A correjir: ¿Se debe buscar la carta monstruo por nombre?
        Carta carta = new CartaMonstruo();

        ZonaCementerio cementerio = new ZonaCementerio();

        cementerio.enviarCarta(carta);

        assertEquals(cementerio.buscarCarta(carta), carta);

    }

}
