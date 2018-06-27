package modelo.Monstruos;

import modelo.Carta;
import modelo.Monstruo;

public class CabezaExodia extends Monstruo {

    public CabezaExodia() {
        super();
        this.puntosAtaque = 1000;
        this.puntosDefensa = 1000;
        this.estrellas = 3;
        this.nombre = "Exodia, el Prohibido";
    }

    // Dado que solo puede haber un Exodia en el juego, se puede asumir este Equals
    @Override
    public boolean equals(Object carta){
        return this.nombre == ((Carta)carta).getNombre();
    }
}
