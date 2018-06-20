package vista;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import modelo.Casillero;
import modelo.Jugador;
import modelo.Monstruo;
import modelo.Posicion;
import vista.Botones.BotonCarta;
import vista.Botones.BotonMonstruo;

import java.util.ArrayList;

public class PanelMonstruos extends HBox {

    private ArrayList<BotonMonstruo> monstruos;
    public PanelMonstruos(Jugador jugador) {
        monstruos = new ArrayList<BotonMonstruo>();
        this.setVisible(true);
        for(int i = 0;i<5;i++){
            BotonMonstruo monsterbutton = new BotonMonstruo();
            monsterbutton.setPrefSize(80,110);
            setSpacing(20);
            monstruos.add(monsterbutton);
            monsterbutton.setStyle("-fx-background-color: #808080");
            this.getChildren().add(monsterbutton);

        }
        for (int i = 0; i < jugador.obtenerCampo().getZonaMonstruo().cantidadCartas(); i++) {
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
            monstruos.get(i).setMonstruo((Monstruo) jugador.obtenerCampo().getZonaMonstruo().obtenerCartaPosicion(casillero));
            monstruos.get(i).setVisible(true);
            ImageView newImage;
            if(monstruos.get(i).getMonstruo().getPosicion()== Posicion.ATAQUE){
                newImage = new ImageView();
            }else{
                newImage = new ImageView();
            }
            monstruos.get(i).setGraphic(newImage);
            monstruos.get(i).setPrefSize(62,91);
        }
    }
}
