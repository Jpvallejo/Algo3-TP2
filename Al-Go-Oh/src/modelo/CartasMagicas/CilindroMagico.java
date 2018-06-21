package modelo.CartasMagicas;

import modelo.*;

public class CilindroMagico extends CartaTrampa {

    @Override
    public void activarEfecto() {

    }

    @Override
    public boolean activarEfectoEnAtaque(Ataque ataque) {
        ataque.getJugadorAtacante().restarPuntosDeVida(ataque.getMonstruoAtacante().getPuntosAtaque());
        this.destruir();
        return true;

    }
}
