module com.example.colecciones {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;

    opens com.example.colecciones to javafx.fxml;
    exports com.example.colecciones;
}