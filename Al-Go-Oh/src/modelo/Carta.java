package modelo;

public abstract class Carta{
    protected Colocacion estado;
    protected String tipo;

    public Carta(){
        estado = Colocacion.BOCAARRIBA;
    }

    public abstract void activarEfecto();

    public boolean estaBocaAbajo(){
        return estado == Colocacion.BOCAABAJO;
    }
}