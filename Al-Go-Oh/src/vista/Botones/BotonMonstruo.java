package vista.Botones;

import controlador.Controlador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.NodeOrientation;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import modelo.Carta;
import modelo.Estados.EstadoAtaque;
import modelo.Estados.EstadoDefensaBocaAbajo;
import modelo.Estados.EstadoDefensaBocaArriba;
import modelo.Excepciones.NoDisponibleParaAtacarException;
import modelo.Juego;
import modelo.Monstruo;
import vista.PanelMonstruosObjetivos;

import java.util.Optional;


public class BotonMonstruo extends BotonCarta {
    private Monstruo monstruo;

    public BotonMonstruo(String nombre){

        super(nombre);
    }

    public BotonMonstruo() {
        this.setVisible(true);
    }

    public BotonMonstruo(Monstruo monstruo){
        this.setCarta(monstruo);
        this.setVisible(true);
    }

    public Monstruo getMonstruo() {
        return monstruo;
    }

    public void setCarta(Carta monstruo) {
        this.monstruo = (Monstruo) monstruo;
        final Tooltip tooltip = new Tooltip();
        tooltip.setText(
                "Nombre :" + this.monstruo.getNombre() +
                "\nAtaque: " + this.monstruo.getPuntosAtaque() + "\n" +
                        "Defensa: " + this.monstruo.getPuntosDefensa() + "\n"
                + this.monstruo.getDescripcion()
        );
        this.setTooltip(tooltip);
    }


    // Handlers
    public void activarHandleManoFasePreparacion(){
        this.setOnAction(new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent t){

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Accion a tomar");

                Scene scene = alert.getDialogPane().getScene();
                scene.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);

                ButtonType invocarBoton = new ButtonType("Invocar");
                ButtonType colocarBoton = new ButtonType("Colocar");
                ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
                alert.getButtonTypes().setAll(invocarBoton,colocarBoton, buttonTypeCancel);

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == invocarBoton){
                    Controlador.getControlador().invocarMonstruo(monstruo);
                }
                else if (result.get() == colocarBoton){
                    Controlador.getControlador().colocarMonstruo(monstruo);
                }
            }
        });
    }

    public void activarHandleCampoFaseAtaque(){

        if (monstruo.estaEnModoAtaque()){
            this.setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent t){

                    Stage stage = new Stage();
                    Pane panel = new PanelMonstruosObjetivos(Juego.getJuego().getJugadorOponente(),stage, monstruo);
                    panel.setPrefSize(1000, 130);
                    Scene scene = new Scene(panel);
                    stage.setTitle("Seleccione Objetivo");
                    stage.setScene(scene);
                    stage.show();

                    //ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
                }
            });
        }
    }


    public void activarHandleCampoFasePreparacion(){
        this.setOnAction(new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent t){

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Accion a tomar");

                Scene scene = alert.getDialogPane().getScene();
                scene.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);

                ButtonType ataque = new ButtonType("Ataque");
                ButtonType defensa = new ButtonType("Defensa");
                ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
                alert.getButtonTypes().setAll(ataque,defensa, buttonTypeCancel);

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ataque){
                    //BotonCartaMagica.this.getMonstruo().activarEfecto();
                    Controlador.getControlador().cambiarEstado(monstruo, new EstadoAtaque());
                }
                else if (result.get() == defensa){
                    Controlador.getControlador().cambiarEstado(monstruo, new EstadoDefensaBocaArriba());
                    // Juego.getJuego().getJugadorActivo().colocarCarta(BotonCartaMagica.this.getMonstruo());
                }
            }
        });
    }

    public void activarHandleObjetivoFaseAtaque(Stage stage, Monstruo atacante){

        this.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent t){
                try {
                    stage.close();
                    Controlador.getControlador().atacarMonstruo(atacante, monstruo);
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
