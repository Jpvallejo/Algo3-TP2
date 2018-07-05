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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import modelo.Carta;
import modelo.CartaCampo;
import modelo.Jugador;
import vista.ParametrosBoton;

import java.util.Optional;

public class BotonCartaCampo extends BotonCarta {

    private CartaCampo carta;

    public BotonCartaCampo(Jugador jugador){
        this.setPrefSize(ParametrosBoton.ANCHOBOTONCARTA,ParametrosBoton.ALTOBOTONCARTA);
        this.setStyle("-fx-background-color: #808080");
        carta = jugador.getCartaCampo();
        Image img = new Image(carta.getUrlImagen(),ParametrosBoton.ANCHOCARTA,ParametrosBoton.ALTOCARTA,true,false);
        this.setGraphic(new ImageView(img));
    }

    public BotonCartaCampo(CartaCampo cartaCampo) {
        super();
        this.carta = cartaCampo;
    }

    @Override
    public void activarHandleManoFasePreparacion(){
        this.setOnAction(new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent t){

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Accion a tomar");

                Scene scene = alert.getDialogPane().getScene();
                scene.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
                Stage standarddialogStage = (Stage) alert.getDialogPane().getScene().getWindow();

                ButtonType activarHechizo = new ButtonType("Activar");
                ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
                alert.getButtonTypes().setAll(activarHechizo, buttonTypeCancel);

                // Add a custom icon.
                //  standarddialogStage.getIcons().add(new Image("file:resources/images/calendar.png"));


                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == activarHechizo){
                    //BotonCartaMagica.this.getMonstruo().activarEfecto();
                    Controlador.getControlador().activarCartaCampoDesdeMano(carta);
                }
            }
        });
    }

    @Override
    public void setCarta(Carta cartaCasillero) {
        carta = (CartaCampo) cartaCasillero;
    }
}
