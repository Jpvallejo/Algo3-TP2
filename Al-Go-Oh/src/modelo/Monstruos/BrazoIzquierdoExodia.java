package modelo.Monstruos;

import modelo.Carta;
import modelo.Monstruo;

public class BrazoIzquierdoExodia extends Monstruo {

    public BrazoIzquierdoExodia(){
        super();
        this.puntosAtaque = 200;
        this.puntosDefensa = 200;
        this.estrellas = 1;
        this.nombre = "Brazo Izquierdo Exodia";
    }

    // Dado que solo puede haber un Exodia en el juego, se puede asumir este Equals
    @Override
    public boolean equals(Object carta){
        return this.nombre == ((Carta)carta).getNombre();
    }
}
