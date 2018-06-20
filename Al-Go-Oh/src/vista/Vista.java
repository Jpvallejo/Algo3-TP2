package vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modelo.CartasMagicas.AgujeroNegro;
import modelo.Jugador;

public class Vista extends Application {

    @Override
    public void start(Stage Stage) {
        Stage.setTitle("Al-Go-Oh!");
        Jugador j = new Jugador();
        j.getMano().agregarCarta(new AgujeroNegro());
        j.getMano().agregarCarta(new AgujeroNegro());
        j.getMano().agregarCarta(new AgujeroNegro());
        j.getMano().agregarCarta(new AgujeroNegro());
        j.getMano().agregarCarta(new AgujeroNegro());
        j.getMano().agregarCarta(new AgujeroNegro());
        j.getMano().agregarCarta(new AgujeroNegro());
        j.getMano().agregarCarta(new AgujeroNegro());
        j.getMano().agregarCarta(new AgujeroNegro());
        j.getMano().agregarCarta(new AgujeroNegro());

        PanelMano p = new PanelMano(j);
        Scene s = new Scene(p);
        Stage.setScene(s);
        Stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
