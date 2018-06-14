import modelo.*;
import modelo.CartasMagicas.*;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class CartaMagicaTest {


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



    @Test
    public void testInvocarAgujeroNegroEnTableroDestruyeTodosLosMonstruosDelTableroDelInvocador() {

        AgujeroNegro agujeroNegro = new AgujeroNegro(Colocacion.BOCAARRIBA);

        Jugador jugador = Juego.getJuego().getJugadorActivo();

        Monstruo monstruo = new Monstruo(0,0,Posicion.DEFENSA,4);

        jugador.colocarEnAtaque(monstruo);
        jugador.colocarCarta(agujeroNegro);

        assertEquals(0,jugador.obtenerCampo().cantidadCartasZonaMonstruos());
        assertEquals(0,jugador.obtenerCampo().cantidadCartasZonaMagicas());

    }

}
