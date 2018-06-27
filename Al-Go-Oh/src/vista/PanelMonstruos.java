package vista;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import modelo.*;
import modelo.Estados.EstadoAtaque;
import vista.Botones.BotonMonstruo;

import java.util.ArrayList;

public class PanelMonstruos extends HBox {

    private ArrayList<BotonMonstruo> monstruos;

    public PanelMonstruos(Jugador jugador) {
        monstruos = new ArrayList<BotonMonstruo>();
        this.setVisible(true);
        for (int i = 0; i < 5; i++) {
            BotonMonstruo monsterbutton = new BotonMonstruo();
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
      
            monstruos.get(i).setCarta((Monstruo) jugador.getZonaMonstruo().obtenerCartaPosicion(i));
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

    public void activarBotonesFaseAtaque(){
        for (BotonMonstruo boton : monstruos) {
            boton.activarHandleCampoFaseAtaque();
        }
    }


    public void activarBotonesFasePreparacion() {
        for (BotonMonstruo boton : monstruos) {
            boton.activarHandleCampoFasePreparacion();
        }
    }
}
