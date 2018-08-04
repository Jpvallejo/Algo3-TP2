package modelo.Fases;

import modelo.Juego;
import vista.PantallaBatalla;

public class FaseInicial implements Fase {

    public Fase siguienteFase(){
        return new FasePreparacion();
    }

    public void iniciarFase() {
        Juego.getJuego().getJugadorActivo().extraerCartaDelMazo();
        Juego.getJuego().avanzarFase();
    }

    public String getNombre() {
        return "Fase Inicial";
    }

    public void activarHandles(PantallaBatalla pantallaBatalla) {

    }
}
