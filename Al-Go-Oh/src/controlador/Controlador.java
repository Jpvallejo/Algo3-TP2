package controlador;

import modelo.Juego;
import modelo.Jugador;

public class Controlador {
    private static Controlador instancia = new Controlador();

    public static Controlador getControlador() {
        return instancia;
    }

    public void terminarTurno() {
        Juego.getJuego().cambiarTurno();
    }

    public void pasarFase() {
        Juego.getJuego().avanzarFase();
    }

    public Jugador getJugadorActivo() {
        return Juego.getJuego().getJugadorActivo();
    }
    public Jugador getJugadorOponente() {
        return Juego.getJuego().getJugadorOponente();
    }

    public String obtenerFase() {
        return Juego.getJuego().obtenerFase().toString();
    }
}
