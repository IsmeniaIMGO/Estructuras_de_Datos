package Laboratorio3;

import java.util.Iterator;

/**
 * 
 * Definicion de la clase lista Simple de tipo Generics
 * @param <T>
 * 
 * **/
public class ListaSimple<T> implements Iterable<T> {
	
	private NodoSimple<T> nodoSimplePrimero;
	private NodoSimple<T> nodoSimpleUltimo;
	private int size;
	

	public ListaSimple() {
		nodoSimplePrimero = null;
		nodoSimpleUltimo = null;
		size = 0;
	}

	//Metodos get y set de la clase ListaSimple

	public NodoSimple<T> getNodoPrimero() {
		return nodoSimplePrimero;
	}

	public void setNodoPrimero(NodoSimple<T> nodoSimplePrimero) {
		this.nodoSimplePrimero = nodoSimplePrimero;
	}

	public NodoSimple<T> getNodoUltimo() {
		return nodoSimpleUltimo;
	}

	public void setNodoUltimo(NodoSimple<T> nodoSimpleUltimo) {
		this.nodoSimpleUltimo = nodoSimpleUltimo;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * Metodo toString de la clase ListaSimple
	 * @return
	 */
	@Override
	public String toString() {
		return "ListaSimple{" +
				"nodoPrimero=" + nodoSimplePrimero +
				/*", nodoUltimo=" + nodoUltimo +*/
				", size=" + size +
				'}';
	}

	//-------------------Metodos basicos-------------------

	/**
	 * Agrega un nuevo nodo al inicio de la lista
	 * @param valorNodo
	 */
	public void agregarInicio(T valorNodo) {
		
		NodoSimple<T> nuevoNodoSimple = new NodoSimple<>(valorNodo);
		
		if(estaVacia())
		{
			nodoSimplePrimero = nuevoNodoSimple;
		}
		else
		{
			nuevoNodoSimple.setSiguienteNodo(nodoSimplePrimero);
			nodoSimplePrimero = nuevoNodoSimple;
		}
		size++;
	}

	/**
	 * Agrega un nuevo nodo al final de la lista
	 * @param valorNodo
	 */
	public void agregarfinal(T valorNodo) {
		
		NodoSimple<T> nodoSimple = new NodoSimple<>(valorNodo);
		
		if( estaVacia() ) {
			nodoSimplePrimero = nodoSimpleUltimo = nodoSimple;
		}else {
			nodoSimpleUltimo.setSiguienteNodo(nodoSimple);
			nodoSimpleUltimo = nodoSimple;
		}
		
		size++;
	}

	/**
	 * Elimina un nodo de la lista segundo el valor del nodo
	 * @param dato
	 * @return
	 */
	public T eliminar(T dato) {
		NodoSimple<T> nodoSimple = nodoSimplePrimero;
		NodoSimple<T> previo = null;

		// Buscar el nodo a eliminar
		while (nodoSimple != null) {
			if (nodoSimple.getValorNodo().equals(dato)) {
				if (previo == null) {
					// El nodo a eliminar es el primero
					nodoSimplePrimero = nodoSimple.getSiguienteNodo();
				} else {
					// El nodo a eliminar está en medio o al final
					previo.setSiguienteNodo(nodoSimple.getSiguienteNodo());
				}

				// Liberar el nodo eliminado
				nodoSimple.setSiguienteNodo(null);
				size--;
				return dato;
			}

			previo = nodoSimple;
			nodoSimple = nodoSimple.getSiguienteNodo();
		}

		// El elemento no fue encontrado
		throw new RuntimeException("El elemento no existe: " + dato);
	}

	/**
	 * Elimina el primer nodo de la lista
	 * @return
	 */
	public T eliminarPrimero() {

		if( !estaVacia() ) {
			NodoSimple<T> n = nodoSimplePrimero;
			T valor = n.getValorNodo();
			nodoSimplePrimero = n.getSiguienteNodo();

			if(nodoSimplePrimero ==null) {
				nodoSimpleUltimo = null;
			}

			size--;
			return valor;
		}

		throw new RuntimeException("Lista vacia");
	}

	/**
	 * obtiene el valor de un nodo segun su posicion en la lista
	 * @param indice
	 * @return
	 */
	public T obtenerValorNodo(int indice) {
		if (indice < 0 || indice >= size) {
			throw new IndexOutOfBoundsException("Índice fuera de rango: " + indice);
		}

		NodoSimple<T> actual = nodoSimplePrimero;
		for (int i = 0; i < indice; i++) {
			actual = actual.getSiguienteNodo();
		}

		return actual.getValorNodo();

	}

	/**
	 * Obtiene el nodo segun su posicion en la lista
	 * @param indice
	 * @return
	 */
	private NodoSimple<T> obtenerNodo(int indice) {
		
		if(indice>=0 && indice< size) {
		
			NodoSimple<T> nodoSimple = nodoSimplePrimero;
			
			for (int i = 0; i < indice; i++) {
				nodoSimple = nodoSimple.getSiguienteNodo();
			}
		
			return nodoSimple;
		}
		
		return null;
	}

	/**
	 * Retorna la primera posicion donde esta guardado el dato
	 * @param dato valor a buscar dentro de la lista
	 * @return primera posicion del dato
	 */
	public int obtenerPosicionNodo(T dato) {

		int i = 0;
		
		for(NodoSimple<T> aux = nodoSimplePrimero; aux!=null ; aux = aux.getSiguienteNodo() ) {
			if( aux.getValorNodo().equals(dato) ) {
				return i;
			}
			i++;
		}
		
		return -1;
	}

	/**
	 * vacia la lista
	 */
	public void vaciar() {
		nodoSimplePrimero = null;
	}


	/**
	 * Cambia el valor de un nodo dada su posici�n en la lista
	 * @param indice posici�n donde se va a cambiar el dato
	 * @param nuevo nuevo valor por el que se actualizar� el nodo
	 */
	public void modificarNodo(int indice, T nuevo) {

		if( indiceValido(indice) ) {
			NodoSimple<T> nodoSimple = obtenerNodo(indice);
			nodoSimple.setValorNodo(nuevo);
		}

	}

	/**
	 * Imprime en consola la lista enlazada
	 */
	public void imprimirLista() {

		NodoSimple<T> aux = nodoSimplePrimero;

		while(aux!=null) {
			System.out.print( aux.getValorNodo()+"\t" );
			aux = aux.getSiguienteNodo();
		}

		System.out.println();
	}

	/**
	 * Verifica si el indice es valido
	 * @param indice
	 * @return
	 */
	private boolean indiceValido(int indice) {
		if( indice>=0 && indice< size) {
			return true;
		}
		throw new IndexOutOfBoundsException("indice no valido");
	}

	/**
	 * Verifica si la lista esta vacia
	 * @return
	 */
	public boolean estaVacia() {
		return(nodoSimplePrimero == null)?true:false;
	}


	/**
	 * clase Iterator
	 * @return
	 */
	@Override
	public Iterator<T> iterator() {
		
		return new IteradorListaSimple (nodoSimplePrimero);
	}
	
	public class IteradorListaSimple implements Iterator<T>{

		private NodoSimple<T> nodoSimple;
		private int posicion;
		
		/**
		 * Constructor de la clase Iterador
		 * aux Primer Nodo de la lista
		 */
		public IteradorListaSimple(NodoSimple<T> nodoSimple) {
			this.nodoSimple = nodoSimple;
			this.posicion = 0;
		}
		
		@Override
		public boolean hasNext() {
			return nodoSimple !=null;
		}

		@Override
		public T next() {
			T valor = nodoSimple.getValorNodo();
			nodoSimple = nodoSimple.getSiguienteNodo();
			posicion++;
			return valor;
		}
		
		/**
		 * Posicion actual de la lista
		 * @return posicion
		 */
		public int getPosicion() {
			return posicion;
		}
		
	}


}
