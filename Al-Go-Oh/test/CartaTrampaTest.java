import modelo.*;
import modelo.CartasMagicas.CilindroMagico;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CartaTrampaTest {

    @Test
    public void colocarCartaTrampaColocaLaCartaBocaAbajo(){
        CartaTrampa carta = new CilindroMagico();
        Jugador jugador = new Jugador();
        jugador.colocarCarta(carta);

        assertTrue(jugador.obtenerCampo().getZonaHechizos().obtenerCartaPosicion(Casillero.UNO).estaBocaAbajo());

    }
}
