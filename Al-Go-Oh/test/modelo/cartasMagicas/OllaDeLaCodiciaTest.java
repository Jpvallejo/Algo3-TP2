package modelo.cartasMagicas;

import modelo.CartasMagicas.OllaDeLaCodicia;
import modelo.Juego;
import modelo.Jugador;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OllaDeLaCodiciaTest {

    @Test
    public void testInvocarOllaDeLaCodiciaPermiteTomarDosCartasDelMazo() {
        Juego.reiniciarJuego();
        OllaDeLaCodicia ollaDeLaCodicia = new OllaDeLaCodicia();

        Jugador jugadorActivo = Juego.getJuego().getJugadorActivo();
        int cantidadEnMazo = jugadorActivo.obtenerTamanioMazo();
        jugadorActivo.activarCarta(ollaDeLaCodicia);

        assertEquals(cantidadEnMazo - 2,jugadorActivo.obtenerTamanioMazo());//Esta Mal Lo veo despues.
    }
}
