package Laboratorio3;

/**
 * Definicion de la lista clase ListaCalculo
 */
public class NodoCalculo {
    private double valor;
    private NodoCalculo siguiente;

    /**
     * Constructor de la clase ListaCalculo
     */
    public NodoCalculo(double valor) {
        this.valor = valor;
        this.siguiente = null;
    }

    //metodos get y set de la clase ListaCalculo
    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public NodoCalculo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCalculo siguiente) {
        this.siguiente = siguiente;
    }

    @Override
    public String toString() {
        return "NodoCalculo{" +
                "valor=" + valor +
                ", siguiente=" + siguiente +
                '}';
    }


}
