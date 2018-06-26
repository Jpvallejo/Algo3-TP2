package vista.Botones;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import modelo.Carta;
import modelo.Juego;
import modelo.Monstruo;
import vista.PanelMonstruosObjetivos;

public class BotonCampoMonstruo extends Button {
    private Monstruo monstruo;

    public Carta getMonstruo() {
        return monstruo;
    }


    public BotonCampoMonstruo() {
        super();
        this.setVisible(true);
    }


    public void activarBoton(){


        this.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent t){

                /*Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                //this.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
                alert.setTitle("Monstruo Seleccionado: ");

                Scene scene = alert.getDialogPane().getScene();
                scene.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
                Stage standarddialogStage = (Stage) alert.getDialogPane().getScene().getWindow();
                /*****/
                Stage stage = new Stage();
                Pane panel = new PanelMonstruosObjetivos(Juego.getJuego().getJugadorOponente(), stage, monstruo);
                panel.setPrefSize(1000, 116);
                //scene.get.add()
                Scene scene = new Scene(panel);
                stage.setTitle("Seleccione Objetivo");
                stage.setScene(scene);
                stage.show();
                /******/
                ButtonType activarHechizo = null;
                ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

                //activarHechizo = new ButtonType("Activar");
                //alert.getButtonTypes().setAll(activarHechizo, buttonTypeCancel);



                // Add a custom icon.
                //  standarddialogStage.getIcons().add(new Image("file:resources/images/calendar.png"));


                //Optional<ButtonType> result = alert.showAndWait();
                /*if (result.get() == activarHechizo){
                    //BotonCartaMagica.this.getMonstruo().activarEfecto();
                    Controlador.getControlador().activarCartaMagica(monstruo);
                }*/
            }
        });
    }

    public void setMonstruo(Monstruo monstruo){
        this.monstruo = monstruo;
    }

}
