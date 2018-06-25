import modelo.*;

import modelo.CartasMagicas.AgujeroNegro;
import modelo.Mazo.Mazo;
import modelo.Monstruos.*;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class ManoTest {

    @Test
    public void testCrearManoGeneraManoVacia(){
        Mano mano = new Mano();

        assertTrue(mano.estaVacia());

    }

    @Test
    public void testManoExtrae1CartaDelMazoYAumentaSuCantidadEn1(){
        Mano mano = new Mano();
        Mazo mazo = null;
        mazo = new Mazo();
        Carta carta = mazo.extaerCarta();
        mano.agregarCarta(carta);

        assertEquals(mano.cantidadCartas(),1);

    }

    @Test
    public void testManoContener5PartesExodiaEnLaManoGanaLaPartida(){
        Juego.reiniciarJuego();
        Juego juego = Juego.getJuego();
        Jugador aGanar = Juego.getJuego().getJugadorActivo();
        aGanar.getMano().agregarCarta(new CabezaExodia());
        aGanar.getMano().agregarCarta(new PiernaIzquierdaExodia());
        aGanar.getMano().agregarCarta(new PiernaDerechaExodia());
        aGanar.getMano().agregarCarta(new BrazoIzquierdoExodia());
        aGanar.getMano().agregarCarta(new BrazoDerechoExodia());
        assertTrue(juego.hayGanador());
        assertTrue(juego.obtenerGanador() == aGanar);
    }






}
