package model;

import java.util.Objects;

public class DetalleActividad {
    //atributos
    private Tarea tarea;

    //Constructor vacio
    public DetalleActividad() {
    }

    //Constructor con atributos
    public DetalleActividad(Tarea tarea) {
        this.tarea = tarea;
    }

    //Getters y Setters
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
        return Objects.equals(tarea, that.tarea);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tarea);
    }

    //Metodo toString

    @Override
    public String toString() {
        return "DetalleActividad{" +
                "tarea=" + tarea +
                '}';
    }
}
