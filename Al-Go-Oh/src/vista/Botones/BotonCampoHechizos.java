package vista.Botones;

import controlador.Controlador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.NodeOrientation;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import modelo.Carta;
import modelo.CartaMagica;
import modelo.CartaTrampa;

import java.util.Optional;

public class BotonCampoHechizos extends Button {
    private Carta hechizo;

    public Carta getHechizo() {
        return hechizo;
    }


    public BotonCampoHechizos() {
        super();
        this.setVisible(true);
    }


    public void activarBoton(){
        this.setOnAction(new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent t){

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle(hechizo.getNombre() + ": Accion a tomar");

                Scene scene = alert.getDialogPane().getScene();
                scene.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
                Stage standarddialogStage = (Stage) alert.getDialogPane().getScene().getWindow();
                ButtonType activarHechizo = null;
                ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
                if (hechizo instanceof CartaMagica) {
                    activarHechizo = new ButtonType("Activar");
                    alert.getButtonTypes().setAll(activarHechizo, buttonTypeCancel);
                }
                else{
                    alert.getButtonTypes().setAll(buttonTypeCancel);
                }



                // Add a custom icon.
                //  standarddialogStage.getIcons().add(new Image("file:resources/images/calendar.png"));


                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == activarHechizo){
                    //BotonCartaMagica.this.getMonstruo().activarEfecto();
                    Controlador.getControlador().activarCartaMagica((CartaMagica) hechizo);
                }
            }
        });
    }

    public void setHechizo(CartaMagica hechizo){
        this.hechizo = hechizo;
    }

    public void setHechizo(CartaTrampa hechizo){
        this.hechizo = hechizo;
    }
}
