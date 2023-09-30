package Laboratorio3;

import java.util.Iterator;

/**
 * 
 * Definicion de la clase lista Simple de tipo Generics
 * @param <T>
 * 
 * **/

public class ListaSimple<T> implements Iterable<T> {
	
	private Nodo<T> nodoPrimero;
	private Nodo<T> nodoUltimo;
	private int size;
	

	public ListaSimple() {
		nodoPrimero = null;
		nodoUltimo = null;
		size = 0;
	}

	//Metodos get y set de la clase ListaSimple

	public Nodo<T> getNodoPrimero() {
		return nodoPrimero;
	}

	public void setNodoPrimero(Nodo<T> nodoPrimero) {
		this.nodoPrimero = nodoPrimero;
	}

	public Nodo<T> getNodoUltimo() {
		return nodoUltimo;
	}

	public void setNodoUltimo(Nodo<T> nodoUltimo) {
		this.nodoUltimo = nodoUltimo;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}



	//-------------------Metodos basicos-------------------

	/**
	 * Agrega un nuevo nodo al inicio de la lista
	 * @param valorNodo
	 */
	public void agregarInicio(T valorNodo) {
		
		Nodo<T> nuevoNodo = new Nodo<>(valorNodo);
		
		if(estaVacia())
		{
			nodoPrimero = nuevoNodo;
		}
		else
		{
			nuevoNodo.setSiguienteNodo(nodoPrimero);
			nodoPrimero = nuevoNodo;
		}
		size++;
	}
	
	
	/**
	 * Agrega un nuevo nodo al final de la lista
	 * @param valorNodo
	 */
	public void agregarfinal(T valorNodo) {
		
		Nodo<T> nodo = new Nodo<>(valorNodo);
		
		if( estaVacia() ) {
			nodoPrimero = nodoUltimo = nodo;
		}else {
			nodoUltimo.setSiguienteNodo(nodo);
			nodoUltimo = nodo;
		}
		
		size++;
	}

	/**
	 * Elimina un nodo de la lista segundo el valor del nodo
	 * @param dato
	 * @return
	 */
	public T eliminar(T dato){
		Nodo<T> nodo = nodoPrimero;
		Nodo<T> previo = null;
		Nodo<T> siguiente = null;
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
			Nodo<T> n = nodoPrimero;
			T valor = n.getValorNodo();
			nodoPrimero = n.getSiguienteNodo();

			if(nodoPrimero==null) {
				nodoUltimo = null;
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
		
		Nodo<T> nodoTemporal = null;
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
	 * Obtiene el nodo segun su posicion en la lista
	 * @param indice
	 * @return
	 */
	private Nodo<T> obtenerNodo(int indice) {
		
		if(indice>=0 && indice< size) {
		
			Nodo<T> nodo = nodoPrimero;
			
			for (int i = 0; i < indice; i++) {
				nodo = nodo.getSiguienteNodo();
			}
		
			return nodo;			
		}
		
		return null;
	}

	
	
	/**
	 * Retorna la primera posicion donde esta guardado el dato
	 * @param dato valor a buscar dentro de la lista
	 * @return primera posici�n del dato
	 */
	public int obtenerPosicionNodo(T dato) {

		int i = 0;
		
		for( Nodo<T> aux = nodoPrimero ; aux!=null ; aux = aux.getSiguienteNodo() ) {
			if( aux.getValorNodo().equals(dato) ) {
				return i;
			}
			i++;
		}
		
		return -1;
	}

	public void vaciar() {
		nodoPrimero = null;
	}


	/**
	 * Cambia el valor de un nodo dada su posici�n en la lista
	 * @param indice posici�n donde se va a cambiar el dato
	 * @param nuevo nuevo valor por el que se actualizar� el nodo
	 */
	public void modificarNodo(int indice, T nuevo) {

		if( indiceValido(indice) ) {
			Nodo<T> nodo = obtenerNodo(indice);
			nodo.setValorNodo(nuevo);
		}

	}


	/**
	 * Imprime en consola la lista enlazada
	 */
	public void imprimirLista() {

		Nodo<T> aux = nodoPrimero;

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
		return(nodoPrimero == null)?true:false;
	}


	@Override
	public Iterator<T> iterator() {
		
		return new IteradorListaSimple (nodoPrimero);
	}
	
	public class IteradorListaSimple implements Iterator<T>{

		private Nodo<T> nodo;
		private int posicion;
		
		/**
		 * Constructor de la clase Iterador
		 * aux Primer Nodo de la lista
		 */
		public IteradorListaSimple(Nodo<T> nodo) {
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
		 * Posicion actual de la lista
		 * @return posicion
		 */
		public int getPosicion() {
			return posicion;
		}
		
	}
	
	


	/*
    Insertar: inserta un nodo con dato x en la lista, pudiendo realizarse esta inserción al principio o final de la lista o bien en orden.
    Eliminar: elimina un nodo de la lista, puede ser según la posición o por el dato.
    Buscar: busca un elemento en la lista.
    Localizar: obtiene la posición del nodo en la lista.
    Vaciar: borra todos los elementos de la lista.

*listaVacia(L) Inicializa la lista L como la lista vacía.
*esVacia(L) Determina si la lista L está vacía.
*insertar(L,x,p) Inserta en la lista L un nodo con el campo dato x, delante del nodo de dirección p.

*localizar(L,x) Devuelve la posición/dirección donde está el campo de información x.

*suprimir(L,x) Elimina de la lista el nodo que contiene el dato x.
anterior(L,p) Devuelve la posición/dirección del nodo anterior a p.
primero(L) Devuelve la posición/dirección del primer nodo de la lista L.
anula(L) Vacía la lista L.


para insertar hay 4 tipos
*En la cabeza de la lista (elemento primero).
*En el final de la lista (elemento último).
Antes de un elemento especificado (valor nodo, posición del nodo).
Después de un elemento especificado.(valor nodo, posición del nodo).

 */
	//add()
	//remove()
	//getA(int Indicie)
	//size()



}
