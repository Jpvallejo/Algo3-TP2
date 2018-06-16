import modelo.*;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MonstruoTest {

    @Test
    public void testColocarMonstruoEnPosicionDeAtaqueGeneraMonstruoEnPosicionDeAtaque(){
        Monstruo monstruo = new Monstruo(100,100,Posicion.ATAQUE,4);

        assertEquals(Posicion.ATAQUE,monstruo.getPosicion());
    }

    @Test
    public void testColocarMonstruoEnPosicionDeDefensaGeneraMonstruoEnPosicionDeDefensa(){
        Monstruo monstruo = new Monstruo(100,100,Posicion.DEFENSA,4);

        assertEquals(Posicion.DEFENSA,monstruo.getPosicion());
    }

    // Ataques entre Monstruos sin invocar
    @Test
    public void testAtacarMounstroEnPocisionAtaqueConIgualesPuntosDestruyeAmbosMounstros()
    {
        Jugador atacante = new Jugador();
        Jugador defensor = new Jugador();
        Monstruo monstruoAtacante = new Monstruo(500,2000, Posicion.ATAQUE,1);
        Monstruo monstruoDefensor = new Monstruo(500,100, Posicion.ATAQUE,1);

        monstruoAtacante.atacarMonstruo(atacante,defensor,monstruoDefensor);

        assertEquals(1,atacante.cantidadCartasCementerio());
        assertEquals(1,defensor.cantidadCartasCementerio());
    }

    @Test
    public void testAtacarMounstroEnPocisionAtaqueConPuntosAtacanteMayorDestruyeDefensorYRestaDiferenciaEnPuntosJugadorQueDefiende()
    {
        Jugador atacante = new Jugador();
        Jugador defensor = new Jugador();
        Monstruo monstruoAtacante = new Monstruo(1000, 2000, Posicion.ATAQUE,1);
        Monstruo monstruoDefensor = new Monstruo(500, 100, Posicion.ATAQUE,1);

        monstruoAtacante.atacarMonstruo(atacante, defensor, monstruoDefensor);

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

        monstruoAtacante.atacarMonstruo(atacante, defensor, monstruoDefensor);

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

        monstruoAtacante.atacarMonstruo(atacante, defensor, monstruoDefensor);

        assertEquals(1,defensor.cantidadCartasCementerio());
    }

    @Test
    public void testAtacarMounstroEnPocisionDefensaConIgualesPuntosNoProduceCambios()
    {
        Jugador atacante = new Jugador();
        Jugador defensor = new Jugador();
        Monstruo monstruoAtacante = new Monstruo(500,2000, Posicion.ATAQUE,1);
        Monstruo monstruoDefensor = new Monstruo(1000,500, Posicion.DEFENSA,1);

        monstruoAtacante.atacarMonstruo(atacante, defensor, monstruoDefensor);

        assertEquals(0,defensor.cantidadCartasCementerio());
        assertEquals(0,atacante.cantidadCartasCementerio());
    }

    @Test
    public void testAtacarMounstroEnPocisionDefensaConMayoresPuntosNoDestruyeMounstroAtacanteYRestaDiferenciaEnPuntosAlJugadorQueAtaca()
    {
        Jugador atacante = new Jugador(); //Juego.getJuego().getJugadorActivo();
        Jugador defensor = new Jugador(); //Juego.getJuego().getJugadorOponente();
        Monstruo monstruoAtacante = new Monstruo(500,2000, Posicion.ATAQUE,1);
        Monstruo monstruoDefensor = new Monstruo(1000,1000, Posicion.DEFENSA,1);

        monstruoAtacante.atacarMonstruo(atacante, defensor, monstruoDefensor);

        assertEquals(0, atacante.cantidadCartasCementerio());
        assertEquals(0, defensor.cantidadCartasCementerio());
        assertEquals(7500, atacante.getPuntosDeVida());
        assertEquals(8000, defensor.getPuntosDeVida());

    }

    //Ataques invocando monstruos
    @Test
    public void testInvocarMonstruoEnPosicionDeAtaqueYAtacarMonstruoEnPosicionAtaqueConIgualesPuntosDestruyeAmbosMounstros()
    {
        Jugador atacante = new Jugador();
        Jugador defensor = new Jugador();
        Monstruo monstruoAtacante = new Monstruo(500,2000, Posicion.ATAQUE,1);
        Monstruo monstruoDefensor = new Monstruo(500,100, Posicion.ATAQUE,1);
        atacante.colocarEnAtaque(monstruoAtacante);
        defensor.colocarEnAtaque(monstruoDefensor);

        atacante.declararAtaqueDePosicionAPosicion(defensor,Casillero.UNO,Casillero.UNO);

        assertEquals(1,atacante.cantidadCartasCementerio());
        assertEquals(1,defensor.cantidadCartasCementerio());
    }


    @Test
    public void testInvocarMonstruoEnPosicionDeAtaqueYAtacarMonstruoEnPocisionAtaqueConPuntosAtacanteMayorDestruyeDefensorYRestaDiferenciaEnPuntosJugadorQueDefiende()
    {
        Jugador atacante = new Jugador();
        Jugador defensor = new Jugador();
        Monstruo monstruoAtacante = new Monstruo(1000, 2000, Posicion.ATAQUE,1);
        Monstruo monstruoDefensor = new Monstruo(500, 100, Posicion.ATAQUE,1);
        atacante.colocarEnAtaque(monstruoAtacante);
        defensor.colocarEnAtaque(monstruoDefensor);

        atacante.declararAtaqueDePosicionAPosicion(defensor,Casillero.UNO,Casillero.UNO);

        assertEquals(0,atacante.cantidadCartasCementerio());
        assertEquals(1,defensor.cantidadCartasCementerio());
        assertEquals(atacante.getPuntosDeVida(), 8000);
        assertEquals(defensor.getPuntosDeVida(), 7500);
    }

    @Test
    public void testInvocarMonstruoEnPosicionDeAtaqueYAtacarMounstroEnPocisionAtaqueConPuntosAtacanteMenorDestruyeAtacanteYRestaDiferenciaEnPuntosJugadorQueAtaca()
    {
        Jugador atacante = new Jugador();
        Jugador defensor = new Jugador();
        Monstruo monstruoAtacante = new Monstruo(500,2000, Posicion.ATAQUE,1);
        Monstruo monstruoDefensor = new Monstruo(1000,100, Posicion.ATAQUE,1);
        atacante.colocarEnAtaque(monstruoAtacante);
        defensor.colocarEnAtaque(monstruoDefensor);

        atacante.declararAtaqueDePosicionAPosicion(defensor,Casillero.UNO,Casillero.UNO);

        assertEquals(1,atacante.cantidadCartasCementerio());
        assertEquals(0,defensor.cantidadCartasCementerio());
        assertEquals(atacante.getPuntosDeVida(), 7500);
        assertEquals(defensor.getPuntosDeVida(), 8000);
    }

    @Test
    public void testInvocarMonstruosEnPosicionDeAtaqueYAtacarMounstroEnPocisionDefensaConMenoresPuntosDestruyeMounstroDefensor()
    {
        Jugador atacante = new Jugador();
        Jugador defensor = new Jugador();
        Monstruo monstruoAtacante = new Monstruo(500,2000, Posicion.ATAQUE,1);
        Monstruo monstruoDefensor = new Monstruo(1000,100, Posicion.DEFENSA,1);
        atacante.colocarEnAtaque(monstruoAtacante);
        defensor.colocarEnDefensa(monstruoDefensor);

        atacante.declararAtaqueDePosicionAPosicion(defensor,Casillero.UNO,Casillero.UNO);

        assertEquals(1,defensor.cantidadCartasCementerio());
    }

    @Test
    public void testInvocarMonstruosEnPosicionDeAtaqueYAtacarMounstroEnPocisionDefensaConIgualesPuntosNoProduceCambios()
    {
        Jugador atacante = new Jugador();
        Jugador defensor = new Jugador();
        Monstruo monstruoAtacante = new Monstruo(500,2000, Posicion.ATAQUE,1);
        Monstruo monstruoDefensor = new Monstruo(1000,500, Posicion.DEFENSA,1);
        atacante.colocarEnAtaque(monstruoAtacante);
        defensor.colocarEnDefensa(monstruoDefensor);

        atacante.declararAtaqueDePosicionAPosicion(defensor,Casillero.UNO,Casillero.UNO);

        assertEquals(0,defensor.cantidadCartasCementerio());
        assertEquals(0,atacante.cantidadCartasCementerio());
    }

    @Test
    public void testInvocarMonstruosEnPosicionDeAtaqueYAtacarMounstroEnPocisionDefensaConMayoresPuntosNoDestruyeMounstroAtacanteYRestaDiferenciaEnPuntosAlJugadorQueAtaca()
    {
        Juego.reiniciarJuego();
        Jugador atacante = new Jugador(); //Juego.getJuego().getJugadorActivo();
        Jugador defensor = new Jugador(); //Juego.getJuego().getJugadorOponente();
        Monstruo monstruoAtacante = new Monstruo(500,2000, Posicion.ATAQUE,1);
        Monstruo monstruoDefensor = new Monstruo(1000,1000, Posicion.DEFENSA,1);
        atacante.colocarEnAtaque(monstruoAtacante);
        defensor.colocarEnDefensa(monstruoDefensor);

        atacante.declararAtaqueDePosicionAPosicion(defensor,Casillero.UNO,Casillero.UNO);

        assertEquals(0, atacante.cantidadCartasCementerio());
        assertEquals(0, defensor.cantidadCartasCementerio());
        assertEquals(7500, atacante.getPuntosDeVida());
        assertEquals(8000, defensor.getPuntosDeVida());

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

    @Test
    public void testColocarMonstruoCon5EstrellasSacrificaUnMonstruo2(){
        //Juego.reiniciarJuego();
        Monstruo aSacrificar= new Monstruo(0,0,Posicion.ATAQUE,3);
        Monstruo sacrificador = new Monstruo(0,0,Posicion.ATAQUE,5);
        //Juego.getJuego().getJugadorActivo().colocarEnAtaque(aSacrificar);
        //Juego.getJuego().getJugadorActivo().colocarEnAtaque(sacrificador);
        Jugador jugador = new Jugador();

        jugador.colocarEnAtaque(aSacrificar);
        jugador.colocarEnAtaque(sacrificador);

        assertEquals(1,jugador.cantidadCartasCementerio());
    }

    @Test
    public void testColocarMonstruoCon5EstrellasSacrificaUnMonstruo(){
        Monstruo aSacrificar= new Monstruo(0,0,Posicion.ATAQUE,3);
        Monstruo sacrificador = new Monstruo(0,0,Posicion.ATAQUE,5);
        Jugador jugador = new Jugador();

        jugador.colocarEnAtaque(aSacrificar);
        jugador.colocarEnAtaque(sacrificador);
        assertEquals(1,jugador.cantidadCartasCementerio());
    }




    /* CORREJIR!! Corre bien dependiendo de cuando se ejecute
    @Test
    public void testColocarMonstruoCon7EstrellasSacrificaDosMonstruos(){
        Monstruo aSacrificar1= new Monstruo(0,0,Posicion.ATAQUE,3);
        Monstruo aSacrificar2= new Monstruo(0,0,Posicion.ATAQUE,3);
        Monstruo sacrificador = new Monstruo(0,0,Posicion.ATAQUE,7);
        Juego.getJuego().getJugadorActivo().colocarEnAtaque(aSacrificar1);
        Juego.getJuego().getJugadorActivo().colocarEnAtaque(aSacrificar2);
        Juego.getJuego().getJugadorActivo().colocarEnAtaque(sacrificador);
        assertEquals(2,Juego.getJuego().getJugadorActivo().cantidadCartasCementerio());
    }
    */

}
