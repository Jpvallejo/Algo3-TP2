import junit.framework.TestCase;
import modelo.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import modelo.CartasMagicas.*;
import modelo.CartasMonstruosEspeciales.InsectoComeHombres;
import modelo.CartasMonstruosEspeciales.JinzoNro7;
import modelo.Casillero;
import modelo.Jugador;
import modelo.Monstruo;
import modelo.Posicion;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Entrega2Test {

    @Test
    public void test01SegundaEntrega(){
        /*Colocar un monstruo de cada lado del campo. Activo la carta mágica Wasteland y verificar que de un lado del campo, el ataque del monstruo aumenta en 200 puntos y del otro lado del campo, se aumenta la defensa del monstruo en 300 puntos.*/

  		Juego.reiniciarJuego();
        Wasteland wasteland = new Wasteland();

        Jugador jugadorActivo = Juego.getJuego().getJugadorActivo();
        Jugador jugadorOponente = Juego.getJuego().getJugadorOponente();
       
        jugadorActivo.colocarCarta(wasteland);
        
        Monstruo monstruoAtaque = new Monstruo("test",100,0,Posicion.ATAQUE,4);
        
        jugadorActivo.colocarEnAtaque(monstruoAtaque);
        
        Monstruo monstruoDefensa = new Monstruo("test",100,200,Posicion.ATAQUE,4);
        
        jugadorOponente.colocarEnAtaque(monstruoDefensa);

        jugadorActivo.activarCartaCampo(); //Suma 200 al ataque del monstruo del jugadorActivo osea tiene 300        
        jugadorActivo.declararAtaqueDePosicionAPosicion(jugadorOponente,Casillero.UNO,Casillero.UNO);
        
      
        assertEquals(1, jugadorOponente.cantidadCartasCementerio());
          //Le resta 200 puntos de vida al jugador defensor
        assertEquals(7800, jugadorOponente.getPuntosDeVida());

    }
    
    @Test
    public void test02SegundaEntrega(){
        /*Activar la carta mágica Olla de la codicia, y verificar que tomo 2 cartas del mazo.*/


        

    }
    
    @Test
    public void test03SegundaEntrega(){
        /*Colocar un monstruo de cada lado del campo. activo la carta mágica Sogen y verificar que de un lado del campo, la defensa del monstruo aumenta en 500 puntos y del otro lado del campo, se aumenta el ataque del monstruo en 200 puntos.*/

        Juego.reiniciarJuego();
        Sogen sogen = new Sogen();

        Jugador jugadorActivo = Juego.getJuego().getJugadorActivo();
        Jugador jugadorOponente = Juego.getJuego().getJugadorOponente();
       
        jugadorActivo.colocarCarta(sogen);
        
        Monstruo monstruoAtaque = new Monstruo("test",100,0,Posicion.ATAQUE,4);
        
        jugadorActivo.colocarEnAtaque(monstruoAtaque);
        
        Monstruo monstruoDefensa = new Monstruo("test",100,200,Posicion.ATAQUE,4);
        
        jugadorOponente.colocarEnAtaque(monstruoDefensa);

        jugadorActivo.activarCartaCampo(); //Suma 200 al ataque del monstruo del jugadorOponente osea tiene 300    
        
        jugadorActivo.declararAtaqueDePosicionAPosicion(jugadorOponente,Casillero.UNO,Casillero.UNO);

        assertEquals(1, jugadorActivo.cantidadCartasCementerio());
          //Le resta 200 puntos de vida al jugadorActivo
        assertEquals(7800, jugadorActivo.getPuntosDeVida());
    

    }
    
    @Test
    public void test04SegundaEntrega(){
        /*Colocar 2 monstruos en el campo enemigo, con diferente ataque. Activo la carta mágica Fisura, y verificar que el de menor ataque es destruido.*/

    }
    
    @Test
    public void test05SegundaEntrega(){
        /*Colocar un monstruo en el campo enemigo. invoco a Jinzo #7 en mi lado del campo. Verificar que puedo atacar a los puntos de vida directamente.*/

        Jugador atacante = new Jugador(); //Juego.getJuego().getJugadorActivo();
        Jugador defensor = new Jugador(); //Juego.getJuego().getJugadorOponente();
        Monstruo jinzoNro7 = new JinzoNro7(Posicion.ATAQUE);
        Monstruo monstruoDefensor = new Monstruo("test",1000,1000, Posicion.DEFENSA,4);
        atacante.colocarEnAtaque(jinzoNro7);
        defensor.colocarEnDefensa(monstruoDefensor);

        atacante.declararAtaqueDePosicionAPosicion(defensor,Casillero.UNO,Casillero.UNO);

        assertEquals(0, atacante.cantidadCartasCementerio());
        assertEquals(0, defensor.cantidadCartasCementerio());
        assertEquals(8000, atacante.getPuntosDeVida());
        assertEquals(7500, defensor.getPuntosDeVida());

    }
    
    @Test
    public void test06SegundaEntrega(){
        /*Invocar 3 dragones blancos de ojos azules, al Dragón definitivo de ojos azules sacrificando los 3 dragones el lado del campo del jugador que los invocó.*/

    }
    
    @Test
    public void test07SegundaEntrega(){
        /*Colocar al Insecto come-hombres, en posición de defensa boca abajo. Invocar un monstruo enemigo y atacar al insecto. activo el efecto de volteo, señalando al atacante como objetivo, verificar que este se destruye, y que mi monstruo sigue en el campo. Verificar que nadie sufre daño a los puntos de vida.*/

        Jugador atacante = new Jugador(); //Juego.getJuego().getJugadorActivo();
        Jugador defensor = new Jugador(); //Juego.getJuego().getJugadorOponente();
        Monstruo monstruoAtacante = new Monstruo("test",1000,1000, Posicion.DEFENSA,4);
        Monstruo insectoComeHombres = new InsectoComeHombres(Posicion.DEFENSA);
        atacante.colocarEnAtaque(monstruoAtacante);
        defensor.colocarEnDefensa(insectoComeHombres);

        atacante.declararAtaqueDePosicionAPosicion(defensor,Casillero.UNO,Casillero.UNO);

        assertEquals(1, atacante.cantidadCartasCementerio());
        assertEquals(0, defensor.cantidadCartasCementerio());
        assertEquals(8000, atacante.getPuntosDeVida());
        assertEquals(8000, defensor.getPuntosDeVida());
        
    }
    
    @Test
    public void test08SegundaEntrega(){
        /*Colocar un monstruo del lado enemigo, luego coloco la carta trampa Cilindro mágico de mi lado del campo. Atacar con el monstruo y verificar que se activa la carta trampa, se niega el ataque y el oponente recibe el daño directamente en sus puntos de vida.*/

        Jugador atacante = new Jugador(); //Juego.getJuego().getJugadorActivo();
        Jugador defensor = new Jugador(); //Juego.getJuego().getJugadorOponente();
        Monstruo monstruoAtacante = new Monstruo("test",2000,1000, Posicion.ATAQUE,4);
        Monstruo monstruoDefensor = new Monstruo("test",1000,1000, Posicion.DEFENSA,4);
        atacante.colocarEnAtaque(monstruoAtacante);
        defensor.colocarEnDefensa(monstruoDefensor);

        CartaTrampa carta = new CilindroMagico();
        defensor.colocarCarta(carta);

        atacante.declararAtaqueDePosicionAPosicion(defensor,Casillero.UNO,Casillero.UNO);

        assertEquals(0, atacante.cantidadCartasCementerio());
        assertEquals(1, defensor.cantidadCartasCementerio());
        assertEquals(6000, atacante.getPuntosDeVida());
        assertEquals(8000, defensor.getPuntosDeVida());
    }
    
    @Test
    public void test09SegundaEntrega(){
        /*Coloco un monstruo en posición de ataque y la carta trampa Reinforcements de mi lado del campo, coloco un monstruo en el campo enemigo (con 400 puntos mas de ataque que el primero) y atacar al primer monstruo. Verificar que se activa la carta trampa, y el monstruo enemigo es destruido y se infligió 100 puntos de daño a la vida del otro jugador.*/


        Jugador atacante = new Jugador(); //Juego.getJuego().getJugadorActivo();
        Jugador defensor = new Jugador(); //Juego.getJuego().getJugadorOponente();
        Monstruo monstruoAtacante = new Monstruo("test",1500,1000, Posicion.ATAQUE,4);
        Monstruo monstruoDefensor = new Monstruo("test",1200,1000, Posicion.ATAQUE,4);
        atacante.colocarEnAtaque(monstruoAtacante);
        defensor.colocarEnAtaque(monstruoDefensor);


        CartaTrampa carta = new Reinforcement();
        defensor.colocarCarta(carta);

        assertEquals(1200, defensor.obtenerCampo().obtenerMonstruoEnCasillero(Casillero.UNO).getPuntosAtaque());

        atacante.declararAtaqueDePosicionAPosicion(defensor,Casillero.UNO,Casillero.UNO);

        assertEquals(1, atacante.cantidadCartasCementerio());
        assertEquals(1, defensor.cantidadCartasCementerio());
        assertEquals(7800, atacante.getPuntosDeVida());
        assertEquals(8000, defensor.getPuntosDeVida());

    }
    
    @Test
    public void test10SegundaEntrega(){
        /*Extraer todas las cartas del mazo, y verificar que la partida terminó y el jugador perdió.*/
        Juego juego = Juego.getJuego();
        for (int i = 0; i<40; i++) {
            juego.getJugadorActivo().extraerCartaDelMazo();
        }
        assertTrue(juego.hayGanador());
        assertTrue(juego.obtenerGanador() == juego.getJugadorOponente());

    }
    
    @Test
    public void test11SegundaEntrega(){
        /*Colocar las 5 partes de exodia en la mano de un jugador, verificar que la partida termina y que ese jugador resultó ganador.*/

    }

}
