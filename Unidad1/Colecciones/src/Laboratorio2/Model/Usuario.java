package Laboratorio2.Model;

import java.util.ArrayList;
import java.util.Objects;

public class Usuario implements Comparable<Usuario>{
    // Atributos
    private String nombre;
    private String cedula;
    private String usser;
    private String password;
    private TipoUsuario tipoUsuario;
    private ArrayList<Prestamo> listaPrestamos = new ArrayList<>();

    // Constructor sin atributos
    public Usuario() {
    }

    // Constructor con atributos
    public Usuario(String nombre, String cedula, String usser, String password, TipoUsuario tipoUsuario) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.usser = usser;
        this.password = password;
        this.tipoUsuario = tipoUsuario;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getUsser() {
        return usser;
    }

    public void setUsser(String usser) {
        this.usser = usser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public ArrayList<Prestamo> getListaPrestamos() {
        return listaPrestamos;
    }

    public void setListaPrestamos(ArrayList<Prestamo> listaPrestamos) {
        this.listaPrestamos = listaPrestamos;
    }

    // Metodos equals

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(cedula, usuario.cedula);
    }


    // Metodos hashCode
    @Override
    public int hashCode() {
        return Objects.hash(cedula);
    }

    // Metodo toString
    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", cedula='" + cedula + '\'' +
                ", tipoUsuario=" + tipoUsuario +
                '}';
    }

    // Metodo compareTo
    @Override
    public int compareTo(Usuario o) {
        return this.cedula.compareTo(o.cedula);
    }



}
