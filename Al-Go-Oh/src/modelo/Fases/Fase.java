package modelo.Fases;

import vista.PantallaBatalla;

public abstract class Fase {

    public Fase siguienteFase(){
        return null;
    };

    public void iniciarFase() {
    }

    public abstract String getNombre();

    //public abstract void activarHandles();

    public void activarHandles(PantallaBatalla pantallaBatalla){};
}
