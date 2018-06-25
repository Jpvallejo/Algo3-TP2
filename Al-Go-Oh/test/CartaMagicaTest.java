import modelo.CartasMagicas.AgujeroNegro;
import modelo.*;
import modelo.CartasMagicas.Fisura;
import modelo.CartasMagicas.OllaDeLaCodicia;
import modelo.CartasMagicas.Sogen;
import modelo.CartasMagicas.Wasteland;
import modelo.Monstruos.MonstruoGenerico;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;



public class CartaMagicaTest {


    @Test
    public void testColocarCartaMagicaColocaLaCartaBocaAbajo(){
        AgujeroNegro agujeroNegro = new AgujeroNegro();
        Jugador jugador = new Jugador();
        jugador.colocarCarta(agujeroNegro);

        assertTrue(jugador.getZonaHechizos().obtenerCartaPosicion(Casillero.UNO).estaBocaAbajo());

    }
    

    @Test
    public void testInvocarAgujeroNegroEnTableroDestruyeTodosLosMonstruosDelTableroDelInvocador() {
        Juego.reiniciarJuego();
        AgujeroNegro agujeroNegro = new AgujeroNegro();

        Jugador jugador = Juego.getJuego().getJugadorActivo();

        Monstruo monstruo = new MonstruoGenerico("test",0,0,4);
        
        jugador.invocar(monstruo);
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

        Monstruo monstruoJugadorActivo = new MonstruoGenerico("test1",0,0,4);
        Monstruo monstruoJugadorOponente = new MonstruoGenerico("test2",0,0,4);

        jugadorActivo.invocar(monstruoJugadorActivo);
        jugadorOponente.invocar(monstruoJugadorOponente);
        
        jugadorActivo.activarCarta(agujeroNegro);

        assertEquals(0,jugadorActivo.cantidadCartasZonaMonstruos());
        assertEquals(0,jugadorOponente.cantidadCartasZonaMonstruos());
        assertEquals(0,jugadorActivo.cantidadCartasZonaMagicas());

    }

     @Test
    public void testAplicarCartaWastelandEnMonstruosYAtacar() {
          
        Juego.reiniciarJuego();
        Wasteland wasteland = new Wasteland();
        
        
        Jugador jugadorActivo = Juego.getJuego().getJugadorActivo();
        
        jugadorActivo.colocarCarta(wasteland);
        
        Jugador jugadorOponente = Juego.getJuego().getJugadorOponente();

        Monstruo monstruoAtaque = new MonstruoGenerico("test1",100,0,4);
        jugadorActivo.invocar(monstruoAtaque);

        Monstruo monstruoDefensa = new MonstruoGenerico("test2",100,200,4);
        jugadorOponente.invocar(monstruoDefensa);
        
        jugadorActivo.activarCartaCampo();
        
        //atacante.declararAtaqueDePosicionAPosicion(defensor,Casillero.UNO,Casillero.UNO);
         monstruoAtaque.atacarMonstruo(monstruoDefensa);
        
        //Le resta 200 puntos de vida al jugador defensor
        assertEquals(1, jugadorOponente.cantidadCartasCementerio());
        assertEquals(7800, jugadorOponente.getPuntosDeVida());
        
        jugadorActivo.revertirCartaCampo();
        
        //Creo monstruo en modo de defensa con 100 de defensa
        Monstruo monstruoDefensa01 = new MonstruoGenerico("test",100,100,4);
        jugadorOponente.colocar(monstruoDefensa01);
        
        
        jugadorActivo.activarCartaCampo();
        
        //atacante.declararAtaqueDePosicionAPosicion(defensor,Casillero.UNO,Casillero.UNO);
         monstruoAtaque.atacarMonstruo(monstruoDefensa01);

        //Le resta 100 puntos de vida al que ataca porque tengo el defensor con un monstruo con 400 de defensa y el mio tiene 300
         assertEquals(7900, jugadorActivo.getPuntosDeVida());
         
    }

    @Test
    public void testAplicarCartaSogenEnMonstruosYAtacar() {


        Juego.reiniciarJuego();
        Sogen sogen = new Sogen();

        Jugador jugadorActivo = Juego.getJuego().getJugadorActivo();
        Jugador jugadorOponente = Juego.getJuego().getJugadorOponente();

        jugadorActivo.colocarCarta(sogen);

        Monstruo monstruoAtaque = new MonstruoGenerico("test",100,0,4);

        jugadorActivo.invocar(monstruoAtaque);

        Monstruo monstruoDefensa = new MonstruoGenerico("test",100,200,4);

        jugadorOponente.invocar(monstruoDefensa);

        jugadorActivo.activarCartaCampo(); //Suma 200 al ataque del monstruo del jugadorOponente osea tiene 300

        jugadorActivo.declararAtaqueDePosicionAPosicion(jugadorOponente,Casillero.UNO,Casillero.UNO);

        assertEquals(1, jugadorActivo.cantidadCartasCementerio());
        //Le resta 200 puntos de vida al jugadorActivo
        assertEquals(7800, jugadorActivo.getPuntosDeVida());

    }




    @Test
    public void testInvocarOllaDeLaCodiciaPermiteTomarDosCartasDelMazo() {
        Juego.reiniciarJuego();
        OllaDeLaCodicia ollaDeLaCodicia = new OllaDeLaCodicia();

        Jugador jugadorActivo = Juego.getJuego().getJugadorActivo();
        int cantidadEnMazo = jugadorActivo.obtenerTamanioMazo();
        jugadorActivo.activarCarta(ollaDeLaCodicia);

        assertEquals(cantidadEnMazo - 2,jugadorActivo.obtenerTamanioMazo());//Esta Mal Lo veo despues.
    }


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
        jugadorOponente.invocar(monstruo2);
        jugadorOponente.invocar(monstruo3);

        Fisura fisura = new Fisura();

        jugadorActivo.activarCarta(fisura);

        assertEquals(1, jugadorOponente.cantidadCartasCementerio());

        //Busca el monstruo3 en el cementerio el cual deberia estar por ser el monstruo con menor Ataque
        assertEquals(monstruo3, jugadorOponente.buscarCartaEnCementerio(monstruo3));

    }
    
}
