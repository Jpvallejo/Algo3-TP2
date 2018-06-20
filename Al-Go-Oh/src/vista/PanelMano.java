package vista;

import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import modelo.*;
import vista.Botones.*;
import java.util.ArrayList;

public class PanelMano  extends GridPane {
        private ArrayList<BotonCarta> botonesMano;
        public PanelMano(Jugador jugador) {
            actualizarMano(jugador);

        }
        public ArrayList<BotonCarta> getBotonesMano(){
            return this.botonesMano;
        }
        public void setBotonesMano(ArrayList<BotonCarta> botones){
            this.botonesMano = botones;
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
                if(carta instanceof Monstruo){
                    BotonMonstruo botonMonstruo = new BotonMonstruo((Monstruo)carta);
                    hbButtons.getChildren().add(botonMonstruo);
                    botonesMano.add(botonMonstruo);
                    /**
                    ImageIcon img = new ImageIcon("Cards Images Database/Monsters/"+carta.getName()+".png");
                    Image img2 = img.getImage();
                    Image newimg = img2.getScaledInstance(100, 146,  java.awt.Image.SCALE_SMOOTH);
                    ImageIcon newIcon = new ImageIcon(newimg);
                     */
                    botonMonstruo.setGraphic(new ImageView());
                    botonMonstruo.setPrefSize(100,110);
                }
                else if(carta instanceof CartaMagica){
                    BotonCartaHechizo botonCartaHechizo = new BotonCartaHechizo((CartaMagica)carta);
                    hbButtons.getChildren().add(botonCartaHechizo);
                    botonesMano.add(botonCartaHechizo);
                    /**FOTO*/
                    botonCartaHechizo.setGraphic(new ImageView());
                    botonCartaHechizo.setPrefSize(100,110);
                }
                else {
                    BotonCartaTrampa botonCartaTrampa = new BotonCartaTrampa((CartaTrampa)carta);
                    botonCartaTrampa.setVisible(true);
                    hbButtons.getChildren().add(botonCartaTrampa);
                    botonesMano.add(botonCartaTrampa);
                    /**FOTO*/
                    botonCartaTrampa.setGraphic(new ImageView());
                    botonCartaTrampa.setPrefSize(100,146);

                }

            }
            this.add(hbButtons,0,2,2,1);
        }

}
