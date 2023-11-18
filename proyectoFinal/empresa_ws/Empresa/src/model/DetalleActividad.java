package model;

import java.util.Objects;

public class DetalleActividad {
    //atributos
    private String id;
    private Tarea tarea;

    //Constructor vacio
    public DetalleActividad() {
    }

    //Constructor con atributos
    public DetalleActividad(String id, Tarea tarea) {
        this.id = id;
        this.tarea = tarea;
    }

    //Getters y Setters
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Tarea getTarea() {
        return tarea;
    }
    public void setTarea(Tarea tarea) {
        this.tarea = tarea;
    }

    //metodo equals

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DetalleActividad that = (DetalleActividad) o;
        return Objects.equals(id, that.id);
    }

    //Metodo hashCode
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    //Metodo toString
    @Override
    public String toString() {
        return "DetalleActividad{" +
                "id='" + id + '\'' +
                ", tarea=" + tarea +
                '}';
    }


}
