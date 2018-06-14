package modelo;

public abstract class CartaMagica extends Carta{

    protected Colocacion colocacion;

    public Colocacion getColocacion(){
        return colocacion;
    };

    public abstract void activarEfecto();

}
