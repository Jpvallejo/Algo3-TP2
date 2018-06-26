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


    @Test
    public void testCilindroMagicoNiegaElAtaqueDeUnMonstruoYRestaLosPuntosDeAtaqueDelMonstruoAtacanteALosPuntosDeVidaDelJugadorAtacante(){

        Jugador atacante = new Jugador(); //Juego.getJuego().getJugadorActivo();
        Jugador defensor = new Jugador(); //Juego.getJuego().getJugadorOponente();
        Monstruo monstruoAtacante = new MonstruoGenerico("test",2000,1000, 4);
        Monstruo monstruoDefensor = new MonstruoGenerico("test",1000,1000, 4);
        atacante.invocar(monstruoAtacante);
        defensor.colocar(monstruoDefensor);

        CartaTrampa carta = new CilindroMagico();
        defensor.colocarCarta(carta);

        //atacante.declararAtaqueDePosicionAPosicion(defensor,Casillero.UNO,Casillero.UNO);
        monstruoAtacante.atacarMonstruo(monstruoDefensor);

        assertEquals(0, atacante.cantidadCartasCementerio());
        assertEquals(1, defensor.cantidadCartasCementerio());
        assertEquals(6000, atacante.getPuntosDeVida());
        assertEquals(8000, defensor.getPuntosDeVida());

    }


    @Test
    public void testCilindroMagicoNiegaElAtaqueDeUnMonstruoALosPuntosDeVidaYRestaLosPuntosDeAtaqueDelMonstruoAtacanteALosPuntosDeVidaDelJugadorAtacante(){

        Jugador atacante = new Jugador(); //Juego.getJuego().getJugadorActivo();
        Jugador defensor = new Jugador(); //Juego.getJuego().getJugadorOponente();
        Monstruo monstruoAtacante = new MonstruoGenerico("test",2000,1000, 4);

        atacante.invocar(monstruoAtacante);

        CartaTrampa carta = new CilindroMagico();
        defensor.colocarCarta(carta);

        //atacante.declararAtaqueDePosicionAPosicion(defensor,Casillero.UNO,Casillero.PUNTOSVIDA);
        monstruoAtacante.atacar(defensor);

        assertEquals(0, atacante.cantidadCartasCementerio());
        assertEquals(1, defensor.cantidadCartasCementerio());
        assertEquals(6000, atacante.getPuntosDeVida());
        assertEquals(8000, defensor.getPuntosDeVida());

    }


    @Test
    public void testActivarReinforcementAumentaElAtaqueDelMonstruoDefensorEn500SoloDuranteElAtaque(){

        Jugador atacante = new Jugador(); //Juego.getJuego().getJugadorActivo();
        Jugador defensor = new Jugador(); //Juego.getJuego().getJugadorOponente();
        Monstruo monstruoAtacante = new MonstruoGenerico("test",1500,1000, 4);
        Monstruo monstruoDefensor = new MonstruoGenerico("test",1200,1000, 4);
        atacante.invocar(monstruoAtacante);
        defensor.invocar(monstruoDefensor);


        CartaTrampa carta = new Reinforcement();
        defensor.colocarCarta(carta);
        
        monstruoAtacante.atacarMonstruo(monstruoDefensor);

        assertEquals(1, atacante.cantidadCartasCementerio());
        assertEquals(1, defensor.cantidadCartasCementerio());
        assertEquals(7800, atacante.getPuntosDeVida());
        assertEquals(8000, defensor.getPuntosDeVida());

    }

}
