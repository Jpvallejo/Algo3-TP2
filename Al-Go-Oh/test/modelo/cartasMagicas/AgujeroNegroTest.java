package modelo.cartasMagicas;

import modelo.CartasMagicas.AgujeroNegro;
import modelo.Juego;
import modelo.Jugador;
import modelo.Monstruo;
import modelo.Monstruos.MonstruoGenerico;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AgujeroNegroTest {


    @Test
    public void testInvocarAgujeroNegroEnTableroDestruyeTodosLosMonstruosDelTableroDelInvocador() {
        Juego.reiniciarJuego();
        AgujeroNegro agujeroNegro = new AgujeroNegro();

        Jugador jugador = Juego.getJuego().getJugadorActivo();

        Monstruo monstruo1 = new MonstruoGenerico("test",0,0,4);
        Monstruo monstruo2 = new MonstruoGenerico("test",0,0,4);

        jugador.invocar(monstruo1);
        jugador.resetearInvocacionesPosibles();
        jugador.invocar(monstruo2);
        jugador.activarCarta(agujeroNegro);

        assertEquals(0,jugador.cantidadCartasZonaMonstruos());
        assertEquals(0,jugador.cantidadCartasZonaMagicas());

    }


    @Test
    public void testInvocarAgujeroNegroEnTableroDestruyeTodosLosMonstruosDelTableroDelInvocadorYDelOponente() {
        Juego.reiniciarJuego();
        AgujeroNegro agujeroNegro = new AgujeroNegro();

        Jugador jugadorActivo = Juego.getJuego().getJugadorActivo();
        Jugador jugadorOponente = Juego.getJuego().getJugadorOponente();

        Monstruo monstruoJugadorActivo1 = new MonstruoGenerico("test1",0,0,4);
        Monstruo monstruoJugadorActivo2 = new MonstruoGenerico("test1",0,0,4);
        Monstruo monstruoJugadorOponente1 = new MonstruoGenerico("test2",0,0,4);
        Monstruo monstruoJugadorOponente2 = new MonstruoGenerico("test2",0,0,4);

        jugadorActivo.invocar(monstruoJugadorActivo1);
        jugadorActivo.resetearInvocacionesPosibles();
        jugadorActivo.invocar(monstruoJugadorActivo2);
        jugadorOponente.invocar(monstruoJugadorOponente1);
        jugadorOponente.resetearInvocacionesPosibles();
        jugadorOponente.invocar(monstruoJugadorOponente2);

        jugadorActivo.activarCarta(agujeroNegro);

        assertEquals(0,jugadorActivo.cantidadCartasZonaMonstruos());
        assertEquals(0,jugadorOponente.cantidadCartasZonaMonstruos());
        assertEquals(0,jugadorActivo.cantidadCartasZonaMagicas());

    }

}
