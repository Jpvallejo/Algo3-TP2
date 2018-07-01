package modelo.CartasMonstruosEspeciales;

import modelo.Carta;
import modelo.Monstruo;

public class CabezaExodia extends Monstruo {

    public CabezaExodia() {
        super();
        this.puntosAtaque = 1000;
        this.puntosDefensa = 1000;
        this.estrellas = 3;
        this.nombre = "Exodia, el Prohibido";
        this.descripcion = "al tener las 5 partes juntas en la mano automáticamente se gana la partida.";
    }

    // Dado que solo puede haber un Exodia en el juego, se puede asumir este Equals
    @Override
    public boolean equals(Object carta){
        return this.nombre == ((Carta)carta).getNombre();
    }
}
