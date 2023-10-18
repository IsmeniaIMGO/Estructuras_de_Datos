package Laboratorio3;

import java.util.Objects;

/**
 * Definicion de la clase Persona
 */
public class Persona {
    private String nombre;
    private int cedula;

    /**
     * Constructor por defecto de la clase Persona
     */
    public Persona(String nombre, int cedula) {
        this.nombre = nombre;
        this.cedula = cedula;
    }

    //metodos get y set
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    /**
     * Metodo equals de la clase Persona
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return cedula == persona.cedula;
    }

    /**
     * Metodo hashCode de la clase Persona
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(cedula);
    }

    /**
     * Metodo toString de la clase Persona
     * @return
     */
    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", cedula=" + cedula +
                '}';
    }
}
