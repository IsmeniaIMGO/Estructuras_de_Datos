module Empresa{
    requires javafx.controls;
    requires javafx.fxml;

    opens controller to javafx.fxml;
    opens model to javafx.base;

    exports application;
}

