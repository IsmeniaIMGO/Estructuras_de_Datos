package controller;

import model.Empresa;
import application.*;

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
       // inicializarDatos();
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
       // aplicacion.mostrarCrudUsuario(ruta);
    }

    /**
     * metodo que me permitira mostrar la vista: CrudProcesos para crear un proceso
     * @param ruta
     */
    public void mostrarCrudProcesos(String ruta) {
       // aplicacion.mostrarCrudProcesos(ruta);
    }



    //------------------------------------------------------------
    //----------Metodos que llaman a la empresa--------------------
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

}
