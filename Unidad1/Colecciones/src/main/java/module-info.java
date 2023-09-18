module com.example.colecciones {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.colecciones to javafx.fxml;
    exports com.example.colecciones;
}