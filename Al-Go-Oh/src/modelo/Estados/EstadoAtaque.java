package modelo.Estados;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modelo.Excepciones.NoDisponibleParaAtacarException;
import modelo.Monstruo;

public class EstadoAtaque implements EstadoMonstruo, Estado {

    private boolean ataqueDisponible = true;

    public void recibirDanio(Monstruo atacante, Monstruo defensor) {
        atacante.comparararConAtaque(defensor);
    }

    public ImageView obtenerImagen(Monstruo monstruo){
        Image img = new Image(monstruo.getUrlImagen(),100,110,true,false);
        return new ImageView(img);
    }

    public void verificarAtaque(){
        if(ataqueDisponible) {
            this.usarAtaque();
        }
        else{
            throw new NoDisponibleParaAtacarException();
        }
    }

    public void usarAtaque(){
        ataqueDisponible = false;
    }

    public void permitirAtaque(){
        ataqueDisponible = true;
    }
}
