package modelo;

import vista.Botones.BotonCarta;
import vista.Botones.BotonCartaTrampa;

public abstract class CartaTrampa extends Carta {

    public CartaTrampa(){
        super();
    }

    public BotonCarta crearBoton(){
        return new BotonCartaTrampa(this);
    }

    //public abstract boolean activarEfectoEnAtaque()

}
