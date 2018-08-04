package modelo.CartasMonstruosEspeciales;

import modelo.Carta;
import modelo.Monstruo;

public class PiernaDerechaExodia extends Monstruo {

    public PiernaDerechaExodia(){
        super();
        this.puntosAtaque = 200;
        this.puntosDefensa = 200;
        this.estrellas = 1;
        this.nombre = "Pierna Derecha Exodia";
        this.descripcion = "Efecto: al tener las 5 partes juntas en la mano automáticamente se gana la partida.";
    }

    // Dado que solo puede haber un Exodia en el juego, se puede asumir este Equals
    @Override
    public boolean equals(Object carta){
        return this.nombre == ((Carta)carta).getNombre();
    }
}
