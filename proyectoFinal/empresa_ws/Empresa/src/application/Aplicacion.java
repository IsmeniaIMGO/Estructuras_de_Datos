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
        this.Escena.setTitle("Empresa");
        mostrarLogin("/view/Login.fxml");
    }


    /**
     * metodo que me permitira mostrar la vista: Login para iniciar sesion
     * @param ruta
     */
    public void mostrarLogin(String ruta) {
        try {
            FXMLLoader ventana = new FXMLLoader();
            ventana.setLocation(Aplicacion.class.getResource(ruta));

            ventana.setRoot(new AnchorPane());

            AnchorPane diseño = (AnchorPane)ventana.load();
            LoginController loginController = ventana.getController();
            loginController.setAplicacion(this);

            Scene lugar = new Scene(diseño);
            Escena.setScene(lugar);
            Escena.show();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void mostrarCrudUsuario(String ruta) {
        try {
            FXMLLoader ventana = new FXMLLoader();
            ventana.setLocation(Aplicacion.class.getResource(ruta));

            ventana.setRoot(new AnchorPane());

            AnchorPane diseño = (AnchorPane)ventana.load();
            CrudUsuarioController crudUsuarioController = ventana.getController();
            crudUsuarioController.setAplicacion(this);

            Scene lugar = new Scene(diseño);
            Escena.setScene(lugar);
            Escena.show();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void mostrarCrudProcesos(String ruta) {
        try {
            FXMLLoader ventana = new FXMLLoader();
            ventana.setLocation(Aplicacion.class.getResource(ruta));

            ventana.setRoot(new AnchorPane());

            AnchorPane diseño = (AnchorPane) ventana.load();
            CrudProcesosController crudProcesosController = ventana.getController();
            crudProcesosController.setAplicacion(this);

            Scene lugar = new Scene(diseño);
            Escena.setScene(lugar);
            Escena.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mostrarNotificaciones(String ruta) {
        try {
            FXMLLoader ventana = new FXMLLoader();
            ventana.setLocation(Aplicacion.class.getResource(ruta));

            ventana.setRoot(new AnchorPane());

            AnchorPane diseño = (AnchorPane) ventana.load();
            NotificacionesController notificacionesController = ventana.getController();
            notificacionesController.setAplicacion(this);

            Scene lugar = new Scene(diseño);
            Escena.setScene(lugar);
            Escena.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void mostrarActividades(String ruta) {
        try {
            FXMLLoader ventana = new FXMLLoader();
            ventana.setLocation(Aplicacion.class.getResource(ruta));

            ventana.setRoot(new AnchorPane());

            AnchorPane diseño = (AnchorPane) ventana.load();
            CrudActividadesController crudActividadesController = ventana.getController();
            crudActividadesController.setAplicacion(this);

            Scene lugar = new Scene(diseño);
            Escena.setScene(lugar);
            Escena.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mostrarTareas(String ruta) {
        try {
            FXMLLoader ventana = new FXMLLoader();
            ventana.setLocation(Aplicacion.class.getResource(ruta));

            ventana.setRoot(new AnchorPane());

            AnchorPane diseño = (AnchorPane) ventana.load();
            CrudTareasController crudTareasController = ventana.getController();
            crudTareasController.setAplicacion(this);

            Scene lugar = new Scene(diseño);
            Escena.setScene(lugar);
            Escena.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mostrarIntercambios(String ruta) {
        try {
            FXMLLoader ventana = new FXMLLoader();
            ventana.setLocation(Aplicacion.class.getResource(ruta));

            ventana.setRoot(new AnchorPane());

            AnchorPane diseño = (AnchorPane) ventana.load();
            IntercambioController intercambioController = ventana.getController();
            intercambioController.setAplicacion(this);

            Scene lugar = new Scene(diseño);
            Escena.setScene(lugar);
            Escena.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
