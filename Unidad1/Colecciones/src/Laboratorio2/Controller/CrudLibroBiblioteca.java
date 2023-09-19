package Laboratorio2.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import Laboratorio2.Application.Aplicacion;
import Laboratorio2.Model.Biblioteca;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class CrudLibroBiblioteca {
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
    private TableColumn<?, ?> col_UsuarioVista;

    @FXML
    private TableColumn<?, ?> colTipoArticulo;

    @FXML
    private TableColumn<?, ?> col_idVista;

    @FXML
    private ChoiceBox<?> cboxArticulo;

    @FXML
    private DatePicker dtpFechaFinal;

    @FXML
    private TableColumn<?, ?> col_ValorInicialVista;

    @FXML
    private Button btnExportarAnuncios;

    @FXML
    private TableView<?> tblArticulos;

    @FXML
    private Button btnVerPujas;

    @FXML
    private TableColumn<?, ?> col_FechaFinVista;

    @FXML
    private Button btnIrAPuja;

    @FXML
    private Tab tabMisLibros;

    @FXML
    private Button btnEliminarAnuncio;

    @FXML
    private TableColumn<?, ?> col_FechaInicioVista;

    @FXML
    private TextField txtIdAnuncio;

    @FXML
    private TableColumn<?, ?> colUsuarioAnuncio;

    @FXML
    private TextField txtDescripcionArticulo;

    @FXML
    private TableColumn<?, ?> colFechaInicioAnuncio;

    @FXML
    private TableColumn<?, ?> col_ArticuloVista;

    @FXML
    private Button btnCrearArticulo;

    @FXML
    private Button btnActualizarArticulo;

    @FXML
    private TableView<?> tblAnuncio;

    @FXML
    private ChoiceBox<?> cboxUsuarios;

    @FXML
    private Button btnCrearAnuncio;

    @FXML
    private TableView<?> tblAnuncioVista;

    @FXML
    private Button btnSubirImagen;

    @FXML
    private Button btnEliminarArticulo;

    @FXML
    private Button btnActualizarAnuncio;

    @FXML
    private ChoiceBox<?> cboxTipoArticulo;

    @FXML
    private TableColumn<?, ?> colArticuloAnuncio;

    @FXML
    private TableColumn<?, ?> colNombreArtiuclo;

    @FXML
    private TextField txtIdArticulo;

    @FXML
    private ImageView vistaImagen;

    @FXML
    private Tab tabLibro;

    @FXML
    private Button btnMensajes;

    @FXML
    private TextField txtNombreArticulo;

    @FXML
    private Tab tabBiblioteca;

    @FXML
    private TableColumn<?, ?> colValorInicialAnuncio;

    @FXML
    private TextField txtValorInicial;

    @FXML
    private Button btnCerrarSesionC;

    @FXML
    private TableColumn<?, ?> col_IdArticulo;

    @FXML
    private DatePicker dtpFechaInicio;

    @FXML
    private TableColumn<?, ?> colDescripcionArticulo;

    @FXML
    private TableColumn<?, ?> colFechaFinAnuncio;

    @FXML
    private Button btnCerrarSesionA;

    @FXML
    private TabPane tabCrudLibro;

    @FXML
    private TableColumn<?, ?> col_IdAnuncio;

    @FXML
    void CrearArticulo(ActionEvent event) {

    }

    @FXML
    void ActualizarArticulo(ActionEvent event) {

    }

    @FXML
    void EliminarArticulo(ActionEvent event) {

    }

    @FXML
    void subirImagen(ActionEvent event) {

    }

    @FXML
    void CrearAnuncio(ActionEvent event) {

    }

    @FXML
    void ActualizarAnuncio(ActionEvent event) {

    }

    @FXML
    void EliminarAnuncio(ActionEvent event) {

    }

    @FXML
    void cerrarSesionA(ActionEvent event) {

    }

    @FXML
    void VerPujas(ActionEvent event) {

    }

    @FXML
    void exportarAnuncios(ActionEvent event) {

    }

    @FXML
    void verMensajes(ActionEvent event) {

    }

    @FXML
    void cerrarSesionC(ActionEvent event) {

    }

    @FXML
    void CrearPuja(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert col_UsuarioVista != null : "fx:id=\"col_UsuarioVista\" was not injected: check your FXML file 'CrudLibroBiblioteca.fxml'.";
        assert colTipoArticulo != null : "fx:id=\"colTipoArticulo\" was not injected: check your FXML file 'CrudLibroBiblioteca.fxml'.";
        assert col_idVista != null : "fx:id=\"col_idVista\" was not injected: check your FXML file 'CrudLibroBiblioteca.fxml'.";
        assert cboxArticulo != null : "fx:id=\"cboxArticulo\" was not injected: check your FXML file 'CrudLibroBiblioteca.fxml'.";
        assert dtpFechaFinal != null : "fx:id=\"dtpFechaFinal\" was not injected: check your FXML file 'CrudLibroBiblioteca.fxml'.";
        assert col_ValorInicialVista != null : "fx:id=\"col_ValorInicialVista\" was not injected: check your FXML file 'CrudLibroBiblioteca.fxml'.";
        assert btnExportarAnuncios != null : "fx:id=\"btnExportarAnuncios\" was not injected: check your FXML file 'CrudLibroBiblioteca.fxml'.";
        assert tblArticulos != null : "fx:id=\"tblArticulos\" was not injected: check your FXML file 'CrudLibroBiblioteca.fxml'.";
        assert btnVerPujas != null : "fx:id=\"btnVerPujas\" was not injected: check your FXML file 'CrudLibroBiblioteca.fxml'.";
        assert col_FechaFinVista != null : "fx:id=\"col_FechaFinVista\" was not injected: check your FXML file 'CrudLibroBiblioteca.fxml'.";
        assert btnIrAPuja != null : "fx:id=\"btnIrAPuja\" was not injected: check your FXML file 'CrudLibroBiblioteca.fxml'.";
        assert tabMisLibros != null : "fx:id=\"tabMisLibros\" was not injected: check your FXML file 'CrudLibroBiblioteca.fxml'.";
        assert btnEliminarAnuncio != null : "fx:id=\"btnEliminarAnuncio\" was not injected: check your FXML file 'CrudLibroBiblioteca.fxml'.";
        assert col_FechaInicioVista != null : "fx:id=\"col_FechaInicioVista\" was not injected: check your FXML file 'CrudLibroBiblioteca.fxml'.";
        assert txtIdAnuncio != null : "fx:id=\"txtIdAnuncio\" was not injected: check your FXML file 'CrudLibroBiblioteca.fxml'.";
        assert colUsuarioAnuncio != null : "fx:id=\"colUsuarioAnuncio\" was not injected: check your FXML file 'CrudLibroBiblioteca.fxml'.";
        assert txtDescripcionArticulo != null : "fx:id=\"txtDescripcionArticulo\" was not injected: check your FXML file 'CrudLibroBiblioteca.fxml'.";
        assert colFechaInicioAnuncio != null : "fx:id=\"colFechaInicioAnuncio\" was not injected: check your FXML file 'CrudLibroBiblioteca.fxml'.";
        assert col_ArticuloVista != null : "fx:id=\"col_ArticuloVista\" was not injected: check your FXML file 'CrudLibroBiblioteca.fxml'.";
        assert btnCrearArticulo != null : "fx:id=\"btnCrearArticulo\" was not injected: check your FXML file 'CrudLibroBiblioteca.fxml'.";
        assert btnActualizarArticulo != null : "fx:id=\"btnActualizarArticulo\" was not injected: check your FXML file 'CrudLibroBiblioteca.fxml'.";
        assert tblAnuncio != null : "fx:id=\"tblAnuncio\" was not injected: check your FXML file 'CrudLibroBiblioteca.fxml'.";
        assert cboxUsuarios != null : "fx:id=\"cboxUsuarios\" was not injected: check your FXML file 'CrudLibroBiblioteca.fxml'.";
        assert btnCrearAnuncio != null : "fx:id=\"btnCrearAnuncio\" was not injected: check your FXML file 'CrudLibroBiblioteca.fxml'.";
        assert tblAnuncioVista != null : "fx:id=\"tblAnuncioVista\" was not injected: check your FXML file 'CrudLibroBiblioteca.fxml'.";
        assert btnSubirImagen != null : "fx:id=\"btnSubirImagen\" was not injected: check your FXML file 'CrudLibroBiblioteca.fxml'.";
        assert btnEliminarArticulo != null : "fx:id=\"btnEliminarArticulo\" was not injected: check your FXML file 'CrudLibroBiblioteca.fxml'.";
        assert btnActualizarAnuncio != null : "fx:id=\"btnActualizarAnuncio\" was not injected: check your FXML file 'CrudLibroBiblioteca.fxml'.";
        assert cboxTipoArticulo != null : "fx:id=\"cboxTipoArticulo\" was not injected: check your FXML file 'CrudLibroBiblioteca.fxml'.";
        assert colArticuloAnuncio != null : "fx:id=\"colArticuloAnuncio\" was not injected: check your FXML file 'CrudLibroBiblioteca.fxml'.";
        assert colNombreArtiuclo != null : "fx:id=\"colNombreArtiuclo\" was not injected: check your FXML file 'CrudLibroBiblioteca.fxml'.";
        assert txtIdArticulo != null : "fx:id=\"txtIdArticulo\" was not injected: check your FXML file 'CrudLibroBiblioteca.fxml'.";
        assert vistaImagen != null : "fx:id=\"vistaImagen\" was not injected: check your FXML file 'CrudLibroBiblioteca.fxml'.";
        assert tabLibro != null : "fx:id=\"tabLibro\" was not injected: check your FXML file 'CrudLibroBiblioteca.fxml'.";
        assert btnMensajes != null : "fx:id=\"btnMensajes\" was not injected: check your FXML file 'CrudLibroBiblioteca.fxml'.";
        assert txtNombreArticulo != null : "fx:id=\"txtNombreArticulo\" was not injected: check your FXML file 'CrudLibroBiblioteca.fxml'.";
        assert tabBiblioteca != null : "fx:id=\"tabBiblioteca\" was not injected: check your FXML file 'CrudLibroBiblioteca.fxml'.";
        assert colValorInicialAnuncio != null : "fx:id=\"colValorInicialAnuncio\" was not injected: check your FXML file 'CrudLibroBiblioteca.fxml'.";
        assert txtValorInicial != null : "fx:id=\"txtValorInicial\" was not injected: check your FXML file 'CrudLibroBiblioteca.fxml'.";
        assert btnCerrarSesionC != null : "fx:id=\"btnCerrarSesionC\" was not injected: check your FXML file 'CrudLibroBiblioteca.fxml'.";
        assert col_IdArticulo != null : "fx:id=\"col_IdArticulo\" was not injected: check your FXML file 'CrudLibroBiblioteca.fxml'.";
        assert dtpFechaInicio != null : "fx:id=\"dtpFechaInicio\" was not injected: check your FXML file 'CrudLibroBiblioteca.fxml'.";
        assert colDescripcionArticulo != null : "fx:id=\"colDescripcionArticulo\" was not injected: check your FXML file 'CrudLibroBiblioteca.fxml'.";
        assert colFechaFinAnuncio != null : "fx:id=\"colFechaFinAnuncio\" was not injected: check your FXML file 'CrudLibroBiblioteca.fxml'.";
        assert btnCerrarSesionA != null : "fx:id=\"btnCerrarSesionA\" was not injected: check your FXML file 'CrudLibroBiblioteca.fxml'.";
        assert tabCrudLibro != null : "fx:id=\"tabCrudLibro\" was not injected: check your FXML file 'CrudLibroBiblioteca.fxml'.";
        assert col_IdAnuncio != null : "fx:id=\"col_IdAnuncio\" was not injected: check your FXML file 'CrudLibroBiblioteca.fxml'.";

    }

    public TabPane getTabCrudLibro() {
        return tabCrudLibro;
    }

}
