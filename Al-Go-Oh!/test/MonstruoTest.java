import modelo.Jugador;
import modelo.Monstruo;
import modelo.Posicion;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MonstruoTest {

    @Test
    public void testAtacarMounstroEnPocisionAtaqueConIgualesPuntosDestruyeAmbosMounstros()
    {
        Jugador atacante = new Jugador();
        Jugador defensor = new Jugador();
        Monstruo monstruoAtacante = new Monstruo(500,2000, Posicion.ATAQUE);
        Monstruo monstruoDefensor = new Monstruo(500,100, Posicion.ATAQUE);

        monstruoAtacante.atacarMounstro(monstruoDefensor,atacante,defensor);

        //assertTrue(atacante.cantidadCartasCementerio() == 1 && defensor.cantidadCartasCementerio() == 1);
        assertEquals(1,atacante.cantidadCartasCementerio());
        assertEquals(1,defensor.cantidadCartasCementerio());
    }

    @Test
    public void testAtacarMounstroEnPocisionAtaqueConPuntosAtacanteMayorDestruyeDefensorYRestaDiferenciaEnPuntosJugadorQueDefiende() {
        Jugador atacante = new Jugador();
        Jugador defensor = new Jugador();
        Monstruo monstruoAtacante = new Monstruo(1000, 2000, Posicion.ATAQUE);
        Monstruo monstruoDefensor = new Monstruo(500, 100, Posicion.ATAQUE);

        monstruoAtacante.atacarMounstro(monstruoDefensor, atacante, defensor);

        //assertTrue(atacante.cantidadCartasCementerio() == 0 && defensor.cantidadCartasCementerio() == 1);
        assertEquals(0,atacante.cantidadCartasCementerio());
        assertEquals(1,defensor.cantidadCartasCementerio());
        assertEquals(atacante.getPuntosDeVida(), 8000);
        assertEquals(defensor.getPuntosDeVida(), 7500);
    }

    @Test
    public void testAtacarMounstroEnPocisionAtaqueConPuntosAtacanteMenorDestruyeAtacanteYRestaDiferenciaEnPuntosJugadorQueAtaca()
    {
        Jugador atacante = new Jugador();
        Jugador defensor = new Jugador();
        Monstruo monstruoAtacante = new Monstruo(500,2000, Posicion.ATAQUE);
        Monstruo monstruoDefensor = new Monstruo(1000,100, Posicion.ATAQUE);

        monstruoAtacante.atacarMounstro(monstruoDefensor,atacante,defensor);

        //assertTrue(atacante.cantidadCartasCementerio() == 0 && defensor.cantidadCartasCementerio() == 1);
        assertEquals(1,atacante.cantidadCartasCementerio());
        assertEquals(0,defensor.cantidadCartasCementerio());
        assertEquals(atacante.getPuntosDeVida(), 7500);
        assertEquals(defensor.getPuntosDeVida(), 8000);
    }

    @Test
    public void testAtacarMounstroEnPocisionDefensaConMenoresPuntosDestruyeMounstroDefensor()
    {
        Jugador atacante = new Jugador();
        Jugador defensor = new Jugador();
        Monstruo monstruoAtacante = new Monstruo(500,2000, Posicion.ATAQUE);
        Monstruo monstruoDefensor = new Monstruo(1000,100, Posicion.DEFENSA);

        monstruoAtacante.atacarMounstro(monstruoDefensor,atacante,defensor);

        assertEquals(1,defensor.cantidadCartasCementerio());
    }

    @Test
    public void testAtacarMounstroEnPocisionDefensaConIgualesPuntosNoProduceCambios()
    {
        Jugador atacante = new Jugador();
        Jugador defensor = new Jugador();
        Monstruo monstruoAtacante = new Monstruo(500,2000, Posicion.ATAQUE);
        Monstruo monstruoDefensor = new Monstruo(1000,500, Posicion.DEFENSA);

        monstruoAtacante.atacarMounstro(monstruoDefensor,atacante,defensor);

        //assertTrue(defensor.cantidadCartasCementerio() == 0 && atacante.cantidadCartasCementerio() == 0);
        assertEquals(0,defensor.cantidadCartasCementerio());
        assertEquals(0,atacante.cantidadCartasCementerio());
    }

    @Test
    public void testAtacarMounstroEnPocisionDefensaConMayoresPuntosNoDestruyeMounstroAtacanteYRestaDiferenciaEnPuntosAlJugadorQueAtaca()
    {

        Jugador atacante = new Jugador();
        Jugador defensor = new Jugador();
        Monstruo monstruoAtacante = new Monstruo(500,2000, Posicion.ATAQUE);
        Monstruo monstruoDefensor = new Monstruo(1000,1000, Posicion.DEFENSA);

        monstruoAtacante.atacarMounstro(monstruoDefensor,atacante,defensor);

        assertEquals(0, atacante.cantidadCartasCementerio());
        assertEquals(0, defensor.cantidadCartasCementerio());
        assertEquals(atacante.getPuntosDeVida(), 7500);
        assertEquals(defensor.getPuntosDeVida(), 8000);

    }
}
