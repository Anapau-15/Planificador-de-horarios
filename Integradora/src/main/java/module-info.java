module mx.edu.utez.integradora {
    requires javafx.controls;
    requires javafx.fxml;


    opens mx.edu.utez.integradora to javafx.fxml;
    exports mx.edu.utez.integradora;
}