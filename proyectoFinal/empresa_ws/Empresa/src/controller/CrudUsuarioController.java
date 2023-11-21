package controller;

import application.Aplicacion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.*;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


public class CrudUsuarioController {
    Empresa empresa = Singleton.getInstance().getEmpresa();
    Singleton singleton = Singleton.getInstance();
    Aplicacion aplicacion;

    //Metodo set de aplicacion
    public void setAplicacion(Aplicacion aplicacion){
        this.aplicacion = aplicacion;
        singleton.setAplicacion(aplicacion);
    }

    //instancia de una lista para la tableview
    public ObservableList<Usuario> listaUsuarios = FXCollections.observableArrayList();
    private ObservableList<TipoUsuario> vistaListaTipoUsuario = FXCollections.observableArrayList();

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnEliminarUsuario"
    private Button btnEliminarUsuario; // Value injected by FXMLLoader

    @FXML // fx:id="tblUsuarios"
    private TableView<Usuario> tblUsuarios; // Value injected by FXMLLoader

    @FXML
    private TextField txtUsser; // Value injected by FXMLLoader

    @FXML // fx:id="txtNombreUsuario"
    private TextField txtPassword; // Value injected by FXMLLoader

    @FXML
    private TextField txtNombre; // Value injected by FXMLLoader


    @FXML // fx:id="cbkPremium"
    private CheckBox cbkPremium; // Value injected by FXMLLoader

    @FXML // fx:id="btnBuscarUsuario"
    private Button btnBuscarUsuario; // Value injected by FXMLLoader

    @FXML
    private TextField txtCedula; // Value injected by FXMLLoader

    @FXML // fx:id="col_CedulaUsuario"
    private TableColumn<Usuario, String> col_CedulaUsuario; // Value injected by FXMLLoader

    @FXML // fx:id="btnActualizarUsuario"
    private Button btnActualizarUsuario; // Value injected by FXMLLoader

    @FXML // fx:id="cboxTipoUsuario"
    private ComboBox<TipoUsuario> cboxTipoUsuario; // Value injected by FXMLLoader

    @FXML // fx:id="cbkGratis"
    private CheckBox cbkGratis; // Value injected by FXMLLoader

    @FXML // fx:id="btnIrLogin"
    private Button btnLogin; // Value injected by FXMLLoader

    @FXML // fx:id="btnCrearUsuario"
    private Button btnCrearUsuario; // Value injected by FXMLLoader

    @FXML // fx:id="col_TipoUsuario"
    private TableColumn<Usuario, TipoUsuario> col_TipoUsuario; // Value injected by FXMLLoader

    @FXML // fx:id="col_NombreUsuario"
    private TableColumn<Usuario, String> col_NombreUsuario; // Value injected by FXMLLoader

    @FXML
    void crearUsuario(ActionEvent event) throws Exception {
        crearUsuario();
        observarDatos();
        limpiarCampos();
    }

    @FXML
    void buscarUsuario(ActionEvent event) {
        buscarUsuario();


    }

    @FXML
    void eliminarUsuario(ActionEvent event) throws Exception {
        eliminarUsuario();
        observarDatos();
        limpiarCampos();
    }

    @FXML
    void actualizarUsuario(ActionEvent event) throws Exception {
        actualizarUsuario();
        observarDatos();
        limpiarCampos();
    }

    @FXML
    void abrirLogin(ActionEvent event) {
        singleton.mostrarLogin("/Laboratorio2/View/Login.fxml");

    }

    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() throws Exception {
        limpiarCampos();
        seleccionarElemento();
        observarDatos();

        cbkGratis.setOnAction(event -> {
            if (cbkGratis.isSelected()) {
                cbkPremium.setSelected(false);
            }
        });

        cbkPremium.setOnAction(event -> {
            if (cbkPremium.isSelected()) {
                cbkGratis.setSelected(false);
            }
        });


    }



