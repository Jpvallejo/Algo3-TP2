package modelo.Fases;

import modelo.Juego;
import vista.PantallaBatalla;

public class FaseAtaque implements Fase {

    @Override
    public Fase siguienteFase(){
        Juego.getJuego().revertirCartasDeCampo();
        return new FaseFinal();
    }
    
    public void iniciarFase() {
        Juego.getJuego().activarCartasDeCampo();
        Juego.getJuego().resetearAtaquesJugadorActivo();
    }

    @Override
    public String getNombre() {
        return "Fase Ataque";
    }

    public void activarHandles(PantallaBatalla pantallaBatalla){
        pantallaBatalla.activarPanelesFaseAtque();
    }
}
