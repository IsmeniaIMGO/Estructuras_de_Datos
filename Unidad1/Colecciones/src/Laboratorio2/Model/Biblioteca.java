package Laboratorio2.Model;

import java.util.*;

import Laboratorio2.Exceptions.*;
import Laboratorio2.Services.*;
public class Biblioteca implements ICrudUsuario, ICrudLibro, ILogin, ITransaccionPrestamo{

    // Atributos
    //te amo git :v
    private String nit;
    private String nombre;
    private Set<Libro> ListaLibros = new HashSet<>();
    private Set<Libro> librosPorAutor = new TreeSet<>(Comparator.comparing(Libro::getAutor));
    private Set<Libro> librosPorFecha = new TreeSet<>(Comparator.comparingInt(Libro::getFechaPublicacion));
    private ArrayList<Usuario> listaUsuarios = new ArrayList<>();
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
                      ArrayList<Usuario> listaUsuarios,
                      Set<Usuario> listaEstudiantes,
                      Set<Usuario> listaBibliotecarios,
                      HashMap<String, Prestamo> listaPrestamos) {
        this.nit = nit;
        this.nombre = nombre;
        ListaLibros = listaLibros;
        this.librosPorAutor = librosPorAutor;
        this.librosPorFecha = librosPorFecha;
        this.listaUsuarios = listaUsuarios;
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

    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
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
    public void crearUsuario(String usser, String password, String nombre, String cedula, TipoUsuario tipoUsuario) throws Exception {

        //aqui verifico que sea bibliotecario y lo agrego a a la lista de bibliotecarios o de estudiantes
        if (cedula == null || cedula.equals(""))
            throw new NuloVacioException("el id del cliente es nulo o vacio");

        if(existeUsuario(cedula))
            throw new CedulaYaExisteException("Esta cedula ya se encuentra registrada");

        if(existeUsser(usser))
            throw new UsserYaExisteException("Este usuario ya se encuentra registrado");

        if(nombre.equals("") || tipoUsuario.equals("") || usser.equals("") || password.equals(""))
            throw new ParametroVacioException("Alguno de los parámetros indicados es está vacío");

        Usuario usuario = new Usuario(nombre, cedula, usser, password, tipoUsuario);

        this.listaUsuarios.add(usuario);

        if(tipoUsuario.equals(TipoUsuario.BIBLIOTECARIO)){
            this.listaBibliotecarios.add(usuario);
        }else{
            this.listaEstudiantes.add(usuario);
        }


    }
    @Override
    public boolean existeUsser(String usser) throws Exception{
        for (Usuario usuario : listaUsuarios) {
            if(usuario.getUsser().equals(usser)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Usuario buscarUsuario(String cedula) {
        for (Usuario usuario : listaUsuarios) {
            if(usuario.getCedula().equals(cedula)){
                return usuario;
            }
        }
        return null;

    }

    @Override
    public void eliminarUsuario(String cedula, TipoUsuario tipoUsuario) {
        for (Usuario usuario : listaUsuarios) {
            if(usuario.getCedula().equals(cedula)){
                listaUsuarios.remove(usuario);
            }
        }

        if (tipoUsuario.equals(TipoUsuario.BIBLIOTECARIO)) {
            for (Usuario usuario : listaBibliotecarios) {
                if (usuario.getCedula().equals(cedula)) {
                    listaBibliotecarios.remove(usuario);
                }
            }
        }else {
            for (Usuario usuario : listaEstudiantes) {
                if (usuario.getCedula().equals(cedula)) {
                    listaEstudiantes.remove(usuario);
                }
            }
        }

    }

    @Override
    public void actualizarUsuario(String nuevoUsser, String nuevaPassword, String nuevoNombre, String cedula, TipoUsuario nuevoTipo) {
        if(!cedula.equals("")){

            for(Usuario u : listaUsuarios){
                if(u != null && u.getCedula() != null && u.getCedula().equals(cedula)){
                    if(!nuevoUsser.equals("")) u.setUsser(nuevoUsser);
                    if(!nuevaPassword.equals("")) u.setPassword(nuevaPassword);
                    if(!nuevoNombre.equals("")) u.setNombre(nuevoNombre);
                    if(nuevoTipo != null) u.setTipoUsuario(nuevoTipo);
                }
            }

        }
    }

    @Override
    public boolean existeUsuario(String cedula) {
        for (Usuario usuario : listaUsuarios) {
            if(usuario.getCedula().equals(cedula)){
                return true;
            }
        }
        return false;
    }


    @Override
    public void crearLibro(String id, String nombre, String autor, int fechaPublicacion) throws Exception {
        if (id == null || id.equals(""))
            throw new NuloVacioException("el id del libro es nulo o vacio");

        if(existeLibro(id))
            throw new IdYaExisteException("Este id ya se encuentra registrado");

        if(nombre.equals("") || autor.equals("") || fechaPublicacion == 0)
            throw new ParametroVacioException("Alguno de los parámetros indicados es está vacío");

        Libro libro = new Libro(id, nombre, autor, fechaPublicacion);

        this.ListaLibros.add(libro);
        this.librosPorAutor.add(libro);
        this.librosPorFecha.add(libro);

    }

    @Override
    public Libro buscarLibro(String id) {
        for (Libro libro : ListaLibros) {
            if(libro.getId().equals(id)){
                return libro;
            }
        }
        return null;
    }

    @Override
    public void eliminarLibro(String id) {
        for (Libro libro : ListaLibros) {
            if(libro.getId().equals(id)){
                ListaLibros.remove(libro);
            }
        }

        for (Libro libro : librosPorAutor) {
            if(libro.getId().equals(id)){
                librosPorAutor.remove(libro);
            }
        }

        for (Libro libro : librosPorFecha) {
            if(libro.getId().equals(id)){
                librosPorFecha.remove(libro);
            }
        }
    }

    @Override
    public void actualizarLibro(String id, String nombre, String autor, int fechaPublicacion) {
        if(!id.equals("")){

            for(Libro l : ListaLibros){
                if(l != null && l.getId() != null && l.getId().equals(id)){
                    if(!nombre.equals("")) l.setNombre(nombre);
                    if(!autor.equals("")) l.setAutor(autor);
                    if(fechaPublicacion != 0) l.setFechaPublicacion(fechaPublicacion);
                }
            }
            for(Libro l : librosPorAutor){
                if(l != null && l.getId() != null && l.getId().equals(id)){
                    if(!nombre.equals("")) l.setNombre(nombre);
                    if(!autor.equals("")) l.setAutor(autor);
                    if(fechaPublicacion != 0) l.setFechaPublicacion(fechaPublicacion);
                }
            }

            for(Libro l : librosPorFecha){
                if(l != null && l.getId() != null && l.getId().equals(id)){
                    if(!nombre.equals("")) l.setNombre(nombre);
                    if(!autor.equals("")) l.setAutor(autor);
                    if(fechaPublicacion != 0) l.setFechaPublicacion(fechaPublicacion);
                }
            }

        }
    }

    @Override
    public boolean existeLibro(String id) {
        for (Libro libro : ListaLibros) {
            if(libro.getId().equals(id)){
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean verificarBibliotecario(String usser, String password) {
        Usuario usuario = buscarUsuario(usser);

        if ((usuario != null) && (usuario.getNombre().equals(password)) && (usuario.getTipoUsuario() == TipoUsuario.BIBLIOTECARIO)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean verificarEstudiante(String usser, String password) {
        Usuario usuario = buscarUsuario(usser);

        if ((usuario != null) && (usuario.getNombre().equals(password)) && (usuario.getTipoUsuario() == TipoUsuario.ESTUDIANTE)) {
            return true;
        }
        return false;
    }

    @Override
    public void prestarLibro(String idPrestamo, String cedulaUsuario) {

    }

    @Override
    public void devolverLibro(String idprestamo, String cedulaUsuario) {

    }



}
