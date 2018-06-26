package modelo.Fases;

public class FasePreparacion extends Fase {

    public Fase siguienteFase(){
        return new FaseAtaque();
    }

    @Override
    public String getNombre() {
        return "Fase Preparacion";
    }
}
