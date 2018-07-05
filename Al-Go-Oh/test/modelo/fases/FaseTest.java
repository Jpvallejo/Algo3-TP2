package modelo.fases;

import modelo.*;
import modelo.Fases.*;
import modelo.Monstruos.*;
import org.junit.Test;
import modelo.CartasMagicas.*;

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
    public void testAvanzarFaseDesdeFaseAtaquePasaAFaseFinalDondeCambiaDeTurno() {
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
    
    
     @Test
    public void testIrHastaFaseAtaqueYAtacarAlOponente() {
        Juego.reiniciarJuego();
        Juego.getJuego().avanzarFase(); //Avanza a FasePreparacion
        Jugador jugadorActivo =  Juego.getJuego().getJugadorActivo();
        Jugador jugadorOponente =  Juego.getJuego().getJugadorOponente();
        
        Wasteland wasteland = new Wasteland();
        AmateFeliz amateFeliz = new AmateFeliz();
        
        jugadorActivo.invocar(amateFeliz); //800 ataque 500 def
        jugadorActivo.colocarCarta(wasteland);
        
        Juego.getJuego().avanzarFase(); //Avanza a FaseAtaque. Se activa la Carta Campo
        
        //800 + 200 de carta campo
        amateFeliz.atacar(jugadorOponente);
        
        //Ataca directo a los puntos de vida le resta 1000 puntos
        assertEquals(7000, jugadorOponente.getPuntosDeVida());
        
        
        Juego.getJuego().cambiarTurno();
        Juego.getJuego().avanzarFase(); //avanza a fase de Preparacion
        jugadorActivo =  Juego.getJuego().getJugadorActivo();
        jugadorOponente =  Juego.getJuego().getJugadorOponente();
                
        AligatorDeLaEspada aligator = new AligatorDeLaEspada();
        
        jugadorActivo.invocar(aligator); //1500 ataque 1200 def

        Juego.getJuego().avanzarFase(); //Avanza a FaseAtaque. Se activa la Carta Campo
        
        aligator.atacarMonstruo(amateFeliz);
        
        //1500 - 1000 
        assertEquals(7500, jugadorOponente.getPuntosDeVida());
        
    }
    
    
    

}
