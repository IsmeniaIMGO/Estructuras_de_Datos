package controller;

import application.Aplicacion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Empresa;

import javafx.fxml.FXML;
import model.Proceso;
import model.Usuario;

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

    private ObservableList<Proceso> vistaListaProcesos = FXCollections.observableArrayList();
    private ObservableList<Usuario> vistaUsuarioLogin = FXCollections.observableArrayList();

    @FXML // fx:id="btnVerMisActividades"
    private Button btnVerMisActividades; // Value injected by FXMLLoader

    @FXML // fx:id="btnNotificaciones"
    private Button btnNotificaciones; // Value injected by FXMLLoader

    @FXML // fx:id="txtNombreProceso"
    private TextField txtNombreProceso; // Value injected by FXMLLoader

    @FXML // fx:id="txtTiempoMaximoProceso"
    private TextField txtTiempoMaximoProceso; // Value injected by FXMLLoader

    @FXML
    private ComboBox<Usuario> cboxVerificarUsuario2;

    @FXML // fx:id="btnCerrarSesion"
    private Button btnCerrarSesion; // Value injected by FXMLLoader

    @FXML // fx:id="btnEliminarProceso"
    private Button btnEliminarProceso; // Value injected by FXMLLoader

    @FXML // fx:id="tblProcesos"
    private TableView<Proceso> tblProcesos; // Value injected by FXMLLoader

    @FXML // fx:id="txtCodigoProceso"
    private TextField txtCodigoProceso; // Value injected by FXMLLoader

    @FXML
    private ComboBox<Usuario> cboxVerificarUsuario1;


    @FXML // fx:id="tabMisProcesos"
    private Tab tabMisProcesos; // Value injected by FXMLLoader

    @FXML // fx:id="btnCrearProceso"
    private Button btnCrearProceso; // Value injected by FXMLLoader

    @FXML // fx:id="btnActualizarProceso"
    private Button btnActualizarProceso; // Value injected by FXMLLoader

    @FXML // fx:id="col_NombreProceso"
    private TableColumn<Proceso, String> col_NombreProceso; // Value injected by FXMLLoader

    @FXML // fx:id="tabCrearProcesos"
    private Tab tabCrearProcesos; // Value injected by FXMLLoader

    @FXML // fx:id="txtTiempoMinimoProceso"
    private TextField txtTiempoMinimoProceso; // Value injected by FXMLLoader

    @FXML // fx:id="col_IdProceso"
    private TableColumn<Proceso, String> col_IdProceso; // Value injected by FXMLLoader

    @FXML // fx:id="col_TiempoMinimo"
    private TableColumn<Proceso, Integer> col_TiempoMinimo; // Value injected by FXMLLoader

    @FXML // fx:id="col_TiempoMaximo"
    private TableColumn<Proceso, Integer> col_TiempoMaximo; // Value injected by FXMLLoader

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
    void crearProceso(ActionEvent event) throws Exception {
        CrearProceso();
        limpiarCampos();

    }


    @FXML
    void actualizarProceso(ActionEvent event) {
        ActualizarProceso();
        limpiarCampos();

    }


    @FXML
    void verBuscarProceso(ActionEvent event) {
        BuscarProceso();
    }

    @FXML
    void eliminarProceso(ActionEvent event) throws Exception {
        EliminarProceso();
        limpiarCampos();

    }


    @FXML
    void mostrarLista(ActionEvent event) {
        Usuario usuario = cboxVerificarUsuario1.getValue();
        observarDatos(usuario);
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        limpiarCampos();

        vistaUsuarioLogin.setAll(singleton.obtenerUsuarioLogin());
        cboxVerificarUsuario1.setItems(vistaUsuarioLogin);
        cboxVerificarUsuario2.setItems(vistaUsuarioLogin);

    }


    private void CrearProceso() throws Exception {
        Usuario usuario = cboxVerificarUsuario2.getValue();
        String nombre = txtNombreProceso.getText();
        String codigo = txtCodigoProceso.getText();

        singleton.crearProceso(usuario, codigo, nombre);
    }


    private void ActualizarProceso() {
        Usuario usuario = cboxVerificarUsuario2.getValue();
        String nuevoNombre = txtNombreProceso.getText();
        String codigo = txtCodigoProceso.getText();

        singleton.actualizarProceso(usuario, codigo, nuevoNombre);
    }


    private void BuscarProceso() {
        Usuario usuario = cboxVerificarUsuario2.getValue();
        String codigo = txtCodigoProceso.getText();

        Proceso proceso = singleton.buscarProceso(usuario, codigo);

        txtNombreProceso.setText(proceso.getNombre());
        txtCodigoProceso.setText(proceso.getId());
        txtTiempoMaximoProceso.setText(String.valueOf(proceso.getTiempoMaximo()));
        txtTiempoMinimoProceso.setText(String.valueOf(proceso.getTiempoMinimo()));
    }


    private void EliminarProceso() throws Exception {
        Usuario usuario = cboxVerificarUsuario2.getValue();
        String codigo = txtCodigoProceso.getText();

        singleton.eliminarProceso(usuario, codigo);
    }


    private void observarDatos(Usuario usuario) {
        col_IdProceso.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_NombreProceso.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        col_TiempoMaximo.setCellValueFactory(new PropertyValueFactory<>("tiempoMaximo"));
        col_TiempoMinimo.setCellValueFactory(new PropertyValueFactory<>("tiempoMinimo"));

        vistaListaProcesos.setAll(singleton.listaProcesos(usuario));
        tblProcesos.setItems(vistaListaProcesos);


    }




    private void limpiarCampos() {
        txtCodigoProceso.setText("");
        txtCodigoProceso.setPromptText("Ingrese el codigo de su proceso");
        txtNombreProceso.setText("");
        txtNombreProceso.setPromptText("Ingrese el nombre de su proceso");
        txtTiempoMaximoProceso.setText("");
        txtTiempoMinimoProceso.setText("");

        cboxVerificarUsuario1.getSelectionModel().clearSelection();
        cboxVerificarUsuario2.getSelectionModel().clearSelection();
        tblProcesos.getSelectionModel().clearSelection();
        tblProcesos.setItems(null);

    }


    }
