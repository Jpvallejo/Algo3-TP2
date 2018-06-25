package modelo.Fases;

import modelo.Juego;

public class FaseFinal extends Fase {

    public Fase siguienteFase(){
        Juego.getJuego().cambiarTurno();
        return new FaseInicial();
    }

    public void iniciarFase() {
    }


}
