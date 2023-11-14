package Laboratorio2.Model;

import java.util.*;

import Laboratorio2.Exceptions.*;
import Laboratorio2.Services.*;
public class Biblioteca implements ICrudUsuario, ICrudLibro, ILogin, ITransaccionPrestamo{

    // Atributos
    //te amo git :v
    private String nit;
    private String nombre;
    private HashSet<Libro> ListaLibros = new HashSet<>();
    private TreeSet<Libro> librosPorAutor = new TreeSet<>(Comparator.comparing(Libro::getAutor));
    private TreeSet<Libro> librosPorFecha = new TreeSet<>(Comparator.comparingInt(Libro::getFechaPublicacion));
    private ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    private TreeSet<Usuario> listaEstudiantes = new TreeSet<>(Comparator.comparing(Usuario::getCedula));
    private HashSet<Usuario> listaBibliotecarios = new HashSet<>();
    private HashMap<String, Prestamo> listaPrestamos = new HashMap<>();

    private ArrayList<Usuario> listaLogin = new ArrayList<>();


    // Constructor sin atributos
    public Biblioteca() {
    }

    // Constructor con atributos
    public Biblioteca(String nit, String nombre,
                      HashSet<Libro> listaLibros,
                      TreeSet<Libro> librosPorAutor,
                      TreeSet<Libro> librosPorFecha,
                      ArrayList<Usuario> listaUsuarios,
                      TreeSet<Usuario> listaEstudiantes,
                      HashSet<Usuario> listaBibliotecarios,
                      HashMap<String, Prestamo> listaPrestamos,
                      ArrayList<Usuario> listaLogin) {
        this.nit = nit;
        this.nombre = nombre;
        this.ListaLibros = listaLibros;
        this.librosPorAutor = librosPorAutor;
        this.librosPorFecha = librosPorFecha;
        this.listaUsuarios = listaUsuarios;
        this.listaEstudiantes = listaEstudiantes;
        this.listaBibliotecarios = listaBibliotecarios;
        this.listaPrestamos = listaPrestamos;
        this.listaLogin = listaLogin;
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

    public HashSet<Libro> getListaLibros() {
        return ListaLibros;
    }

    public void setListaLibros(HashSet<Libro> listaLibros) {
        ListaLibros = listaLibros;
    }

    public Set<Libro> getLibrosPorAutor() {
        return librosPorAutor;
    }

    public void setLibrosPorAutor(TreeSet<Libro> librosPorAutor) {
        this.librosPorAutor = librosPorAutor;
    }

    public Set<Libro> getLibrosPorFecha() {
        return librosPorFecha;
    }

    public void setLibrosPorFecha(TreeSet<Libro> librosPorFecha) {
        this.librosPorFecha = librosPorFecha;
    }

    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public TreeSet<Usuario> getListaEstudiantes() {
        return listaEstudiantes;
    }

    public void setListaEstudiantes(TreeSet<Usuario> listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }

    public HashSet<Usuario> getListaBibliotecarios() {
        return listaBibliotecarios;
    }

    public void setListaBibliotecarios(HashSet<Usuario> listaBibliotecarios) {
        this.listaBibliotecarios = listaBibliotecarios;
    }

    public HashMap<String, Prestamo> getListaPrestamos() {
        return listaPrestamos;
    }

    public void setListaPrestamos(HashMap<String, Prestamo> listaPrestamos) {
        this.listaPrestamos = listaPrestamos;
    }

    public ArrayList<Usuario> getListaLogin() {
        return listaLogin;
}

    public void setListaLogin(ArrayList<Usuario> listaLogin) {
        this.listaLogin = listaLogin;
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
        ArrayList<Libro> librosPrestados = new ArrayList<Libro>();

        Usuario usuario = new Usuario(nombre, cedula, usser, password, tipoUsuario, librosPrestados);

        this.listaUsuarios.add(usuario);
        this.listaBibliotecarios.add(usuario);

        if (tipoUsuario == TipoUsuario.ESTUDIANTE)
            this.listaEstudiantes.add(usuario);

    }
    @Override
    public boolean existeUsser(String usser) throws Exception{
        Iterator<Usuario> iterator = listaUsuarios.iterator();
        while (iterator.hasNext()) {
            Usuario usuario = iterator.next();
            if (usuario.getUsser().equals(usser)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Usuario buscarUsuario(String cedula) {
        Iterator<Usuario> iterator = listaUsuarios.iterator();
        while (iterator.hasNext()) {
            Usuario usuario = iterator.next();
            if (usuario.getCedula().equals(cedula)) {
                return usuario;
            }
        }
        return null;

    }

    @Override
    public void eliminarUsuario(String cedula) throws Exception {

        if (!existeUsuario(cedula))
            throw new UsuarioException("El usuario con ID " + cedula + " no se encuentra registrado dentro de la empresa");

        Iterator<Usuario> iterator = listaUsuarios.iterator();
        while (iterator.hasNext()) {
            Usuario u = iterator.next();
            if (u.getCedula().equals(cedula)) {
                iterator.remove();  // Elimina el usuario actual de la lista
                break;  // Termina el bucle después de eliminar el usuario
            }
        }

        Iterator<Usuario> iterator2 = listaEstudiantes.iterator();
        while (iterator2.hasNext()) {
            Usuario u = iterator2.next();
            if (u.getCedula().equals(cedula)) {
                iterator2.remove();  // Elimina el estudiante actual del TreeSet
                break;  // Termina el bucle después de eliminar el estudiante
            }
        }

        Iterator<Usuario> iterator3 = listaBibliotecarios.iterator();
        while (iterator3.hasNext()) {
            Usuario u = iterator3.next();
            if (u.getCedula().equals(cedula)) {
                iterator3.remove();  // Elimina el bibliotecario actual del HashSet
                break;  // Termina el bucle después de eliminar el bibliotecario
            }
        }

    }

    @Override
    public void actualizarUsuario(String nuevoUsser, String nuevaPassword, String nuevoNombre, String cedula, TipoUsuario nuevoTipo) {
        if(!cedula.equals("")){

            Iterator<Usuario> iterator = listaUsuarios.iterator();
            while (iterator.hasNext()) {
                Usuario u = iterator.next();
                if (u != null && u.getCedula() != null && u.getCedula().equals(cedula)) {
                    if (!nuevoUsser.equals("")) u.setUsser(nuevoUsser);
                    if (!nuevaPassword.equals("")) u.setPassword(nuevaPassword);
                    if (!nuevoNombre.equals("")) u.setNombre(nuevoNombre);
                    if (nuevoTipo != null) u.setTipoUsuario(nuevoTipo);
                }
            }

        }
    }

    @Override
    public boolean existeUsuario(String cedula) {
        Iterator<Usuario> iterator = listaUsuarios.iterator();
        while (iterator.hasNext()) {
            Usuario usuario = iterator.next();
            if (usuario.getCedula().equals(cedula)) {
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
        this.librosPorAutor.addAll(ListaLibros);
        this.librosPorFecha.addAll(ListaLibros);

    }

    @Override
    public Libro buscarLibro(String id) {
        Iterator<Libro> iterator = ListaLibros.iterator();
        while (iterator.hasNext()) {
            Libro libro = iterator.next();
            if (libro.getId().equals(id)) {
                return libro;
            }
        }
        return null;
    }

    @Override
    public void eliminarLibro(String id) throws LibroException {
        if (!existeLibro(id))
            throw new LibroException("El libro con ID " + id + " no se encuentra registrado dentro de la empresa");

        Iterator<Libro> iterator = ListaLibros.iterator();
        while (iterator.hasNext()) {
            Libro libro = iterator.next();
            if (libro.getId().equals(id)) {
                iterator.remove();
                break;
            }
        }

        Iterator<Libro> iterator2 = librosPorAutor.iterator();
        while (iterator2.hasNext()) {
            Libro libro = iterator2.next();
            if (libro.getId().equals(id)) {
                iterator2.remove();
                break;
            }
        }

        Iterator<Libro> iterator3 = librosPorFecha.iterator();
        while (iterator3.hasNext()) {
            Libro libro = iterator3.next();
            if (libro.getId().equals(id)) {
                iterator3.remove();
                break;
            }
        }
    }

    @Override
    public void actualizarLibro(String id, String nombre, String autor, int fechaPublicacion) {
        if(!id.equals("")){

            Iterator<Libro> iterator = ListaLibros.iterator();
            while (iterator.hasNext()) {
                Libro libro = iterator.next();
                if (libro != null && libro.getId() != null && libro.getId().equals(id)) {
                    if (!nombre.equals("")) libro.setNombre(nombre);
                    if (!autor.equals("")) libro.setAutor(autor);
                    if (fechaPublicacion != 0) libro.setFechaPublicacion(fechaPublicacion);
                }
            }

        }
    }

    @Override
    public boolean existeLibro(String id) {
        Iterator<Libro> iterator = ListaLibros.iterator();
        while (iterator.hasNext()) {
            Libro libro = iterator.next();
            if (libro.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean verificarBibliotecario(String usser, String password) {
        Usuario usuario = buscarUsser(usser);

        if ((usuario != null) && (usuario.getPassword().equals(password)) && (usuario.getTipoUsuario() == TipoUsuario.BIBLIOTECARIO)) {
            return true;
        }
        return false;
    }

    private Usuario buscarUsser(String usser) {
        Iterator<Usuario> iterator = listaUsuarios.iterator();
        while (iterator.hasNext()) {
            Usuario usuario = iterator.next();
            if (usuario.getUsser().equals(usser)) {
                return usuario;
            }
        }
        return null;
    }

    @Override
    public boolean verificarEstudiante(String usser, String password) {
        Usuario usuario = buscarUsser(usser);

        if ((usuario != null) && (usuario.getPassword().equals(password)) && (usuario.getTipoUsuario() == TipoUsuario.ESTUDIANTE)) {
            listaLogin.add(usuario);
            return true;
        }
        return false;
    }

    @Override
    public void prestarLibro(Libro libro, Usuario usuario) throws Exception {
        Random random = new Random();

        if (libro == null)
            throw new NuloVacioException("Elija un libro para el prestamo");

        if (usuario==null)
            throw new NuloVacioException("Elija su usuario para hacer el prestamo");

        HashMap<String, DetallePrestamo> listaDetallePrestamo = new HashMap<>();
        String id = libro.getId();
        if (listaPrestamos.containsKey(id))
            id = String.valueOf(random.nextInt(100)) ;

        listaDetallePrestamo.put(libro.getId(), new DetallePrestamo(libro.getId(), libro));

        Prestamo prestamo = new Prestamo(id, usuario, listaDetallePrestamo);

        usuario.getListaPrestamos().add(libro);
        listaPrestamos.put(prestamo.getId(), prestamo);

    }

    @Override
    public void devolverLibro(Libro libro, Usuario usuario) throws Exception {

        if (libro == null)
            throw new NuloVacioException("Elija un libro para el prestamo");

        if (usuario==null)
            throw new NuloVacioException("Elija su usuario para hacer el prestamo");



        Iterator<Usuario> iterator = listaUsuarios.iterator();
        while (iterator.hasNext()) {
            Usuario u = iterator.next();
            if (u.getCedula().equals(usuario.getCedula())) {
                u.getListaPrestamos().remove(libro);
                break;
            }
        }

        listaPrestamos.remove(libro.getId());

    }

    public ArrayList<Libro> listaLibrosPrestados(String cedula) {
        ArrayList<Libro> librosPrestados = new ArrayList<>();
        Iterator<Usuario> iterator = listaUsuarios.iterator();
        while (iterator.hasNext()) {
            Usuario usuario = iterator.next();
            if (usuario.getCedula().equals(cedula)) {
                librosPrestados = usuario.getListaPrestamos();
                break;
            }
        }
        return librosPrestados;
    }

    public void cerrarSesion() {
        listaLogin.clear();
    }
}
