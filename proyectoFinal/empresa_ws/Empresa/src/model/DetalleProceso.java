package model;

import javafx.scene.AccessibleRole;

import java.util.Objects;

public class DetalleProceso {
    // Atributos
    private Actividad actividad;

    // Constructor vacio
    public DetalleProceso() {
    }

    // Constructor con atributos
    public DetalleProceso( Actividad actividad) {
        this.actividad = actividad;
    }

    // Getters y Setters


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
        return Objects.equals(actividad, that.actividad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actividad);
    }

    //Metodo toString

    @Override
    public String toString() {
        return "DetalleProceso{" +
                "actividad=" + actividad +
                '}';
    }

    public int calcularTiempoMaximo() {
        return actividad.calcularTiempoMaximo();
    }

    public int calcularTiempoMinimo() {
        if (actividad.getTipoCumplimiento().equals(TipoCumplimiento.OBLIGATORIO)) {
            return actividad.calcularTiempoMinimo();
        }
        return 0;
    }
}
