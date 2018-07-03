import modelo.CartasMagicas.AgujeroNegro;
import modelo.*;
import modelo.CartasMagicas.Fisura;
import modelo.CartasMagicas.OllaDeLaCodicia;
import modelo.CartasMagicas.Sogen;
import modelo.CartasMagicas.Wasteland;
import modelo.Monstruos.AgresorOscuro;
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

        assertTrue(jugador.getZonaHechizos().contains(agujeroNegro));

    }
    

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

     @Test
    public void testColocarWastelandEnElCampoAumentaElAtaqueDelJugadorActivosEn200YLaDefensaDelJugadorOponenteEn300() {

         Juego.reiniciarJuego();
        Wasteland wasteland = new Wasteland();
        
        
        Jugador jugadorActivo = Juego.getJuego().getJugadorActivo();
        
        jugadorActivo.colocarCarta(wasteland);
        Jugador jugadorOponente = Juego.getJuego().getJugadorOponente();

        Monstruo monstruoAtaque = new MonstruoGenerico("test1",300,0,4);
        jugadorActivo.invocar(monstruoAtaque);
        Monstruo monstruoDefensa = new MonstruoGenerico("test2",100,200,4);
        jugadorOponente.colocar(monstruoDefensa);
        jugadorActivo.activarCartaCampo();

        assertEquals(500,monstruoAtaque.getPuntosAtaque());
        assertEquals(500,monstruoDefensa.getPuntosDefensa());
    }

    @Test
    public void testColocarWastelandYRevertirCartaDeCampoDevuelveAtaquesYDefensasALaNormalidad() {

        Juego.reiniciarJuego();
        Wasteland wasteland = new Wasteland();


        Jugador jugadorActivo = Juego.getJuego().getJugadorActivo();

        jugadorActivo.colocarCarta(wasteland);
        Jugador jugadorOponente = Juego.getJuego().getJugadorOponente();

        Monstruo monstruoAtaque = new MonstruoGenerico("test1",300,0,4);
        jugadorActivo.invocar(monstruoAtaque);
        Monstruo monstruoDefensa = new MonstruoGenerico("test2",100,200,4);
        jugadorOponente.colocar(monstruoDefensa);

        // Simulacion de Fase de Ataque
        Juego.getJuego().activarCartasDeCampo();
        monstruoAtaque.atacarMonstruo(monstruoDefensa);
        Juego.getJuego().revertirCartasDeCampo();

        assertEquals(300,monstruoAtaque.getPuntosAtaque());
        assertEquals(200,monstruoDefensa.getPuntosDefensa());
        assertEquals(0,jugadorOponente.cantidadCartasCementerio());
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

        monstruoAtaque.atacarMonstruo(monstruoDefensa);

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
        jugadorOponente.resetearInvocacionesPosibles();
        jugadorOponente.invocar(monstruo2);
        jugadorOponente.resetearInvocacionesPosibles();
        jugadorOponente.invocar(monstruo3);

        Fisura fisura = new Fisura();

        jugadorActivo.activarCarta(fisura);

        assertEquals(1, jugadorOponente.cantidadCartasCementerio());

        //Busca el monstruo3 en el cementerio el cual deberia estar por ser el monstruo con menor Ataque
        assertEquals(monstruo3, jugadorOponente.buscarCartaEnCementerio(monstruo3));

    }
    
}
