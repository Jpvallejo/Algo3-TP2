package modelo.CartasMagicas;

import modelo.*;
import modelo.Excepciones.DetenerAtaqueException;

public class CilindroMagico extends CartaTrampa {

    public CilindroMagico(){
        nombre = "Cilindro Magico";
        descripcion = "Efecto: niega el ataque del monstruo atacante, e inflige el mismo daño directamente a los " +
                "puntos de vida del oponente";
    }

    @Override
    public void activarEfectoEnAtaque(Monstruo atacante, Monstruo defensor) {
        atacante.daniarJugador(atacante.getPuntosAtaque());
        this.destruir();
        throw new DetenerAtaqueException();

    }
}
