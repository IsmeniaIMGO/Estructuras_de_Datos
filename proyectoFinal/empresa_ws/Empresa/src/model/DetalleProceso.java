package model;

import javafx.scene.AccessibleRole;

import java.util.Objects;

public class DetalleProceso {
    // Atributos
    private String id;
    private Actividad actividad;

    // Constructor vacio
    public DetalleProceso() {
    }

    // Constructor con atributos
    public DetalleProceso(String id, Actividad actividad) {
        this.id = id;
        this.actividad = actividad;
    }

    // Getters y Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    //metodo equals

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DetalleProceso that = (DetalleProceso) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    //Metodo toString
    @Override
    public String toString() {
        return "DetalleProceso{" +
                "id='" + id + '\'' +
                ", actividad=" + actividad +
                '}';
    }


}
