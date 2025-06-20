module mx.edu.utez.proyectointegrador {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;

    opens mx.edu.utez.proyectointegrador to javafx.fxml;
    exports mx.edu.utez.proyectointegrador;
}