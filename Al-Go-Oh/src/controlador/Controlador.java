package controlador;

import modelo.Juego;
import modelo.Jugador;
import modelo.Monstruo;
import vista.PantallaBatalla;

public class Controlador {
    private static Controlador instancia = new Controlador();

    private PantallaBatalla pantallaBatalla;

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

    public void asociarPantalla(PantallaBatalla _pantallaBatalla){
        pantallaBatalla = _pantallaBatalla;
    }

    public void invocarMonstruo(Monstruo monstruo) {
        Juego.getJuego().getJugadorActivo().invocar(monstruo);
        Juego.getJuego().getJugadorActivo().quitarCartaDeMano(monstruo);
        pantallaBatalla.actualizarTodo();
    }

    public void colocarMonstruo(Monstruo monstruo) {
        Juego.getJuego().getJugadorActivo().colocar(monstruo);
        Juego.getJuego().getJugadorActivo().quitarCartaDeMano(monstruo);
        pantallaBatalla.actualizarTodo();
    }
}
