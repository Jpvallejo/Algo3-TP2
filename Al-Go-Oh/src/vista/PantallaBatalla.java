package vista;

import controlador.Controlador;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import modelo.Juego;
import modelo.Jugador;
import modelo.Monstruo;
import modelo.Sacrificios;
import vista.Botones.*;

import java.util.ArrayList;


public class PantallaBatalla {
    private Scene escena;
    private Stage stage;


    private PanelHechizos panelHechizosJugador1;
    private PanelMonstruos panelMonstruosJugador1;
    private PanelMonstruos panelMonstruosJugador2;
    private PanelHechizos panelHechizosJugador2;
    public Label mazoJugador1;
    public Label mazoJugador2;
    public Label puntosVidaJugador1;
    public Label puntosVidaJugador2;
    private BotonCementerio cementerioJugador1;
    private BotonCementerio cementerioJugador2;
    private BotonCartaCampo cartaCampoJugador1;
    private BotonCartaCampo cartaCampoJugador2;
    private BotonPasarFase botonPasarFase;
    private Label nombreJugador1;
    private Label nombreJugador2;
    public Label faseActual;
    private BotonTerminarTurno botonTerminarTurno;
    private BotonReiniciarJuego botonReiniciarJuego;
    private Pane panelJugador1;
    private Pane panelJugador2;
    private Pane panelDePuntos;
    private PanelMano manoJugador1;
    private PanelMano manoJugador2;
    private ScrollPane pan;
    private PanelManoEscondida manoOcultaJugador1;
    private PanelManoEscondida manoOcultaJugador2;
    private Jugador jugador1;
    private Jugador jugador2;
    private Label descripcion;
    private ScrollPane panelCartasJugador1;
    private ScrollPane panelCartasJugador2;

    public void cargarPantalla(Stage stage, Controlador controlador) {

        this.stage = stage;

        jugador1 = controlador.getJugadorActivo();
        jugador2 = controlador.getJugadorOponente();
        actualizarPantalla(stage,controlador);
    }

