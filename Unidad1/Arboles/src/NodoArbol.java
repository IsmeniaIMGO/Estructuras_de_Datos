public class NodoArbol {

    private int dato;
    private Arbol hijoIzquierdo;
    private Arbol hijoDerecho;

    public NodoArbol( int dato) {
        this.dato = dato;
        this.hijoDerecho = null;
        this.hijoIzquierdo = null;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public Arbol getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    public void setHijoIzquierdo(Arbol hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    public Arbol getHijoDerecho() {
        return hijoDerecho;
    }

    public void setHijoDerecho(Arbol hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }

    @Override
    public String toString() {
        return "NodoArbol{" +
                "dato=" + dato +
                ", hijoIzquierdo=" + hijoIzquierdo.getRaiz().getDato() +
                ", hijoDerecho=" + hijoDerecho.getRaiz().getDato() +
                '}';
    }


}
