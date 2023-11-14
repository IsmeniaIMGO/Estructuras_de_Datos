package Laboratorio1.model;

public class Espacio {
    /*
    atributos
     */
    private boolean estado;
    private Prisionero prisionero;
    private TipoEspacio tipoEspacio;


    /*
    constructor vacio
     */
    public Espacio() {
    }

    /*
    constructor con atributos
     */
    public Espacio(boolean estado, Prisionero prisionero, TipoEspacio tipoEspacio) {
        this.estado = estado;
        this.prisionero = prisionero;
        this.tipoEspacio = tipoEspacio;
    }


    /*
    metodos set y get
     */
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


    /*
    metodo toString
     */
    @Override
    public String toString() {
        return " "+tipoEspacio + " " ;
    }
}
