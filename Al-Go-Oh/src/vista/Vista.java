package vista;

import controlador.Controlador;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modelo.CartasMagicas.AgujeroNegro;
import modelo.Jugador;
import vista.Botones.BotonPasarFase;

public class Vista extends Application {

    @Override
    public void start(Stage Stage) {
        Stage.setTitle("Al-Go-Oh!");
        /**
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
        BotonPasarFase fase = new BotonPasarFase();
        fase.setText("Pasar Fase");
        PanelMano p = new PanelMano(j);
        p.add(fase,0,0);
        Scene s = new Scene(p);
*/

        Controlador controlador = new Controlador();
        PantallaBatalla pantallaBatalla = new PantallaBatalla();
        pantallaBatalla.cargarPantalla(Stage,controlador);
    }
    public static void main(String[] args) {
        launch(args);
    }
}
