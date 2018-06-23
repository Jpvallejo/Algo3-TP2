import modelo.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import modelo.CartasMonstruosEspeciales.InsectoComeHombres;
import modelo.CartasMonstruosEspeciales.JinzoNro7;
import modelo.Monstruos.MonstruoGenerico;
import org.junit.Test;


public class MonstruosEspecialesTest {

    @Test
    public void testColocarJinzoEnPosicionDeAtaqueAtacaALosPuntosDeVidaDelOponenteDirectamenteSinImportarElMonstruoDelLadoOponente(){

        Jugador atacante = new Jugador(); //Juego.getJuego().getJugadorActivo();
        Jugador defensor = new Jugador(); //Juego.getJuego().getJugadorOponente();
        Monstruo jinzoNro7 = new JinzoNro7(new EstadoAtaque());
        Monstruo monstruoDefensor = new MonstruoGenerico("test",1000,1000, 4);
        atacante.invocar(jinzoNro7);
        defensor.colocar(monstruoDefensor);

        jinzoNro7.atacarMonstruo(monstruoDefensor);

        assertEquals(0, atacante.cantidadCartasCementerio());
        assertEquals(0, defensor.cantidadCartasCementerio());
        assertEquals(8000, atacante.getPuntosDeVida());
        assertEquals(7500, defensor.getPuntosDeVida());

    }


    @Test
    public void testAlAtacarAlInsectoComeHombresBocaAbajoEnPosicionDeDefensaSeDestruyeElMonstruoAtacante(){

        Jugador atacante = new Jugador(); //Juego.getJuego().getJugadorActivo();
        Jugador defensor = new Jugador(); //Juego.getJuego().getJugadorOponente();
        Monstruo monstruoAtacante = new MonstruoGenerico("test",1000,1000, 4);
        Monstruo insectoComeHombres = new InsectoComeHombres();
        atacante.invocar(monstruoAtacante);
        defensor.colocar(insectoComeHombres);

        monstruoAtacante.atacarMonstruo(insectoComeHombres);

        // Supuesto: El Insecto Come Hombres en el juego original cuando lo atacan el efecto se activa luego del calculo de puntos, por lo cual, este se destruye tambien.
        assertEquals(1, atacante.cantidadCartasCementerio());
        assertEquals(1, defensor.cantidadCartasCementerio());
        assertEquals(8000, atacante.getPuntosDeVida());
        assertEquals(8000, defensor.getPuntosDeVida());

    }

    @Test
    public void testAlAtacarAlInsectoComeHombresBocaAbajoEnPosicionDeDefensaConAtaqueMenorQueLaDefensaSeCalculaElDanioALosPuntosDeVidaYSeDestruyeElMonstruoAtacante(){

        Jugador atacante = new Jugador(); //Juego.getJuego().getJugadorActivo();
        Jugador defensor = new Jugador(); //Juego.getJuego().getJugadorOponente();
        Monstruo monstruoAtacante = new MonstruoGenerico("test",100,1000, 4);
        Monstruo insectoComeHombres = new InsectoComeHombres();
        atacante.invocar(monstruoAtacante);
        defensor.colocar(insectoComeHombres);

        monstruoAtacante.atacarMonstruo(insectoComeHombres);

        assertEquals(1, atacante.cantidadCartasCementerio());
        assertEquals(0, defensor.cantidadCartasCementerio());
        assertEquals(7500, atacante.getPuntosDeVida());
        assertEquals(8000, defensor.getPuntosDeVida());

    }



}
