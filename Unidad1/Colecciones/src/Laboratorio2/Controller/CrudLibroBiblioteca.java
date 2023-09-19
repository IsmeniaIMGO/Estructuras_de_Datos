/**
 * Sample Skeleton for 'CrudLibroBiblioteca.fxml' Controller Class
 */
package Laboratorio2.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import Laboratorio2.Application.Aplicacion;
import Laboratorio2.Model.Biblioteca;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class CrudLibroBiblioteca {

    Biblioteca biblioteca = Singleton.getInstance().getBiblioteca();

    Singleton singleton = Singleton.getInstance();
    Aplicacion aplicacion;

    //Metodo set de aplicacion
    public void setAplicacion(Aplicacion aplicacion){
        this.aplicacion = aplicacion;
        singleton.setAplicacion(aplicacion);
    }






    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="col_IdLibroP"
    private TableColumn<?, ?> col_IdLibroP; // Value injected by FXMLLoader

    @FXML // fx:id="tblLibrosPrestados"
    private TableView<?> tblLibrosPrestados; // Value injected by FXMLLoader

    @FXML // fx:id="colNombreLibroC"
    private TableColumn<?, ?> colNombreLibroC; // Value injected by FXMLLoader

    @FXML // fx:id="btnActualizarLibro"
    private Button btnActualizarLibro; // Value injected by FXMLLoader

    @FXML // fx:id="colNombreLibroD"
    private TableColumn<?, ?> colNombreLibroD; // Value injected by FXMLLoader

    @FXML // fx:id="btnDevolverLibro"
    private Button btnDevolverLibro; // Value injected by FXMLLoader

    @FXML // fx:id="dateFechaLibro"
    private DatePicker dateFechaLibro; // Value injected by FXMLLoader

    @FXML // fx:id="tblLibrosCreados"
    private TableView<?> tblLibrosCreados; // Value injected by FXMLLoader

    @FXML // fx:id="btnBuscarLibro"
    private Button btnBuscarLibro; // Value injected by FXMLLoader

    @FXML // fx:id="colAutorLibroP"
    private TableColumn<?, ?> colAutorLibroP; // Value injected by FXMLLoader

    @FXML // fx:id="colFechaLibroP"
    private TableColumn<?, ?> colFechaLibroP; // Value injected by FXMLLoader

    @FXML // fx:id="tabCrearLibro"
    private Tab tabCrearLibro; // Value injected by FXMLLoader

    @FXML // fx:id="txtIdLibro"
    private TextField txtIdLibro; // Value injected by FXMLLoader

    @FXML // fx:id="btnSolicitarPrestamo"
    private Button btnSolicitarPrestamo; // Value injected by FXMLLoader

    @FXML // fx:id="txtAutorLibro"
    private TextField txtAutorLibro; // Value injected by FXMLLoader

    @FXML // fx:id="colNombreLibroP"
    private TableColumn<?, ?> colNombreLibroP; // Value injected by FXMLLoader

    @FXML // fx:id="colFechaInicioAnuncio"
    private TableColumn<?, ?> colFechaInicioAnuncio; // Value injected by FXMLLoader

    @FXML // fx:id="colAutorLibroC"
    private TableColumn<?, ?> colAutorLibroC; // Value injected by FXMLLoader

    @FXML // fx:id="colAutorLibroD"
    private TableColumn<?, ?> colAutorLibroD; // Value injected by FXMLLoader

    @FXML // fx:id="colFechaLibroC"
    private TableColumn<?, ?> colFechaLibroC; // Value injected by FXMLLoader

    @FXML // fx:id="colFechaLibroD"
    private TableColumn<?, ?> colFechaLibroD; // Value injected by FXMLLoader

    @FXML // fx:id="tblLibrosDisponibles"
    private TableView<?> tblLibrosDisponibles; // Value injected by FXMLLoader

    @FXML // fx:id="btnCrearLibro"
    private Button btnCrearLibro; // Value injected by FXMLLoader

    @FXML // fx:id="txtNombreLibro"
    private TextField txtNombreLibro; // Value injected by FXMLLoader

    @FXML // fx:id="btnCerrarSesionP"
    private Button btnCerrarSesionP; // Value injected by FXMLLoader

    @FXML // fx:id="tabPrestamos"
    private Tab tabPrestamos; // Value injected by FXMLLoader

    @FXML // fx:id="cboxEstudiantes"
    private ComboBox<?> cboxEstudiantes; // Value injected by FXMLLoader

    @FXML // fx:id="col_idLibroD"
    private TableColumn<?, ?> col_idLibroD; // Value injected by FXMLLoader

    @FXML // fx:id="col_IdLibroC"
    private TableColumn<?, ?> col_IdLibroC; // Value injected by FXMLLoader

    @FXML // fx:id="cboxOrden"
    private ComboBox<?> cboxOrden; // Value injected by FXMLLoader

    @FXML // fx:id="tabBiblioteca"
    private Tab tabBiblioteca; // Value injected by FXMLLoader

    @FXML // fx:id="btnEliminarLibro"
    private Button btnEliminarLibro; // Value injected by FXMLLoader

    @FXML // fx:id="colFechaFinAnuncio"
    private TableColumn<?, ?> colFechaFinAnuncio; // Value injected by FXMLLoader

    @FXML // fx:id="btnCerrarSesionD"
    private Button btnCerrarSesionD; // Value injected by FXMLLoader

    @FXML // fx:id="tabCrudLibro"
    private TabPane tabCrudLibro; // Value injected by FXMLLoader

    @FXML
    void CrearLibro(ActionEvent event) {

    }

    @FXML
    void BuscarLibro(ActionEvent event) {

    }

    @FXML
    void EliminarLibro(ActionEvent event) {

    }

    @FXML
    void ActualizarLibro(ActionEvent event) {

    }

    @FXML
    void cerrarSesionP(ActionEvent event) {

    }

    @FXML
    void DevolverLibro(ActionEvent event) {

    }

    @FXML
    void cerrarSesionD(ActionEvent event) {

    }

    @FXML
    void SolicitarPrestamo(ActionEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert col_IdLibroP != null : "fx:id=\"col_IdLibroP\" was not injected: check your FXML file 'CrudLibroBiblioteca.fxml'.";
        assert tblLibrosPrestados != null : "fx:id=\"tblLibrosPrestados\" was not injected: check your FXML file 'CrudLibroBiblioteca.fxml'.";
        assert colNombreLibroC != null : "fx:id=\"colNombreLibroC\" was not injected: check your FXML file 'CrudLibroBiblioteca.fxml'.";
        assert btnActualizarLibro != null : "fx:id=\"btnActualizarLibro\" was not injected: check your FXML file 'CrudLibroBiblioteca.fxml'.";
        assert colNombreLibroD != null : "fx:id=\"colNombreLibroD\" was not injected: check your FXML file 'CrudLibroBiblioteca.fxml'.";
        assert btnDevolverLibro != null : "fx:id=\"btnDevolverLibro\" was not injected: check your FXML file 'CrudLibroBiblioteca.fxml'.";
        assert dateFechaLibro != null : "fx:id=\"dateFechaLibro\" was not injected: check your FXML file 'CrudLibroBiblioteca.fxml'.";
        assert tblLibrosCreados != null : "fx:id=\"tblLibrosCreados\" was not injected: check your FXML file 'CrudLibroBiblioteca.fxml'.";
        assert btnBuscarLibro != null : "fx:id=\"btnBuscarLibro\" was not injected: check your FXML file 'CrudLibroBiblioteca.fxml'.";
        assert colAutorLibroP != null : "fx:id=\"colAutorLibroP\" was not injected: check your FXML file 'CrudLibroBiblioteca.fxml'.";
        assert colFechaLibroP != null : "fx:id=\"colFechaLibroP\" was not injected: check your FXML file 'CrudLibroBiblioteca.fxml'.";
        assert tabCrearLibro != null : "fx:id=\"tabCrearLibro\" was not injected: check your FXML file 'CrudLibroBiblioteca.fxml'.";
        assert txtIdLibro != null : "fx:id=\"txtIdLibro\" was not injected: check your FXML file 'CrudLibroBiblioteca.fxml'.";
        assert btnSolicitarPrestamo != null : "fx:id=\"btnSolicitarPrestamo\" was not injected: check your FXML file 'CrudLibroBiblioteca.fxml'.";
        assert txtAutorLibro != null : "fx:id=\"txtAutorLibro\" was not injected: check your FXML file 'CrudLibroBiblioteca.fxml'.";
        assert colNombreLibroP != null : "fx:id=\"colNombreLibroP\" was not injected: check your FXML file 'CrudLibroBiblioteca.fxml'.";
        assert colFechaInicioAnuncio != null : "fx:id=\"colFechaInicioAnuncio\" was not injected: check your FXML file 'CrudLibroBiblioteca.fxml'.";
        assert colAutorLibroC != null : "fx:id=\"colAutorLibroC\" was not injected: check your FXML file 'CrudLibroBiblioteca.fxml'.";
        assert colAutorLibroD != null : "fx:id=\"colAutorLibroD\" was not injected: check your FXML file 'CrudLibroBiblioteca.fxml'.";
        assert colFechaLibroC != null : "fx:id=\"colFechaLibroC\" was not injected: check your FXML file 'CrudLibroBiblioteca.fxml'.";
        assert colFechaLibroD != null : "fx:id=\"colFechaLibroD\" was not injected: check your FXML file 'CrudLibroBiblioteca.fxml'.";
        assert tblLibrosDisponibles != null : "fx:id=\"tblLibrosDisponibles\" was not injected: check your FXML file 'CrudLibroBiblioteca.fxml'.";
        assert btnCrearLibro != null : "fx:id=\"btnCrearLibro\" was not injected: check your FXML file 'CrudLibroBiblioteca.fxml'.";
        assert txtNombreLibro != null : "fx:id=\"txtNombreLibro\" was not injected: check your FXML file 'CrudLibroBiblioteca.fxml'.";
        assert btnCerrarSesionP != null : "fx:id=\"btnCerrarSesionP\" was not injected: check your FXML file 'CrudLibroBiblioteca.fxml'.";
        assert tabPrestamos != null : "fx:id=\"tabPrestamos\" was not injected: check your FXML file 'CrudLibroBiblioteca.fxml'.";
        assert cboxEstudiantes != null : "fx:id=\"cboxEstudiantes\" was not injected: check your FXML file 'CrudLibroBiblioteca.fxml'.";
        assert col_idLibroD != null : "fx:id=\"col_idLibroD\" was not injected: check your FXML file 'CrudLibroBiblioteca.fxml'.";
        assert col_IdLibroC != null : "fx:id=\"col_IdLibroC\" was not injected: check your FXML file 'CrudLibroBiblioteca.fxml'.";
        assert cboxOrden != null : "fx:id=\"cboxOrden\" was not injected: check your FXML file 'CrudLibroBiblioteca.fxml'.";
        assert tabBiblioteca != null : "fx:id=\"tabBiblioteca\" was not injected: check your FXML file 'CrudLibroBiblioteca.fxml'.";
        assert btnEliminarLibro != null : "fx:id=\"btnEliminarLibro\" was not injected: check your FXML file 'CrudLibroBiblioteca.fxml'.";
        assert colFechaFinAnuncio != null : "fx:id=\"colFechaFinAnuncio\" was not injected: check your FXML file 'CrudLibroBiblioteca.fxml'.";
        assert btnCerrarSesionD != null : "fx:id=\"btnCerrarSesionD\" was not injected: check your FXML file 'CrudLibroBiblioteca.fxml'.";
        assert tabCrudLibro != null : "fx:id=\"tabCrudLibro\" was not injected: check your FXML file 'CrudLibroBiblioteca.fxml'.";

    }


}
