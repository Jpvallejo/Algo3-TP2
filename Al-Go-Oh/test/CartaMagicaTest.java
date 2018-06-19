import modelo.*;
import modelo.CartasMagicas.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;



public class CartaMagicaTest {


    @Test
    public void colocarCartaMagicaColocaLaCartaBocaAbajo(){
        AgujeroNegro agujeroNegro = new AgujeroNegro();
        Jugador jugador = new Jugador();
        jugador.colocarCarta(agujeroNegro);

        assertTrue(jugador.obtenerCampo().getZonaHechizos().obtenerCartaPosicion(Casillero.UNO).estaBocaAbajo());

    }
    

    @Test
    public void testInvocarAgujeroNegroEnTableroDestruyeTodosLosMonstruosDelTableroDelInvocador() {
        Juego.reiniciarJuego();
        AgujeroNegro agujeroNegro = new AgujeroNegro(Colocacion.BOCAARRIBA);

        Jugador jugador = Juego.getJuego().getJugadorActivo();

        Monstruo monstruo = new Monstruo(0,0,Posicion.DEFENSA,4);
        
        jugador.colocarEnAtaque(monstruo);
        jugador.colocarCarta(agujeroNegro);

        assertEquals(0,jugador.obtenerCampo().cantidadCartasZonaMonstruos());
        assertEquals(0,jugador.obtenerCampo().cantidadCartasZonaMagicas());

    }


    @Test
    public void testInvocarAgujeroNegroEnTableroDestruyeTodosLosMonstruosDelTableroDelInvocadorYDelOponente() {
        Juego.reiniciarJuego();
        AgujeroNegro agujeroNegro = new AgujeroNegro(Colocacion.BOCAARRIBA);

        Jugador jugadorActivo = Juego.getJuego().getJugadorActivo();
        Jugador jugadorOponente = Juego.getJuego().getJugadorOponente();

        Monstruo monstruoJugadorActivo = new Monstruo(0,0,Posicion.DEFENSA,4);
        Monstruo monstruoJugadorOponente = new Monstruo(0,0,Posicion.DEFENSA,4);

        jugadorActivo.colocarEnAtaque(monstruoJugadorActivo);
        jugadorOponente.colocarEnAtaque(monstruoJugadorOponente);
        
        jugadorActivo.colocarCarta(agujeroNegro);

        assertEquals(0,jugadorActivo.obtenerCampo().cantidadCartasZonaMonstruos());
        assertEquals(0,jugadorOponente.obtenerCampo().cantidadCartasZonaMonstruos());
        assertEquals(0,jugadorActivo.obtenerCampo().cantidadCartasZonaMagicas());

    }

     @Test
    public void testAplicarCartaWastelandEnMonstruosYAtacar() {
            
        Jugador atacante = new Jugador();
        Monstruo monstruoAtaque = new Monstruo(100,0,Posicion.ATAQUE,4);
             
        atacante.colocarEnAtaque(monstruoAtaque);
        
        
        Jugador defensor = new Jugador();

        Monstruo monstruoDefensa = new Monstruo(100,200,Posicion.ATAQUE,4);
        
        defensor.colocarEnAtaque(monstruoDefensa);
        
        atacante.obtenerCampo().aplicarCartaCampo(200,true);//Aca aplicaria la carta de campo
        defensor.obtenerCampo().aplicarCartaCampo(300,false);
        
        atacante.declararAtaqueDePosicionAPosicion(defensor,Casillero.UNO,Casillero.UNO);
        
        //Le resta 200 puntos de vida al jugador defensor
        assertEquals(1, defensor.cantidadCartasCementerio());
        assertEquals(7800, defensor.getPuntosDeVida());
        
        
        //Creo monstruo en modo de defensa con 100 de defensa
        Monstruo monstruoDefensa01 = new Monstruo(100,100,Posicion.DEFENSA,4);
        
        defensor.colocarEnDefensa(monstruoDefensa01);
        
        defensor.obtenerCampo().aplicarCartaCampo(300,false);
        
        atacante.declararAtaqueDePosicionAPosicion(defensor,Casillero.UNO,Casillero.UNO);
        
        //Le resta 100 puntos de vida al que ataca porque tengo el defensor con un monstruo con 400 de defensa y el mio tiene 300
         assertEquals(7900, atacante.getPuntosDeVida());
         
    }
     
    
    
}
