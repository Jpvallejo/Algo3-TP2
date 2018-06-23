import modelo.*;
import modelo.Monstruos.MonstruoGenerico;
import org.junit.Test;

import static org.junit.Assert.*;


public class CementerioTest {

    @Test
    public void testCrearCementerioGeneraCementerioVacio() {

        Cementerio cementerio = new Cementerio();
        assertTrue(cementerio.estaVacio());

    }

    @Test
    public void testCrearCementerioGeneraCementerioConCantidadDeCartas0() {

        Cementerio cementerio = new Cementerio();
        assertEquals(cementerio.cantidadCartas(),0);

    }

    @Test
    public void testCementerioNoEstaVacioSiSeDestruyeUnaCarta() {

        Carta carta = new MonstruoGenerico("test",0,0,0);
        Cementerio cementerio = new Cementerio();

        cementerio.enviarCarta(carta);

        assertFalse(cementerio.estaVacio());

    }

    @Test
    public void testEnviarUnaCartaAlCementerioAumentaCantidadDeCartasDelCementerioEn1() {

        Carta carta = new MonstruoGenerico("test",0,0,0);

        Cementerio cementerio = new Cementerio();

        cementerio.enviarCarta(carta);

        assertEquals(1, cementerio.cantidadCartas());

    }

}
