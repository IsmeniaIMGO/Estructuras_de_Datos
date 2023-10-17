package Laboratorio3;


/**
 * Clase nodo aplicando Generics
 * @param <T>
 * **/


public class NodoSimple<T> {

	private T valorNodo;
	private NodoSimple<T> siguienteNodoSimple;

	
	
	/**
	 * Constructor de la clase Nodo
	 * dato Elemento que se guarda en el Nodo
	 */
	public NodoSimple(T valorNodo) {
		this.valorNodo = valorNodo;
	}
	
	
	/**
	 * Constructor de la clase Nodo
	 * @param dato Elemento que se guarda en el Nodo
	 * @param siguiente Enlace al siguiente Nodo
	 */
	public NodoSimple(T dato, NodoSimple<T> siguiente) {
		super();
		this.valorNodo = dato;
		this.siguienteNodoSimple = siguiente;
	}
	

	//Metodos get y set de la clase Nodo
	
	public NodoSimple<T> getSiguienteNodo() {
		return siguienteNodoSimple;
	}


	public void setSiguienteNodo(NodoSimple<T> siguienteNodoSimple) {
		this.siguienteNodoSimple = siguienteNodoSimple;
	}


	public T getValorNodo() {
		return valorNodo;
	}


	public void setValorNodo(T valorNodo) {
		this.valorNodo = valorNodo;
	}

	@Override
	public String toString() {
		return "valorNodo=" + valorNodo +
				", siguienteNodo=" + siguienteNodoSimple;
	}
}
