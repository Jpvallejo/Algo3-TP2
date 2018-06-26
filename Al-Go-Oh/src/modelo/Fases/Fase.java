package modelo.Fases;

public abstract class Fase {

    public Fase siguienteFase(){
        return null;
    };

    public void iniciarFase() {
    }

    public abstract String getNombre();
}
