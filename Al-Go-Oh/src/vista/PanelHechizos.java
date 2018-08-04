package vista;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import modelo.*;
import vista.Botones.*;

import java.util.ArrayList;

public class PanelHechizos extends HBox {

    private ArrayList<BotonCarta> hechizos;

    public PanelHechizos(Jugador jugador) {

        setPrefSize(500,100);
        hechizos = new ArrayList<BotonCarta>();

        actualizarPanel(jugador);
    }

    public void actualizarPanel(Jugador jugador){
        for (int i = 0; i < jugador.getZonaHechizos().cantidadCartas(); i++) {
            Carta cartaCasillero = jugador.getZonaHechizos().obtenerCartaPosicion(i);
            BotonCarta botonHechizo = cartaCasillero.crearBoton();
            botonHechizo.setPrefSize(ParametrosBoton.ANCHOBOTONCAMPO, ParametrosBoton.ALTOBOTONCAMPO);
            setSpacing(20);
            hechizos.add(botonHechizo);
            botonHechizo.setStyle("-fx-background-color: #808080");

            Image img = new Image("/vista/imagenes/cartaAtras.jpg",ParametrosBoton.ANCHOCARTA,ParametrosBoton.ALTOCARTA,true,false);
            hechizos.get(i).setGraphic(new ImageView(img));
        }

        for (int i = jugador.getZonaHechizos().cantidadCartas() ; i < 5; i++) {
            BotonSinCarta botonHechizo = new BotonSinCarta();
            botonHechizo.setPrefSize(ParametrosBoton.ANCHOBOTONCAMPO, ParametrosBoton.ALTOBOTONCAMPO);
            setSpacing(20);
            hechizos.add(botonHechizo);
            botonHechizo.setStyle("-fx-background-color: #808080");
        }

        this.getChildren().addAll(hechizos);
    }

    public void activarBotonesFasePreparacion() {
        for (BotonCarta boton : hechizos) {
            boton.activarHandleCampoFasePreparacion();
        }
    }
}
