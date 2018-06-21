package modelo;

import modelo.Fases.FaseInicial;
import modelo.Fases.Fase;

public class Juego {
        private static Juego instancia = new Juego();

        public static Juego getJuego() {
            return instancia;
        }

        private Juego(){
            jugadorActivo = new Jugador();
            jugadorOponente = new Jugador();
            faseActual = new FaseInicial();
           /* for (int i = 0; i < 5; i++){
                jugadorActivo.extraerCartaDelMazo();
                jugadorOponente.extraerCartaDelMazo();
            }*/
        }

    private Jugador jugadorActivo;

    private Jugador jugadorOponente;

    private Fase faseActual;

    public static void reiniciarJuego() {
        instancia = new Juego();
    }

    public void cambiarTurno(){
        Jugador temp = this.jugadorActivo;
        this.jugadorActivo = this.jugadorOponente;
        this.jugadorOponente = temp;
        faseActual = new FaseInicial();
    }

    public Jugador getJugadorOponente()
    {
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
    }

    public void iniciarFase() {
        faseActual.iniciarFase();
    }
}
