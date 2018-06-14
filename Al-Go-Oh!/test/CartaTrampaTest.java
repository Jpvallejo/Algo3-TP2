import modelo.*;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.*;

public class CartaTrampaTest {

    @Test
    public void colocarCartaTrampaColocaLaCartaBocaAbajo(){
        CartaTrampa carta = new CartaTrampa();
        Jugador jugador = new Jugador();
        jugador.colocarCarta(carta);

        ArrayList<Carta> cartas = jugador.obtenerCampo().obtenerHechizosEnCampo();
        assertTrue(cartas.contains(carta));
        for (Carta cartaActual:cartas) {
            if (cartaActual == carta) {
                assertTrue(cartaActual.estaBocaAbajo());
                return;
            }
        }

        // Si llega aca, significa que no encontro la carta
        assertFalse(true);
    }
}
