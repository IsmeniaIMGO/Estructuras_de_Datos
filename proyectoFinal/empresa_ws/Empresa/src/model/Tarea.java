package model;

import java.util.Objects;

public class Tarea {

    //atributos
    private String nombre;
    private String descripcion;
    private int tiempo;
    private TipoEstado estado;
    private TipoCumplimiento cumplimiento;

    //relacion con otras clases


    //Constructor vacio
    public Tarea() {
    }

    //Constructor con atributos

    public Tarea(String nombre, String descripcion, int tiempo, TipoEstado estado, TipoCumplimiento cumplimiento) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tiempo = tiempo;
        this.estado = estado;
        this.cumplimiento = cumplimiento;
    }

    //Getters y Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public TipoEstado getEstado() {
        return estado;
    }

    public void setEstado(TipoEstado estado) {
        this.estado = estado;
    }

    public TipoCumplimiento getCumplimiento() {
        return cumplimiento;
    }

    public void setCumplimiento(TipoCumplimiento cumplimiento) {
        this.cumplimiento = cumplimiento;
    }

    //Metodo equals

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tarea tarea = (Tarea) o;
        return Objects.equals(nombre, tarea.nombre);
    }

    //metodo hashCode
    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    //Metodo toString

    @Override
    public String toString() {
        return "Tarea{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", tiempo=" + tiempo +
                ", estado=" + estado +
                ", cumplimiento=" + cumplimiento +
                '}';
    }



}
