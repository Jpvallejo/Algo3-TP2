package modelo.cartasTrampa;

import modelo.CartaTrampa;
import modelo.CartasMagicas.Reinforcement;
import modelo.Juego;
import modelo.Jugador;
import modelo.Monstruo;
import modelo.Monstruos.MonstruoGenerico;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReinforcementTest {


    @Test
    public void testActivarReinforcementAumentaElAtaqueDelMonstruoDefensorEn500SoloDuranteElAtaque(){
        Juego.reiniciarJuego();
        Juego.getJuego().avanzarFase(); // fase de preparacion
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
