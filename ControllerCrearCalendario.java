package mx.edu.utez.proyectointegrador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;

public class ControllerCrearCalendario {
    @FXML
    private Button botonAñadirHora;
    @FXML
    private Button botonRepetirDia;

    @FXML
    private void SeleccionarHora(ActionEvent event) {
        abrirVentana(
                "/mx/edu/utez/proyectointegrador/BotonAñadirHora.fxml",
                "Seleccionar Hora",
                180,
                405
        );
    }

    @FXML
    private void SeleccionarRepetir(ActionEvent event) {
        abrirVentana(
                "/mx/edu/utez/proyectointegrador/BotonRepetirDia.fxml",
                "Repetir Día",
                280,
                280
        );
    }

    private void abrirVentana(String fxmlPath, String title, double width, double height) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlPath));
            Scene scene = new Scene(fxmlLoader.load());

            Stage newStage = new Stage();
            newStage.setTitle(title);
            newStage.setScene(scene);

            // Configuración de tamaño específico
            newStage.setWidth(width);
            newStage.setHeight(height);

            // Centrar la ventana
            newStage.centerOnScreen();

            // Evitar redimensionamiento
            newStage.setResizable(false);

            newStage.show();

        } catch (IOException e) {
            System.err.println("Error al cargar " + fxmlPath + ":");
            e.printStackTrace();

            // Mostrar alerta de error
            javafx.scene.control.Alert alert = new javafx.scene.control.Alert(
                    javafx.scene.control.Alert.AlertType.ERROR
            );
            alert.setTitle("Error");
            alert.setHeaderText("No se pudo abrir la ventana");
            alert.setContentText("Ocurrió un error al intentar abrir: " + title);
            alert.show();
        }
    }
}