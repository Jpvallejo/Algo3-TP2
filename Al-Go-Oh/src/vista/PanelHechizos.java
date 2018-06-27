package vista;

import javafx.scene.control.Button;
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
            BotonCarta botonHechizo;
            if(cartaCasillero instanceof CartaMagica) {
                botonHechizo = new BotonCartaMagica();
            }
            else{
                botonHechizo = new BotonCartaTrampa();
            }
            botonHechizo.setCarta(cartaCasillero);
            botonHechizo.setPrefSize(80, 110);
            setSpacing(20);
            hechizos.add(botonHechizo);
            botonHechizo.setStyle("-fx-background-color: #808080");

            Image img = new Image("/vista/imagenes/cartaAtras.jpg",100,110,true,false);
            hechizos.get(i).setGraphic(new ImageView(img));
            hechizos.get(i).setPrefSize(62,91);
        }

        for (int i = jugador.getZonaHechizos().cantidadCartas() ; i < 5; i++) {
            BotonSinCarta botonHechizo = new BotonSinCarta();
            botonHechizo.setPrefSize(80, 110);
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
