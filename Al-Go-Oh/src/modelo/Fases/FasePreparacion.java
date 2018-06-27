package modelo.Fases;

import vista.PantallaBatalla;

public class FasePreparacion extends Fase {

    public Fase siguienteFase(){
        return new FaseAtaque();
    }

    @Override
    public String getNombre() {
        return "Fase Preparacion";
    }


    public void activarHandles(PantallaBatalla pantallaBatalla){
        pantallaBatalla.activarPanelesFasePreparacion();
    }
}
