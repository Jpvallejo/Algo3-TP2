package vista;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import modelo.*;
import vista.Botones.BotonCarta;
import vista.Botones.BotonCartaHechizo;

import java.util.ArrayList;

public class PanelHechizos extends HBox {

    private ArrayList<BotonCartaHechizo> hechizos;
    public PanelHechizos(Jugador jugador) {

        setPrefSize(500,100);
        hechizos = new ArrayList<BotonCartaHechizo>();
        this.setVisible(true);
        for(int i = 0;i<5;i++){
            BotonCartaHechizo botonHechizo = new BotonCartaHechizo();
            botonHechizo.setPrefSize(80,110);
            setSpacing(20);
            hechizos.add(botonHechizo);
            botonHechizo.setStyle("-fx-background-color: #808080");
            this.getChildren().add(botonHechizo);

        }
        for (int i = 0; i < jugador.getZonaHechizos().cantidadCartas(); i++) {
            Casillero casillero = Casillero.UNO;
            switch (i) {
                case 0:
                    casillero = Casillero.UNO;
                    break;
                case 1:
                    casillero = Casillero.DOS;
                    break;
                case 2:
                    casillero = Casillero.TRES;
                    break;
                case 3:
                    casillero = Casillero.CUATRO;
                case 4:
                    casillero = Casillero.CINCO;
                    break;
            }
            Carta cartaCasillero = jugador.getZonaHechizos().obtenerCartaPosicion(casillero);
            if(cartaCasillero instanceof CartaTrampa) {
                hechizos.get(i).setHechizo((CartaTrampa)cartaCasillero);
            }
            else{
                hechizos.get(i).setHechizo((CartaMagica)cartaCasillero);
            }
            hechizos.get(i).setVisible(true);
            ImageView newImage;
            Image img = new Image("/vista/imagenes/cartaAtras.jpg",100,146,true,false);
            hechizos.get(i).setGraphic(new ImageView(img));
            hechizos.get(i).setPrefSize(62,91);
        }
    }
}
