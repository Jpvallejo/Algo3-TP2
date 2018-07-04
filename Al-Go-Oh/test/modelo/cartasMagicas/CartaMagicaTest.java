package modelo.cartasMagicas;

import modelo.CartasMagicas.AgujeroNegro;
import modelo.*;
import modelo.CartasMagicas.Fisura;
import modelo.CartasMagicas.OllaDeLaCodicia;
import modelo.CartasMagicas.Sogen;
import modelo.CartasMagicas.Wasteland;
import modelo.Monstruos.AgresorOscuro;
import modelo.Monstruos.MonstruoGenerico;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;



public class CartaMagicaTest {


    @Test
    public void testColocarCartaMagicaColocaLaCartaBocaAbajo(){
        AgujeroNegro agujeroNegro = new AgujeroNegro();
        Jugador jugador = new Jugador();
        jugador.colocarCarta(agujeroNegro);

        assertTrue(jugador.getZonaHechizos().contains(agujeroNegro));

    }

    
}
