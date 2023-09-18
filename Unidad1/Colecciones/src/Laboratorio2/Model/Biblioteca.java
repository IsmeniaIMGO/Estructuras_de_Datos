package Laboratorio2.Model;

import java.util.*;
import Laboratorio2.Services.*;
public class Biblioteca implements ICrudUsuario, ICrudLibro, ILogin, ITransaccionPrestamo{

    // Atributos
    //te amo git :v
    private String nit;
    private String nombre;
    private Set<Libro> ListaLibros = new HashSet<>();
    private Set<Libro> librosPorAutor = new TreeSet<>(Comparator.comparing(Libro::getAutor));
    private Set<Libro> librosPorFecha = new TreeSet<>(Comparator.comparingInt(Libro::getFechaPublicacion));
    private Set<Usuario> listaEstudiantes = new TreeSet<>();
    private Set<Usuario> listaBibliotecarios = new HashSet<>();
    private HashMap<String, Prestamo> listaPrestamos = new HashMap<>();


    // Constructor sin atributos
    public Biblioteca() {
    }

    // Constructor con atributos


    public Biblioteca(String nit, String nombre,
                      Set<Libro> listaLibros,
                      Set<Libro> librosPorAutor,
                      Set<Libro> librosPorFecha,
                      Set<Usuario> listaEstudiantes,
                      Set<Usuario> listaBibliotecarios,
                      HashMap<String, Prestamo> listaPrestamos) {
        this.nit = nit;
        this.nombre = nombre;
        ListaLibros = listaLibros;
        this.librosPorAutor = librosPorAutor;
        this.librosPorFecha = librosPorFecha;
        this.listaEstudiantes = listaEstudiantes;
        this.listaBibliotecarios = listaBibliotecarios;
        this.listaPrestamos = listaPrestamos;
    }

    // Getters y Setters

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Libro> getListaLibros() {
        return ListaLibros;
    }

    public void setListaLibros(Set<Libro> listaLibros) {
        ListaLibros = listaLibros;
    }

    public Set<Libro> getLibrosPorAutor() {
        return librosPorAutor;
    }

    public void setLibrosPorAutor(Set<Libro> librosPorAutor) {
        this.librosPorAutor = librosPorAutor;
    }

    public Set<Libro> getLibrosPorFecha() {
        return librosPorFecha;
    }

    public void setLibrosPorFecha(Set<Libro> librosPorFecha) {
        this.librosPorFecha = librosPorFecha;
    }

    public Set<Usuario> getListaEstudiantes() {
        return listaEstudiantes;
    }

    public void setListaEstudiantes(Set<Usuario> listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }

    public Set<Usuario> getListaBibliotecarios() {
        return listaBibliotecarios;
    }

    public void setListaBibliotecarios(Set<Usuario> listaBibliotecarios) {
        this.listaBibliotecarios = listaBibliotecarios;
    }

    public HashMap<String, Prestamo> getListaPrestamos() {
        return listaPrestamos;
    }

    public void setListaPrestamos(HashMap<String, Prestamo> listaPrestamos) {
        this.listaPrestamos = listaPrestamos;
    }

    // Metodos hashCode y equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Biblioteca that = (Biblioteca) o;
        return Objects.equals(nit, that.nit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nit);
    }

    // Metodo toString
    @Override
    public String toString() {
        return "Biblioteca{" +
                "nit='" + nit + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }


    //----------------------------------------------------------------------------------
    // Metodos implementados de las interfaces
    //----------------------------------------------------------------------------------



    @Override
    public void crearUsuario(String usser, String password, String nombre, String cedula, String tipoUsuario) {

        //aqui verifico que sea bibliotecario y lo agrego a a la lista de bibliotecarios o de estudiantes
    }

    @Override
    public Usuario buscarUsuario(String cedula) {
        return null;
    }

    @Override
    public void eliminarUsuario(String cedula) {

    }

    @Override
    public void actualizarUsuario(String usser, String password, String nombre, String cedula, String tipoUsuario) {

    }

    @Override
    public boolean existeUsuario(String cedula) {
        return false;
    }


    @Override
    public void crearLibro(String id, String nombre, String autor, int fechaPublicacion) {

    }

    @Override
    public Libro buscarLibro(String id) {
        return null;
    }

    @Override
    public void eliminarLibro(String id) {

    }

    @Override
    public void actualizarLibro(String id, String nombre, String autor, int fechaPublicacion) {

    }

    @Override
    public boolean existeLibro(String id) {
        return false;
    }


    @Override
    public void prestarLibro(String idPrestamo, String cedulaUsuario) {

    }

    @Override
    public void devolverLibro(String idprestamo, String cedulaUsuario) {

    }

    @Override
    public boolean verificarBibliotecario(String usuario, String password) {
        return false;
    }

    @Override
    public boolean verificarEstudiante(String usuario, String password) {
        return false;
    }





}
