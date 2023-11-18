package application;

import controller.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Aplicacion extends Application {
    //atributos propios
    private Singleton singleton = Singleton.getInstance();
    private Stage Escena = new Stage();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.Escena = primaryStage;
        this.Escena.setTitle("BIBLIOTECA");
        mostrarLogin("/Laboratorio2/View/Login.fxml");
    }


    /**
     * metodo que me permitira mostrar la vista: Login para iniciar sesion
     *
     * @param ruta
     */
    public void mostrarLogin(String ruta) {
        try {
            FXMLLoader ventana = new FXMLLoader();
            ventana.setLocation(Aplicacion.class.getResource(ruta));

            ventana.setRoot(new AnchorPane());

            AnchorPane diseño = (AnchorPane) ventana.load();
            LoginController loginController = ventana.getController();
            loginController.setAplicacion(this);

            Scene lugar = new Scene(diseño);
            Escena.setScene(lugar);
            Escena.show();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * metodo que muestra el crud para el usuario
     *
     * @param ruta
     */
    public void mostrarCrudUsuario(String ruta) {
        try {
            FXMLLoader ventana = new FXMLLoader();
            ventana.setLocation(Aplicacion.class.getResource(ruta));

            AnchorPane diseño = (AnchorPane) ventana.load();
            CrudUsuarioController crudUsuarioController = ventana.getController();
            crudUsuarioController.setAplicacion(this);

            Scene lugar = new Scene(diseño);
            Escena.setScene(lugar);
            Escena.setY(-4);
            Escena.show();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