    public void actualizarPantalla(Stage stage, Controlador controlador){

        int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;

        Pane panelPrincipal = new Pane();
        panelPrincipal.setPrefSize(ancho - 10, alto - 70);

        // Paneles
        panelMonstruosJugador1 = new PanelMonstruos(jugador1);
        panelMonstruosJugador1.setPrefSize(1000, 116);
        panelMonstruosJugador1.setLayoutY(232);

        panelMonstruosJugador2 = new PanelMonstruos(jugador2);
        panelMonstruosJugador2.setPrefSize(1000, 116);

        panelHechizosJugador1 = new PanelHechizos(jugador1);
        panelHechizosJugador1.setLayoutY(114);
        panelHechizosJugador1.setPrefSize(1000, 116);

        panelHechizosJugador2 = new PanelHechizos(jugador2);
        panelHechizosJugador2.setLayoutY(114);
        panelHechizosJugador2.setPrefSize(1000, 116);

        manoOcultaJugador1 = new PanelManoEscondida(jugador1);
        manoOcultaJugador2 = new PanelManoEscondida(jugador2);
        manoJugador1 = new PanelMano(jugador1);
        manoJugador2 = new PanelMano(jugador2);


        // Botones
        botonPasarFase = new BotonPasarFase();
        botonPasarFase.setText("Pasar Fase");
        botonPasarFase.setLayoutY(340);

        botonTerminarTurno = new BotonTerminarTurno(this);
        botonTerminarTurno.setLayoutY(300);
        botonTerminarTurno.setText("Terminar Turno");

        botonReiniciarJuego = new BotonReiniciarJuego();
        botonReiniciarJuego.setLayoutY(380);
        botonReiniciarJuego.setText("Reiniciar Juego");

        cartaCampoJugador1 = new BotonCartaCampo(jugador1);
        cartaCampoJugador1.setLayoutX(550);
        cartaCampoJugador1.setLayoutY(170);

        cartaCampoJugador2 = new BotonCartaCampo(jugador2);
        cartaCampoJugador2.setLayoutX(550);
        cartaCampoJugador2.setLayoutY(72);

        cementerioJugador1 = new BotonCementerio(jugador1);
        cementerioJugador1.setLayoutX(750);
        cementerioJugador1.setLayoutY(170);
        cementerioJugador1.setPrefSize(ParametrosBoton.ANCHOBOTONCARTA,ParametrosBoton.ALTOBOTONCARTA);

        cementerioJugador2 = new BotonCementerio(jugador2);
        cementerioJugador2.setLayoutX(750);
        cementerioJugador2.setLayoutY(72);
        cementerioJugador2.setPrefSize(ParametrosBoton.ANCHOBOTONCARTA,ParametrosBoton.ALTOBOTONCARTA);


        // Labels
        nombreJugador1 = new Label(jugador1.obtenerNombre());
        nombreJugador2 = new Label("Jugador 2");
        nombreJugador2.setLayoutY(650);

        puntosVidaJugador1 = new Label("Life Points:" + jugador1.getPuntosDeVida());
        puntosVidaJugador1.setLayoutY(20);
        puntosVidaJugador2 = new Label("Life Ponts:" + jugador2.getPuntosDeVida());
        puntosVidaJugador2.setLayoutY(630);

        mazoJugador1 = new Label(jugador1.obtenerTamanioMazo() + "");
        mazoJugador2 = new Label("" + jugador2.obtenerTamanioMazo());

        faseActual = new Label("Fase: " + controlador.obtenerNombreFase());
        faseActual.setLayoutY(50);


        panelJugador1 = new Pane();
        panelJugador1.setPrefSize(1000, 394);
        panelJugador1.setLayoutX(151);
        panelJugador1.getChildren().add(panelMonstruosJugador1);
        panelJugador1.getChildren().add(panelHechizosJugador1);
        panelCartasJugador1 = obtenerPanelCartasJugador(controlador, this.jugador1,manoJugador1,manoOcultaJugador1);
        panelCartasJugador1.setPrefSize(1000, 116);
        panelJugador1.getChildren().add(panelCartasJugador1);
        panelJugador1.getChildren().add(cementerioJugador1);
        panelJugador1.getChildren().add(cartaCampoJugador1);

        panelJugador2 = new Pane();
        panelJugador2.setPrefSize(1000, 394);
        panelJugador2.setLayoutX(151);
        panelJugador2.setLayoutY(346);
        panelJugador2.getChildren().add(panelMonstruosJugador2);
        panelJugador2.getChildren().add(panelHechizosJugador2);
        panelJugador2.getChildren().add(cementerioJugador2);
        panelJugador2.getChildren().add(cartaCampoJugador2);

        panelCartasJugador2 = obtenerPanelCartasJugador(controlador, this.jugador2,manoJugador2,manoOcultaJugador2);
        panelCartasJugador2.setPrefSize(1000, 116);
        panelCartasJugador2.setLayoutY(232);
        panelJugador2.getChildren().add(panelCartasJugador2);

        Pane panelDePuntos = new Pane();
        panelDePuntos.setStyle("-fx-background-color: #a2a2a2");
        panelDePuntos.setPrefSize(148, 698);
        panelDePuntos.getChildren().add(nombreJugador2);
        panelDePuntos.getChildren().add(puntosVidaJugador2);
        panelDePuntos.getChildren().add(faseActual);
        panelDePuntos.getChildren().add(botonTerminarTurno);
        panelDePuntos.getChildren().add(botonPasarFase);
        panelDePuntos.getChildren().add(botonReiniciarJuego);
        panelDePuntos.getChildren().add(puntosVidaJugador1);
        panelDePuntos.getChildren().add(nombreJugador1);

        panelPrincipal.getChildren().addAll(panelJugador1, panelJugador2, panelDePuntos);
        panelPrincipal.setBackground(new Background(new BackgroundImage(new Image("vista/imagenes/fondobatalla.jpg", 1500, 5000, true, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT)));

        this.escena = new Scene(panelPrincipal, ancho - 10, alto - 70);
        stage.setScene(escena);
        stage.centerOnScreen();

        stage.show();

        controlador.verificarGanador();

        controlador.obtenerFase().activarHandles(this);

        panelCartasJugador1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                
            }
        });
    }

    public ScrollPane obtenerPanelCartasJugador(Controlador controlador, Jugador jugador, PanelMano mano, PanelManoEscondida manoEscondida) {
        ScrollPane panelCartas;
        if (jugador == controlador.getJugadorActivo()) {
            panelCartas = new ScrollPane(mano);
        } else {
            panelCartas = new ScrollPane(manoEscondida);
        }
        panelCartas.setBorder(null);
        panelCartas.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        panelCartas.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        panelCartas.setFitToHeight(true);
        panelCartas.setFitToWidth(true);
        return panelCartas;
    }


    public void activarPanelesFasePreparacion(){
        manoJugador1.activarBotonesFasePreparacion();
        manoJugador2.activarBotonesFasePreparacion();
        panelHechizosJugador1.activarBotonesFasePreparacion();
        panelHechizosJugador2.activarBotonesFasePreparacion();
        panelMonstruosJugador1.activarBotonesFasePreparacion();
        panelMonstruosJugador2.activarBotonesFasePreparacion();
    }

    public void activarPanelesFaseAtque(){
        if(jugador1 == Controlador.getControlador().getJugadorActivo() ){
            panelMonstruosJugador1.activarBotonesFaseAtaque();
        }
        else{
            panelMonstruosJugador2.activarBotonesFaseAtaque();
        }

    }


    public void activarPanelesFaseFinal() {
        panelHechizosJugador1.activarBotonesFasePreparacion();
        panelHechizosJugador2.activarBotonesFasePreparacion();
    }


    public void reiniciarPantalla() {
        cargarPantalla(stage, Controlador.getControlador());
    }

    public void actualizarPantalla(){
       actualizarPantalla(stage, Controlador.getControlador());

    }

    public void mostrarPantallaGanador() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Juego Terminado!");
        alert.setHeaderText(null);
        alert.setContentText("Ganador: " + Controlador.getControlador().obtenerNombreGanador());

        alert.showAndWait();
        Controlador.getControlador().reiniciarJuego();
    }

    public void abrirPanelSacrificios(Monstruo aInvocar, Sacrificios sacrificios) {
        ArrayList<Monstruo> monstruosDisponibles = new ArrayList<Monstruo>();
        Jugador jugadorActivo = Juego.getJuego().getJugadorActivo();
        for (int i = 0; i < jugadorActivo.cantidadCartasZonaMonstruos(); i++) {
            monstruosDisponibles.add((Monstruo) jugadorActivo.getZonaMonstruo().obtenerCartaPosicion(i));
        }

        for (int i=0 ; i < aInvocar.cantidadASacrificar() ; i++) {
            Stage stage = new Stage();
            Pane panel = new PanelSacrificios(monstruosDisponibles, stage, sacrificios);
            panel.setPrefSize(1000, 130);
            Scene scene = new Scene(panel);
            stage.setTitle("Seleccione Sacrificios");
            stage.setScene(scene);
            stage.showAndWait();
        }
    }
}
