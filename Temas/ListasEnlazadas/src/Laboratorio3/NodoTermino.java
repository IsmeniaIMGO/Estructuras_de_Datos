package Laboratorio3;

/**
 * Definicion de la clase NodoTermino
 */
public class NodoTermino {
    private double coeficiente;
    private int exponente;
    private NodoTermino siguiente;

    /**
     * Constructor por defecto de la clase NodoTermino
     */
    public NodoTermino(double coeficiente, int exponente) {
        this.coeficiente = coeficiente;
        this.exponente = exponente;
        this.siguiente = null;
    }

    //metodos get y set
    public double getCoeficiente() {
        return coeficiente;
    }

    public void setCoeficiente(double coeficiente) {
        this.coeficiente = coeficiente;
    }

    public int getExponente() {
        return exponente;
    }

    public void setExponente(int exponente) {
        this.exponente = exponente;
    }

    public NodoTermino getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoTermino siguiente) {
        this.siguiente = siguiente;
    }

    /**
     * Metodo toString de la clase NodoTermino
     * @return
     */
    @Override
    public String toString() {
        return "NodoTermino{" +
                "coeficiente=" + coeficiente +
                ", exponente=" + exponente +
                ", siguiente=" + siguiente +
                '}';
    }
}
