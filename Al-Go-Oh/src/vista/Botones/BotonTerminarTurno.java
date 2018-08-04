package vista.Botones;

import controlador.Controlador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import vista.PantallaBatalla;

public class BotonTerminarTurno extends Button {

    public BotonTerminarTurno(PantallaBatalla pantallaBatalla){
        this.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                    Controlador controlador = Controlador.getControlador();
                    controlador.terminarTurno();
                    pantallaBatalla.actualizarPantalla();
                }
            });
    }



}
