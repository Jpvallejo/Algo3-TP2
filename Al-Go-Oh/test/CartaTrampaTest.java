import modelo.*;
import modelo.CartasMagicas.CilindroMagico;
import modelo.CartasMagicas.Reinforcement;
import modelo.CartasMonstruosEspeciales.InsectoComeHombres;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.*;
import static org.junit.Assert.assertEquals;

public class CartaTrampaTest {

    @Test
    public void colocarCartaTrampaColocaLaCartaBocaAbajo(){
        CartaTrampa carta = new CilindroMagico();
        Jugador jugador = new Jugador();
        jugador.colocarCarta(carta);

        assertTrue(jugador.obtenerCampo().getZonaHechizos().obtenerCartaPosicion(Casillero.UNO).estaBocaAbajo());

    }


    @Test
    public void testCilindroMagicoNiegaElAtaqueDeUnMonstruoYRestaLosPuntosDeAtaqueDelMonstruoAtacanteALosPuntosDeVidaDelJugadorAtacante(){

        Jugador atacante = new Jugador(); //Juego.getJuego().getJugadorActivo();
        Jugador defensor = new Jugador(); //Juego.getJuego().getJugadorOponente();
        Monstruo monstruoAtacante = new Monstruo("test",2000,1000, Posicion.ATAQUE,4);
        Monstruo monstruoDefensor = new Monstruo("test",1000,1000, Posicion.DEFENSA,4);
        atacante.colocarEnAtaque(monstruoAtacante);
        defensor.colocarEnDefensa(monstruoDefensor);

        CartaTrampa carta = new CilindroMagico();
        defensor.colocarCarta(carta);

        atacante.declararAtaqueDePosicionAPosicion(defensor,Casillero.UNO,Casillero.UNO);

        assertEquals(0, atacante.cantidadCartasCementerio());
        assertEquals(1, defensor.cantidadCartasCementerio());
        assertEquals(6000, atacante.getPuntosDeVida());
        assertEquals(8000, defensor.getPuntosDeVida());

    }


    @Test
    public void testCilindroMagicoNiegaElAtaqueDeUnMonstruoALosPuntosDeVidaYRestaLosPuntosDeAtaqueDelMonstruoAtacanteALosPuntosDeVidaDelJugadorAtacante(){

        Jugador atacante = new Jugador(); //Juego.getJuego().getJugadorActivo();
        Jugador defensor = new Jugador(); //Juego.getJuego().getJugadorOponente();
        Monstruo monstruoAtacante = new Monstruo("test",2000,1000, Posicion.ATAQUE,4);

        atacante.colocarEnAtaque(monstruoAtacante);

        CartaTrampa carta = new CilindroMagico();
        defensor.colocarCarta(carta);

        atacante.declararAtaqueDePosicionAPosicion(defensor,Casillero.UNO,Casillero.PUNTOSVIDA);

        assertEquals(0, atacante.cantidadCartasCementerio());
        assertEquals(1, defensor.cantidadCartasCementerio());
        assertEquals(6000, atacante.getPuntosDeVida());
        assertEquals(8000, defensor.getPuntosDeVida());

    }


    @Test
    public void testActivarReinforcementAumentaElAtaqueDelMonstruoDefensorEn500SoloDuranteElAtaque(){

        Jugador atacante = new Jugador(); //Juego.getJuego().getJugadorActivo();
        Jugador defensor = new Jugador(); //Juego.getJuego().getJugadorOponente();
        Monstruo monstruoAtacante = new Monstruo("test",1500,1000, Posicion.ATAQUE,4);
        Monstruo monstruoDefensor = new Monstruo("test",1200,1000, Posicion.ATAQUE,4);
        atacante.colocarEnAtaque(monstruoAtacante);
        defensor.colocarEnAtaque(monstruoDefensor);


        CartaTrampa carta = new Reinforcement();
        defensor.colocarCarta(carta);

        assertEquals(1200, defensor.obtenerCampo().obtenerMonstruoEnCasillero(Casillero.UNO).getPuntosAtaque());

        atacante.declararAtaqueDePosicionAPosicion(defensor,Casillero.UNO,Casillero.UNO);

        assertEquals(1, atacante.cantidadCartasCementerio());
        assertEquals(1, defensor.cantidadCartasCementerio());
        assertEquals(7800, atacante.getPuntosDeVida());
        assertEquals(8000, defensor.getPuntosDeVida());

    }

}
