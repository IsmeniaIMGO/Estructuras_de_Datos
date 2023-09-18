package Laboratorio2.Controller;


import java.net.URL;
import java.util.ResourceBundle;

import Laboratorio2.Application.Aplicacion;
import Laboratorio2.Model.Biblioteca;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class CrudUsuarioController {

    /**
     * atributos
     */
    Biblioteca biblioteca = Singleton.getInstance().getBiblioteca();

    Singleton singleton = Singleton.getInstance();
    Aplicacion aplicacion;

    //Metodo set de aplicacion
    public void setAplicacion(Aplicacion aplicacion){
        this.aplicacion = aplicacion;
        singleton.setAplicacion(aplicacion);
    }

    @FXML
    private Button btnEliminarUsuario;

    @FXML
    private TableView<?> tblUsuarios;

    @FXML
    private TextField txtIdUsuario;

    @FXML
    private CheckBox cbkComprador;

    @FXML
    private TextField txtNombreUsuario;

    @FXML
    private Button btnBuscarUsuario;

    @FXML
    private TextField txtEdadUsuario;

    @FXML
    private TableColumn<?, ?> col_CedulaUsuario;

    @FXML
    private Button btnActualizarUsuario;

    @FXML
    private Button btnIrLogin;

    @FXML
    private Button btnCrearUsuario;

    @FXML
    private TableColumn<?, ?> col_TipoUsuario;

    @FXML
    private TableColumn<?, ?> col_NombreUsuario;

    @FXML
    private CheckBox cbkAnunciante;

    @FXML
    void CrearUsuario(ActionEvent event) {

    }

    @FXML
    void ActualizarUsuario(ActionEvent event) {

    }

    @FXML
    void EliminarUsuario(ActionEvent event) {

    }

    @FXML
    void buscarUsuario(ActionEvent event) {

    }

    @FXML
    void AbrirLogin(ActionEvent event) {

    }

    @FXML
    void initialize() {

    }
}