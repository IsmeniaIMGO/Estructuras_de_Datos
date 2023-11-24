package controller;

import model.*;
import application.*;

import java.util.ArrayList;

public class Singleton {
    /**
     * atributos
     */
    Empresa empresa;
    private Aplicacion aplicacion;

    public ArrayList<Proceso> obtenerProcesosUsuario(Usuario usuario) {
        for(Usuario aux: empresa.getListaUsuarios()){
            if(aux.getCedula().equals(usuario.getCedula())){
                return aux.getProcesos();
            }
        }
        return null;
    }

    public ArrayList<DetalleProceso> obtenerActividadesUsuario(Usuario usuario, Proceso proceso) {
        for (Usuario aux: empresa.getListaUsuarios()){
            if (aux.getCedula().equals(usuario.getCedula())){
                for (Proceso aux2: aux.getProcesos()){
                    if (aux2.getId().equals(proceso.getId())){
                        return aux2.getListaDetalleProceso();
                    }
                }
            }
        }
        return null;
    }

    public void crearActividad(Usuario usuario, Proceso proceso, String nombre, String descripcion, TipoCumplimiento tipoCumplimiento, String posicion, Actividad actividad) throws Exception {
        empresa.crearActividad(usuario, proceso, nombre, descripcion,tipoCumplimiento,posicion, actividad);
    }

    public Actividad buscarActividad(Usuario usuario,Proceso proceso,String nombre) throws Exception {
        empresa.buscarActividad(usuario, proceso, nombre);
        return null;
    }


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

    public void mostrarNotificaciones(String ruta) {
        aplicacion.mostrarNotificaciones(ruta);
    }

    public void mostrarActividades(String ruta) {
        aplicacion.mostrarActividades(ruta);
    }
    public void mostrarTareas(String ruta) {
        aplicacion.mostrarTareas(ruta);
    }

    public void mostrarIntercambios(String ruta) {
        aplicacion.mostrarIntercambios(ruta);
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

    public void cerrarSesion() {
        empresa.cerrarSesion();
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


    //-------------------------------Crud Proceso-----------------

    public void crearProceso(Usuario usuario, String codigo, String nombre) throws Exception {
        empresa.crearProceso(usuario, codigo, nombre);
    }

    public void actualizarProceso(Usuario usuario, String codigo, String nuevoNombre) {
        empresa.actualizarProceso(usuario, codigo, nuevoNombre);
    }

    public Proceso buscarProceso(Usuario usuario, String codigo) {
        return empresa.buscarProceso(usuario, codigo);
    }

    public void eliminarProceso(Usuario usuario, String codigo) throws Exception {
        empresa.eliminarProceso(usuario, codigo);
    }


    //-----------------------------------obtener listas--------------------------------
    //-------------------------------------------------------------------------------
    /**
     * metodo que retorna la lista de usuarios
     * @return ArrayList<Usuario>
     */
    public ArrayList<Usuario> listaUsuarios() {
        return empresa.getListaUsuarios();

    }


    public ArrayList<Proceso> listaProcesos(Usuario usuario) {
        for (Usuario aux: empresa.getListaUsuarios())
            if(aux.getCedula().equals(usuario.getCedula()))
                return aux.getProcesos();
        return null;
    }



    public ArrayList<Usuario> obtenerUsuarioLogin() {
        return empresa.getListaLogin();
    }


}
