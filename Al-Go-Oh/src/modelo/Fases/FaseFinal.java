package modelo.Fases;

import modelo.Juego;

public class FaseFinal extends Fase {

    public void iniciarFase() {
        Juego.getJuego().cambiarTurno();
    }


}
