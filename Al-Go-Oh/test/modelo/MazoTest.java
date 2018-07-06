package modelo;

import modelo.Juego;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class MazoTest {

    @Test
    public void testAlExtraerTodasLasCartasDelMazoGeneraUnGanadorEnElJuegoYElGanadorEsElOponente(){

        Juego.reiniciarJuego();
        Juego juego = Juego.getJuego();

        // Al iniciar el juego se descuentan las 5 primeras cartas que se extraen mas la 1er carta del jugador activo
        for (int i = 0; i<34; i++) {
            juego.getJugadorActivo().extraerCartaDelMazo();
        }
        assertTrue(juego.hayGanador());
        assertTrue(juego.obtenerGanador() == juego.getJugadorOponente());

    }

}
