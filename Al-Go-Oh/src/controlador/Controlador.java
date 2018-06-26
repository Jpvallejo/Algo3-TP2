package controlador;

import modelo.*;
import vista.PantallaBatalla;

public class Controlador {
    private static Controlador instancia = new Controlador();

    private PantallaBatalla pantallaBatalla;

    public static Controlador getControlador() {
        return instancia;
    }

    public void terminarTurno() {
        Juego.getJuego().cambiarTurno();
        Juego.getJuego().iniciarFase();
    }

    public void pasarFase() {
        Juego.getJuego().avanzarFase();
        pantallaBatalla.actualizarPantalla();
    }

    public Jugador getJugadorActivo() {
        return Juego.getJuego().getJugadorActivo();
    }
    public Jugador getJugadorOponente() {
        return Juego.getJuego().getJugadorOponente();
    }

    public String obtenerFase() {
        return Juego.getJuego().getNombreFaseActual();
    }

    public void asociarPantalla(PantallaBatalla _pantallaBatalla){
        pantallaBatalla = _pantallaBatalla;
    }

    public void invocarMonstruo(Monstruo monstruo) {
        Juego.getJuego().getJugadorActivo().invocar(monstruo);
        Juego.getJuego().getJugadorActivo().quitarCartaDeMano(monstruo);
        pantallaBatalla.actualizarPantalla();
    }

    public void colocarMonstruo(Monstruo monstruo) {
        Juego.getJuego().getJugadorActivo().colocar(monstruo);
        Juego.getJuego().getJugadorActivo().quitarCartaDeMano(monstruo);
        pantallaBatalla.actualizarPantalla();
    }

    public void activarCartaMagica(CartaMagica carta) {
        Juego.getJuego().getJugadorActivo().activarCarta(carta);
        Juego.getJuego().getJugadorActivo().quitarCartaDeMano(carta);
        pantallaBatalla.actualizarPantalla();
    }

    public void colocarCartaMagica(CartaMagica carta) {
        Juego.getJuego().getJugadorActivo().colocarCarta(carta);
        Juego.getJuego().getJugadorActivo().quitarCartaDeMano(carta);
        pantallaBatalla.actualizarPantalla();
    }

    public void colocarCartaTrampa(CartaTrampa carta) {
        Juego.getJuego().getJugadorActivo().colocarCarta(carta);
        Juego.getJuego().getJugadorActivo().quitarCartaDeMano(carta);
        pantallaBatalla.actualizarPantalla();
    }

    public void reiniciarJuego() {
        Juego.reiniciarJuego();
        pantallaBatalla.reiniciarPantalla();
    }
}
