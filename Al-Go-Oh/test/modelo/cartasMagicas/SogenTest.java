package modelo.cartasMagicas;

import modelo.CartasMagicas.Sogen;
import modelo.Juego;
import modelo.Jugador;
import modelo.Monstruo;
import modelo.Monstruos.MonstruoGenerico;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SogenTest {

    @Test
    public void testAplicarCartaSogenEnMonstruosYAtacar() {


        Juego.reiniciarJuego();
        Juego.getJuego().avanzarFase(); // fase de preparacion
        Sogen sogen = new Sogen();

        Jugador jugadorActivo = Juego.getJuego().getJugadorActivo();
        Jugador jugadorOponente = Juego.getJuego().getJugadorOponente();

        jugadorActivo.colocarCarta(sogen);

        Monstruo monstruoAtaque = new MonstruoGenerico("test",100,0,4);

        jugadorActivo.invocar(monstruoAtaque);

        Monstruo monstruoDefensa = new MonstruoGenerico("test",100,200,4);

        jugadorOponente.invocar(monstruoDefensa);

        jugadorActivo.activarCartaCampo(); //Suma 200 al ataque del monstruo del jugadorOponente osea tiene 300

        monstruoAtaque.atacarMonstruo(monstruoDefensa);

        assertEquals(1, jugadorActivo.cantidadCartasCementerio());
        //Le resta 200 puntos de vida al jugadorActivo
        assertEquals(7800, jugadorActivo.getPuntosDeVida());

    }


}
