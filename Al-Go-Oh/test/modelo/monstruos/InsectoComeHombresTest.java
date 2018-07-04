package modelo.monstruos;

import modelo.CartasMonstruosEspeciales.InsectoComeHombres;
import modelo.Jugador;
import modelo.Monstruo;
import modelo.Monstruos.MonstruoGenerico;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InsectoComeHombresTest {

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
