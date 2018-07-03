package modelo.Estados;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modelo.Excepciones.NoDisponibleParaAtacarException;
import modelo.Monstruo;

public class EstadoDefensaBocaAbajo implements EstadoMonstruo,Estado{

    public void recibirDanio(Monstruo atacante, Monstruo defensor) {
        defensor.activarEfectoDeVolteo(atacante);
        defensor.setEstado(new EstadoDefensaBocaArriba());
        atacante.comparararConDefensa(defensor);
    }

    public ImageView obtenerImagen(Monstruo monstruo){
        Image img = new Image("vista/imagenes/cartaAtras.jpg",100,110,true,false);
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
