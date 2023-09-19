package Laboratorio2.Controller;

import Laboratorio2.Application.*;
import Laboratorio2.Model.Biblioteca;
import Laboratorio2.Model.Libro;
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

        Usuario usuario = new Usuario();

        usuario.setUsser("marce");
        usuario.setPassword("123");
        usuario.setNombre("Marcela");
        usuario.setCedula("1");
        usuario.setTipoUsuario(TipoUsuario.BIBLIOTECARIO);

        this.biblioteca.getListaUsuarios().add(usuario);
        this.biblioteca.getListaBibliotecarios().add(usuario);

        Usuario usuario1 = new Usuario();
        usuario1.setUsser("sofi");
        usuario1.setPassword("123");
        usuario1.setNombre("Sofia");
        usuario1.setCedula("2");
        usuario1.setTipoUsuario(TipoUsuario.ESTUDIANTE);

        this.biblioteca.getListaUsuarios().add(usuario1);
        this.biblioteca.getListaEstudiantes().add(usuario1);

        Usuario usuario2 = new Usuario();
        usuario2.setUsser("juan");
        usuario2.setPassword("123");
        usuario2.setNombre("Juan");
        usuario2.setCedula("3");
        usuario2.setTipoUsuario(TipoUsuario.ESTUDIANTE);

        this.biblioteca.getListaUsuarios().add(usuario2);
        this.biblioteca.getListaEstudiantes().add(usuario2);

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

    public Set<Usuario> obtenerListaUsuariosEstudiantes() {
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

    public void eliminarLibro(String idLibro) {
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
