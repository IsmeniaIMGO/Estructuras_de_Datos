package controller;

import application.Aplicacion;
import javafx.event.ActionEvent;
import model.Empresa;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class CrudProcesosController {
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
    private Button btnVerMisActividades;

    @FXML
    private Button btnNotificaciones;

    @FXML
    private TextField txtNombreProceso;

    @FXML
    private TextField txtTiempoMaximoProceso;

    @FXML
    private Button btnCerrarSesion;

    @FXML
    private Button btnEliminarProceso;

    @FXML
    private TableView<?> tblProcesos;

    @FXML
    private TextField txtCodigoProceso;

    @FXML
    private ChoiceBox<?> cbxUsuarioProceso;

    @FXML
    private Tab tabMisProcesos;

    @FXML
    private Button btnCrearProceso;

    @FXML
    private Button btnActualizarProceso;

    @FXML
    private TableColumn<?, ?> col_NombreProceso;

    @FXML
    private Tab tabCrearProcesos;

    @FXML
    private TextField txtTiempoMinimoProceso;

    @FXML
    private TableColumn<?, ?> col_IdProceso;

    @FXML
    private TableColumn<?, ?> col_TiempoMinimo;

    @FXML
    private TableColumn<?, ?> col_TiempoMaximo;

    @FXML
    private Button btnBuscarProceso;

    @FXML
    void cerrarSesion(ActionEvent event) {

    }

    @FXML
    void notificaciones(ActionEvent event) {

    }

    @FXML
    void verMisActividades(ActionEvent event) {

    }

    @FXML
    void crearProceso(ActionEvent event) {

    }

    @FXML
    void actualizarProceso(ActionEvent event) {

    }

    @FXML
    void eeeeee(ActionEvent event) {

    }

    @FXML
    void verBuscarProceso(ActionEvent event) {

    }

    @FXML
    void eliminarProceso(ActionEvent event) {

    }


}
