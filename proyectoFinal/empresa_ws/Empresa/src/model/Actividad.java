package model;

import java.util.ArrayList;
import java.util.Objects;

public class Actividad {
    //Atributos
    private String nombre;
    private String descripcion;
    private int tiempoMaximo;
    private int tiempoMinimo;

    //relacion con otras clases
    private TipoCumplimiento tipoCumplimiento;
    private ArrayList<DetalleActividad> listaDetalleActividad = new ArrayList<>();

    //Constructor vacio
    public Actividad() {
    }

    //Constructor con atributos


    public Actividad(String nombre, String descripcion, int tiempoMaximo, int tiempoMinimo, TipoCumplimiento tipoCumplimiento, ArrayList<DetalleActividad> listaDetalleActividad) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tiempoMaximo = tiempoMaximo;
        this.tiempoMinimo = tiempoMinimo;
        this.listaDetalleActividad = listaDetalleActividad;
        this.tipoCumplimiento = tipoCumplimiento;
    }


    //Getters y Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public TipoCumplimiento getTipoCumplimiento() {
        return tipoCumplimiento;
    }

    public void setTipoCumplimiento(TipoCumplimiento tipoCumplimiento) {
        this.tipoCumplimiento = tipoCumplimiento;
    }

    public ArrayList<DetalleActividad> getListaDetalleActividad() {
        return listaDetalleActividad;
    }

    public void setListaDetalleActividad(ArrayList<DetalleActividad> listaDetalleActividad) {
        this.listaDetalleActividad = listaDetalleActividad;
    }


    //metodo equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actividad actividad = (Actividad) o;
        return Objects.equals(nombre, actividad.nombre);
    }
    //Metodo hashCode
    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    //Metodo toString
    @Override
    public String toString() {
        return "Actividad{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", tiempoMaximo=" + tiempoMaximo +
                ", tiempoMinimo=" + tiempoMinimo +
                ", tipoCumplimiento=" + tipoCumplimiento;
    }

    public int calcularTiempoMaximo() {
        for (DetalleActividad detalleActividad : listaDetalleActividad) {
            tiempoMaximo = tiempoMaximo + detalleActividad.calcularTiempoMaximo();
        }
        return tiempoMaximo;
    }

    public int calcularTiempoMinimo() {
        for (DetalleActividad detalleActividad : listaDetalleActividad) {
            tiempoMinimo = tiempoMinimo + detalleActividad.calcularTiempoMinimo();
        }
        return tiempoMinimo;
    }
}
