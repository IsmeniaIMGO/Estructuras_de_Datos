package structures;

/**
 *
 * @param <Tarea>
 */
public class Cola<Tarea> {

	public NodoDoble<Tarea> nodoPrimero, nodoUltimo;
	public int tamanio;
	

	
	/**
	 * Agrega un elemento en la Cola
	 * @param dato elemento a guardar en la Cola
	 */
	public void encolar(Tarea dato) {
		
		NodoDoble<Tarea> nodo = new NodoDoble<>(dato);
		
		if(estaVacia()) {
			nodoPrimero = nodoUltimo = nodo;
		}else {
			nodoUltimo.setSiguienteNodo(nodo);
			nodoUltimo = nodo;
		}
		
		tamanio++;
	}
	public void agregarDespuesDe(Tarea tareaNueva, Tarea tareaAntigua) {
		if (tareaNueva == null || tareaAntigua == null) {
			throw new IllegalArgumentException("Las tareas no pueden ser nulas");
		}

		// Encuentra el nodo de la tarea existente
		NodoDoble<Tarea> nodoExistente = encontrarNodo(tareaNueva);

		if (nodoExistente != null) {
			// Crea un nuevo nodo para la nueva tarea
			NodoDoble<Tarea> nuevoNodo = new NodoDoble<>(tareaAntigua);

			// Actualiza los enlaces para insertar el nuevo nodo después del nodo existente
			nuevoNodo.setSiguienteNodo(nodoExistente.getSiguienteNodo());
			nuevoNodo.setAnteriorNodo(nodoExistente);
			nodoExistente.setSiguienteNodo(nuevoNodo);

			// Si la tarea existente no es la última en la cola, actualiza el enlace del siguiente nodo
			if (nodoExistente.getSiguienteNodo() != null) {
				nodoExistente.getSiguienteNodo().setAnteriorNodo(nuevoNodo);
			} else {
				// Si la tarea existente es la última, actualiza el nodoUltimo de la cola
				nodoUltimo = nuevoNodo;
			}

			// Aumenta el tamaño de la cola
			tamanio++;
		}
	}

	// Método auxiliar para encontrar el nodo de una tarea en la cola
	private NodoDoble<Tarea> encontrarNodo(Tarea tarea) {
		NodoDoble<Tarea> actual = nodoPrimero;

		while (actual != null) {
			if (actual.getValorNodo().equals(tarea)) {
				return actual;
			}
			actual = actual.getSiguienteNodo();
		}

		return null; // La tarea no se encontró en la cola
	}
	
	/**
	 * Retorna y elimina el elemento que est� al incio de la Cola
	 * @return Primer elemento de la Cola
	 */
	public Tarea desencolar() {
		
		if(estaVacia()) {
			throw new RuntimeException("La Cola est� vac�a");
		}
		
		Tarea dato = nodoPrimero.getValorNodo();
		nodoPrimero = nodoPrimero.getSiguienteNodo();
		
		if(nodoPrimero==null) {
			nodoUltimo = null;
		}
		
		tamanio--;
		return dato;
	}
	
	/**
	 * Verifica si la Cola est� vac�a
	 * @return true si est� vac�a
	 */
	public boolean estaVacia() {
		return nodoPrimero == null;
	}
	
	
	
	/**
	 * Borra completamente la Cola
	 */
	public void borrarCola() {
		nodoPrimero = nodoUltimo = null;
		tamanio = 0;
	}

	/**
	 * @return the primero
	 */
	public NodoDoble<Tarea> getPrimero() {
		return nodoPrimero;
	}

	/**
	 * @return the ultimo
	 */
	public NodoDoble<Tarea> getUltimo() {
		return nodoUltimo;
	}

	/**
	 * @return the tamano
	 */
	public int getTamano() {
		return tamanio;
	}
	
	/**
	 * Verifica si la Cola es id�ntica a la actual
	 * @param cola Cola a comparar
	 * @return True si son iguales
	 */
	public boolean sonIdenticas(Cola<Tarea> cola) {
		
		Cola<Tarea> clon1 = clone();
		Cola<Tarea> clon2 = cola.clone();
		
		if(clon1.getTamano() == clon2.getTamano()) {
			
			while( !clon1.estaVacia() ) {				
				if( !clon1.desencolar().equals( clon2.desencolar() ) ) {
					return false;
				}				
			}
			
		}else {
			return false;
		}
		
		return  true;
	}
	
	/**
	 * Imprime una cola en consola
	 */
	public void imprimir() {
		NodoDoble<Tarea> aux = nodoPrimero;
		while(aux!=null) {
			System.out.print(aux.getValorNodo()+"\t");
			aux = aux.getSiguienteNodo();
		}
		System.out.println();
	}
	
	@Override
	protected Cola<Tarea> clone() {
		
		Cola<Tarea> nueva = new Cola<>();
		NodoDoble<Tarea> aux = nodoPrimero;
		
		while(aux!=null) {
			nueva.encolar( aux.getValorNodo() );
			aux = aux.getSiguienteNodo();
		}
		
		return nueva;		
	}

	@Override
	public String toString() {
		return "Cola{" +
				"nodoPrimero=" + nodoPrimero +
				", nodoUltimo=" + nodoUltimo +
				'}';
	}
}