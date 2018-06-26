package vista.Botones;

import controlador.Controlador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import modelo.Carta;
import modelo.Juego;
import modelo.Monstruo;

public class BotonMonstruoObjetivo extends Button {
    private Monstruo monstruo;

    public Carta getMonstruo() {
        return monstruo;
    }


    public BotonMonstruoObjetivo() {
        super();
        this.setVisible(true);
    }


    public void activarBoton(Stage stage, Monstruo atacante){


        this.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent t){

                Controlador.getControlador().atacarMonstruo(atacante, monstruo);
                stage.close();
            }
        });
    }

    public void setMonstruo(Monstruo monstruo){
        this.monstruo = monstruo;
    }

}
