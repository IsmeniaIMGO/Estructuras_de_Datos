package model;

import java.util.ArrayList;
import java.util.Objects;

public class Usuario {
    // Atributos
    private String nombre;
    private String cedula;
    private String usser;
    private String password;
    private TipoUsuario tipoUsuario;

    //relacion con otras clases
    private ArrayList<Proceso> procesos = new ArrayList<>();

    // Constructor vacio
    public Usuario() {
    }

    // Constructor con atributos

    public Usuario(String nombre, String cedula, String usser, String password, TipoUsuario tipoUsuario, ArrayList<Proceso> procesos) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.usser = usser;
        this.password = password;
        this.tipoUsuario = tipoUsuario;
        this.procesos = procesos;
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

    public ArrayList<Proceso> getProcesos() {
        return procesos;
    }

    public void setProcesos(ArrayList<Proceso> procesos) {
        this.procesos = procesos;
    }

    //metodo equals

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(cedula, usuario.cedula);
    }

    //metodo hashCode
    @Override
    public int hashCode() {
        return Objects.hash(cedula);
    }

    // Metodo toString
    @Override
    public String toString() {
        return "nombre: " + nombre + " - cedula: " + cedula;
    }
}
