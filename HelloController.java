package mx.edu.utez.proyectointegrador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloController {
    @FXML
    private Button OnLoginButton;

    @FXML
    private void Crear(ActionEvent event) {
        abrirVentana(
                "/mx/edu/utez/proyectointegrador/botonCrear.fxml",
                "Crear Calendario",
                419,  // Ancho para Crear
                304   // Alto para Crear
        );
    }

    @FXML
    private void Vista(ActionEvent event) {
        abrirVentana(
                "/mx/edu/utez/proyectointegrador/Vistas.fxml",
                "Vistas",
                140,  // Ancho para Vista
                180  // Alto para Vista
        );
    }

    @FXML
    private void CompartirCalendario(ActionEvent event) {
        abrirVentana(
                "/mx/edu/utez/proyectointegrador/BotonCompartir.fxml",
                "Compartir Calendario",
                615,  // Ancho para calendario
                438   // Alto para notifiaciones
        );
    }

    @FXML
    private void MostrarNotificaciones(ActionEvent event) {
        abrirVentana(
                "/mx/edu/utez/proyectointegrador/BotonNotificacion.fxml",
                "Notificaciones Recibidas",
                415,
                338
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