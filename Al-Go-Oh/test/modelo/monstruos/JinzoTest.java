package modelo.monstruos;

import modelo.CartasMonstruosEspeciales.JinzoNro7;
import modelo.Estados.EstadoAtaque;
import modelo.Juego;
import modelo.Jugador;
import modelo.Monstruo;
import modelo.Monstruos.MonstruoGenerico;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JinzoTest {


    @Test
    public void testColocarJinzoEnPosicionDeAtaqueAtacaALosPuntosDeVidaDelOponenteDirectamenteSinImportarElMonstruoDelLadoOponente(){

        Juego.reiniciarJuego();
        Juego.getJuego().avanzarFase(); //avanza a fase de Preparacion
        Jugador atacante = new Jugador(); //Juego.getJuego().getJugadorActivo();
        Jugador defensor = new Jugador(); //Juego.getJuego().getJugadorOponente();
        Monstruo jinzoNro7 = new JinzoNro7(new EstadoAtaque());
        Monstruo monstruoDefensor = new MonstruoGenerico("test",1000,1000, 4);
        atacante.invocar(jinzoNro7);
        defensor.colocar(monstruoDefensor);

        Juego.getJuego().avanzarFase(); //avanza a fase de Ataque
        jinzoNro7.atacarMonstruo(monstruoDefensor);

        assertEquals(0, atacante.cantidadCartasCementerio());
        assertEquals(0, defensor.cantidadCartasCementerio());
        assertEquals(8000, atacante.getPuntosDeVida());
        assertEquals(7500, defensor.getPuntosDeVida());

    }
}
