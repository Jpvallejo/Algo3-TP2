package modelo.Estados;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modelo.Excepciones.NoDisponibleParaAtacarException;
import modelo.Monstruo;
import vista.ParametrosBoton;

public class EstadoDefensaBocaArriba implements Estado,EstadoMonstruo{

    public void recibirDanio(Monstruo atacante, Monstruo defensor) {
        atacante.comparararConDefensa(defensor);
    }

    public ImageView obtenerImagen(Monstruo monstruo){
        Image img = new Image(monstruo.getUrlImagen(),ParametrosBoton.ANCHOCARTA,ParametrosBoton.ALTOCARTA,true,false);
        ImageView imgvw = new ImageView(img);
        imgvw.setRotate(90);
        return imgvw;
    }

    public void verificarAtaque(){
        throw new NoDisponibleParaAtacarException();
    }

    @Override
    public void permitirAtaque() {}

}
