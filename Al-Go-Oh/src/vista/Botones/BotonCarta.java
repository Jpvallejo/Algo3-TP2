package vista.Botones;
import javafx.scene.control.Button;
import modelo.Carta;
import modelo.CartaMagica;

public abstract class BotonCarta extends Button {

    public BotonCarta(String nombre){
        super(nombre);
    }

    public BotonCarta(){
        super();
    }

    public void activarHandleManoFasePreparacion() {
    }

    public abstract void setCarta(Carta cartaCasillero);

    public void activarBotonHechizo(){};

    public void activarHandlerManoFasePreparacion(){}

    //public void activarHandlerCampoFasePreparacion(){}

    public void activarHandleCampoFasePreparacion(){}
}
