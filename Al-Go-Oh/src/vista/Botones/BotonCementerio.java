package vista.Botones;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import modelo.Juego;
import modelo.Jugador;
import vista.PanelCementerio;
import vista.PanelMonstruosObjetivos;

public class BotonCementerio extends Button {

    public BotonCementerio(Jugador jugador){
        this.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent t){

                Stage stage = new Stage();
                Pane panel = new PanelCementerio(jugador,stage);
                panel.setPrefSize(1000, 500);
                Scene scene = new Scene(panel);
                stage.setTitle("Cementerio");
                stage.setScene(scene);
                stage.show();

                //ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
            }
        });
    }
}
