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

    //---------------------------------------PRISIONERO----------------------------------------------
    public String crearPrisionero(String id, String nombre) throws Exception{
        if (id == null || id.equals(""))
            throw new NuloVacioException("el id del prisioner es nulo o vacio");

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

    private Prisionero buscarPrisionero(String id) {
        for (Prisionero p : listaPrisioneros) {
            if(p.getId().equals(id)) return p;

        }
        return null;
    }

    //---------------------------------------PISO----------------------------------------------
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

    //---------------------------------------ESPACIO----------------------------------------------
    public String crearEspacio(int numeroPiso, int fila, int columna, TipoEspacio tipoEspacio) throws Exception{
        if (numeroPiso <= 0)
            throw new NuloVacioException("el numero del piso debe ser mayor a 0");

        if (fila < 0 || fila > 5)
            throw new NuloVacioException("el numero de fila debe ser mayor a 0 y menor a 5");

        if (columna < 0 || columna > 6)
            throw new NuloVacioException("el numero de columna debe ser mayor a 0 y menor a 6");

        if (tipoEspacio == null)
            throw new NuloVacioException("el tipo de espacio no puede ser nulo");

        if(existeEspacio(numeroPiso, fila, columna))
            throw new IdYaExisteException("Este espacio ya se encuentra registrado");

        Espacio espacio = new Espacio(false, null, tipoEspacio);
        this.listaPisos.get(numeroPiso-1).agregarEspacio(espacio, fila, columna);

        return "El espacio ha sido creado exitosamente";
    }

    private boolean existeEspacio(int numeroPiso, int fila, int columna) {
        if(listaPisos.get(numeroPiso-1).getMatrizEspacios()[fila][columna] != null) return true;
        return false;
    }

    //-------------------------METODOS------------------------------------------------------------
    public String asignarEspacioAPrisionero(String id, int numeroPiso, int fila, int columna) throws Exception{
        if (numeroPiso <= 0)
            throw new NuloVacioException("el numero del piso debe ser mayor a 0");

        if (fila < 0 || fila > 5)
            throw new NuloVacioException("el numero de fila debe ser mayor a 0 y menor a 5");

        if (columna < 0 || columna > 6)
            throw new NuloVacioException("el numero de columna debe ser mayor a 0 y menor a 6");

        if (id == null || id.equals(""))
            throw new NuloVacioException("el id del prisionero es nulo o vacio");

        if(!existePrisionero(id))
            throw new IdNoExisteException("Este ID no se encuentra registrado");

        if (espacioOcupado(numeroPiso, fila, columna))
            throw new EspacioOcupadoException("El espacio ya se encuentra ocupado por otro prisionero");

        Espacio espacio = new Espacio(true, buscarPrisionero(id), TipoEspacio.CELDA);
        this.listaPisos.get(numeroPiso-1).agregarEspacio(espacio, fila, columna);

        return "El espacio ha sido asignado a un prisionero exitosamente";
    }

    private boolean espacioOcupado(int numeroPiso, int fila, int columna) {
        if(listaPisos.get(numeroPiso-1).getMatrizEspacios()[fila][columna].isEstado()) return true;
        return false;
    }


}

