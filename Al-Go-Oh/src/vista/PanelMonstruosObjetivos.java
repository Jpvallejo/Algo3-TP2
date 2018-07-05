package vista;

import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import modelo.Jugador;
import modelo.Monstruo;
import vista.Botones.BotonMonstruo;
import vista.Botones.BotonPuntosDeVida;

import java.util.ArrayList;

public class PanelMonstruosObjetivos extends HBox {

    private ArrayList<BotonMonstruo> monstruos;
    private BotonPuntosDeVida lp;

    public PanelMonstruosObjetivos(Jugador jugador, Stage stage, Monstruo atacante) {
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
        actualizarPanel(jugador,stage, atacante);
    }

    public void actualizarPanel(Jugador jugador,Stage stage, Monstruo atacante){
        if(jugador.getZonaMonstruo().cantidadCartas() == 0){
            this.dibujarPuntosDeVida(stage, atacante);
            return;
        }

        for (int i = 0; i < jugador.getZonaMonstruo().cantidadCartas(); i++) {

            monstruos.get(i).setCarta(jugador.getZonaMonstruo().obtenerCartaPosicion(i));
            monstruos.get(i).activarHandleObjetivoFaseAtaque(stage, atacante);
            monstruos.get(i).setVisible(true);

            ImageView newImage = monstruos.get(i).getMonstruo().obtenerImagen();

            monstruos.get(i).setGraphic(newImage);
        }
    }

    private void dibujarPuntosDeVida(Stage stage, Monstruo atacante) {
        this.monstruos.forEach(x -> x.setVisible(false));
        this.lp = new BotonPuntosDeVida();
        this.lp.activarBoton(stage,atacante);
        this.getChildren().add(this.lp);

    }

}