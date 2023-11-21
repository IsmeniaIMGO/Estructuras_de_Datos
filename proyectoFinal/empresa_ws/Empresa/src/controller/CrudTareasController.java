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

public class CrudTareasController {
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
    private ComboBox<?> btnVerificarAtividad;

    @FXML
    private CheckBox cbkFinalizado;

    @FXML
    private Button btnCerrarSesion;

    @FXML
    private TableColumn<?, ?> col_DescripcionTarea;

    @FXML
    private TableColumn<?, ?> col_EstadoTarea;

    @FXML
    private TableView<?> tblTareas;

    @FXML
    private ComboBox<?> cboxVerificarUsuario;

    @FXML
    private CheckBox cbkObligatorio;

    @FXML
    private TextField txtTiempoTarea;

    @FXML
    private TableColumn<?, ?> col_TiempoTarea;

    @FXML
    private ComboBox<?> cboxSeleccionUsuario;

    @FXML
    private Tab tabCrearTareas;

    @FXML
    private CheckBox cbkOpcional;

    @FXML
    private Button btnBuscarTarea;

    @FXML
    private TableColumn<?, ?> col_NombreTarea;

    @FXML
    private CheckBox cbkPendiente;

    @FXML
    private TextField txtNombreTarea;

    @FXML
    private ComboBox<?> cboxSeleccionarAtividad;

    @FXML
    private TableColumn<?, ?> col_CumplimientoTarea;

    @FXML
    private Button btnActualizarTarea;

    @FXML
    private Button btnEliminarTarea;

    @FXML
    private Tab tabMisTareas;

    @FXML
    private ComboBox<?> cboxTareas;

    @FXML
    private Button btnCrearTarea;

    @FXML
    private ComboBox<?> cboxVerificarProceso;

    @FXML
    private CheckBox cbkFinal;

    @FXML
    private CheckBox cbkDespues;

    @FXML
    private TextField txtDescripcionTarea;

    @FXML
    private Button btnRegresarMisActividades;

    @FXML
    private ComboBox<?> cboxSeleccionarProceso;

    @FXML
    void cerrarSesion(ActionEvent event) {
        singleton.mostrarLogin("/view/Login.fxml");
        singleton.cerrarSesion();
    }

    @FXML
    void regresarMisActividades(ActionEvent event) {
        singleton.mostrarActividades("/view/CrudActividades.fxml");
    }

    @FXML
    void buscarTarea(ActionEvent event) {

    }

    @FXML
    void eliminarTarea(ActionEvent event) {

    }

    @FXML
    void actualizarTarea(ActionEvent event) {

    }

    @FXML
    void crearTarea(ActionEvent event) {

    }

}
