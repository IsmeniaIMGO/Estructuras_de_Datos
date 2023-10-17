package Laboratorio3;

public class ListaCalculo {
    NodoCalculo cabeza;
    private int size;

    public ListaCalculo() {
        this.cabeza = null;
        this.size = 0;
    }

    public void agregar(double valor) {
        NodoCalculo nuevoNodo = new NodoCalculo(valor);

        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            NodoCalculo actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
        size++;
    }

    public double obtenersize() {
        return size;
    }

    public double obtenerSuma() {
        double suma = 0.0;
        NodoCalculo actual = cabeza;

        while (actual != null) {
            suma += actual.valor;
            actual = actual.siguiente;
        }

        return suma;
    }

}
