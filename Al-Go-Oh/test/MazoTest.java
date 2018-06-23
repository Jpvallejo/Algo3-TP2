import modelo.Juego;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class MazoTest {

    @Test
    public void testAlExtraerTodasLasCartasDelMazoGeneraUnGanadorEnElJuegoYElGanadorEsElOponente(){

        Juego.reiniciarJuego();
        Juego juego = Juego.getJuego();
        for (int i = 0; i<40; i++) {
            juego.getJugadorActivo().extraerCartaDelMazo();
        }
        assertTrue(juego.hayGanador());
        assertTrue(juego.obtenerGanador() == juego.getJugadorOponente());

    }

}
