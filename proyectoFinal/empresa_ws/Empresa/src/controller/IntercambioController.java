package controller;

import application.Aplicacion;
import javafx.event.ActionEvent;
import model.Empresa;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class IntercambioController {
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
    private Button btnIntercambio;

    @FXML
    private ComboBox<?> cboxVerificarProceso;

    @FXML
    private ComboBox<?> cboxSeleccionActividad2;

    @FXML
    private ComboBox<?> cboxSeleccionActividad1;

    @FXML
    private ComboBox<?> cboxVerificarUsuario;

    @FXML
    private Button btnRegresaAActividades;

    @FXML
    void intercambiarActividades(ActionEvent event) {

    }


    @FXML
    void regresarActividades(ActionEvent event) {
        singleton.mostrarActividades("/view/CrudActividades.fxml");

    }

}
