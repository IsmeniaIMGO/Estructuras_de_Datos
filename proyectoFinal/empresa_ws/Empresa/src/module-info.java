module com.example.empresa {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;

    opens com.example.empresa to javafx.fxml;
    exports com.example.empresa;
}