package Laboratorio1.model;

import java.util.Objects;

public class Prisionero {
    private String id;
    private String nombre;
    private Espacio espacio;

    public Prisionero() {
    }

    public Prisionero(String id, String nombre, Espacio espacio) {
        this.id = id;
        this.nombre = nombre;
        this.espacio = espacio;
    }

    public Prisionero(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Espacio getEspacio() {
        return espacio;
    }

    public void setEspacio(Espacio espacio) {
        this.espacio = espacio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prisionero that = (Prisionero) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Prisionero{" +
                "nombre='" + nombre + '\'' +
                ", espacio=" + espacio +
                '}';
    }
}
