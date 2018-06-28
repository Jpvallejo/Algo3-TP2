package modelo.cartasTrampa;

import modelo.CartaTrampa;
import modelo.CartasMagicas.CilindroMagico;
import modelo.Jugador;
import modelo.Monstruo;
import modelo.Monstruos.MonstruoGenerico;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CilindroMagicoTest {

    @Test
    public void testCilindroMagicoNiegaElAtaqueDeUnMonstruoYRestaLosPuntosDeAtaqueDelMonstruoAtacanteALosPuntosDeVidaDelJugadorAtacante(){
        Juego.reiniciarJuego();
        Juego.getJuego().avanzarFase(); // fase de preparacion
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
        Juego.reiniciarJuego();
        Juego.getJuego().avanzarFase(); // fase de preparacion
        Jugador atacante = new Jugador(); //Juego.getJuego().getJugadorActivo();
        Jugador defensor = new Jugador(); //Juego.getJuego().getJugadorOponente();
        Monstruo monstruoAtacante = new MonstruoGenerico("test",2000,1000, 4);

        atacante.invocar(monstruoAtacante);

        CartaTrampa carta = new CilindroMagico();
        defensor.colocarCarta(carta);
        Juego.getJuego().avanzarFase(); // fase de ataque
        //atacante.declararAtaqueDePosicionAPosicion(defensor,Casillero.UNO,Casillero.PUNTOSVIDA);
        monstruoAtacante.atacar(defensor);

        assertEquals(0, atacante.cantidadCartasCementerio());
        assertEquals(1, defensor.cantidadCartasCementerio());
        assertEquals(6000, atacante.getPuntosDeVida());
        assertEquals(8000, defensor.getPuntosDeVida());

    }

}
