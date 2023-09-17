package Laboratorio2.Model;

import java.util.*;
import Laboratorio2.Services.*;
public class Biblioteca implements ICrudUsuario, ICrudLibro, ILogin, ITransaccionPrestamo{

    // Atributos
    private String nit;
    private String nombre;
    private Set<Libro> ListaLibrosSinOrdenar = new HashSet<>();
    private TreeSet<Libro> librosOrdenados = new TreeSet<>();
    private TreeSet<Usuario> listaEstudiantes = new TreeSet<>();
    private TreeSet<Usuario> listaBibliotecarios = new TreeSet<>();
    private HashMap<String, Prestamo> listaPrestamos = new HashMap<>();

    // Constructor sin atributos
    public Biblioteca() {
    }

    // Constructor con atributos
    public Biblioteca(String nit, String nombre,
                      Set<Libro> listaLibrosSinOrdenar,
                      TreeSet<Libro> librosOrdenados,
                      TreeSet<Usuario> listaEstudiantes,
                      TreeSet<Usuario> listaBibliotecarios,
                      HashMap<String, Prestamo> listaPrestamos) {
        this.nit = nit;
        this.nombre = nombre;
        ListaLibrosSinOrdenar = listaLibrosSinOrdenar;
        this.librosOrdenados = librosOrdenados;
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

    public Set<Libro> getListaLibrosSinOrdenar() {
        return ListaLibrosSinOrdenar;
    }

    public void setListaLibrosSinOrdenar(Set<Libro> listaLibrosSinOrdenar) {
        ListaLibrosSinOrdenar = listaLibrosSinOrdenar;
    }

    public TreeSet<Libro> getLibrosOrdenados() {
        return librosOrdenados;
    }

    public void setLibrosOrdenados(TreeSet<Libro> librosOrdenados) {
        this.librosOrdenados = librosOrdenados;
    }

    public TreeSet<Usuario> getListaEstudiantes() {
        return listaEstudiantes;
    }

    public void setListaEstudiantes(TreeSet<Usuario> listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }

    public TreeSet<Usuario> getListaBibliotecarios() {
        return listaBibliotecarios;
    }

    public void setListaBibliotecarios(TreeSet<Usuario> listaBibliotecarios) {
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
