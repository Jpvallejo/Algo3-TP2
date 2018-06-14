import modelo.Jugador;
import modelo.Monstruo;
import modelo.Posicion;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MonstruoTest {

    @Test
    public void testAtacarMounstroEnPocisionAtaqueConIgualesPuntosDestruyeAmbosMounstros()
    {
        Jugador atacante = new Jugador();
        Jugador defensor = new Jugador();
        Monstruo monstruoAtacante = new Monstruo(500,2000, Posicion.ATAQUE,1);
        Monstruo monstruoDefensor = new Monstruo(500,100, Posicion.ATAQUE,1);

        monstruoAtacante.atacarMounstro(monstruoDefensor);

        //assertTrue(atacante.cantidadCartasCementerio() == 1 && defensor.cantidadCartasCementerio() == 1);
        assertEquals(1,atacante.cantidadCartasCementerio());
        assertEquals(1,defensor.cantidadCartasCementerio());
    }

    @Test
    public void testAtacarMounstroEnPocisionAtaqueConPuntosAtacanteMayorDestruyeDefensorYRestaDiferenciaEnPuntosJugadorQueDefiende() {
        Jugador atacante = new Jugador();
        Jugador defensor = new Jugador();
        Monstruo monstruoAtacante = new Monstruo(1000, 2000, Posicion.ATAQUE,1);
        Monstruo monstruoDefensor = new Monstruo(500, 100, Posicion.ATAQUE,1);

        monstruoAtacante.atacarMounstro(monstruoDefensor);

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
        Monstruo monstruoAtacante = new Monstruo(500,2000, Posicion.ATAQUE,1);
        Monstruo monstruoDefensor = new Monstruo(1000,100, Posicion.ATAQUE,1);

        monstruoAtacante.atacarMounstro(monstruoDefensor);

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
        Monstruo monstruoAtacante = new Monstruo(500,2000, Posicion.ATAQUE,1);
        Monstruo monstruoDefensor = new Monstruo(1000,100, Posicion.DEFENSA,1);

        monstruoAtacante.atacarMounstro(monstruoDefensor);

        assertEquals(1,defensor.cantidadCartasCementerio());
    }

    @Test
    public void testAtacarMounstroEnPocisionDefensaConIgualesPuntosNoProduceCambios()
    {
        Jugador atacante = new Jugador();
        Jugador defensor = new Jugador();
        Monstruo monstruoAtacante = new Monstruo(500,2000, Posicion.ATAQUE,1);
        Monstruo monstruoDefensor = new Monstruo(1000,500, Posicion.DEFENSA,1);

        monstruoAtacante.atacarMounstro(monstruoDefensor);

        //assertTrue(defensor.cantidadCartasCementerio() == 0 && atacante.cantidadCartasCementerio() == 0);
        assertEquals(0,defensor.cantidadCartasCementerio());
        assertEquals(0,atacante.cantidadCartasCementerio());
    }

    @Test
    public void testAtacarMounstroEnPocisionDefensaConMayoresPuntosNoDestruyeMounstroAtacanteYRestaDiferenciaEnPuntosAlJugadorQueAtaca()
    {

        Jugador atacante = new Jugador();
        Jugador defensor = new Jugador();
        Monstruo monstruoAtacante = new Monstruo(500,2000, Posicion.ATAQUE,1);
        Monstruo monstruoDefensor = new Monstruo(1000,1000, Posicion.DEFENSA,1);

        monstruoAtacante.atacarMounstro(monstruoDefensor);

        assertEquals(0, atacante.cantidadCartasCementerio());
        assertEquals(0, defensor.cantidadCartasCementerio());
        assertEquals(atacante.getPuntosDeVida(), 7500);
        assertEquals(defensor.getPuntosDeVida(), 8000);

    }

    @Test
    public void testMonstruoConMenosDeCuatroEstrellasNoRequiereSacrificio(){
        Monstruo monstruo = new Monstruo(0,0,Posicion.ATAQUE,3);
        assertFalse(monstruo.requiereSacrificio());
    }

    @Test
    public void testMonstruoConMasDeCuatroEstrellasRequiereSacrificio(){
        Monstruo monstruo = new Monstruo(0,0,Posicion.ATAQUE,6);
        assertTrue(monstruo.requiereSacrificio());
    }

    @Test
    public void testMonstruoConMasDeCuatroEstrellasRequiereSacrificarUnMonstruo(){
        Monstruo monstruo = new Monstruo(0,0,Posicion.ATAQUE,5);
        assertEquals(monstruo.cantidadASacrificar(),1);
    }

    @Test
    public void testMonstruoConMasDeSeisEstrellasRequiereSacrificarDosMonstruos(){
        Monstruo monstruo = new Monstruo(0,0,Posicion.ATAQUE,7);
        assertEquals(monstruo.cantidadASacrificar(),2);
    }


}
