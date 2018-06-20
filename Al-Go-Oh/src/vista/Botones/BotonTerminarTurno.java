package vista.Botones;

import controlador.Controlador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class BotonTerminarTurno extends Button {

    public void BotonPasarFase(){
        this.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Controlador.getControlador().terminarTurno();
            }
        });
    }

}
