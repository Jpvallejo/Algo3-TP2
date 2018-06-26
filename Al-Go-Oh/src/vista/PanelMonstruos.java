package vista;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import modelo.*;
import modelo.Estados.EstadoAtaque;
import vista.Botones.BotonCampoMonstruo;
import vista.Botones.BotonMonstruo;

import javax.swing.event.ChangeListener;
import java.util.ArrayList;

public class PanelMonstruos extends HBox {

    private ArrayList<BotonCampoMonstruo> monstruos;

    public PanelMonstruos(Jugador jugador) {
        monstruos = new ArrayList<BotonCampoMonstruo>();
        this.setVisible(true);
        for (int i = 0; i < 5; i++) {
            BotonCampoMonstruo monsterbutton = new BotonCampoMonstruo();
            monsterbutton.setPrefSize(80, 110);
            setSpacing(20);
            monstruos.add(monsterbutton);
            monsterbutton.setStyle("-fx-background-color: #808080");
            this.getChildren().add(monsterbutton);
        }
        actualizarPanel(jugador);
    }

    public void actualizarPanel(Jugador jugador){
        for (int i = 0; i < jugador.getZonaMonstruo().cantidadCartas(); i++) {
      
            monstruos.get(i).setMonstruo((Monstruo) jugador.getZonaMonstruo().obtenerCartaPosicion(i));
            /**************/
            monstruos.get(i).activarBoton();

            /******************/
            monstruos.get(i).setVisible(true);
            ImageView newImage;

            if(monstruos.get(i).getMonstruo().getEstado() instanceof EstadoAtaque){
                Image img = new Image(monstruos.get(i).getMonstruo().getUrlImagen(),100,110,true,false);
                newImage = new ImageView(img);
            }else{
                Image img = new Image("vista/imagenes/cartaAtras.jpg",100,110,true,false);
                newImage = new ImageView(img);
            }
            monstruos.get(i).setGraphic(newImage);
            monstruos.get(i).setPrefSize(62,91);
        }
    }


}
