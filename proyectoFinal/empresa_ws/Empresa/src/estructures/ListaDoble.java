package estructures;


/**
 *
 * Definicion de la clase lista Simple de tipo Generics
 * @param <Actividad>
 *
 * **/

public class ListaDoble<Actividad> {

	private NodoDoble<Actividad> nodoPrimero;
	private NodoDoble<Actividad> nodoUltimo;
	private int size;


	/**
	 * Constructor de la clase ListaDooble
	 */
	public ListaDoble() {
		nodoPrimero = null;
		nodoUltimo = null;
		size = 0;
	}

	//Metodos set y get
	public NodoDoble<Actividad> getNodoPrimero() {
		return nodoPrimero;
	}

	public void setNodoPrimero(NodoDoble<Actividad> nodoPrimero) {
		this.nodoPrimero = nodoPrimero;
	}


	public int getSize() {
		return size;
	}


	public void setSize(int size) {
		this.size = size;
	}


	public NodoDoble<Actividad> getNodoUltimo() {
		return nodoUltimo;
	}


	public void setNodoUltimo(NodoDoble<Actividad> nodoUltimo) {
		this.nodoUltimo = nodoUltimo;
	}


	/**
	 * Metodo toString de la clase ListaDoble
	 *
	 * @return
	 */
	@Override
	public String toString() {
		return "ListaDoble{" +
				"nodoPrimero=" + nodoPrimero +
				", nodoUltimo=" + nodoUltimo;
	}


	//Metodos basicos

	/**
	 * Agrega un nodo al inicio de la lista
	 *
	 * @param valorNodo
	 */
	public void agregarInicio(Actividad valorNodo) {

		NodoDoble<Actividad> nuevoNodo = new NodoDoble<>(valorNodo);

		if (estaVacia()) {
			nodoPrimero = nodoUltimo = nuevoNodo;
		} else {
			nuevoNodo.setSiguienteNodo(nodoPrimero);
			nodoPrimero = nuevoNodo;
		}
		size++;
	}


	/**
	 * Agrega un nodo al final de la lista
	 *
	 * @param valorNodo
	 */
	public void agregarFinal(Actividad valorNodo) {

		NodoDoble<Actividad> nuevoNodo = new NodoDoble<>(valorNodo);

		if (estaVacia()) {
			nodoPrimero = nodoUltimo = nuevoNodo;
		} else {
			nuevoNodo.setSiguienteNodo(nodoPrimero);
			nodoPrimero.setAnteriorNodo(nuevoNodo);
			nodoPrimero = nuevoNodo;
		}
		size++;
	}


	/**
	 * Agrega un valor en la lista en una posici�n espec�fica
	 *
	 * @param indice �ndice donde se va a guardar el dato
	 * @param dato   El valor a guardar
	 */
	public void agregarDespuesDe(Actividad dato, int indice) {

		if (indiceValido(indice)) {

			if (indice == 0) {
				agregarInicio(dato);
			} else {
				NodoDoble<Actividad> nuevo = new NodoDoble<>(dato);
				NodoDoble<Actividad> actual = obtenerNodo(indice);

				nuevo.setAnteriorNodo(actual);
				nuevo.setSiguienteNodo(actual.getSiguienteNodo());
				actual.getSiguienteNodo().setAnteriorNodo(nuevo);
				actual.setSiguienteNodo(nuevo);

				size++;
			}
		}
	}


	/**
	 * Borra completamente la Lista
	 */
	public void borrarLista() {
		nodoPrimero = nodoUltimo = null;
		size = 0;
	}


	/**
	 * Obtiene el valor de un nodo dado su indice
	 *
	 * @param indice
	 * @return
	 */
	public Actividad obtenerValorNodo(int indice) {

		NodoDoble<Actividad> nodoTemporal = null;
		int contador = 0;

		if (indiceValido(indice)) {
			nodoTemporal = nodoPrimero;

			while (contador < indice) {

				nodoTemporal = nodoTemporal.getSiguienteNodo();
				contador++;
			}
		}

		if (nodoTemporal != null)
			return nodoTemporal.getValorNodo();
		else
			return null;
	}


	/**
	 * Verifica si el indice es valido
	 *
	 * @param indice
	 * @return
	 */
	private boolean indiceValido(int indice) {
		if (indice >= 0 && indice < size) {
			return true;
		}
		throw new RuntimeException("�ndice no v�lido");
	}

	/**
	 * Verifica si la lista esta vacia
	 *
	 * @return
	 */
	public boolean estaVacia() {
		//		return(nodoPrimero == null)?true:false;
		return nodoPrimero == null && nodoUltimo == null;
	}


	/**
	 * Imprime en consola la lista enlazada
	 */
	public void imprimirLista() {

		NodoDoble<Actividad> aux = nodoPrimero;

		while (aux != null) {
			System.out.print(aux.getValorNodo() + "\t");
			aux = aux.getSiguienteNodo();
		}

		System.out.println();
	}

