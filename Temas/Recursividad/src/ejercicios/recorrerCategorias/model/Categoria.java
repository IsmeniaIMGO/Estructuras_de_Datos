package ejercicios.recorrerCategorias.model;

import java.util.ArrayList;

public class Categoria {

	/**
	 * Atributos
	 */
	private String nombre;
	private ArrayList<Producto> listaProductos;
	private ArrayList<Categoria> subCategoria;
	
	/**
	 * Constructor
	 * @param nombre
	 * @param listaProductos
	 * @param subCategoria
	 */
	public Categoria(String nombre, ArrayList<Producto> listaProductos, ArrayList<Categoria> subCategoria) {
		super();
		this.nombre = nombre;
		this.listaProductos = listaProductos;
		this.subCategoria = subCategoria;
	}

	
	
	public Categoria(String nombre, ArrayList<Producto> listaProductos) {
		super();
		this.nombre = nombre;
		this.listaProductos = listaProductos;
	}



	/**
	 * Metodos set y get
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}

	public ArrayList<Producto> getListaProductos() {
		return listaProductos;
	}

	public ArrayList<Categoria> getSubCategoria() {
		return subCategoria;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setListaProductos(ArrayList<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}

	public void setSubcategoria(ArrayList<Categoria> subCategoria) {
		this.subCategoria = subCategoria;
	}

	/**
	 * metodo toString
	 */
	@Override
	public String toString() {
		return "Categoria [nombre=" + nombre + ", listaProductos=" + listaProductos + ", subCategoria=" + subCategoria
				+ "]";
	}

	/**
	 * metodo que usa recursividad para encontrar los productos con un precio mayor a 10000
	 * @param i
	 * @param listaProductosPrecio
	 */
	public ArrayList<Producto> buscarPrecio2(int i, ArrayList<Producto> listaProductosPrecio) {
		//caso base
		
		if (i == listaProductos.size()) {
			buscarEnSubcategoria(0, listaProductosPrecio);
			return listaProductosPrecio;
		//caso recursivo
		}else{
			listaProductos.get(i).buscarPrecio3(listaProductosPrecio);
			buscarPrecio2(i+1, listaProductosPrecio);
		}
		return listaProductosPrecio;
	}
	

	
	private ArrayList<Producto> buscarEnSubcategoria(int i, ArrayList<Producto> listaProductosPrecio) {

		//como verifico que un arraylist no es nulo?
		if (subCategoria == null ){
			return listaProductosPrecio;
		}else {
		//caso base
				if (i == subCategoria.size()){
					return listaProductosPrecio;
				}
				//caso recursivo
				else {	
					subCategoria.get(i).buscarPrecio2(0,listaProductosPrecio);
					buscarEnSubcategoria(i+1, listaProductosPrecio);	
				}		
				return listaProductosPrecio;

		}
	}


	
	
	
	
}
