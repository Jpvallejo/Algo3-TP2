package modelo.cartasMagicas;

import modelo.CartasMagicas.Fisura;
import modelo.Juego;
import modelo.Jugador;
import modelo.Monstruo;
import modelo.Monstruos.MonstruoGenerico;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FisuraTest {


    @Test
    public void testInvocar2MonstruosYActivarLaCartaMagicaFisuraDestruyeElMonstruoDeMenorAtaque() {
        /*Colocar 2 monstruos en el campo enemigo, con diferente ataque. Activo la carta mágica Fisura, y verificar que el de menor ataque es destruido.*/
        Juego.reiniciarJuego();

        Jugador jugadorActivo = Juego.getJuego().getJugadorActivo();
        Jugador jugadorOponente = Juego.getJuego().getJugadorOponente();

        Monstruo monstruo1 = new MonstruoGenerico("test1",200,100,4);
        Monstruo monstruo2 = new MonstruoGenerico("test2",300,200,4);
        Monstruo monstruo3 = new MonstruoGenerico("test2",100,200,4);

        jugadorOponente.invocar(monstruo1);
        jugadorOponente.resetearInvocacionesPosibles();
        jugadorOponente.invocar(monstruo2);
        jugadorOponente.resetearInvocacionesPosibles();
        jugadorOponente.invocar(monstruo3);

        Fisura fisura = new Fisura();

        jugadorActivo.activarCarta(fisura);

        assertEquals(1, jugadorOponente.cantidadCartasCementerio());

        //Busca el monstruo3 en el cementerio el cual deberia estar por ser el monstruo con menor Ataque
        assertEquals(monstruo3, jugadorOponente.buscarCartaEnCementerio(monstruo3));

    }
}
