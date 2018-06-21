package modelo.CartasMagicas;

import modelo.Ataque;
import modelo.CartaTrampa;
import modelo.Jugador;
import modelo.Monstruo;

public class Reinforcement extends CartaTrampa {

    @Override
    public void activarEfecto() {

    }

    @Override
    public boolean activarEfectoEnAtaque(Ataque ataque) {
        ataque.getMonstruoDefensor().sumarAdicionalAlataque(500);
        this.destruir();
        return false;

    }
}
