package Laboratorio2.Controller;

import Laboratorio2.Application.*;
import Laboratorio2.Exceptions.LibroException;
import Laboratorio2.Model.Biblioteca;
import Laboratorio2.Model.Libro;
import Laboratorio2.Model.TipoUsuario;
import Laboratorio2.Model.Usuario;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

public class Singleton {
    /**
     * atributos
     */
    Biblioteca biblioteca;
    private Aplicacion aplicacion;

    public ArrayList<Libro> listaLibrosPrestados(String cedula) {
        return biblioteca.listaLibrosPrestados(cedula);
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

    public Singleton(){
        inicializarDatos();
    }


    //---------------------------Inicializacion de datos--------------//

    private void inicializarDatos (){
        biblioteca = new Biblioteca();
        biblioteca.setNombre("Subastas Quindio");

        try {
            this.biblioteca.crearUsuario("marce", "123", "Marcela", "1", TipoUsuario.BIBLIOTECARIO);
            this.biblioteca.crearUsuario("sofi", "123", "Sofia", "2", TipoUsuario.ESTUDIANTE);
            this.biblioteca.crearUsuario("juan", "123", "Juan", "3", TipoUsuario.ESTUDIANTE);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            this.biblioteca.crearLibro("1", "El principito", "Antoine de Saint-Exupéry", 1943);
            this.biblioteca.crearLibro("2", "El alquimista", "Paulo Coelho", 1988);
            this.biblioteca.crearLibro("3", "El señor de los anillos", "J. R. R. Tolkien", 1954);
            this.biblioteca.crearLibro("4", "El código Da Vinci", "Dan Brown", 2003);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println("Biblioteca Inicializada "+ biblioteca.getNombre());

    }


    ///---------------------------Metodos de cambio de ventanas--------------//
    /**
     * metodo que envia una ruta a aplicacion para que muestre la vista: Login
     * @param ruta
     */
    public void mostrarLogin(String ruta){
        aplicacion.mostrarLogin(ruta);
    }

    public void mostrarCrudUsuario(String ruta) {
        aplicacion.mostrarCrudUsuario(ruta);
    }

    public void mostrarCrudLibroBibliotecaE(String ruta) {
        aplicacion.mostrarCrudLibroBibliotecaE(ruta);
    }

    public void mostrarCrudLibroBibliotecaB(String ruta) {
        aplicacion.mostrarCrudLibroBibliotecaB(ruta);
    }


    ///---------------------------METODOS QUE LLAMAN A LA BIBLIOTECA--------------//
    //---------------------------Metodos de Login--------------//
    public boolean verificarEstudiante(String usser, String password) {
        return biblioteca.verificarEstudiante(usser, password);
    }

    public boolean verificarBibliotecario(String usser, String password) {
        return biblioteca.verificarBibliotecario(usser, password);
    }

    //---------------------------Metodos de usuario--------------//
    public void crearUsuario(String usser, String password, String nombre, String cedula, TipoUsuario tipoUsuario) throws Exception {
        biblioteca.crearUsuario(usser, password, nombre, cedula, tipoUsuario);
    }

    public void actualizarUsuario(String usser, String password, String nombre, String cedula, TipoUsuario tipoUsuario) {
        biblioteca.actualizarUsuario(usser, password, nombre, cedula, tipoUsuario);
    }

    public void eliminarUsuario(String cedula) throws Exception {
        biblioteca.eliminarUsuario(cedula);
    }

    public Usuario buscarUsuario(String cedula) {
        return biblioteca.buscarUsuario(cedula);
    }


    public ArrayList<Usuario> listaUsuarios() {
        return biblioteca.getListaUsuarios();

    }

    public TreeSet<Usuario> obtenerListaUsuariosEstudiantes() {
        return biblioteca.getListaEstudiantes();
    }

    public Set<Usuario> obtenerListaUsuariosBibliotecarios() {
        return biblioteca.getListaBibliotecarios();
    }

    //---------------------------Metodos de libro--------------//
    public void crearLibro(String idLibro, String nombreLibro, String autorLibro, int year) throws Exception {
        biblioteca.crearLibro(idLibro, nombreLibro, autorLibro, year);
    }

    public Libro buscarLibro(String idLibro) {
        return biblioteca.buscarLibro(idLibro);
    }

    public void eliminarLibro(String idLibro) throws LibroException {
        biblioteca.eliminarLibro(idLibro);
    }

    public void actualizarLibro(String idLibro, String nombreLibro, String autorLibro, int year) {
        biblioteca.actualizarLibro(idLibro, nombreLibro, autorLibro, year);
    }
    public Set<Libro> listaLibros() {
        return biblioteca.getListaLibros();

    }
    public Set<Libro> obtenerListaLibrosAutor() {
        return biblioteca.getLibrosPorAutor();
    }

    public Set<Libro> obtenerListaLibrosFecha() {
        return biblioteca.getLibrosPorFecha();
    }


}
