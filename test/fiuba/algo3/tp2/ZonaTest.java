package fiuba.algo3.tp2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ZonaTest {
    @Test
    public void testBuscarCartaEnCementerioObtieneLaMismaCartaSiEstaSeEncuentraAhi() {

        // A correjir: ¿Se debe buscar la carta monstruo por nombre?
        Carta carta = new CartaMonstruo();

        ZonaCementerio cementerio = new ZonaCementerio();

        cementerio.enviarCarta(carta);

        assertEquals(cementerio.buscarCarta(carta), carta);

    }

}
