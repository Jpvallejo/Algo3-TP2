package vista.Botones;

import controlador.Controlador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import modelo.Excepciones.NoDisponibleParaAtacarException;
import modelo.Juego;
import modelo.Jugador;
import modelo.Monstruo;

public class BotonPuntosDeVida extends Button {

    public BotonPuntosDeVida(){
        this.setText("Atacar jugador");
        this.setVisible(true);
    }

    // Handlers
    public void activarBoton(Stage stage, Monstruo atacante){
        this.setOnAction(new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent t){
                try {
                    stage.close();
                    Controlador.getControlador().atacarPuntosDeVida(atacante);
                }
                catch(NoDisponibleParaAtacarException e){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Ataque No Permitido");
                    alert.setHeaderText(null);
                    alert.setContentText("El monstruo seleccionado ya no puede atacar");

                    alert.showAndWait();
                }

            }
        });
    }

}
