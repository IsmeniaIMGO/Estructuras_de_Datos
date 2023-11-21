package controller;

import model.DetalleProceso;
import model.Empresa;
import application.*;
import model.TipoUsuario;
import model.Usuario;

import java.util.ArrayList;

public class Singleton {
    /**
     * atributos
     */
    Empresa empresa;
    private Aplicacion aplicacion;



    private static class SingletonHolder{
        private final static Singleton eInstance = new Singleton();
    }
    public static Singleton getInstance(){
        return SingletonHolder.eInstance;
    }

    /**
     * metodo set de aplicacion
     * @param aplicacion
     */
    public void setAplicacion(Aplicacion aplicacion){
        this.aplicacion = aplicacion;
    }

    /**
     * metodo get de empresa
     * @return
     */
    public Empresa getEmpresa() {
        return empresa;
  }
    public Singleton(){
       inicializarDatos();
    }


    //---------------------------Inicializacion de datos--------------//

    /**
     * metodo que inicializa los datos de la biblioteca
     */
    private void inicializarDatos (){
        empresa = new Empresa();
        empresa.setNombre("Software");

        try {
            this.empresa.crearUsuario("Marce", "123", "Marcela", "123", TipoUsuario.REGULAR);
            this.empresa.crearUsuario("Sofi", "123", "Sofia", "456", TipoUsuario.PREMIUM);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            Usuario usuario = this.empresa.buscarUsuario("123");
            this.empresa.crearProceso(usuario,"1" ,"Hacer Desayuno");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        System.out.println("Empresa Inicializada "+ empresa.getNombre());

    }

    ///---------------------------Metodos de cambio de ventanas--------------//
    /**
     * metodo que me permitira mostrar la vista: Login para iniciar sesion
     * @param ruta
     */
    public void mostrarLogin(String ruta) {
        aplicacion.mostrarLogin(ruta);
    }

    /**
     * metodo que me permitira mostrar la vista: CrudUsuario para crear un usuario
     * @param ruta
     */
    public void mostrarCrudUsuario(String ruta) {
       aplicacion.mostrarCrudUsuario(ruta);
    }

    /**
     * metodo que me permitira mostrar la vista: CrudProcesos para crear un proceso
     * @param ruta
     */
    public void mostrarCrudProcesos(String ruta) {
       aplicacion.mostrarCrudProcesos(ruta);
    }



    //-------------------------------------------------------------------
    //--------------------Login-----------------------------
    /**
     * metodo que verifica si el usuario es regular
     * @param usser
     * @param password
     * @return
     */
    public boolean verificarRegular(String usser, String password) {
        return empresa.verificarRegular(usser, password);
    }

    /**
     * metodo que verifica si el usuario es premium
     *
     * @param usser
     * @param password
     * @return
     */
    public boolean verificarPremium(String usser, String password) {
        return empresa.verificarPremium(usser, password);
    }

    //---------------------------Metodos de usuario--------------//

    /**
     * metodo que crea un usuario
     * @param usser
     * @param password
     * @param nombre
     * @param cedula
     * @param tipoUsuario
     * @throws Exception
     */
    public void crearUsuario(String usser, String password, String nombre, String cedula, TipoUsuario tipoUsuario) throws Exception {
        empresa.crearUsuario(usser, password, nombre, cedula, tipoUsuario);
    }

    /**
     *
     * @param usser
     * @param password
     * @param nombre
     * @param cedula
     * @param tipoUsuario
     */
    public void actualizarUsuario(String usser, String password, String nombre, String cedula, TipoUsuario tipoUsuario) {
        empresa.actualizarUsuario(usser, password, nombre, cedula, tipoUsuario);
    }

    /**
     *
     * @param cedula
     * @throws Exception
     */
    public void eliminarUsuario(String cedula) throws Exception {
        empresa.eliminarUsuario(cedula);
    }

    /**
     * metodo que busca un usuario
     * @param cedula
     * @return Usuario
     */
    public Usuario buscarUsuario(String cedula) {
        return empresa.buscarUsuario(cedula);
    }

    /**
     * metodo que retorna la lista de usuarios
     * @return ArrayList<Usuario>
     */
    public ArrayList<Usuario> listaUsuarios() {
        return empresa.getListaUsuarios();

    }





}
