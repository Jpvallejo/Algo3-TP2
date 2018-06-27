package vista;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import modelo.*;
import vista.Botones.BotonCarta;

import java.util.ArrayList;

public class PanelManoEscondida extends GridPane {

    private ArrayList<Button> botonesMano;

    public PanelManoEscondida(Jugador jugador) {
        actualizarMano(jugador);

    }

    public ArrayList<Button> getBotonesMano(){
        return this.botonesMano;
    }

    public void setBotonesMano(ArrayList<Button> botones){
        this.botonesMano = botones;
    }

    public void actualizarMano(Jugador jugador) {
        this.getChildren().clear();
        this.setHgap(10);
        this.setVgap(12);

        HBox hbButtons = new HBox();
        hbButtons.setSpacing(10.0);
        botonesMano = new ArrayList<Button>();
        Mano mano = jugador.getMano();
        for (Carta carta : mano.getCartas()) {
            Button botonMonstruo = new Button();
            hbButtons.getChildren().add(botonMonstruo);
            botonesMano.add(botonMonstruo);
            Image img = new Image("vista/imagenes/cartaAtras.jpg",100,110,true,false);
            botonMonstruo.setGraphic(new ImageView(img));
            botonMonstruo.setPrefSize(80, 110);
        }
        this.add(hbButtons, 0, 2, 2, 1);
    }
}
