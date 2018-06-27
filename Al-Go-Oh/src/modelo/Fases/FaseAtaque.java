package modelo.Fases;

import modelo.Juego;
import vista.PantallaBatalla;

public class FaseAtaque extends Fase {

    @Override
    public Fase siguienteFase(){
        Juego.getJuego().getJugadorActivo().revertirCartaCampo();
        Juego.getJuego().getJugadorOponente().revertirCartaCampo();
        return new FaseFinal();
    }
    
    public void iniciarFase() {
        Juego.getJuego().getJugadorActivo().activarCartaCampo();
        Juego.getJuego().getJugadorOponente().activarCartaCampo();
    }

    @Override
    public String getNombre() {
        return "Fase Ataque";
    }

    public void activarHandles(PantallaBatalla pantallaBatalla){
        pantallaBatalla.activarPanelesFaseAtque();
    }
}
