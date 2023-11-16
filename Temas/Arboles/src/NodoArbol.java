public class NodoArbol<T> {
    private T dato;
    private Arbol<T> hijoIzquierdo;
    private Arbol<T> hijoDerecho;

    public NodoArbol(T dato) {
        this.dato = dato;
        this.hijoDerecho = null;
        this.hijoIzquierdo = null;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public Arbol<T> getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    public void setHijoIzquierdo(Arbol<T> hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    public Arbol<T> getHijoDerecho() {
        return hijoDerecho;
    }

    public void setHijoDerecho(Arbol<T> hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }

    @Override
    public String toString() {
        return "NodoArbol{" +
                "dato=" + dato +
                ", hijoIzquierdo=" + (hijoIzquierdo != null ? hijoIzquierdo.getRaiz().getDato() : "null") +
                ", hijoDerecho=" + (hijoDerecho != null ? hijoDerecho.getRaiz().getDato() : "null") +
                '}';
    }
}




