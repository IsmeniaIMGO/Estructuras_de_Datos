module Colecciones {


    requires javafx.controls;
    requires javafx.fxml;
    requires com.dlsc.formsfx;

    opens Laboratorio2.Controller to javafx.fxml;
    exports Laboratorio2.Application;

}