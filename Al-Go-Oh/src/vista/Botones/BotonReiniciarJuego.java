package vista.Botones;

import controlador.Controlador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

import java.awt.*;

public class BotonReiniciarJuego extends Button {

    public BotonReiniciarJuego(){
        this.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Controlador.getControlador().reiniciarJuego();
            }
        });
    }
}
