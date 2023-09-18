package Laboratorio2.Controller;

import Laboratorio2.Application.Aplicacion;
import Laboratorio2.Model.Biblioteca;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController {

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
    private Button btnCrearCuenta;

    @FXML
    private TextField txtUsser;

    @FXML
    private Button btnIngresar;

    @FXML
    private TextField txtPassword;

    @FXML
    void ingresarUsuario(ActionEvent event) {

    }

    @FXML
    void crearUsuario(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert btnCrearCuenta != null : "fx:id=\"btnCrearCuenta\" was not injected: check your FXML file 'Login.fxml'.";
        assert txtUsser != null : "fx:id=\"txtUsser\" was not injected: check your FXML file 'Login.fxml'.";
        assert btnIngresar != null : "fx:id=\"btnIngresar\" was not injected: check your FXML file 'Login.fxml'.";
        assert txtPassword != null : "fx:id=\"txtPassword\" was not injected: check your FXML file 'Login.fxml'.";

    }

    /**
     * Metodo que me permite verificar el inicio de sesion
     */
    /*private void verificarInicioSesion() {
        String usser = txtUsser.getText();
        String contrasena = txtPassword.getText();

        if (!usser.equals("") && !contrasena.equals("")){
            //si el tipo de usuario es anunciante entonces me abre una ventana especial para anunciantes
            if (singleton.verificarAnunciante(usser, contrasena)) {
                singleton.mostrarCrudArticuloAnuncioA("/co/uniquindio/edu/Empresa/views/CrudArticuloAnuncio.fxml");
                singleton.guardarRegistroLog("Usuario: "+usser+"-"+contrasena, 1, "iniciarSesion");

                //si el tipo de usuario es comprador entonces me abre una ventana especial para anunciantes
            }else if (singleton.verificarComprador(usser, contrasena)) {
                singleton.mostrarCrudArticuloAnuncioC("/co/uniquindio/edu/Empresa/views/CrudArticuloAnuncio.fxml");
                singleton.guardarRegistroLog("Usuario: "+usser+"-"+contrasena, 1, "iniciarSesion");

            }else {
                //si no cumple las anteriores opciones entonces ingreso algo mal
                singleton.mostrarMensaje("Error Ingreso", "", "La informacion digitada no es correcta ", AlertType.ERROR);
            }
        }else {
            //si intenta iniciar sesion pero los campos estan vacios
            singleton.mostrarMensaje("Parametros Vacios", "", "por favor llene los campos vacios", AlertType.WARNING);
        }

    }*/
}
