package controlador;

import javafx.scene.control.Alert;
import modelo.*;
import modelo.Estados.Estado;
import modelo.Estados.EstadoAtaque;
import modelo.Excepciones.InvocacionNoPosibleException;
import modelo.Excepciones.RequiereSacrificioEspecialException;
import modelo.Excepciones.RequiereSacrificioException;
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
        try {
            Juego.getJuego().getJugadorActivo().invocar(monstruo);
            Juego.getJuego().getJugadorActivo().quitarCartaDeMano(monstruo);
            pantallaBatalla.actualizarPantalla();
        }
        catch(RequiereSacrificioException e){
            try {
                Juego.getJuego().getJugadorActivo().resetearInvocacionesPosibles();
                Sacrificios sacrificios = new Sacrificios();
                pantallaBatalla.abrirPanelSacrificios(monstruo, sacrificios);
                Juego.getJuego().getJugadorActivo().invocar(monstruo, sacrificios);
                Juego.getJuego().getJugadorActivo().quitarCartaDeMano(monstruo);
                pantallaBatalla.actualizarPantalla();
            }
            catch (RequiereSacrificioException e2){
                Juego.getJuego().getJugadorActivo().resetearInvocacionesPosibles();
                this.informar("Invocacion no Permitida", "El monstruo seleccionado requiere mas sacrificos");
            }
            catch (RequiereSacrificioEspecialException e2){
                Juego.getJuego().getJugadorActivo().resetearInvocacionesPosibles();
                this.informar("Invocacion no Permitida", "El monstruo seleccionado requiere un sacrificio especial");
            }
        }
        catch(InvocacionNoPosibleException i){
            this.informar("Invocacion no Permitida", "No es posible invocar mas monstruos");
        }

    }

    public void colocarMonstruo(Monstruo monstruo) {
        try {
            Juego.getJuego().getJugadorActivo().colocar(monstruo);
            Juego.getJuego().getJugadorActivo().quitarCartaDeMano(monstruo);
            pantallaBatalla.actualizarPantalla();
        }
        catch(RequiereSacrificioException e){
            try {
                Juego.getJuego().getJugadorActivo().resetearInvocacionesPosibles();
                Sacrificios sacrificios = new Sacrificios();
                pantallaBatalla.abrirPanelSacrificios(monstruo, sacrificios);
                Juego.getJuego().getJugadorActivo().colocar(monstruo, sacrificios);
                Juego.getJuego().getJugadorActivo().quitarCartaDeMano(monstruo);
                pantallaBatalla.actualizarPantalla();
            }
            catch (RequiereSacrificioException e2){
                Juego.getJuego().getJugadorActivo().resetearInvocacionesPosibles();
                this.informar("Invocacion no Permitida", "El monstruo seleccionado requiere mas sacrificos");
            }
            catch (RequiereSacrificioEspecialException e2){
                Juego.getJuego().getJugadorActivo().resetearInvocacionesPosibles();
                this.informar("Invocacion no Permitida", "El monstruo seleccionado requiere un sacrificio especial");
            }
        }
        catch(InvocacionNoPosibleException i){
            this.informar("Invocacion no Permitida", "No es posible invocar mas monstruos");
        }

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


    public void atacarPuntosDeVida(Monstruo atacante) {
        atacante.atacar(this.getJugadorOponente());
        pantallaBatalla.actualizarPantalla();
    }

    public void verificarGanador() {
        if(Juego.getJuego().hayGanador()){
            pantallaBatalla.mostrarPantallaGanador();
        }
    }

    public String obtenerNombreGanador() {
        return Juego.getJuego().obtenerGanador().obtenerNombre();
    }

    public void activarCartaCampoDesdeMano(CartaCampo carta) {
        Juego.getJuego().getJugadorActivo().colocarCarta(carta);
        Juego.getJuego().getJugadorActivo().quitarCartaDeMano(carta);
        pantallaBatalla.actualizarPantalla();
    }


    public void informar(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);

        alert.showAndWait();
    }
}
