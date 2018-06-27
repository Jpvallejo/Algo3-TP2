package controlador;

import modelo.*;
import modelo.Estados.Estado;
import modelo.Estados.EstadoAtaque;
import modelo.Fases.Fase;
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

    public String obtenerNombreFase() {
        return Juego.getJuego().getNombreFaseActual();
    }

    public Fase obtenerFase() {
        return Juego.getJuego().obtenerFase();
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

    public void activarCartaMagicaDesdeMano(CartaMagica carta) {
        Juego.getJuego().getJugadorActivo().activarCarta(carta);
        Juego.getJuego().getJugadorActivo().quitarCartaDeMano(carta);
        pantallaBatalla.actualizarPantalla();
    }

    public void activarCartaMagica(CartaMagica carta) {
        carta.activarEfecto();
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

    public void atacarMonstruo(Monstruo atacante, Monstruo defensor) {
        atacante.atacarMonstruo(defensor);
        pantallaBatalla.actualizarPantalla();
    }

    public void cambiarEstado(Monstruo monstruo, Estado estado) {
        monstruo.setEstado(estado);
        pantallaBatalla.actualizarPantalla();
    }


}
