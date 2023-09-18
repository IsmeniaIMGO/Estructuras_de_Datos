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
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnEliminarUsuario;

    @FXML
    private TableColumn<?, ?> col_IdUsuario;

    @FXML
    private TableView<?> tblUsuarios;

    @FXML
    private TextField txtIdUsuario;

    @FXML
    private CheckBox cbkComprador;

    @FXML
    private TextField txtNombreUsuario;

    @FXML
    private TableColumn<?, ?> col_EdadUsuario;

    @FXML
    private Button limpiarCampos;

    @FXML
    private TextField txtEdadUsuario;

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
    void limpiarCampos(ActionEvent event) {

    }

    @FXML
    void AbrirLogin(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert btnEliminarUsuario != null : "fx:id=\"btnEliminarUsuario\" was not injected: check your FXML file 'CrudUsuario.fxml'.";
        assert col_IdUsuario != null : "fx:id=\"col_IdUsuario\" was not injected: check your FXML file 'CrudUsuario.fxml'.";
        assert tblUsuarios != null : "fx:id=\"tblUsuarios\" was not injected: check your FXML file 'CrudUsuario.fxml'.";
        assert txtIdUsuario != null : "fx:id=\"txtIdUsuario\" was not injected: check your FXML file 'CrudUsuario.fxml'.";
        assert cbkComprador != null : "fx:id=\"cbkComprador\" was not injected: check your FXML file 'CrudUsuario.fxml'.";
        assert txtNombreUsuario != null : "fx:id=\"txtNombreUsuario\" was not injected: check your FXML file 'CrudUsuario.fxml'.";
        assert col_EdadUsuario != null : "fx:id=\"col_EdadUsuario\" was not injected: check your FXML file 'CrudUsuario.fxml'.";
        assert limpiarCampos != null : "fx:id=\"limpiarCampos\" was not injected: check your FXML file 'CrudUsuario.fxml'.";
        assert txtEdadUsuario != null : "fx:id=\"txtEdadUsuario\" was not injected: check your FXML file 'CrudUsuario.fxml'.";
        assert btnActualizarUsuario != null : "fx:id=\"btnActualizarUsuario\" was not injected: check your FXML file 'CrudUsuario.fxml'.";
        assert btnIrLogin != null : "fx:id=\"btnIrLogin\" was not injected: check your FXML file 'CrudUsuario.fxml'.";
        assert btnCrearUsuario != null : "fx:id=\"btnCrearUsuario\" was not injected: check your FXML file 'CrudUsuario.fxml'.";
        assert col_TipoUsuario != null : "fx:id=\"col_TipoUsuario\" was not injected: check your FXML file 'CrudUsuario.fxml'.";
        assert col_NombreUsuario != null : "fx:id=\"col_NombreUsuario\" was not injected: check your FXML file 'CrudUsuario.fxml'.";
        assert cbkAnunciante != null : "fx:id=\"cbkAnunciante\" was not injected: check your FXML file 'CrudUsuario.fxml'.";

    }
}