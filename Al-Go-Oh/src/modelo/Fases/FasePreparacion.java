package modelo.Fases;

import vista.PantallaBatalla;

public class FasePreparacion implements Fase {

    public Fase siguienteFase(){
        return new FaseAtaque();
    }

    public void iniciarFase() {

    }

    public String getNombre() {
        return "Fase Preparacion";
    }


    public void activarHandles(PantallaBatalla pantallaBatalla){
        pantallaBatalla.activarPanelesFasePreparacion();
    }
}
