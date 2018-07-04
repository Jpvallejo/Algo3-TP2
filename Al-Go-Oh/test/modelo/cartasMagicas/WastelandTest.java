package modelo.cartasMagicas;

import modelo.CartasMagicas.Wasteland;
import modelo.Juego;
import modelo.Jugador;
import modelo.Monstruo;
import modelo.Monstruos.MonstruoGenerico;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WastelandTest {

    @Test
    public void testColocarWastelandEnElCampoAumentaElAtaqueDelJugadorActivosEn200YLaDefensaDelJugadorOponenteEn300() {

        Juego.reiniciarJuego();
        Wasteland wasteland = new Wasteland();


        Jugador jugadorActivo = Juego.getJuego().getJugadorActivo();

        jugadorActivo.colocarCarta(wasteland);
        Jugador jugadorOponente = Juego.getJuego().getJugadorOponente();

        Monstruo monstruoAtaque = new MonstruoGenerico("test1",300,0,4);
        jugadorActivo.invocar(monstruoAtaque);
        Monstruo monstruoDefensa = new MonstruoGenerico("test2",100,200,4);
        jugadorOponente.colocar(monstruoDefensa);
        jugadorActivo.activarCartaCampo();

        assertEquals(500,monstruoAtaque.getPuntosAtaque());
        assertEquals(500,monstruoDefensa.getPuntosDefensa());
    }

    @Test
    public void testColocarWastelandYRevertirCartaDeCampoDevuelveAtaquesYDefensasALaNormalidad() {

        Juego.reiniciarJuego();
        Wasteland wasteland = new Wasteland();


        Jugador jugadorActivo = Juego.getJuego().getJugadorActivo();

        jugadorActivo.colocarCarta(wasteland);
        Jugador jugadorOponente = Juego.getJuego().getJugadorOponente();

        Monstruo monstruoAtaque = new MonstruoGenerico("test1",300,0,4);
        jugadorActivo.invocar(monstruoAtaque);
        Monstruo monstruoDefensa = new MonstruoGenerico("test2",100,200,4);
        jugadorOponente.colocar(monstruoDefensa);

        // Simulacion de Fase de Ataque
        Juego.getJuego().activarCartasDeCampo();
        monstruoAtaque.atacarMonstruo(monstruoDefensa);
        Juego.getJuego().revertirCartasDeCampo();

        assertEquals(300,monstruoAtaque.getPuntosAtaque());
        assertEquals(200,monstruoDefensa.getPuntosDefensa());
        assertEquals(0,jugadorOponente.cantidadCartasCementerio());
    }

}
