package modelo.CartasMagicas;

import modelo.CartaTrampa;
import modelo.Jugador;
import modelo.Monstruo;

public class Reinforcement extends CartaTrampa {

    @Override
    public void activarEfecto() {

    }

    @Override
    public boolean activarEfectoEnAtaque(Jugador atacante, Jugador defensor, Monstruo monstruoAtacante, Monstruo monstruoDefensor) {
        monstruoAtacante.sumarAdicionalAlataque(-500);
        this.destruir();
        return false;

    }
}
