package vista.Botones;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.NodeOrientation;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import modelo.Carta;
import modelo.CartaMagica;
import modelo.CartaTrampa;
import modelo.Juego;

import java.util.Optional;

public class BotonCartaHechizo extends BotonCarta{
    private Carta hechizo;
    private boolean esCartaTrampa;

    public Carta getHechizo() {
        return hechizo;
    }


    public BotonCartaHechizo() {
        super();
        this.setVisible(true);

    }
    public BotonCartaHechizo(CartaMagica hechizo){
        this.setVisible(true);
        this.setHechizo(hechizo);
        this.setOnAction(new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent t){

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Accion a tomar");

                Scene scene = alert.getDialogPane().getScene();
                scene.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
                Stage standarddialogStage = (Stage) alert.getDialogPane().getScene().getWindow();

                ButtonType activarHechizo = new ButtonType("Activar");
                ButtonType colocarBoton = new ButtonType("Colocar");
                ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
                alert.getButtonTypes().setAll(activarHechizo,colocarBoton, buttonTypeCancel);

                // Add a custom icon.
              //  standarddialogStage.getIcons().add(new Image("file:resources/images/calendar.png"));


                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == activarHechizo){
                    BotonCartaHechizo.this.getHechizo().activarEfecto();
                }
                else if (result.get() == colocarBoton){
                   // Juego.getJuego().getJugadorActivo().colocarCarta(BotonCartaHechizo.this.getHechizo());
                }
            }
        });
    }

    public void setHechizo(CartaTrampa hechizo){
        this.hechizo = hechizo;
        this.esCartaTrampa = true;
    }
    public void setHechizo(CartaMagica hechizo){
        this.hechizo = hechizo;
        this.esCartaTrampa = false;
    }
}
