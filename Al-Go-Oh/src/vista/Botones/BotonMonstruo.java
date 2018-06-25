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
import modelo.Juego;
import modelo.Jugador;
import modelo.Monstruo;
import vista.PanelMano;

import java.util.Optional;


public class BotonMonstruo extends BotonCarta {
    private Monstruo monstruo;

    public Monstruo getMonstruo() {
        return monstruo;
    }

    public void setMonstruo(Monstruo monstruo) {
        this.monstruo = monstruo;
    }

    public BotonMonstruo() {
        this.setVisible(true);
    }
    public BotonMonstruo(Monstruo monstruo){
        this.setMonstruo(monstruo);
        this.setVisible(true);
        this.setOnAction(new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent t){

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Accion a tomar");

                Scene scene = alert.getDialogPane().getScene();
                scene.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
                Stage standarddialogStage = (Stage) alert.getDialogPane().getScene().getWindow();

                ButtonType invocarBoton = new ButtonType("Invocar");
                ButtonType colocarBoton = new ButtonType("Colocar");
                ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
                alert.getButtonTypes().setAll(invocarBoton,colocarBoton, buttonTypeCancel);

                // Add a custom icon.
                //  standarddialogStage.getIcons().add(new Image("file:resources/images/calendar.png"));


                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == invocarBoton){
                    Controlador.getControlador().invocarMonstruo(monstruo);
                    //panel.actualizarMano(Juego.getJuego().getJugadorActivo());

                }
                else if (result.get() == colocarBoton){
                    Controlador.getControlador().colocarMonstruo(monstruo);

                    // Juego.getJuego().getJugadorActivo().colocarCarta(BotonCartaHechizo.this.getHechizo());
                }
            }
        });

    }
    public BotonMonstruo(String nombre){

        super(nombre);
    }
}
