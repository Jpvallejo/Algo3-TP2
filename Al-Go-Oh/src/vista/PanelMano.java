package vista;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import modelo.*;
import vista.Botones.*;

import java.util.ArrayList;

public class PanelMano  extends GridPane {
    private ArrayList<BotonCarta> botonesMano;

    public ArrayList<BotonCarta> getBotonesMano(){
        return this.botonesMano;
    }

    public void setBotonesMano(ArrayList<BotonCarta> botones){
        this.botonesMano = botones;
    }

    public PanelMano(Jugador jugador) {
        actualizarMano(jugador);
    }

    public void actualizarMano(Jugador jugador){
        this.getChildren().clear();
        this.setHgap(10);
        this.setVgap(12);

        HBox hbButtons = new HBox();
        hbButtons.setSpacing(10.0);
        botonesMano = new ArrayList<BotonCarta>();
        Mano mano = jugador.getMano();
        for (Carta carta: mano.getCartas()) {
            Image img = new Image(carta.getUrlImagen(),100,110,true,false);
            ImageView icono = new ImageView(img);
            BotonCarta botonCarta;

            if(carta instanceof Monstruo ){
                botonCarta = new BotonMonstruo((Monstruo)carta);
                hbButtons.getChildren().add(botonCarta);
                botonesMano.add(botonCarta);
            }
            else if(carta instanceof CartaMagica){
                botonCarta = new BotonCartaMagica((CartaMagica)carta);
                hbButtons.getChildren().add(botonCarta);
                botonesMano.add(botonCarta);
            }
            else {
                botonCarta = new BotonCartaTrampa((CartaTrampa)carta);
                hbButtons.getChildren().add(botonCarta);
                botonesMano.add(botonCarta);
            }

            botonCarta.setGraphic(new ImageView(img));
            botonCarta.setPrefSize(100,110);

        }
        this.add(hbButtons,0,2,2,1);

    }


    public void activarBotonesFasePreparacion(){
        for (BotonCarta boton : botonesMano){
            boton.activarHandleManoFasePreparacion();
        }
    }

}
