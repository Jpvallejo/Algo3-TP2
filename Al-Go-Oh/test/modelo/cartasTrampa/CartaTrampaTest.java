package modelo.cartasTrampa;

import modelo.*;
import modelo.CartasMagicas.CilindroMagico;
import modelo.CartasMagicas.Reinforcement;
import modelo.Monstruos.MonstruoGenerico;
import org.junit.Test;

import static junit.framework.TestCase.*;
import static org.junit.Assert.assertEquals;

public class CartaTrampaTest {

    @Test
    public void testColocarCartaTrampaColocaLaCartaBocaAbajo(){
        CartaTrampa carta = new CilindroMagico();
        Jugador jugador = new Jugador();
        jugador.colocarCarta(carta);

        assertTrue(jugador.getZonaHechizos().contains(carta));

    }


}
