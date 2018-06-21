package modelo.CartasMonstruosEspeciales;

import modelo.*;

public class InsectoComeHombres extends Monstruo{


    public InsectoComeHombres(Posicion posicion){
        super();
        this.puntosAtaque = 450;
        this.puntosDefensa = 600;
        this.adicionalesDeAtaque = 0;
        this.adicionalesDeDefensa = 0;
        this.posicion = posicion;
        this.estrellas = 2;
    }


    public boolean noDefiendeEnDefensa(Monstruo monstruoAtacante){
        if ( estado == Colocacion.BOCAABAJO ) {
            return false;
        }
        else {
            int puntosDefensaDefensor = this.getPuntosDefensa();
            int puntosAtaqueAtacante = monstruoAtacante.getPuntosAtaque();
            return (puntosAtaqueAtacante > puntosDefensaDefensor);
        }
    }

    @Override
    public boolean activarEfectoEnAtaque(Jugador atacante, Jugador defensor, Monstruo monstruoAtacante) {
        monstruoAtacante.destruir();
        return false;
    }

}
