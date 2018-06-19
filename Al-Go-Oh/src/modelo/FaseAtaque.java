package modelo;

public class FaseAtaque extends Fase {

    public Fase siguienteFase(){
        return new FaseFinal();
    }
}
