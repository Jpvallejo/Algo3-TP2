package modelo;

public abstract class Carta{
    protected Colocacion estado;
    protected String tipo;
    protected String nombre;

    public Carta(){
        estado = Colocacion.BOCAARRIBA;
    }

    public abstract void activarEfecto();

    public boolean estaBocaAbajo(){
        return estado == Colocacion.BOCAABAJO;
    }

    public String getNombre(){
        return this.nombre;
    };

    public Colocacion getEstado(){
        return estado;
    };
}