package ejercicios.recorrerCategorias.test;

import ejercicios.recorrerCategorias.model.*;

import java.util.ArrayList;


public class TiendaPrueba {

	public static void main(String[] args) {
		//crear lista vacia para punto1 precio
		ArrayList<Producto> listaProductoPrecio = new ArrayList<Producto>();
		
		//crear listaCategorias para la tienda
		ArrayList<Categoria> listaCategorias = new ArrayList<Categoria>();
		
		//crear la tienda
		Tienda tienda = new Tienda("tienda1", listaCategorias);
		
		ArrayList<Producto> c1_1 = new ArrayList<Producto>();
		ArrayList<Categoria> c1_2 = new ArrayList<Categoria>();
		
		Categoria c1 = new Categoria("Tecnologia", c1_1, c1_2);
		
		Producto c1_1_1 = new Producto("Televisor", 12000000 , "negro");
		Producto c1_1_2 = new Producto("Impresora", 13000000, "rojo");

		ArrayList<Producto> c1_2_1_1 = new ArrayList<Producto>();

		Categoria c1_2_1 = new Categoria("Camaras",c1_2_1_1);

		Producto c1_2_1_1_1 = new Producto("Camara reflexiva", 10000, "rojo");
		Producto c1_2_1_1_2 = new Producto("Camara digital", 1500000, "rojo");

		//_______________________________________
		ArrayList<Producto> c2_1 = new ArrayList<Producto>();
		ArrayList<Categoria> c2_2 = new ArrayList<Categoria>();
		
		Categoria c2 = new Categoria("Ollas",  c2_1, c2_2);
		
		Producto c2_1_1 = new Producto("Arrocera", 9000, "rojo");
		Producto c2_1_2 = new Producto("Freidora", 13000000, "negro");

		ArrayList<Producto> c2_2_1_1 = new ArrayList<Producto>();

		Categoria c2_2_1 = new Categoria("Papel",c2_2_1_1);

		Producto c2_2_1_1_1 = new Producto("Carton", 11100000, "rojo");
		Producto c2_2_1_1_2 = new Producto("Periodico", 1500000, "rojo");
		
		
		//___________________________________________
		
		listaCategorias.add(c1);
		listaCategorias.add(c2);

		
		//añadir productos a lista de productos en categoria c1
		c1_1.add(c1_1_1);
		c1_1.add(c1_1_2);

		//añadir categoria a lista de categorias en categoria c1
		c1_2.add(c1_2_1);

		//añadir productos a lista de categorias dentro
		c1_2_1_1.add(c1_2_1_1_1);
		c1_2_1_1.add(c1_2_1_1_2);


		//añadir productos a lista de productos en categoria c2
		c2_1.add(c2_1_1);
		c2_1.add(c2_1_2);
		
		//añadir categoria a lista de categorias en categoria c2
		c2_2.add(c2_2_1);

		//añadir productos a lista de productos en categoria c2
		c2_2_1_1.add(c2_2_1_1_1);
		c2_2_1_1.add(c2_2_1_1_2);
		
		//llamar metod que pide los productos con valor mayor a 10.000
		tienda.buscarPrecio1(0, listaProductoPrecio);
		System.out.println("PUNTO1: "+listaProductoPrecio +"\n");
		
		}
		

}
