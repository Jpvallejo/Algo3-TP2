package vista;

import javafx.application.Application;
import javafx.stage.Stage;

public class Vista extends Application {

    @Override
    public void start(Stage Stage) {
        Stage.setTitle("Al-Go-Oh!");
        Stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
