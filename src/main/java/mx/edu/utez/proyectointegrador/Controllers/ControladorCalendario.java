package mx.edu.utez.proyectointegrador.Controllers;

import com.calendarfx.view.CalendarView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.application.Platform;
import java.net.URL;
import java.util.ResourceBundle;

public class ControladorCalendario implements Initializable {
    @FXML
    private CalendarView calendarView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        calendarView.showMonthPage(); // Muestra la vista de mes por defecto

        // Espera a que la escena esté lista para buscar el botón
        Platform.runLater(() -> {
            removePrintButton();
        });
    }

    private void removePrintButton() {
        // Busca el botón de imprimir (puede variar según la versión de CalendarFX)
        Node printButton = calendarView.lookup("#print-button"); // Por ID
        if (printButton == null) {
            printButton = calendarView.lookup(".print-button");  // Por clase CSS
        }

        // Si lo encuentra, lo oculta
        if (printButton != null) {
            printButton.setVisible(false);
            printButton.setManaged(false); // Asegura que no ocupe espacio
        } else {
            System.err.println("No se encontró el botón de imprimir.");
        }
    }


}