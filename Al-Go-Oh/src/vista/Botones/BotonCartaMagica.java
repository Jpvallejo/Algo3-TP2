package vista.Botones;

import controlador.Controlador;
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

import java.util.Optional;

public class BotonCartaMagica extends BotonCarta{
    private CartaMagica cartaMagica;

    public Carta getCartaMagica() {
        return cartaMagica;
    }


    public BotonCartaMagica() {
        super();
        this.setVisible(true);
        //this.activarHandleManoFasePreparacion();
    }


    public BotonCartaMagica(CartaMagica cartaMagica) {
        this.setVisible(true);
        this.setCarta(cartaMagica);
        //this.activarHandleManoFasePreparacion();
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
                ButtonType colocarBoton = new ButtonType("Colocar");
                ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
                alert.getButtonTypes().setAll(activarHechizo,colocarBoton, buttonTypeCancel);

                // Add a custom icon.
              //  standarddialogStage.getIcons().add(new Image("file:resources/images/calendar.png"));


                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == activarHechizo){
                    //BotonCartaMagica.this.getMonstruo().activarEfecto();
                    Controlador.getControlador().activarCartaMagicaDesdeMano(cartaMagica);
                }
                else if (result.get() == colocarBoton){
                    Controlador.getControlador().colocarCartaMagica(cartaMagica);
                   // Juego.getJuego().getJugadorActivo().colocarCarta(BotonCartaMagica.this.getMonstruo());
                }
            }
        });
    }

    public void activarHandleCampoFasePreparacion(){
        this.setOnAction(new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent t){

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle(cartaMagica.getNombre() + ": Accion a tomar");

                Scene scene = alert.getDialogPane().getScene();
                scene.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
                Stage standarddialogStage = (Stage) alert.getDialogPane().getScene().getWindow();
                ButtonType activarHechizo = null;
                ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
                activarHechizo = new ButtonType("Activar");
                alert.getButtonTypes().setAll(activarHechizo, buttonTypeCancel);

                // Add a custom icon.
                //  standarddialogStage.getIcons().add(new Image("file:resources/images/calendar.png"));

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == activarHechizo){
                    Controlador.getControlador().activarCartaMagica(cartaMagica);
                }
            }
        });
    }


    public void setCarta(Carta cartaMagica){
        this.cartaMagica = (CartaMagica) cartaMagica;
    }
}
