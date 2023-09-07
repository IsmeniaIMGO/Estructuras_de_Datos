package Laboratorio1.model;

public class Espacio {
    private boolean estado;

    private Prisionero prisionero;
    private TipoEspacio tipoEspacio;


    public Espacio() {
    }

    public Espacio(boolean estado, Prisionero prisionero, TipoEspacio tipoEspacio) {
        this.estado = estado;
        this.prisionero = prisionero;
        this.tipoEspacio = tipoEspacio;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public TipoEspacio getTipoEspacio() {
        return tipoEspacio;
    }

    public void setTipoEspacio(TipoEspacio tipoEspacio) {
        this.tipoEspacio = tipoEspacio;
    }

    public Prisionero getPrisionero() {
        return prisionero;
    }

    public void setPrisionero(Prisionero prisionero) {
        this.prisionero = prisionero;
    }

    @Override
    public String toString() {
        return " "+tipoEspacio + " " ;
    }
}
