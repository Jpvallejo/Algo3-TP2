package vista;

import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import modelo.*;
import vista.Botones.BotonMonstruo;

import java.util.ArrayList;

public class PanelMonstruos extends HBox {

    private ArrayList<BotonMonstruo> monstruos;

    public PanelMonstruos(Jugador jugador) {
        monstruos = new ArrayList<BotonMonstruo>();
        this.setVisible(true);
        for (int i = 0; i < 5; i++) {
            BotonMonstruo monsterbutton = new BotonMonstruo();
            monsterbutton.setPrefSize(ParametrosBoton.ANCHOBOTONCAMPO, ParametrosBoton.ALTOBOTONCAMPO);
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

            ImageView newImage = monstruos.get(i).getMonstruo().obtenerImagen();

            monstruos.get(i).setGraphic(newImage);
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
