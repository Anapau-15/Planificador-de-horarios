module mx.edu.utez.fxa.demo {
    requires javafx.controls;
    requires javafx.fxml;


    opens mx.edu.utez.fxa.demo to javafx.fxml;
    exports mx.edu.utez.fxa.demo;
}