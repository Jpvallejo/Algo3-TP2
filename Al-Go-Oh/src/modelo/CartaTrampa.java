package modelo;

public abstract class CartaTrampa extends Carta {

    public CartaTrampa(){
        super();
        this.estado = Colocacion.BOCAABAJO;
    }
}
