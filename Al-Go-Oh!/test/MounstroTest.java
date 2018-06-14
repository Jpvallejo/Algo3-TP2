import modelo.Jugador;
import modelo.Mounstro;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MounstroTest {

    @Test
    public void testAtacarMounstroEnPocisionAtaqueConIgualesPuntosDestruyeAmbosMounstros()
    {
        Jugador atacante = new Jugador();
        Jugador defensor = new Jugador();
        Mounstro mounstroAtacante = new Mounstro(500,2000);
        Mounstro mounstroDefensor = new Mounstro(500,100);

        mounstroAtacante.atacarMounstro(mounstroDefensor,atacante,defensor);

        assertTrue(atacante.cantidadCartasCementerio() == 1 && defensor.cantidadCartasCementerio() == 1);
    }

    @Test
    public void testAtacarMounstroEnPocisionAtaqueConPuntosAtacanteMayorDestruyeDefensorYRestaDiferenciaEnPuntosJugadorQueDefiende() {
        Jugador atacante = new Jugador();
        Jugador defensor = new Jugador();
        Mounstro mounstroAtacante = new Mounstro(1000, 2000);
        Mounstro mounstroDefensor = new Mounstro(500, 100);

        mounstroAtacante.atacarMounstro(mounstroDefensor, atacante, defensor);

        assertTrue(atacante.cantidadCartasCementerio() == 0 && defensor.cantidadCartasCementerio() == 1);
        assertEquals(atacante.getPuntosDeVida(), 8000);
        assertEquals(defensor.getPuntosDeVida(), 7500);
    }

    @Test
    public void testAtacarMounstroEnPocisionAtaqueConPuntosAtacanteMenorDestruyeAtacanteYRestaDiferenciaEnPuntosJugadorQueAtaca()
    {
        Jugador atacante = new Jugador();
        Jugador defensor = new Jugador();
        Mounstro mounstroAtacante = new Mounstro(500,2000);
        Mounstro mounstroDefensor = new Mounstro(1000,100);

        mounstroAtacante.atacarMounstro(mounstroDefensor,atacante,defensor);

        assertTrue(atacante.cantidadCartasCementerio() == 0 && defensor.cantidadCartasCementerio() == 1);
        assertEquals(atacante.getPuntosDeVida(), 7500);
        assertEquals(defensor.getPuntosDeVida(), 8000);
    }

    @Test
    public void testAtacarMounstroEnPocisionDefensaConMenoresPuntosDestruyeMounstroDefensor()
    {
        Jugador atacante = new Jugador();
        Jugador defensor = new Jugador();
        Mounstro mounstroAtacante = new Mounstro(500,2000);
        Mounstro mounstroDefensor = new Mounstro(1000,100);

        mounstroAtacante.atacarMounstro(mounstroDefensor,atacante,defensor);

        assertTrue(defensor.cantidadCartasCementerio() == 1);
    }

    @Test
    public void testAtacarMounstroEnPocisionDefensaConIgualesPuntosNoProduceCambios()
    {
        Jugador atacante = new Jugador();
        Jugador defensor = new Jugador();
        Mounstro mounstroAtacante = new Mounstro(500,2000);
        Mounstro mounstroDefensor = new Mounstro(1000,100);

        mounstroAtacante.atacarMounstro(mounstroDefensor,atacante,defensor);

        assertTrue(defensor.cantidadCartasCementerio() == 0 && atacante.cantidadCartasCementerio() == 0);
    }

    @Test
    public void testAtacarMounstroEnPocisionDefensaConMayoresPuntosDestruyeMounstroAtacante()
    {
        Jugador atacante = new Jugador();
        Jugador defensor = new Jugador();
        Mounstro mounstroAtacante = new Mounstro(500,2000);
        Mounstro mounstroDefensor = new Mounstro(1000,100);

        mounstroAtacante.atacarMounstro(mounstroDefensor,atacante,defensor);

        assertEquals(1, atacante.cantidadCartasCementerio());
    }
}
