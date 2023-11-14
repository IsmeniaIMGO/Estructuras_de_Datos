package Laboratorio3;

/**
 * Definicion de la lista clase ListaCalculo
 */
public class ListaCalculo {
    NodoCalculo nodoPrimero;
    private int size;


    /**
     * Constructor de la clase ListaCalculo
     */
    public ListaCalculo() {
        this.nodoPrimero = null;
        this.size = 0;
    }


    //metodos get y set de la clase ListaCalculo
    public NodoCalculo getNodoPrimero() {
        return nodoPrimero;
    }

    public void setNodoPrimero(NodoCalculo nodoPrimero) {
        this.nodoPrimero = nodoPrimero;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Metodo toString de la clase ListaCalculo
     * @return
     */
    @Override
    public String toString() {
        return "ListaCalculo{" +
                "nodoPrimero=" + nodoPrimero +
                ", size=" + size +
                '}';
    }

    //metodos basicos

    /**
     * Metodo para agregar un nodo a la lista
     * @param valor
     */
    public void agregar(double valor) {
        NodoCalculo nuevoNodo = new NodoCalculo(valor);

        if (nodoPrimero == null) {
            nodoPrimero = nuevoNodo;
        } else {
            NodoCalculo actual = nodoPrimero;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevoNodo);
        }
        size++;
    }

    /**
     * metodo que obtiene el tamaño de la lista
     * @return
     */
    public double obtenersize() {
        return size;
    }

    /**
     * Metodo que obtiene la suma de los valores de la lista
     * @return
     */
    public double obtenerSuma() {
        double suma = 0.0;
        NodoCalculo actual = nodoPrimero;

        while (actual != null) {
            suma += actual.getValor();
            actual = actual.getSiguiente();
        }

        return suma;
    }

}
