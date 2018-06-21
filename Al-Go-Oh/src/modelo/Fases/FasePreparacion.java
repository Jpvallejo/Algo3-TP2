package modelo.Fases;

public class FasePreparacion extends Fase {

    public Fase siguienteFase(){
        return new FaseAtaque();
    }

}