    /**
     * Metodo que me permite crear un usuario obteniendo la informacion
     * de los campos de texto y con la logica creada en la clase empresa
     *
     * @throws Exception
     */
    private void crearUsuario() throws Exception {
        String usser = txtUsser.getText();
        String password = txtNombre.getText();
        String nombre = txtNombre.getText();
        String cedula = txtCedula.getText();
        TipoUsuario tipoUsuario = null;

        if (cbkGratis.isSelected()) {
            tipoUsuario = tipoUsuario.REGULAR;
        } else {
            if (cbkPremium.isSelected()) {
                tipoUsuario = tipoUsuario.PREMIUM;
            }
        }
        singleton.crearUsuario(usser, password, nombre, cedula, tipoUsuario);
    }

    private void buscarUsuario() {
        String cedula = txtCedula.getText();

        Usuario usuario = singleton.buscarUsuario(cedula);
        if (usuario != null) {
            txtUsser.setText(usuario.getUsser());
            txtPassword.setText(usuario.getPassword());
            txtCedula.setText(usuario.getCedula());
            txtNombre.setText(usuario.getNombre());
            if (usuario.getTipoUsuario() == TipoUsuario.REGULAR) {
                cbkGratis.setSelected(true);
                cbkPremium.setSelected(false);
            }else {
                if (usuario.getTipoUsuario() == TipoUsuario.PREMIUM) {
                    cbkGratis.setSelected(false);
                    cbkPremium.setSelected(true);
                }
            }
        }
    }

    private void actualizarUsuario() throws Exception {
        String usser = txtUsser.getText();
        String password = txtPassword.getText();
        String nombre = txtNombre.getText();
        String cedula = txtCedula.getText();
        TipoUsuario tipoUsuario = null;

        if (cbkGratis.isSelected()) {
            tipoUsuario = tipoUsuario.REGULAR;
        } else {
            if (cbkPremium.isSelected()) {
                tipoUsuario = tipoUsuario.PREMIUM;
            }
        }

        singleton.actualizarUsuario(usser, password, nombre, cedula, tipoUsuario);

    }

    private void eliminarUsuario() throws Exception {
        String cedula = txtCedula.getText();


        singleton.eliminarUsuario(cedula);
    }

    private void observarDatos(){
        col_CedulaUsuario.setCellValueFactory(new PropertyValueFactory<>("cedula"));
        col_NombreUsuario.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        col_TipoUsuario.setCellValueFactory(new PropertyValueFactory<>("tipoUsuario"));

        listaUsuarios.setAll(singleton.listaUsuarios());
        tblUsuarios.setItems(listaUsuarios);


    }


    private void seleccionarElemento(){
        tblUsuarios.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Usuario>() {
                    @Override
                    public void changed(ObservableValue<? extends Usuario> arg0, Usuario oldValue, Usuario usuarioSeleccionado ){
                        if (usuarioSeleccionado != null) {
                            txtUsser.setText(usuarioSeleccionado.getUsser());
                            txtPassword.setText(usuarioSeleccionado.getPassword());
                            txtCedula.setText(usuarioSeleccionado.getCedula());
                            txtNombre.setText(usuarioSeleccionado.getNombre());
                            if (usuarioSeleccionado.getTipoUsuario() == TipoUsuario.REGULAR) {
                                cbkGratis.setSelected(true);
                                cbkPremium.setSelected(false);
                            }else {
                                if (usuarioSeleccionado.getTipoUsuario() == TipoUsuario.PREMIUM) {
                                    cbkGratis.setSelected(false);
                                    cbkPremium.setSelected(true);
                                }
                            }
                        }
                    }
                }
        );
    }




    private void limpiarCampos() {
        txtCedula.setText("");
        txtCedula.setPromptText("Ingrese un nuevo Id");
        txtNombre.setText("");
        txtNombre.setPromptText("Ingrese un nombre");
        txtUsser.setText("");
        txtUsser.setPromptText("Ingrese un usuario");
        txtPassword.setText("");
        txtPassword.setPromptText("Ingrese una contraseña");
        cbkGratis.setSelected(false);;
        cbkPremium.setSelected(false);

        tblUsuarios.getSelectionModel().clearSelection();
    }

}
