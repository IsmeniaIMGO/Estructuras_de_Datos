package model;

import java.util.ArrayList;
import java.util.Objects;

public class Proceso {
    // Atributos
    private String id;
    private String nombre;
    private int tiempoMaximo;
    private int tiempoMinimo;

    // Relacion con otras clases
    private ArrayList<DetalleProceso> listaDetalleProceso = new ArrayList<>();

    // Constructor vacio
    public Proceso() {
    }

    // Constructor con atributos


    public Proceso(String id, String nombre, int tiempoMaximo, int tiempoMinimo, ArrayList<DetalleProceso> listaDetalleProceso) {
        this.id = id;
        this.nombre = nombre;
        this.tiempoMaximo = tiempoMaximo;
        this.tiempoMinimo = tiempoMinimo;
        this.listaDetalleProceso = listaDetalleProceso;
    }

    // Getters y Setters


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

    public int getTiempoMaximo() {
        return tiempoMaximo;
    }

    public void setTiempoMaximo(int tiempoMaximo) {
        this.tiempoMaximo = tiempoMaximo;
    }

    public int getTiempoMinimo() {
        return tiempoMinimo;
    }

    public void setTiempoMinimo(int tiempoMinimo) {
        this.tiempoMinimo = tiempoMinimo;
    }

    public ArrayList<DetalleProceso> getListaDetalleProceso() {
        return listaDetalleProceso;
    }

    public void setListaDetalleProceso(ArrayList<DetalleProceso> listaDetalleProceso) {
        this.listaDetalleProceso = listaDetalleProceso;
    }

// Metodo hashCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Proceso proceso = (Proceso) o;
        return Objects.equals(id, proceso.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // Metodo toString

    @Override
    public String toString() {
        return "Proceso{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", tiempoMaximo=" + tiempoMaximo +
                ", tiempoMinimo=" + tiempoMinimo ;
    }



}
