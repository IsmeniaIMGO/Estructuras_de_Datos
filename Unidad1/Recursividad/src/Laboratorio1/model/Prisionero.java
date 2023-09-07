package Laboratorio1.model;

import java.util.Objects;

public class Prisionero {
    /*
    atributos
     */
    private String id;
    private String nombre;
    private Espacio espacio;

    /*
    constructor vacio
     */
    public Prisionero() {
    }

    /*
    constructor con atributos
     */
    public Prisionero(String id, String nombre, Espacio espacio) {
        this.id = id;
        this.nombre = nombre;
        this.espacio = espacio;
    }

    /*
    constructor solo con dos atributos
     */
    public Prisionero(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    /*
    metodos set y get
     */
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

    /*
    metodos equals y hashcode
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prisionero that = (Prisionero) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    /*
    metodo to String
     */
    @Override
    public String toString() {
        return "Prisionero{" +
                "nombre='" + nombre + '\'' +
                ", espacio=" + espacio +
                '}';
    }
}
