package modelo;

import vista.Botones.BotonCarta;
import vista.Botones.BotonCartaMagica;

public abstract class CartaMagica extends Carta{

    public CartaMagica(){
        super();
    }

    public BotonCarta crearBoton(){
        return new BotonCartaMagica(this);
    }
}
