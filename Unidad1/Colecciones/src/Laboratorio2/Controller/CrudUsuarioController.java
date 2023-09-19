/**
 * Sample Skeleton for 'CrudUsuario.fxml' Controller Class
 */
package Laboratorio2.Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Set;

import Laboratorio2.Application.Aplicacion;
import Laboratorio2.Model.Biblioteca;
import Laboratorio2.Model.TipoUsuario;
import Laboratorio2.Model.Usuario;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

    /**
     * atributos
     */
    Biblioteca biblioteca = Singleton.getInstance().getBiblioteca();

    Singleton singleton = Singleton.getInstance();
    Aplicacion aplicacion;

    //Metodo set de aplicacion
    public void setAplicacion(Aplicacion aplicacion) {
        this.aplicacion = aplicacion;
        singleton.setAplicacion(aplicacion);
    }

    //instancia de una lista para la tableview
    public ObservableList<Usuario> listaUsuarios = FXCollections.observableArrayList();
    private ObservableList<TipoUsuario> vistaListaTipoUsuario = FXCollections.observableArrayList();

    public ObservableList<Usuario> listaEstudiantes = FXCollections.observableArrayList();


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
    private TextField txtNombreUsuario; // Value injected by FXMLLoader


    @FXML // fx:id="cbkBibliotecario"
    private CheckBox cbkBibliotecario; // Value injected by FXMLLoader

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

    @FXML // fx:id="cbkEstudiante"
    private CheckBox cbkEstudiante; // Value injected by FXMLLoader

    @FXML // fx:id="btnIrLogin"
    private Button btnIrLogin; // Value injected by FXMLLoader

    @FXML // fx:id="btnCrearUsuario"
    private Button btnCrearUsuario; // Value injected by FXMLLoader

    @FXML // fx:id="col_TipoUsuario"
    private TableColumn<Usuario, TipoUsuario> col_TipoUsuario; // Value injected by FXMLLoader

    @FXML // fx:id="col_NombreUsuario"
    private TableColumn<Usuario, String> col_NombreUsuario; // Value injected by FXMLLoader

    @FXML
    void CrearUsuario(ActionEvent event) throws Exception {
        crearUsuario();
        observarDatos();
        limpiarCampos();
    }

    @FXML
    void buscarUsuario(ActionEvent event) {
        buscarUsuario();
        observarDatos();


    }

    @FXML
    void EliminarUsuario(ActionEvent event) throws Exception {
        eliminarUsuario();
        observarDatos();
        limpiarCampos();
    }

    @FXML
    void ActualizarUsuario(ActionEvent event) throws Exception {
        actualizarUsuario();
        observarDatos();
        limpiarCampos();
    }

    @FXML
    void AbrirLogin(ActionEvent event) {
        singleton.mostrarLogin("/Laboratorio2/View/Login.fxml");

    }

    @FXML
    void Ordenar(ActionEvent event) {
        observarDatos();

    }

    @FXML
        // This method is called by the FXMLLoader when initialization is complete
    void initialize() throws Exception {
        limpiarCampos();
        seleccionarElemento();
        observarDatos();
    }



    /**
     * Metodo que me permite crear un usuario obteniendo la informacion
     * de los campos de texto y con la logica creada en la clase empresa
     *
     * @throws Exception
     */
    private void crearUsuario() throws Exception {
        String usser = txtUsser.getText();
        String password = txtNombreUsuario.getText();
        String nombre = txtNombreUsuario.getText();
        String cedula = txtCedula.getText();
        TipoUsuario tipoUsuario = null;

        if (cbkEstudiante.isSelected()) {
            tipoUsuario = tipoUsuario.ESTUDIANTE;
        } else {
            if (cbkBibliotecario.isSelected()) {
                tipoUsuario = tipoUsuario.BIBLIOTECARIO;
            }
        }
        singleton.crearUsuario(usser, password, nombre, cedula, tipoUsuario);
    }

    private void buscarUsuario() {
        String cedula = txtCedula.getText();

        Usuario usuario = singleton.buscarUsuario(cedula);
        if (usuario != null) {
            txtUsser.setText(usuario.getUsser());
            txtCedula.setText(usuario.getCedula());
            txtNombreUsuario.setText(usuario.getNombre());
            if (usuario.getTipoUsuario() == TipoUsuario.ESTUDIANTE) {
                cbkEstudiante.setSelected(true);
                cbkBibliotecario.setSelected(false);
            }else {
                if (usuario.getTipoUsuario() == TipoUsuario.BIBLIOTECARIO) {
                    cbkEstudiante.setSelected(false);
                    cbkBibliotecario.setSelected(true);
                }
            }
        }
    }

    private void actualizarUsuario() throws Exception {
        String usser = txtUsser.getText();
        String password = txtNombreUsuario.getText();
        String nombre = txtNombreUsuario.getText();
        String cedula = txtCedula.getText();
        TipoUsuario tipoUsuario = null;

        if (cbkEstudiante.isSelected()) {
            tipoUsuario = tipoUsuario.ESTUDIANTE;
        } else {
            if (cbkBibliotecario.isSelected()) {
                tipoUsuario = tipoUsuario.BIBLIOTECARIO;
            }
        }

        singleton.actualizarUsuario(usser, password, nombre, cedula, tipoUsuario);

    }

    private void eliminarUsuario() throws Exception {
        String cedula = txtCedula.getText();
        TipoUsuario tipoUsuario = null;

        if (cbkEstudiante.isSelected()) {
            tipoUsuario = tipoUsuario.ESTUDIANTE;
        } else {
            if (cbkBibliotecario.isSelected()) {
                tipoUsuario = tipoUsuario.BIBLIOTECARIO;
            }
        }

        singleton.eliminarUsuario(cedula, tipoUsuario);
    }

    private void observarDatos(){
        col_CedulaUsuario.setCellValueFactory(new PropertyValueFactory<>("cedula"));
        col_NombreUsuario.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        col_TipoUsuario.setCellValueFactory(new PropertyValueFactory<>("tipoUsuario"));

        vistaListaTipoUsuario.setAll(TipoUsuario.ESTUDIANTE, TipoUsuario.BIBLIOTECARIO);
        cboxTipoUsuario.setItems(vistaListaTipoUsuario);

        if (cboxTipoUsuario.getValue() == TipoUsuario.ESTUDIANTE) {
            Set<Usuario> listaEstudiantes = singleton.obtenerListaUsuariosEstudiantes();
            listaUsuarios.setAll(listaEstudiantes);
            tblUsuarios.setItems(listaUsuarios);
        }
        if (cboxTipoUsuario.getValue() == TipoUsuario.BIBLIOTECARIO) {
            Set<Usuario> listaBibliotecarios = singleton.obtenerListaUsuariosBibliotecarios();
            listaUsuarios.setAll(listaBibliotecarios);
            tblUsuarios.setItems(listaUsuarios);
        }

        tblUsuarios.setItems(listaUsuarios);

    }


    private void seleccionarElemento(){
        tblUsuarios.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Usuario>() {
                    @Override
                    public void changed(ObservableValue<? extends Usuario> arg0, Usuario oldValue, Usuario usuarioSeleccionado ){
                        if (usuarioSeleccionado != null) {
                            txtCedula.setText(usuarioSeleccionado.getCedula());
                            txtNombreUsuario.setText(usuarioSeleccionado.getNombre());
                            if (usuarioSeleccionado.getTipoUsuario() == TipoUsuario.ESTUDIANTE) {
                                cbkEstudiante.setSelected(true);
                                cbkBibliotecario.setSelected(false);
                            }else {
                                if (usuarioSeleccionado.getTipoUsuario() == TipoUsuario.BIBLIOTECARIO) {
                                    cbkEstudiante.setSelected(false);
                                    cbkBibliotecario.setSelected(true);
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
        txtNombreUsuario.setText("");
        txtNombreUsuario.setPromptText("Ingrese un nombre");
        txtUsser.setText("");
        txtUsser.setPromptText("Ingrese un usuario");
        txtPassword.setText("");
        txtPassword.setPromptText("Ingrese una contraseña");
        cbkEstudiante.setSelected(false);;
        cbkBibliotecario.setSelected(false);

        tblUsuarios.getSelectionModel().clearSelection();
    }

}
