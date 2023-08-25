package recorrerCategorias.model;

import recorrerCategorias.model.Categoria;
import recorrerCategorias.model.Producto;

import java.util.ArrayList;
public class Tienda {
	private String nombre;
	private ArrayList<Categoria> listaCategorias;
	
	/**
	 * Contructor
	 * @param nombre
	 * @param categoria
	 */
	public Tienda(String nombre, ArrayList<Categoria> categoria) {
		super();
		this.nombre = nombre;
		listaCategorias = categoria;
	}

	/**
	 * metodos set y get
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}
	public ArrayList<Categoria> getListaCategorias() {
		return listaCategorias;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setListaCategorias(ArrayList<Categoria> listaCategorias) {
		this.listaCategorias = listaCategorias;
	}


	/**
	 * metodo toString
	 */
	@Override
	public String toString() {
		return "Tienda [nombre=" + nombre + ", Categoria=" + listaCategorias + "]";
	}

	/**
	 * Metodo que retorna los productos con un precio mayor a 10000
	 * @param i
	 * @param listaProductosPrecio
	 * @return listaProductosPrecio
	 */
	public ArrayList<Producto> buscarPrecio1(int i, ArrayList<Producto> listaProductosPrecio){
		//caso base
		if (i == listaCategorias.size()){
			return listaProductosPrecio;
		}
		//caso recursivo
		else {
			listaCategorias.get(i).buscarPrecio2(0, listaProductosPrecio);
			buscarPrecio1(i + 1, listaProductosPrecio);
			return listaProductosPrecio;
		}
	}
	
}
