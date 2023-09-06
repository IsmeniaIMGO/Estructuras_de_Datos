package Laboratorio1.model;

import java.util.Objects;

public class Prisionero {
    private int id;
    private String nombre;
    private Espacio espacio;

    public Prisionero() {
    }

    public Prisionero(int id, String nombre, Espacio espacio) {
        this.id = id;
        this.nombre = nombre;
        this.espacio = espacio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
        return Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public String toString() {
        return "Prisionero{" +
                "nombre='" + nombre + '\'' +
                ", espacio=" + espacio +
                '}';
    }
}
