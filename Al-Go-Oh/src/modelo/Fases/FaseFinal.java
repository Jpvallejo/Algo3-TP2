package modelo.Fases;

import modelo.Juego;
import vista.PantallaBatalla;

public class FaseFinal extends Fase {

    public Fase siguienteFase(){
        Juego.getJuego().cambiarTurno();
        return new FaseInicial();
    }

    public void iniciarFase() {
    }

    @Override
    public String getNombre() {
        return "Fase Final";
    }


    public void activarHandles(PantallaBatalla pantallaBatalla){
        pantallaBatalla.activarPanelesFaseFinal();
    }
}
