package modelo;

import modelo.*;
import modelo.CartasMagicas.*;
import static org.junit.Assert.assertEquals;

import modelo.Monstruos.MonstruoGenerico;
import org.junit.Test;



public class JugadorTest {

    @Test
    public void testInvocarCartaMagicaAumentaEn1LaCantidadDeCartasEnZonaMagicas() {

        AgujeroNegro agujeroNegro = new AgujeroNegro();

        Jugador jugador = new Jugador();

        jugador.colocarCarta(agujeroNegro);

        assertEquals(1,jugador.cantidadCartasZonaMagicas());

    }

    @Test
    public void testInvocarCartaMonstruoAumentaEn1LaCantidadDeCartasEnZonaMonstruos() {
        Juego.reiniciarJuego();
        Juego.getJuego().avanzarFase(); //avanza a fase de Preparacion
        Jugador jugador = new Jugador();

        Monstruo monstruo = new MonstruoGenerico("test",0,0,4);
        jugador.invocar(monstruo);
        assertEquals(1,jugador.cantidadCartasZonaMonstruos());

    }



}
