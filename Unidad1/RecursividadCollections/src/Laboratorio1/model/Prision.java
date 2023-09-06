package Laboratorio1.model;

import java.lang.reflect.Array;
import java.util.*;

public class Prision {
    private int id;
    private String nombre;
    private ArrayList<Prisionero>  listaPrisioneros;
    private ArrayList<Piso> listaPisos;


    public Prision() {
    }

    public Prision(int id, String nombre, ArrayList<Prisionero> listaPrisioneros, ArrayList<Piso> listaPisos) {
        this.id = id;
        this.nombre = nombre;
        this.listaPrisioneros = listaPrisioneros;
        this.listaPisos = listaPisos;
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

    public ArrayList<Prisionero> getListaPrisioneros() {
        return listaPrisioneros;
    }

    public void setListaPrisioneros(ArrayList<Prisionero> listaPrisioneros) {
        this.listaPrisioneros = listaPrisioneros;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prision prision = (Prision) o;
        return id == prision.id;
    }

    public ArrayList<Piso> getListaPisos() {
        return listaPisos;
    }

    public void setListaPisos(ArrayList<Piso> listaPisos) {
        this.listaPisos = listaPisos;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Prision{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", listaPrisioneros=" + listaPrisioneros +
                ", listaPisos=" + listaPisos +
                '}';
    }


}
