import modelo.*;
import modelo.Fases.*;
import org.junit.Test;

import static org.junit.Assert.*;


public class FaseTest {

    @Test
    public void testAlReiniciarElJuegoComienzaEnLaFaseInicial() {
        Juego.reiniciarJuego();

        Fase faseActual = Juego.getJuego().obtenerFase();

        assertTrue(faseActual instanceof FaseInicial);

    }

    @Test
    public void testAvanzarFaseDesdeFaseInicialPasaAFasePreparacion() {
        Juego.reiniciarJuego();
        Juego.getJuego().avanzarFase();

        Fase faseActual = Juego.getJuego().obtenerFase();

        assertTrue(faseActual instanceof FasePreparacion);

    }

    @Test
    public void testAvanzarFaseDesdeFasePreparacionPasaAFaseAtaque() {
        Juego.reiniciarJuego();
        Juego.getJuego().avanzarFase(); //Avanza a FasePreparacion
        Juego.getJuego().avanzarFase(); //Avanza a FaseAtaque

        Fase faseActual = Juego.getJuego().obtenerFase();

        assertTrue(faseActual instanceof FaseAtaque);

    }

    @Test
    public void testAvanzarFaseDesdeFaseAtaquePasaAFaseFinal() {
        Juego.reiniciarJuego();
        Juego.getJuego().avanzarFase(); //Avanza a FasePreparacion
        Juego.getJuego().avanzarFase(); //Avanza a FaseAtaque
        Juego.getJuego().avanzarFase(); //Avanza a FaseFinal

        Fase faseActual = Juego.getJuego().obtenerFase();

        assertTrue(faseActual instanceof FaseFinal);

    }

    @Test
    public void testAlCambiarTurnoSeCambiaLaFaseALaFaseInicial() {
        Juego.reiniciarJuego();
        Juego.getJuego().avanzarFase(); //Avanza a FasePreparacion
        Juego.getJuego().avanzarFase(); //Avanza a FaseAtaque
        Juego.getJuego().avanzarFase(); //Avanza a FaseFinal
        Juego.getJuego().cambiarTurno();

        Fase faseActual = Juego.getJuego().obtenerFase();

        assertTrue(faseActual instanceof FaseInicial);

    }

    /* Completar cuando este la Mano modelada
    @Test
    public void testAlIniciarFaseEnFaseInicialLaCantidadDeCartasEnLaManoAumentaA6() {
        Juego.reiniciarJuego();
        Juego.getJuego().iniciarFase();
        Mano mano = Juego.getJuego().getJugadorActivo().getMano();

        assertEquals(6, mano.cantidadCartas());

    } */

}
