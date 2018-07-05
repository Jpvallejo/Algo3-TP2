package modelo.Fases;

import modelo.Juego;
import vista.PantallaBatalla;

public class FasePrimerTurno implements Fase{


    public Fase siguienteFase(){
        Juego.getJuego().cambiarTurno();
        return new FaseInicial();
    }

    public void iniciarFase() {

    }

    public String getNombre() {
        return "Fase Preparacion";
    }


    public void activarHandles(PantallaBatalla pantallaBatalla){
        pantallaBatalla.activarPanelesFasePreparacion();
    }
}
