package modelo.Fases;

import modelo.Juego;

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
    
    
}
