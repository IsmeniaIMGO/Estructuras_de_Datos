package Laboratorio3;

public class NodoTermino {
    double coeficiente;
    int exponente;
    NodoTermino siguiente;

    public NodoTermino(double coeficiente, int exponente) {
        this.coeficiente = coeficiente;
        this.exponente = exponente;
        this.siguiente = null;
    }

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

    @Override
    public String toString() {
        return "NodoTermino{" +
                "coeficiente=" + coeficiente +
                ", exponente=" + exponente +
                ", siguiente=" + siguiente +
                '}';
    }
}
