package vista.Botones;

import modelo.Monstruo;


public class BotonMonstruo extends BotonCarta {
    private Monstruo monstruo;

    public Monstruo getMonstruo() {
        return monstruo;
    }

    private void setMonstruo(Monstruo monstruo) {
        this.monstruo = monstruo;
    }

    public BotonMonstruo() {
        this.setVisible(true);
    }
    public BotonMonstruo(Monstruo monstruo){
        this.setMonstruo(monstruo);
        this.setVisible(true);

    }
    public BotonMonstruo(String nombre){

        super(nombre);
    }
}
