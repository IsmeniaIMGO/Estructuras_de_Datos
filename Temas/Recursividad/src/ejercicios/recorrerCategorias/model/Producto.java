package ejercicios.recorrerCategorias.model;

import java.util.ArrayList;

public class Producto {

	/**
	 * Atributos
	 */
	private String nombre;
	private double precio;
	private String color;
	
	/**
	 * Constructor
	 * @param nombre
	 * @param precio
	 * @param color
	 */
	public Producto(String nombre, double precio, String color) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.color = color;
	}
	
	/**
	 * Metodos get y set
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public String getColor() {
		return color;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	/**
	 * metodo toString
	 */
	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", precio=" + precio + ", color=" + color + "]";
	}

	/**
	 * metodo que compara el precio que sea mayor a 10mil
	 * @param i
	 * @param listaProductosPrecio
	 */
	public void buscarPrecio3(ArrayList<Producto> listaProductosPrecio) {
		double valor = 2000000;
		if (precio < valor) {
			listaProductosPrecio.add(this);
		}
	}

}
