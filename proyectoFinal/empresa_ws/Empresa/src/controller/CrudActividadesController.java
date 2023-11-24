package controller;

import application.Aplicacion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import model.*;

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

    private ObservableList<DetalleProceso> vistaListaActividades = FXCollections.observableArrayList();
    private ObservableList<Proceso> vistaListaProcesos = FXCollections.observableArrayList();
    private ObservableList<Usuario> vistaUsuarioLogin = FXCollections.observableArrayList();


    @FXML
    private Button btnIntercambiar;

    @FXML
    private Tab tabMisActividades;

    @FXML
    private Button btnCerrarSesion;

    @FXML
    private Button btnActualizarActividad;

    @FXML
    private ComboBox<Usuario> cboxSeleccionarUsuario;

    @FXML
    private Button btnVerMisTareas;

    @FXML
    private Button btnEliminarActividad;

    @FXML
    private ComboBox<Usuario> cboxVerificarUsuario;

    @FXML
    private CheckBox cbkObligatorio;

    @FXML
    private Button btnCrearActividad;

    @FXML
    private CheckBox cbkOpcional;

    @FXML
    private TableColumn<DetalleProceso, Actividad> col_NombreActividad;

    @FXML
    private Button btnRegresarMisProcesos;

    @FXML
    private TableView<DetalleProceso> tblActividades;

    @FXML
    private TextField txtDescripcionActividad;

    @FXML
    private Tab tabCrearActividades;

    @FXML
    private Button btnBuscarActividad;

    @FXML
    private ComboBox<Proceso> cboxVerificarProceso;

    @FXML
    private ComboBox<DetalleProceso> cboxSeleccionarActividad;

    @FXML
    private CheckBox cbkFinal;

    @FXML
    private CheckBox cbkDespues;

    @FXML
    private TextField txtTiempoMinimoActividad;

    @FXML
    private TextField txtTiempoMaximoActividad;

    @FXML
    private ComboBox<Proceso> cboxSeleccionarProceso;

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
    void buscarActividad(ActionEvent event) throws Exception {
        //BuscarActividad();

    }

    private void BuscarActividad() throws Exception {
        /*String nombre = txtNombreActividad.getText();

        Actividad actividad = singleton.buscarActividad(nombre);

        //txtNombreActividad.setText(actividad.getNombre());
        txtDescripcionActividad.setText(actividad.getDescripcion());
        txtTiempoMaximoActividad.setText(String.valueOf(actividad.getTiempoMaximo()));
        txtTiempoMinimoActividad.setText(String.valueOf(actividad.getTiempoMinimo()));

        TipoCumplimiento tipoCumplimiento =  actividad.getTipoCumplimiento();

        if (tipoCumplimiento==tipoCumplimiento.OBLIGATORIO){
            cbkObligatorio.setSelected(true);
        } else if (tipoCumplimiento==tipoCumplimiento.OPCIONAL) {
            cbkOpcional.setSelected(true);
        }*/


    }

    @FXML
    void eliminarActividad(ActionEvent event) {

    }

    @FXML
    void actualizarActividad(ActionEvent event) {

    }

    @FXML
    void crearActividad(ActionEvent event) throws Exception {
        CrearActividad();
        limpiarCampos();

    }

    @FXML
    void intercambiarActividades(ActionEvent event) {
        singleton.mostrarIntercambios("/view/Intercambios.fxml");

    }

    @FXML
    void cargarActividades(ActionEvent event) {
        Usuario usuario = cboxSeleccionarUsuario .getValue();
        Proceso proceso = cboxSeleccionarProceso.getValue();
        observarDatos(usuario, proceso);

    }

    @FXML
    void cargarProcesos1(ActionEvent event) {
        Usuario usuario = cboxSeleccionarUsuario.getValue();

        vistaListaProcesos.setAll(singleton.obtenerProcesosUsuario(usuario));
        cboxSeleccionarProceso.setItems(vistaListaProcesos);


    }

    @FXML
    void cargarProcesos2(ActionEvent event) {
        Usuario usuario = cboxVerificarUsuario.getValue();

        vistaListaProcesos.setAll(singleton.obtenerProcesosUsuario(usuario));
        cboxVerificarProceso.setItems(vistaListaProcesos);

    }


    @FXML
    void cargarActividadesCrud(ActionEvent event) {

        Usuario usuario = cboxVerificarUsuario.getValue();
        Proceso proceso = cboxVerificarProceso.getValue();

        vistaListaActividades.setAll(singleton.obtenerActividadesUsuario(usuario, proceso));
        cboxSeleccionarActividad.setItems(vistaListaActividades);
    }


    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        limpiarCampos();
        vistaUsuarioLogin.setAll(singleton.obtenerUsuarioLogin());
        cboxSeleccionarUsuario.setItems(vistaUsuarioLogin);
        cboxVerificarUsuario.setItems(vistaUsuarioLogin);

        cbkObligatorio.setOnAction(event -> {
            if (cbkObligatorio.isSelected()) {
                cbkOpcional.setSelected(false);
            }
        });

        cbkOpcional.setOnAction(event -> {
            if (cbkOpcional.isSelected()) {
                cbkObligatorio.setSelected(false);
            }
        });


        cbkFinal.setOnAction(event -> {
            if (cbkDespues.isSelected()) {
                cbkFinal.setSelected(false);
            }
        });

        cbkDespues.setOnAction(event -> {
            if (cbkFinal.isSelected()) {
                cbkDespues.setSelected(false);
            }
        });

    }


    private void CrearActividad() throws Exception {
        Usuario usuario = cboxVerificarUsuario.getValue();
        Proceso proceso = cboxVerificarProceso.getValue();

        String nombre = txtNombreActividad.getText();
        String descripcion = txtDescripcionActividad.getText();
        TipoCumplimiento tipoCumplimiento = null;

        if (cbkObligatorio.isSelected()) {
            tipoCumplimiento = tipoCumplimiento.OBLIGATORIO;
        } else {
            if (cbkOpcional.isSelected()) {
                tipoCumplimiento = tipoCumplimiento.OPCIONAL;
            }
        }

        String posicion = null;
        DetalleProceso detalle = cboxSeleccionarActividad.getValue();
        Actividad actividad = null;

        if (cbkFinal.isSelected()) {
            posicion = "final";
        } else {
            if (cbkDespues.isSelected()) {
                posicion = "despues";
                actividad = detalle.getActividad();
            }
        }

        singleton.crearActividad(usuario, proceso,nombre,descripcion, tipoCumplimiento, posicion, actividad);

    }



    private void observarDatos(Usuario usuario, Proceso proceso) {
        col_NombreActividad.setCellValueFactory(new PropertyValueFactory<>("actividad"));

        vistaListaActividades.setAll(singleton.obtenerActividadesUsuario(usuario, proceso));
        tblActividades.setItems(vistaListaActividades);

    }


    private void limpiarCampos() {
        txtNombreActividad.setText("");
        txtNombreActividad.setPromptText("Ingrese el nombre");
        txtDescripcionActividad.setText("");
        txtDescripcionActividad.setPromptText("ingrese descripcion");
        txtTiempoMaximoActividad.setText("");
        txtTiempoMaximoActividad.setPromptText("");
        txtTiempoMinimoActividad.setPromptText("");

        cboxVerificarUsuario.getSelectionModel().clearSelection();
        cboxVerificarProceso.getSelectionModel().clearSelection();
        cboxSeleccionarUsuario.getSelectionModel().clearSelection();
        cboxSeleccionarProceso.getSelectionModel().clearSelection();
        cboxSeleccionarActividad.getSelectionModel().clearSelection();

        tblActividades.getSelectionModel().clearSelection();

    }
}
