package modelo.CartasMagicas;

import modelo.*;

public class CilindroMagico extends CartaTrampa {

    @Override
    public void activarEfecto() {

    }

    @Override
    public boolean activarEfectoEnAtaque(Jugador atacante, Jugador defensor, Monstruo monstruoAtacante) {
        atacante.restarPuntosDeVida(monstruoAtacante.getPuntosAtaque());
        this.destruir();
        return true;

    }
}
