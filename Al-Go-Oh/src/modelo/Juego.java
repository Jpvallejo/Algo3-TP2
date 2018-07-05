package modelo;

import modelo.CartasMonstruosEspeciales.*;
import modelo.Fases.FaseInicial;
import modelo.Fases.Fase;
import modelo.Fases.FasePrimerTurno;

import java.util.ArrayList;

public class Juego {

    private static Juego instancia = new Juego();
    private ArrayList<Carta> exodia;

    public static Juego getJuego() {
        return instancia;
    }

    private Juego() {
        jugadorActivo = new Jugador("Jugador 1");
        jugadorOponente = new Jugador("Jugador 2");
        //faseActual = new FaseInicial();
        faseActual = new FasePrimerTurno();
        for (int i = 0; i < 5; i++){
            jugadorActivo.extraerCartaDelMazo();
            jugadorOponente.extraerCartaDelMazo();
        }
        exodia = new ArrayList<Carta>();
        exodia.add(new CabezaExodia());
        exodia.add(new PiernaDerechaExodia());
        exodia.add(new PiernaIzquierdaExodia());
        exodia.add(new BrazoDerechoExodia());
        exodia.add(new BrazoIzquierdoExodia());
        /*** Pruebas: Borrar luego ***/
        //jugadorActivo.getMano().quitarCarta(jugadorActivo.getMano().getCartas().get(1));
        //jugadorActivo.invocar(new AsechadorDelCraneo());
        //jugadorActivo.colocar(new AsechadorDelCraneo());
        //jugadorActivo.invocar(new AsechadorDelCraneo());
    }

    private Jugador jugadorActivo;

    private Jugador jugadorOponente;

    private Fase faseActual;

    public static void reiniciarJuego() {
        instancia = new Juego();
    }

    public void cambiarTurno() {
        this.revertirCartasDeCampo();
        this.jugadorActivo.resetearInvocacionesPosibles();
        Jugador temp = this.jugadorActivo;
        this.jugadorActivo = this.jugadorOponente;
        this.jugadorOponente = temp;
        faseActual = new FaseInicial();
    }

    public Jugador getJugadorOponente() {
        return jugadorOponente;
    }

    public Jugador getJugadorActivo() {
        return jugadorActivo;
    }

    public Fase obtenerFase() {
        return faseActual;
    }

    public void avanzarFase() {
        faseActual = faseActual.siguienteFase();
        faseActual.iniciarFase();
    }

    public void iniciarFase() {
        faseActual.iniciarFase();
    }

    public boolean hayGanador() {
        if (this.jugadorActivo.obtenerTamanioMazo() == 0 || this.jugadorActivo.getPuntosDeVida() <= 0 ||
                this.jugadorOponente.getPuntosDeVida() <= 0 || this.jugadorOponente.obtenerTamanioMazo() == 0
                || this.jugadorActivo.contieneExodia() || this.jugadorOponente.contieneExodia())
            return true;

        return false;

    }

    public Jugador obtenerGanador() {
        if (this.jugadorActivo.obtenerTamanioMazo() == 0 || this.jugadorActivo.getPuntosDeVida() <= 0 || this.jugadorOponente.contieneExodia())
            return this.jugadorOponente;
        else if (this.jugadorOponente.getPuntosDeVida() <= 0 || this.jugadorOponente.obtenerTamanioMazo() == 0 || this.jugadorActivo.contieneExodia())
            return this.jugadorActivo;
        return null;
    }

    public ArrayList<Carta> getExodia() {
        return this.exodia;
    }

    public String getNombreFaseActual() {
        return faseActual.getNombre();
    }

    public void activarCartasDeCampo() {
        jugadorActivo.activarCartaCampo();
        jugadorOponente.activarCartaCampo();
    }

    public void revertirCartasDeCampo() {
        jugadorActivo.revertirCartaCampo();
        jugadorOponente.revertirCartaCampo();
    }

    public void resetearAtaquesJugadorActivo() {
        jugadorActivo.resetearAtaques();
    }
}
