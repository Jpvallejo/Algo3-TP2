package vista;

import controlador.Controlador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import modelo.Jugador;
import vista.Botones.BotonPasarFase;
import vista.Botones.BotonTerminarTurno;


public class PantallaBatalla {
    private Scene escena;
    private Stage stage;


    private Pane panel2;
    private PanelHechizos panelHechizosJugador1;
    private PanelMonstruos panelMonstruosJugador1;
    private PanelMonstruos panelMonstruosJugador2;
    private PanelHechizos panelHechizosJugador2;
    public Label mazoJugador1;
    public Label mazoJugador2;
    public Label puntosVidaJugador1;
    public Label puntosVidaJugador2;
    private Button cementerioJugador1;
    private Button cementerioJugador2;
    private BotonPasarFase botonPasarFase;
    private Label nombreJugador1;
    private Label nombreJugador2;
    public Label faseActual;
    private BotonTerminarTurno botonTerminarTurno;
    private Pane panel1;
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
        int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;


        this.stage = stage;
        Pane panelPrincipal = new Pane();
        panelPrincipal.setPrefSize(ancho - 10, alto - 70);

        jugador1 = controlador.getJugadorActivo();
        jugador2 = controlador.getJugadorOponente();

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

        botonPasarFase = new BotonPasarFase();
        botonPasarFase.setText("Pasar Fase");
        botonPasarFase.setLayoutY(340);

        botonTerminarTurno = new BotonTerminarTurno();
        botonTerminarTurno.setLayoutY(300);
        botonTerminarTurno.setText("Terminar Turno");

        nombreJugador1 = new Label("Jugador 1");
        nombreJugador2 = new Label("Jugador 2");
        nombreJugador2.setLayoutY(650);
        cementerioJugador1 = new Button();
        cementerioJugador2 = new Button();

        puntosVidaJugador1 = new Label("Life Points:" + jugador1.getPuntosDeVida());
        puntosVidaJugador1.setLayoutY(20);
        puntosVidaJugador2 = new Label("Life Ponts:" + jugador2.getPuntosDeVida());
        puntosVidaJugador2.setLayoutY(630);

        mazoJugador1 = new Label(jugador1.obtenerTamanioMazo() + "");
        mazoJugador2 = new Label("" + jugador2.obtenerTamanioMazo());
        manoJugador1 = new PanelMano(jugador1);
        manoJugador2 = new PanelMano(jugador2);
        faseActual = new Label(controlador.obtenerFase());

        manoOcultaJugador1 = new PanelManoEscondida(jugador1);
        manoOcultaJugador2 = new PanelManoEscondida(jugador2);

        panel1 = new Pane();
        panel1.setPrefSize(1000, 394);
        panel1.setLayoutX(151);
        panel1.getChildren().add(panelMonstruosJugador1);
        panel1.getChildren().add(panelHechizosJugador1);
        panelCartasJugador1 = obtenerPanelCartasJugador(controlador, this.jugador1,manoJugador1,manoOcultaJugador1);
        panelCartasJugador1.setPrefSize(800, 116);
        panel1.getChildren().add(panelCartasJugador1);

        panelCartasJugador2 = obtenerPanelCartasJugador(controlador, this.jugador2,manoJugador2,manoOcultaJugador2);

        panel2 = new Pane();
        panel2.setPrefSize(800, 394);
        panel2.setLayoutX(151);
        panel2.setLayoutY(346);
        panel2.getChildren().add(panelMonstruosJugador2);
        panel2.getChildren().add(panelHechizosJugador2);


        panelCartasJugador2.setPrefSize(1000, 116);
        panelCartasJugador2.setLayoutY(232);
        panel2.getChildren().add(panelCartasJugador2);

        Pane panel3 = new Pane();
        panel3.setStyle("-fx-background-color: #a2a2a2");
        panel3.setPrefSize(148, 698);
        panel3.getChildren().add(nombreJugador2);
        panel3.getChildren().add(puntosVidaJugador2);
        panel3.getChildren().add(botonTerminarTurno);
        panel3.getChildren().add(botonPasarFase);
        panel3.getChildren().add(puntosVidaJugador1);
        panel3.getChildren().add(nombreJugador1);
        panelPrincipal.getChildren().addAll(panel1, panel2, panel3);
        panelPrincipal.setBackground(new Background(new BackgroundImage(new Image("vista/imagenes/fondobatalla.jpg", 1500, 5000, true, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT)));

        this.escena = new Scene(panelPrincipal, ancho - 10, alto - 70);
        stage.setScene(escena);
        stage.centerOnScreen();

        stage.show();


        botonTerminarTurno.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                controlador.terminarTurno();
                ScrollPane panelCartas1 = obtenerPanelCartasJugador(controlador, PantallaBatalla.this.jugador1,manoJugador1,manoOcultaJugador1);
                ScrollPane panelCartas2 = obtenerPanelCartasJugador(controlador, PantallaBatalla.this.jugador2,manoJugador2,manoOcultaJugador2);
                panelCartas1.setPrefSize(1000, 116);
                panelCartas2.setPrefSize(1000, 116);
                panelCartas2.setLayoutY(232);
                PantallaBatalla pantalla = PantallaBatalla.this;
                pantalla.panel1.getChildren().set(2, panelCartas1);
                pantalla.panel2.getChildren().set(2, panelCartas2);
            }
        });

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
}
