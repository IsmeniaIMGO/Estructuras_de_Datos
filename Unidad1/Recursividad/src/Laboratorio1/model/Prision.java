package Laboratorio1.model;

import java.util.*;
import Laboratorio1.exceptions.*;

public class Prision {
    private String id;
    private String nombre;
    private ArrayList<Prisionero>  listaPrisioneros;
    private ArrayList<Piso> listaPisos;


    public Prision() {
    }

    public Prision(String id, String nombre, ArrayList<Prisionero> listaPrisioneros, ArrayList<Piso> listaPisos) {
        this.id = id;
        this.nombre = nombre;
        this.listaPrisioneros = listaPrisioneros;
        this.listaPisos = listaPisos;
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

    public ArrayList<Prisionero> getListaPrisioneros() {
        return listaPrisioneros;
    }

    public void setListaPrisioneros(ArrayList<Prisionero> listaPrisioneros) {
        this.listaPrisioneros = listaPrisioneros;
    }

    public ArrayList<Piso> getListaPisos() {
        return listaPisos;
    }

    public void setListaPisos(ArrayList<Piso> listaPisos) {
        this.listaPisos = listaPisos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prision prision = (Prision) o;
        return Objects.equals(id, prision.id);
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

    public String crearUsuario(String id, String nombre) throws Exception{
        if (id == null || id.equals(""))
            throw new NuloVacioException("el id del cliente es nulo o vacio");

        if(existePrisionero(String.valueOf(id)))
            throw new IdYaExisteException("Este ID ya se encuentra registrado");

        if(nombre.equals(""))
            throw new ParametroVacioException("Alguno de los parámetros indicados es está vacío");

        Prisionero prisionero = new Prisionero(id, nombre);
        this.listaPrisioneros.add(prisionero);

        return "El prisionero ha sido creado exitosamente";
    }

    public boolean existePrisionero(String id) throws NullPointerException {

        for (Prisionero u : listaPrisioneros) {
            if(u.getId().equals(id)) return true;

        }
        return false;
    }

    public String crearPiso(int numeroPiso) throws Exception{
        if (numeroPiso <= 0)
            throw new NuloVacioException("el numero del piso debe ser mayor a 0");

        if(existePiso(numeroPiso))
            throw new IdYaExisteException("Este numero de piso ya se encuentra registrado");

        Piso piso = new Piso(numeroPiso, new Espacio[5][6]);
        this.listaPisos.add(piso);

        return "El piso ha sido creado exitosamente";
    }

    private boolean existePiso(int numeroPiso) {
        for (Piso p : listaPisos) {
            if(p.getNumeroPiso() == numeroPiso) return true;

        }
        return false;
    }

}
