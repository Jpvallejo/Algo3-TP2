package modelo.CartasMagicas;

import modelo.*;
import modelo.Excepciones.DetenerAtaqueException;

public class CilindroMagico extends CartaTrampa {

    @Override
    public void activarEfectoEnAtaque(Monstruo atacante, Monstruo defensor) {
        atacante.daniarJugador(atacante.getPuntosAtaque());
        this.destruir();
        throw new DetenerAtaqueException();

    }
}
