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

    @FXML // fx:id="btnVerMisActividades"
    private Button btnVerMisActividades; // Value injected by FXMLLoader

    @FXML // fx:id="btnNotificaciones"
    private Button btnNotificaciones; // Value injected by FXMLLoader

    @FXML // fx:id="txtNombreProceso"
    private TextField txtNombreProceso; // Value injected by FXMLLoader

    @FXML // fx:id="txtTiempoMaximoProceso"
    private TextField txtTiempoMaximoProceso; // Value injected by FXMLLoader

    @FXML // fx:id="cbxUsuarioCrudProceso"
    private ChoiceBox<?> cbxUsuarioCrudProceso; // Value injected by FXMLLoader

    @FXML // fx:id="btnCerrarSesion"
    private Button btnCerrarSesion; // Value injected by FXMLLoader

    @FXML // fx:id="btnEliminarProceso"
    private Button btnEliminarProceso; // Value injected by FXMLLoader

    @FXML // fx:id="tblProcesos"
    private TableView<?> tblProcesos; // Value injected by FXMLLoader

    @FXML // fx:id="txtCodigoProceso"
    private TextField txtCodigoProceso; // Value injected by FXMLLoader

    @FXML // fx:id="cbxUsuarioProceso"
    private ChoiceBox<?> cbxUsuarioProceso; // Value injected by FXMLLoader

    @FXML // fx:id="tabMisProcesos"
    private Tab tabMisProcesos; // Value injected by FXMLLoader

    @FXML // fx:id="btnCrearProceso"
    private Button btnCrearProceso; // Value injected by FXMLLoader

    @FXML // fx:id="btnActualizarProceso"
    private Button btnActualizarProceso; // Value injected by FXMLLoader

    @FXML // fx:id="col_NombreProceso"
    private TableColumn<?, ?> col_NombreProceso; // Value injected by FXMLLoader

    @FXML // fx:id="tabCrearProcesos"
    private Tab tabCrearProcesos; // Value injected by FXMLLoader

    @FXML // fx:id="txtTiempoMinimoProceso"
    private TextField txtTiempoMinimoProceso; // Value injected by FXMLLoader

    @FXML // fx:id="col_IdProceso"
    private TableColumn<?, ?> col_IdProceso; // Value injected by FXMLLoader

    @FXML // fx:id="col_TiempoMinimo"
    private TableColumn<?, ?> col_TiempoMinimo; // Value injected by FXMLLoader

    @FXML // fx:id="col_TiempoMaximo"
    private TableColumn<?, ?> col_TiempoMaximo; // Value injected by FXMLLoader

    @FXML // fx:id="btnBuscarProceso"
    private Button btnBuscarProceso; // Value injected by FXMLLoader

    @FXML
    void cerrarSesion(ActionEvent event) {
        singleton.mostrarLogin("/view/Login.fxml");
        singleton.cerrarSesion();
    }

    @FXML
    void notificaciones(ActionEvent event) {
        singleton.mostrarNotificaciones("/view/Notificaciones.fxml");
    }

    @FXML
    void verMisActividades(ActionEvent event) {
        singleton.mostrarActividades("/view/CrudActividades.fxml");
    }

    @FXML
    void crearProceso(ActionEvent event) {

    }

    @FXML
    void actualizarProceso(ActionEvent event) {

    }

    @FXML
    void verBuscarProceso(ActionEvent event) {

    }

    @FXML
    void eliminarProceso(ActionEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnVerMisActividades != null : "fx:id=\"btnVerMisActividades\" was not injected: check your FXML file 'CrudProcesos.fxml'.";
        assert btnNotificaciones != null : "fx:id=\"btnNotificaciones\" was not injected: check your FXML file 'CrudProcesos.fxml'.";
        assert txtNombreProceso != null : "fx:id=\"txtNombreProceso\" was not injected: check your FXML file 'CrudProcesos.fxml'.";
        assert txtTiempoMaximoProceso != null : "fx:id=\"txtTiempoMaximoProceso\" was not injected: check your FXML file 'CrudProcesos.fxml'.";
        assert cbxUsuarioCrudProceso != null : "fx:id=\"cbxUsuarioCrudProceso\" was not injected: check your FXML file 'CrudProcesos.fxml'.";
        assert btnCerrarSesion != null : "fx:id=\"btnCerrarSesion\" was not injected: check your FXML file 'CrudProcesos.fxml'.";
        assert btnEliminarProceso != null : "fx:id=\"btnEliminarProceso\" was not injected: check your FXML file 'CrudProcesos.fxml'.";
        assert tblProcesos != null : "fx:id=\"tblProcesos\" was not injected: check your FXML file 'CrudProcesos.fxml'.";
        assert txtCodigoProceso != null : "fx:id=\"txtCodigoProceso\" was not injected: check your FXML file 'CrudProcesos.fxml'.";
        assert cbxUsuarioProceso != null : "fx:id=\"cbxUsuarioProceso\" was not injected: check your FXML file 'CrudProcesos.fxml'.";
        assert tabMisProcesos != null : "fx:id=\"tabMisProcesos\" was not injected: check your FXML file 'CrudProcesos.fxml'.";
        assert btnCrearProceso != null : "fx:id=\"btnCrearProceso\" was not injected: check your FXML file 'CrudProcesos.fxml'.";
        assert btnActualizarProceso != null : "fx:id=\"btnActualizarProceso\" was not injected: check your FXML file 'CrudProcesos.fxml'.";
        assert col_NombreProceso != null : "fx:id=\"col_NombreProceso\" was not injected: check your FXML file 'CrudProcesos.fxml'.";
        assert tabCrearProcesos != null : "fx:id=\"tabCrearProcesos\" was not injected: check your FXML file 'CrudProcesos.fxml'.";
        assert txtTiempoMinimoProceso != null : "fx:id=\"txtTiempoMinimoProceso\" was not injected: check your FXML file 'CrudProcesos.fxml'.";
        assert col_IdProceso != null : "fx:id=\"col_IdProceso\" was not injected: check your FXML file 'CrudProcesos.fxml'.";
        assert col_TiempoMinimo != null : "fx:id=\"col_TiempoMinimo\" was not injected: check your FXML file 'CrudProcesos.fxml'.";
        assert col_TiempoMaximo != null : "fx:id=\"col_TiempoMaximo\" was not injected: check your FXML file 'CrudProcesos.fxml'.";
        assert btnBuscarProceso != null : "fx:id=\"btnBuscarProceso\" was not injected: check your FXML file 'CrudProcesos.fxml'.";


    }

    }
