package controller;

import application.Aplicacion;
import javafx.event.ActionEvent;
import model.Empresa;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class NotificacionesController {
    /**
     * atributos
     */
    Empresa empresa = Singleton.getInstance().getEmpresa();
    Singleton singleton = Singleton.getInstance();
    Aplicacion aplicacion;

    //Metodo set de aplicacion
    public void setAplicacion(Aplicacion aplicacion){
        this.aplicacion = aplicacion;
        singleton.setAplicacion(aplicacion);
    }

    @FXML
    private Button btnRegresarMisProcesos;

    @FXML
    private TableView<?> tblNotificaciones;

    @FXML
    private TableColumn<?, ?> colNotificaciones;

    @FXML
    void regresarMisProcesos(ActionEvent event) {
        singleton.mostrarCrudProcesos("/view/CrudProcesos.fxml");

    }

}
