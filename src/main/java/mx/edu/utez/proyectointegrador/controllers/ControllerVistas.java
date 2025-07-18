package mx.edu.utez.proyectointegrador.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;

public class ControllerVistas {
    // Botones (opcional, si necesitas referencia a ellos)
    @FXML
    private Button btnDia;
    @FXML
    private Button btnSemana;
    @FXML
    private Button btnAnio;

    @FXML
    private void CalendarioDia(ActionEvent event) {
        abrirVentana(
                "/mx/edu/utez/proyectointegrador/CalendarioPorDia.fxml",
                "Calendario por Día",
                855,
                590
        );
    }

    @FXML
    private void CalendarioSemana(ActionEvent event) {
        abrirVentana(
                "/mx/edu/utez/proyectointegrador/CalendarioSemana.fxml",
                "Calendario por Semana",
                1550,  // Ancho sugerido para vista semanal
                800   // Alto sugerido
        );
    }

    @FXML
    private void CalendarioAño(ActionEvent event) {
        abrirVentana(
                "/mx/edu/utez/proyectointegrador/CalendarioPorAño.fxml",
                "Calendario por Año",
                1100,  // Ancho sugerido para vista anual
                690    // Alto sugerido
        );
    }

    private void abrirVentana(String fxmlPath, String title, double width, double height) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlPath));
            Scene scene = new Scene(fxmlLoader.load());

            Stage newStage = new Stage();
            newStage.setTitle(title);
            newStage.setScene(scene);

            // Configuración de tamaño
            newStage.setWidth(width);
            newStage.setHeight(height);

            // Centrar ventana
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