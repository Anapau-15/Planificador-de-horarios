module mx.edu.utez.proyectointegrador {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires java.desktop;
    requires com.calendarfx.view;
    requires java.sql;
    requires ucp;

    opens mx.edu.utez.proyectointegrador to javafx.fxml;
    exports mx.edu.utez.proyectointegrador.Controllers;
    opens mx.edu.utez.proyectointegrador.Controllers to javafx.fxml;
    exports mx.edu.utez.proyectointegrador.models;
    opens mx.edu.utez.proyectointegrador.models to javafx.fxml;
}