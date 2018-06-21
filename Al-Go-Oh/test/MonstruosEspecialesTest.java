import modelo.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import modelo.CartasMonstruosEspeciales.InsectoComeHombres;
import modelo.CartasMonstruosEspeciales.JinzoNro7;
import org.junit.Test;


public class MonstruosEspecialesTest {

    @Test
    public void testColocarJinzoEnPosicionDeAtaqueAtacaALosPuntosDeVidaDelOponenteDirectamenteSinImportarElMonstruoDelLadoOponente(){

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
    public void testAlAtacarAlInsectoComeHombresBocaAbajoEnPosicionDeDefensaSeDestruyeElMonstruoAtacante(){

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
    public void testAlAtacarAlInsectoComeHombresBocaAbajoEnPosicionDeDefensaConAtaqueMenorQueLaDefensaSeCalculaElDanioALosPuntosDeVidaYSeDestruyeElMonstruoAtacante(){

        Jugador atacante = new Jugador(); //Juego.getJuego().getJugadorActivo();
        Jugador defensor = new Jugador(); //Juego.getJuego().getJugadorOponente();
        Monstruo monstruoAtacante = new Monstruo(100,1000, Posicion.DEFENSA,4);
        Monstruo insectoComeHombres = new InsectoComeHombres(Posicion.DEFENSA);
        atacante.colocarEnAtaque(monstruoAtacante);
        defensor.colocarEnDefensa(insectoComeHombres);

        atacante.declararAtaqueDePosicionAPosicion(defensor,Casillero.UNO,Casillero.UNO);

        assertEquals(1, atacante.cantidadCartasCementerio());
        assertEquals(0, defensor.cantidadCartasCementerio());
        assertEquals(7500, atacante.getPuntosDeVida());
        assertEquals(8000, defensor.getPuntosDeVida());

    }



}
