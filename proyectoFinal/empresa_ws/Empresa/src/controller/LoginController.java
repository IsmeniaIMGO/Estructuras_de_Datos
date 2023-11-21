package controller;

import exceptions.NuloVacioException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import model.*;
import application.*;

public class LoginController {
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
    private Button btnCrearCuenta;

    @FXML
    private TextField txtUsser;

    @FXML
    private Button btnIngresar;

    @FXML
    private PasswordField txtPassword;

    @FXML
    void ingresarUsuario(ActionEvent event) throws NuloVacioException {
        verificarInicioSesion();
    }


    @FXML
    void crearUsuario(ActionEvent event) {
       singleton.mostrarCrudUsuario("/view/CrudUsuario.fxml");
    }


    @FXML
    void initialize() {
        assert btnCrearCuenta != null : "fx:id=\"btnCrearCuenta\" was not injected: check your FXML file 'Login.fxml'.";
        assert txtUsser != null : "fx:id=\"txtUsser\" was not injected: check your FXML file 'Login.fxml'.";
        assert btnIngresar != null : "fx:id=\"btnIngresar\" was not injected: check your FXML file 'Login.fxml'.";
        assert txtPassword != null : "fx:id=\"txtPassword\" was not injected: check your FXML file 'Login.fxml'.";
        txtUsser.setPromptText("Ingrese su usuario");
        txtPassword.setPromptText("Ingrese su contraseña");
    }

    /**
     * Metodo que me permite verificar el inicio de sesion
     */
    private void verificarInicioSesion() throws NuloVacioException {
        String usser = txtUsser.getText();
        String password = txtPassword.getText();

        if (!usser.equals("") && !password.equals("")){
            //si el tipo de usuario es estudiante entonces me abre una ventana especial para estudiantes
            if (singleton.verificarRegular(usser, password)) {
                singleton.mostrarCrudProcesos("/view/CrudProcesos.fxml");

                //si el tipo de usuario es comprador entonces me abre una ventana especial para anunciantes
            }else if (singleton.verificarPremium(usser, password)) {
                singleton.mostrarCrudProcesos("/view/CrudProcesos.fxml");

            }else {
                //si no cumple las anteriores opciones entonces ingreso algo mal
                System.out.println("La informacion digitada no es correcta "+ password+usser);
            }
        }else {
            //si intenta iniciar sesion pero los campos estan vacios
            throw new NuloVacioException("Alguno de los parámetros indicados es está vacío");
        }

    }
}
