package modelo;

public abstract class CartaMagica extends Carta{

    public CartaMagica(){
        super();
    }
    protected Colocacion colocacion;

    public Colocacion getColocacion(){
        return colocacion;
    };



}
