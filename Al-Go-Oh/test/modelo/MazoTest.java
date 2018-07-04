package modelo;

import modelo.Juego;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class MazoTest {

    @Test
    public void testAlExtraerTodasLasCartasDelMazoGeneraUnGanadorEnElJuegoYElGanadorEsElOponente(){

        Juego.reiniciarJuego();
        Juego juego = Juego.getJuego();

        // Se descuentan las primeras 5 cartas que se extraen al iniciar el juego
        for (int i = 0; i<35; i++) {
            juego.getJugadorActivo().extraerCartaDelMazo();
        }
        assertTrue(juego.hayGanador());
        assertTrue(juego.obtenerGanador() == juego.getJugadorOponente());

    }

}
