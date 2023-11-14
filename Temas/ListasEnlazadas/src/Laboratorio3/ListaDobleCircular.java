package Laboratorio3;

public class ListaDobleCircular<T> {

	private NodoDoble<T> nodoPrimero;
	private NodoDoble<T> nodoUltimo;
	private int size;

	/**
	 * Constructor de la clase ListaDobleCircular
	 */
	public ListaDobleCircular() {
		nodoPrimero = null;
		nodoUltimo = null;
		size = 0;
	}

	//Metodos get y set de la clase ListaDobleCircular
	public NodoDoble<T> getNodoPrimero() {
		return nodoPrimero;
	}

	public void setNodoPrimero(NodoDoble<T> nodoPrimero) {
		this.nodoPrimero = nodoPrimero;
	}

	public NodoDoble<T> getNodoUltimo() {
		return nodoUltimo;
	}

	public void setNodoUltimo(NodoDoble<T> nodoUltimo) {
		this.nodoUltimo = nodoUltimo;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * Metodo toString de la clase ListaDobleCircular
	 * @return
	 */
	@Override
	public String toString() {
		return "ListaDobleCircular{" +
				"nodoPrimero=" + nodoPrimero /*+
				", nodoUltimo=" + nodoUltimo*/ +
				", size=" + size +
				'}';
	}

	//metodos basicos

	/**
	 * Agrega un nuevo nodo en la posici�n dada
	 * @param valor
	 * @param posicion
	 */
	public void insertar( T valor, int posicion ) {
		int cont = 0;

		for(NodoDoble<T> aux = nodoPrimero; cont < size; cont++, aux = aux.getSiguienteNodo() ) {
			if( cont == posicion ) {
				NodoDoble<T> aux2 = aux.getAnteriorNodo();
				NodoDoble<T> nuevo = new NodoDoble<>( valor );
				aux2.setSiguienteNodo( nuevo );
				nuevo.setSiguienteNodo( aux );
				nuevo.setAnteriorNodo( aux2 );
				aux.setAnteriorNodo( nuevo );
				size++;
			}
		}
	}

	/**
	 * Busca y retorna la posici�n de un nodo que tenga el valor ingresado por parametro
	 * @param valor a buscar
	 * @return posici�n donde se encontr� el nodo
	 */
	public int buscar( T valor ) {
		int cont = 0;
		int pos = -1;

		for(NodoDoble<T> aux = nodoPrimero; cont < size; cont++, aux = aux.getSiguienteNodo() ) {
			if( aux.getValorNodo().equals( valor ) ) {
				pos = cont;
			}
		}
		return pos;
	}

	/**
	 * Agrega un nuevo nodo al final de la lista
	 * @param valorNodo
	 */
	public void agregarFinal(T valorNodo) {

		NodoDoble<T> nuevoNodo = new NodoDoble<>( valorNodo );

		if( estaVacia() ) {
			nodoPrimero = nodoUltimo = nuevoNodo;
		}
		else {
			nuevoNodo.setSiguienteNodo(nodoPrimero);
			nodoPrimero.setAnteriorNodo(nuevoNodo);
			nodoUltimo.setSiguienteNodo( nuevoNodo );
			nuevoNodo.setAnteriorNodo( nodoUltimo );
			nodoPrimero = nuevoNodo;
		}
		size++;
	}

	/**
	 * verifica si la lista esta vacia
	 * @return
	 */
	public boolean estaVacia() {
		return nodoPrimero == null && nodoUltimo == null;
	}

	/**
	 * Imprime en consola la lista enlazada
	 */
	public void imprimirLista() {

		NodoDoble<T> aux = nodoPrimero;
		int cont = 0;

		while( aux!=null && cont != size) {
			System.out.print( aux.getValorNodo()+"\t" );
			aux = aux.getSiguienteNodo();
			cont ++;
		}

		System.out.println();
	}

}
