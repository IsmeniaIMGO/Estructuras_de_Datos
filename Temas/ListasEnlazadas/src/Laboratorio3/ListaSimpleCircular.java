package Laboratorio3;

import java.util.Iterator;



/**
 * 
 * Definici�n de la clase lista Simple Circular de tipo Generics
 * @param <T>
 * 
 * **/

public class ListaSimpleCircular<T> implements Iterable<T> {

	private NodoSimple<T> nodoPrimero;
	private NodoSimple<T> nodoUltimo;
	private int size;


	/**
	 * Constructor de la clase ListaSimpleCircular
	 */
	public ListaSimpleCircular() {
		nodoPrimero = null;
		nodoUltimo = null;
		size = 0;
	}

	//Metodos get y set de la clase ListaSimpleCircular
	public NodoSimple<T> getNodoPrimero() {
		return nodoPrimero;
	}

	public void setNodoPrimero(NodoSimple nodoPrimero) {
		this.nodoPrimero = nodoPrimero;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * Metodo toString de la clase ListaSimpleCircular
	 * @return
	 */
	@Override
	public String toString() {
		return "ListaSimpleCircular{" +
				"nodoPrimero=" + nodoPrimero /*+
				", nodoUltimo=" + nodoUltimo*/ +
				", size=" + size +
				'}';
	}

//Metodos basicos

	/**
	 * Agregar un nodo al inicio de la lista
	 * @param valorNodo
	 */
	public void agregarInicio(T valorNodo) {
		
		NodoSimple<T> nuevoNodo = new NodoSimple<>(valorNodo);
		
		if(estaVacia())
		{
			nodoPrimero = nuevoNodo;
		}
		else
		{
			NodoSimple<T> aux = nodoUltimo.getSiguienteNodo();
			nodoUltimo.setSiguienteNodo(nuevoNodo);
			nuevoNodo.setSiguienteNodo(aux);
			nodoUltimo = nuevoNodo;
		}
		size++;
	}


	/**
	 * Agregar un nodo al final de la lista
	 * @param valorNodo
	 */
	public void agregarfinal(T valorNodo) {
		
		NodoSimple<T> nuevoNodo = new NodoSimple<>(valorNodo);
		
		if(estaVacia())
		{
			nodoPrimero = nodoUltimo = nuevoNodo;
		}
		else
		{
			NodoSimple<T> aux = nodoUltimo.getSiguienteNodo();
			nodoUltimo.setSiguienteNodo(nuevoNodo);
			nuevoNodo.setSiguienteNodo(aux);
			nodoUltimo = nuevoNodo;
		}
		size++;
	}

	/**
	 * Obtener el valor de un Nodo dado su indice
	 * @param indice
	 * @return
	 */
	public T obtenerValorNodo(int indice) {
		
		NodoSimple<T> nodoTemporal = null;
		int contador = 0;
		
		if(indiceValido(indice))
		{
			nodoTemporal = nodoPrimero;
			
			while (contador < indice) {
				
				nodoTemporal = nodoTemporal.getSiguienteNodo();
				contador++;
			}
		}
		
		if(nodoTemporal != null)
			return nodoTemporal.getValorNodo();
		else
			return null;
	}


	/**
	 * Verificar si indice es valido
	 * @param indice
	 * @return
	 */
	private boolean indiceValido(int indice) {		
		if( indice>=0 && indice< size) {
			return true;
		}			
		throw new RuntimeException("Indice no valido");
	}


	/**
	 * Verificar si la lista esta vacia
	 * @return
	 */
	public boolean estaVacia() {
		return(nodoPrimero == null)?true:false;
	}

	
	/**
	 * Imprime en consola la lista enlazada
	 */
	public void imprimirLista() {
		
		NodoSimple<T> aux = nodoPrimero;
		
		while(aux!=null) {
			System.out.print( aux.getValorNodo()+"\t" );
			aux = aux.getSiguienteNodo();			
		}
		
		System.out.println();
	}

	/**
	 * Elimina un nodo dado su valor
	 * @param dato
	 * @return
	 */
	public T eliminar(T dato){
		NodoSimple<T> nodo = nodoPrimero;
		NodoSimple<T> previo = null;
		NodoSimple<T> siguiente = null;
		boolean encontrado = false;
		
		//buscar el nodo previo
		while(nodo!=null) {			
			if( nodo.getValorNodo() == dato ) {
				encontrado = true;
				break;
			}
			previo = nodo;
			nodo = nodo.getSiguienteNodo();
		}
		
		if(encontrado) {
			siguiente = nodo.getSiguienteNodo();
			if( previo==null ) {
				nodoPrimero = siguiente;
			}else {
				previo.setSiguienteNodo(siguiente);
			}
			
			if(siguiente==null) {
//				nodoUltimo = previo;
			}else {
				nodo.setSiguienteNodo(null);
			}
			
			nodo = null;
			size--;
			return dato;			
		}
		throw new RuntimeException("El elemento no existe");
	}


	/**
	 * Elimina el primer nodo de la lista
	 * @return
	 */
	public T eliminarPrimero() {
		
		if( !estaVacia() ) {
			NodoSimple<T> n = nodoPrimero;
		    T valor = n.getValorNodo();
			nodoPrimero = n.getSiguienteNodo();
			
			if(nodoPrimero==null) {
//				nodoUltimo = null;
			}
			
			size--;
			return valor;
		}
		
		throw new RuntimeException("Lista vac�a");		
	}

	/**
	 * Elimina el ultimo nodo de la lista
	 * @return
	 */
	public T eliminarUltimo() {
		
		if( !estaVacia() ) {			
			T valor = nodoUltimo.getValorNodo();
			NodoSimple<T> prev = obtenerNodo(size -2);
			nodoUltimo = prev;
			
			if(nodoUltimo==null) {
				nodoPrimero=null;
			}else {					
				prev.setSiguienteNodo(null);
			}				
			
			size--;
			return valor;
		}
		
		throw new RuntimeException("Lista vac�a");
	}


	/**
	 * obtiene el nodo de una posicion dada
	 * @param indice
	 * @return
	 */
	private NodoSimple<T> obtenerNodo(int indice) {
		
		if(indice>=0 && indice< size) {
		
			NodoSimple<T> nodo = nodoPrimero;
			
			for (int i = 0; i < indice; i++) {
				nodo = nodo.getSiguienteNodo();
			}
		
			return nodo;			
		}
		
		return null;
	}
	
	
	/**
	 * Cambia el valor de un nodo dada su posici�n en la lista
	 * @param indice posici�n donde se va a cambiar el dato
	 * @param nuevo nuevo valor por el que se actualizar� el nodo
	 */
	public void modificarNodo(int indice, T nuevo) {
		
		if( indiceValido(indice) ) {			
			NodoSimple<T> nodo = obtenerNodo(indice);
			nodo.setValorNodo(nuevo);			
		}
		
	}
	
	
	/**
	 * Retorna la primera posici�n donde est� guardado el dato
	 * @param dato valor a buscar dentro de la lista
	 * @return primera posici�n del dato
	 */
	public int obtenerPosicionNodo(T dato) {

		int i = 0;
		
		for( NodoSimple<T> aux = nodoPrimero ; aux!=null ; aux = aux.getSiguienteNodo() ) {
			if( aux.getValorNodo().equals(dato) ) {
				return i;
			}
			i++;
		}
		
		return -1;
	}
	
	
	@Override
	public Iterator<T> iterator() {
		
		return new IteradorListaSimple (nodoPrimero);
	}
	
	protected class IteradorListaSimple implements Iterator<T>{

		private NodoSimple<T> nodo;
		private int posicion;
		
		/**
		 * Constructor de la clase Iterador
		 * Primer Nodo de la lista
		 */
		public IteradorListaSimple(NodoSimple<T> nodo) {
			this.nodo = nodo;
			this.posicion = 0;
		}
		
		@Override
		public boolean hasNext() {
			return nodo!=null;
		}

		@Override
		public T next() {
			T valor = nodo.getValorNodo();
			nodo = nodo.getSiguienteNodo();
			posicion++;
			return valor;
		}
		
		/**
		 * Posici�n actual de la lista
		 * @return posici�n
		 */
		public int getPosicion() {
			return posicion;
		}
		
	}
	
	


	
	

}
