package Laboratorio2.Controller;

import Laboratorio2.Application.*;
import Laboratorio2.Model.Biblioteca;
import Laboratorio2.Model.TipoUsuario;
import Laboratorio2.Model.Usuario;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Set;

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

    public void crearUsuario(String usser, String password, String nombre, String cedula, TipoUsuario tipoUsuario) throws Exception {
        biblioteca.crearUsuario(usser, password, nombre, cedula, tipoUsuario);
    }

    public void actualizarUsuario(String usser, String password, String nombre, String cedula, TipoUsuario tipoUsuario) {
        biblioteca.actualizarUsuario(usser, password, nombre, cedula, tipoUsuario);
    }

    public void eliminarUsuario(String cedula, TipoUsuario tipoUsuario) {
        biblioteca.eliminarUsuario(cedula, tipoUsuario);
    }

    public Usuario buscarUsuario(String cedula) {
        return biblioteca.buscarUsuario(cedula);
    }

    public Set<Usuario> obtenerListaUsuariosEstudiantes() {
        return biblioteca.getListaEstudiantes();
    }

    public Set<Usuario> obtenerListaUsuariosBibliotecarios() {
        return biblioteca.getListaBibliotecarios();
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
