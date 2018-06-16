import modelo.*;
import modelo.CartasMagicas.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


public class CartaMagicaTest {


    @Test
    public void colocarCartaMagicaColocaLaCartaBocaAbajo(){
        AgujeroNegro agujeroNegro = new AgujeroNegro();
        Jugador jugador = new Jugador();
        jugador.colocarCarta(agujeroNegro);

        assertTrue(jugador.obtenerCampo().getZonaHechizos().obtenerCartaPosicion(Casillero.UNO).estaBocaAbajo());

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
