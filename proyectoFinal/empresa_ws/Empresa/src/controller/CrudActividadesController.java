package controller;

import application.Aplicacion;
import javafx.event.ActionEvent;
import model.Empresa;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class CrudActividadesController {
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
    private Tab tabMisActividades;

    @FXML
    private Button btnCerrarSesion;

    @FXML
    private Button btnActualizarActividad;

    @FXML
    private ComboBox<?> cboxSeleccionarUsuario;

    @FXML
    private Button btnVerMisTareas;

    @FXML
    private Button btnEliminarActividad;

    @FXML
    private ComboBox<?> cboxVerificarUsuario;

    @FXML
    private CheckBox cbkObligatorio;

    @FXML
    private Button btnCrearActividad;

    @FXML
    private CheckBox cbkOpcional;

    @FXML
    private TableColumn<?, ?> col_DescripcionActividad;

    @FXML
    private TableColumn<?, ?> col_NombreActividad;

    @FXML
    private Button btnRegresarMisProcesos;

    @FXML
    private TableView<?> tblActividades;

    @FXML
    private TextField txtDescripcionActividad;

    @FXML
    private Tab tabCrearActividades;

    @FXML
    private TableColumn<?, ?> col_TiempoMaximoActividad;

    @FXML
    private Button btnBuscarActividad;

    @FXML
    private ComboBox<?> cboxVerificarProceso;

    @FXML
    private ComboBox<?> cboxSeleccionarActividad;

    @FXML
    private CheckBox cbkFinal;

    @FXML
    private TableColumn<?, ?> col_TiempoMinimoActividad;

    @FXML
    private ImageView cbkDespues;

    @FXML
    private TextField txtTiempoMinimoActividad;

    @FXML
    private TextField txtTiempoMaximoActividad;

    @FXML
    private ComboBox<?> cboxSeleccionarProceso;

    @FXML
    private TextField txtNombreActividad;

    @FXML
    void cerrarSesion(ActionEvent event) {
        singleton.mostrarLogin("/view/Login.fxml");
        singleton.cerrarSesion();
    }

    @FXML
    void regresarMisProcesos(ActionEvent event) {
        singleton.mostrarCrudProcesos("/view/CrudProcesos.fxml");
    }

    @FXML
    void verMisTareas(ActionEvent event) {
        singleton.mostrarTareas("/view/CrudTareas.fxml");

    }

    @FXML
    void buscarActividad(ActionEvent event) {

    }

    @FXML
    void eliminarActividad(ActionEvent event) {

    }

    @FXML
    void actualizarActividad(ActionEvent event) {

    }

    @FXML
    void crearActividad(ActionEvent event) {

    }


}
