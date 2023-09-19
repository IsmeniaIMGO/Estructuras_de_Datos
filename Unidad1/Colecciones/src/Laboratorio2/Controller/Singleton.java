package Laboratorio2.Controller;

import Laboratorio2.Application.*;
import Laboratorio2.Model.Biblioteca;

public class Singleton {
    /**
     * atributos
     */
    Biblioteca biblioteca;
    private Aplicacion aplicacion;

    public boolean verificarEstudiante(String usser, String contrasena) {
        return biblioteca.verificarEstudiante(usser, contrasena);
    }

    public void mostrarCrudLibroBibliotecaE(String ruta) {
        aplicacion.mostrarCrudLibroBibliotecaE(ruta);
    }

    public boolean verificarBibliotecario(String usser, String contrasena) {
        return biblioteca.verificarBibliotecario(usser, contrasena);
    }

    public void mostrarCrudLibroBibliotecaB(String ruta) {
        aplicacion.mostrarCrudLibroBibliotecaB(ruta);
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
    public Biblioteca getBiblioteca() {
        return biblioteca;
    }


    ///---------------------------Metodos de cambio de ventanas--------------//
    /**
     * metodo que envia una ruta a aplicacion para que muestre la vista: Login
     * @param ruta
     */
    public void mostrarLogin(String ruta){
        aplicacion.mostrarLogin(ruta);

    }

    /**
     * metodo que envia una ruta a aplicacion para que muestre la vista: CrudUsuario
     * @param ruta
     */

    public void mostrarCrudUsuario(String ruta) {
        aplicacion.mostrarCrudUsuario(ruta);
    }

}
