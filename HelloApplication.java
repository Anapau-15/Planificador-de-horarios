package mx.edu.utez.proyectointegrador;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("experimento.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240); // Estos valores (320,240) serán ignorados al maximizar
        stage.setTitle("Bienvenido a su calendario");
        stage.setScene(scene);

        // Maximizar la ventana al iniciar
        stage.setMaximized(true);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}