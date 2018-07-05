package vista;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import modelo.Carta;
import modelo.Jugador;
import modelo.Monstruo;
import vista.Botones.BotonCarta;
import vista.Botones.BotonMonstruo;

import java.util.ArrayList;

public class PanelCementerio extends HBox {


    private ArrayList<BotonCarta> cartasCementerio;

    public PanelCementerio(Jugador jugador, Stage stage) {
        cartasCementerio = new ArrayList<BotonCarta>();
        this.setVisible(true);
        actualizarPanel(jugador,stage);
    }

    public void actualizarPanel(Jugador jugador,Stage stage){

        for (int i = 0; i < jugador.cantidadCartasCementerio(); i++) {

            Carta cartaActual = jugador.obtenerCartaCementerioPosicion(i);

            BotonCarta botonCarta = cartaActual.crearBoton();
            botonCarta.setPrefSize(ParametrosBoton.ANCHOBOTONCARTA, ParametrosBoton.ALTOBOTONCARTA);
            setSpacing(20);
            cartasCementerio.add(botonCarta);
            this.getChildren().add(botonCarta);
            cartasCementerio.get(i).setVisible(true);
            Image img = new Image(cartaActual.getUrlImagen(),ParametrosBoton.ANCHOCARTA,ParametrosBoton.ALTOCARTA,true,false);
            cartasCementerio.get(i).setGraphic(new ImageView(img));
        }
    }

}