	/**
	 * Imprime en consola la lista enlazada hacia atras
	 */
	public void imprimirAtras() {

		NodoDoble<Actividad> aux = nodoUltimo;

		while (aux != null) {
			System.out.print(aux.getValorNodo() + "\t");
			aux = aux.getAnteriorNodo();
		}

		System.out.println();

	}

	/**
	 * Elimina un elemento de la lista dado su valor
	 *
	 * @param actividad dato a eliminar
	 * @return El dato que se elimina
	 */
	public void eliminar(Actividad actividad) {

		NodoDoble<Actividad> nodo = buscarNodo(actividad);

		if (nodo != null) {

			NodoDoble<Actividad> previo = nodo.getAnteriorNodo();
			NodoDoble<Actividad> siguiente = nodo.getSiguienteNodo();

			if (previo == null) {
				nodoPrimero = siguiente;
			} else {
				previo.setSiguienteNodo(siguiente);
			}

			if (siguiente == null) {
				nodoUltimo = previo;
			} else {
				siguiente.setAnteriorNodo(previo);
			}

			nodo = null;
			size--;

		}

		throw new RuntimeException("El valor no existe");
	}


	/**
	 * Elimina el primer nodo de la lista
	 *
	 * @return
	 */
	public Actividad eliminarPrimero() {

		if (!estaVacia()) {
			NodoDoble<Actividad> nodoAux = nodoPrimero;
			Actividad valor = nodoAux.getValorNodo();
			nodoPrimero = nodoAux.getSiguienteNodo();

			if (nodoPrimero == null) {
				nodoUltimo = null;
			} else {
				nodoPrimero.setAnteriorNodo(null);
			}

			size--;
			return valor;
		}

		throw new RuntimeException("Lista vac�a");
	}


	/**
	 * Elimina el ultimo nodo de la lista
	 *
	 * @return
	 */
	public Actividad eliminarUltimo() {

		if (!estaVacia()) {
			Actividad valor = nodoUltimo.getValorNodo();
			NodoDoble<Actividad> prev = obtenerNodo(size - 2);
			nodoUltimo = prev;

			if (nodoUltimo == null) {
				nodoPrimero = null;
			} else {
				prev.setSiguienteNodo(null);
			}

			size--;
			return valor;
		}

		throw new RuntimeException("Lista vac�a");
	}


	/**
	 * Devuelve el Nodo de una lista dada su posici�n
	 *
	 * @param indice indice para obtener el Nodo
	 * @return Nodo objeto
	 */
	private NodoDoble<Actividad> obtenerNodo(int indice) {

		if (indice >= 0 && indice < size) {

			NodoDoble<Actividad> nodo = nodoPrimero;

			for (int i = 0; i < indice; i++) {
				nodo = nodo.getSiguienteNodo();
			}

			return nodo;
		}

		return null;
	}

	/**
	 * Devuelve un nodo que contenga un dato especifico
	 * @return Nodo
	 */
	public NodoDoble<Actividad> buscarNodo(Actividad actividad) {

		NodoDoble<Actividad> aux = nodoPrimero;

		while (aux != null) {
			if (aux.getValorNodo().equals(actividad)) {
				return aux;
			}
			aux = aux.getSiguienteNodo();
		}

		return null;
	}

	/**
	 * Cambia el valor de un nodo dada su posici�n en la lista
	 *
	 * @param indice posici�n donde se va a cambiar el dato
	 * @param nuevo  nuevo valor por el que se actualizar� el nodo
	 */
	public void modificarNodo(int indice, Actividad nuevo) {

		if (indiceValido(indice)) {
			NodoDoble<Actividad> nodo = obtenerNodo(indice);
			nodo.setValorNodo(nuevo);
		}

	}

	/**
	 * Retorna la primera posici�n donde est� guardado el dato
	 *
	 * @param dato valor a buscar dentro de la lista
	 * @return primera posici�n del dato
	 */
	public int obtenerPosicionNodo(Actividad dato) {

		int i = 0;

		for (NodoDoble<Actividad> aux = nodoPrimero; aux != null; aux = aux.getSiguienteNodo()) {
			if (aux.getValorNodo().equals(dato)) {
				return i;
			}
			i++;
		}

		return -1;
	}

	public void intercambiar(int pos1, int pos2) {

		if (pos1 >= 0 && pos1 < size && pos2 >= 0 && pos2 < size) {

			NodoDoble<Actividad> nodo1 = obtenerNodo(pos1);
			NodoDoble<Actividad> nodo2 = obtenerNodo(pos2);

			Actividad aux = nodo1.getValorNodo();
			nodo1.setValorNodo(nodo2.getValorNodo());
			nodo2.setValorNodo(aux);

		} else {
			throw new RuntimeException("indice no valido");
		}
	}
}