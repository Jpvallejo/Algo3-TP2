package vista;

import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import modelo.Jugador;
import modelo.Monstruo;
import modelo.Sacrificios;
import vista.Botones.BotonMonstruo;
import vista.Botones.BotonPuntosDeVida;

import java.util.ArrayList;

public class PanelSacrificios extends HBox {

    private ArrayList<BotonMonstruo> monstruos;
    private BotonPuntosDeVida lp;

    public PanelSacrificios(ArrayList<Monstruo> monstruosDisponibles, Stage stage, Sacrificios sacrificios) {
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
        actualizarPanel(monstruosDisponibles,stage, sacrificios);
    }

    public void actualizarPanel(ArrayList<Monstruo> monstruosDisponibles,Stage stage, Sacrificios sacrificios){

        for (int i = 0; i < monstruosDisponibles.size(); i++) {

            monstruos.get(i).setCarta(monstruosDisponibles.get(i));
            monstruos.get(i).activarHandleSacrificios(monstruosDisponibles,stage, sacrificios);
            monstruos.get(i).setVisible(true);
            ImageView newImage = monstruos.get(i).getMonstruo().obtenerImagen();
            monstruos.get(i).setGraphic(newImage);
        }
    }


}