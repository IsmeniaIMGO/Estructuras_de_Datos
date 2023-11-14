package Laboratorio3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Test {

    public static void main(String[] args) {

        //------------------------Ejercicio 1----------------------------
        ListaSimple<Integer> listaNumeros = new ListaSimple<Integer>();
        listaNumeros.agregarfinal(3);
        listaNumeros.agregarfinal(4);
        listaNumeros.agregarfinal(5);

        ListaSimple<Integer> posicionesImpares = new ListaSimple<Integer>();
        posicionesImpares = obtenerPosImpares(listaNumeros);

        System.out.println("1. Lista de posiciones impares: "+ posicionesImpares+"\n");

        //------------------------Ejercicio 2----------------------------
        ListaSimple<Persona> listaPersonas = new ListaSimple<Persona>();
        listaPersonas.agregarfinal(new Persona("Juan", 123));
        listaPersonas.agregarfinal(new Persona("Pedro", 4564));
        listaPersonas.agregarfinal(new Persona("Maria", 789));

        ListaSimple<Persona> cedulasPares = new ListaSimple<Persona>();
        cedulasPares = obtenerCedulasPares(listaPersonas);

        System.out.println("2. Lista de personas con cédula par: "+ cedulasPares+"\n");

        //------------------------Ejercicio 3----------------------------
        ListaSimple<Integer> listaNumeros2 = new ListaSimple<Integer>();
        listaNumeros2.agregarfinal(3);
        listaNumeros2.agregarfinal(4);
        listaNumeros2.agregarfinal(5);

        ListaSimple<Integer> numerosPares = new ListaSimple<Integer>();
        numerosPares = obtenerPares(listaNumeros2);

        System.out.println("3. Lista de números pares eliminados: "+ numerosPares+"\n"
                + "Lista actualizada: "+ listaNumeros2 +"\n");


        //------------------------Ejercicio 4----------------------------
        ListaSimple<Integer> listaNumeros3 = new ListaSimple<Integer>();
        listaNumeros3.agregarfinal(3);
        listaNumeros3.agregarfinal(4);
        listaNumeros3.agregarfinal(5);

        ListaSimple<Integer> numerosImpares = new ListaSimple<Integer>();
        numerosImpares = obtenerValorImpares(listaNumeros3);

        System.out.println("4. Lista de números impares: "+ numerosImpares+"\n");


        //------------------------Ejercicio 5----------------------------

        ListaSimple<Integer> listaNumeros4 = new ListaSimple<Integer>();
        listaNumeros4.agregarfinal(3);
        listaNumeros4.agregarfinal(4);
        listaNumeros4.agregarfinal(4);
        
        int valor = 4;
        int cantidad = obtenerCantidad(listaNumeros4, valor);

        System.out.println("5. Cantidad de veces que se repite el valor "+valor+": "+ cantidad+"\n");

        //------------------------Ejercicio 6----------------------------

        ListaDoble<Integer> listaNumeros5 = new ListaDoble<Integer>();
        listaNumeros5.agregarfinal(3);
        listaNumeros5.agregarfinal(4);
        listaNumeros5.agregarfinal(5);

        System.out.println("6. Lista de números: ");
        listaNumeros5.imprimirLista();
        System.out.println("Lista de números hacia atrás: ");
        listaNumeros5.imprimirAtras();
        System.out.println("\n");

        //------------------------Ejercicio 7----------------------------
        System.out.println("7. ejercicio resuelto dentro de la clase lista doble \n");


        //------------------------Ejercicio 8----------------------------
        //Obtener la lista de personas tengan cédula con cantidad de elementos par de una lista enlazada doble de personas.

        ListaDoble<Persona> listaPersonas2 = new ListaDoble<Persona>();
        listaPersonas2.agregarfinal(new Persona("Juan", 123));
        listaPersonas2.agregarfinal(new Persona("Pedro", 4564));
        listaPersonas2.agregarfinal(new Persona("Maria", 789));

        ListaDoble<Persona> cedulasPares2 = new ListaDoble<Persona>();
        cedulasPares2 = obtenerCedulasPares2(listaPersonas2);

        System.out.println("8. Lista de personas con cédula par: "+ cedulasPares2+"\n");

        //------------------------Ejercicio 9----------------------------
        //Escribir el método insertar y buscar de una lista circular.
        System.out.println("9. ejercicio resuelto dentro de la clase lista simple y doble circular \n");

        //------------------------Ejercicio 10----------------------------

        //Escribir un método que permita “concatenar” dos listas enlazadas simples, el método debe recibir como parámetro dos objetos de tipo Lista, unirlas y retornar una lista que contenga a ambas.

        ListaSimple<Integer> listaNumeros6 = new ListaSimple<Integer>();
        listaNumeros6.agregarfinal(3);
        listaNumeros6.agregarfinal(4);
        listaNumeros6.agregarfinal(5);

        ListaSimple<Integer> listaNumeros7 = new ListaSimple<Integer>();
        listaNumeros7.agregarfinal(6);
        listaNumeros7.agregarfinal(7);
        listaNumeros7.agregarfinal(8);

        ListaSimple<Integer> listaConcatenada = new ListaSimple<Integer>();
        listaConcatenada = concatenarListas(listaNumeros6, listaNumeros7);

        System.out.println("10. Lista concatenada: "+ listaConcatenada+"\n");


        //------------------------Ejercicio 11----------------------------
        Polinomio polinomio = new Polinomio();
        polinomio.agregarTermino(3, 4);
        polinomio.agregarTermino(-4, 2);
        polinomio.agregarTermino(11, 0);

        System.out.println("11. Tabla de valores del polinomio:");
        polinomio.imprimirPolinomio();
        System.out.println("\n x\tPolinomio(x)");

        for (double x = 0.0; x <= 5.0; x += 0.5) {
            double resultado = polinomio.evaluar(x);
            System.out.println(x + "\t" + resultado);
        }


        //------------------------Ejercicio 12----------------------------

        ListaCalculo lista = leerArchivo();
        double media = obtenerMedia(lista);
        double desviacionEstandar = obtenerDesviacionEstandar(lista, media);


        System.out.println("\n 12. Calculos");
        System.out.println("Media: " + media);
        System.out.println("Desviación estándar: " + desviacionEstandar);
        

    }


    /**
     * 1. Obtener los números de las posiciones impares de una lista enlazada simple de números
     * @param listaNumeros
     * @return listaAux
     */
    public static ListaSimple<Integer> obtenerPosImpares(ListaSimple<Integer> listaNumeros) {

        ListaSimple<Integer> listaAux = new ListaSimple<Integer>();


        for (int i = 0; i < listaNumeros.getSize(); i++) {
            if (i % 2 != 0) {
                listaAux.agregarfinal(listaNumeros.obtenerValorNodo(i));
            }
        }
        return listaAux;

    }

    /**
     * 2. Obtener la lista de personas tengan cédula con cantidad de números par de una lista
     * @param listaPersonas
     * @return listaAux
     */
    private static ListaSimple<Persona> obtenerCedulasPares(ListaSimple<Persona> listaPersonas) {

            ListaSimple<Persona> listaAux = new ListaSimple<Persona>();

            for (int i = 0; i < listaPersonas.getSize(); i++) {
                if (listaPersonas.obtenerValorNodo(i).getCedula() % 2 == 0) {
                    listaAux.agregarfinal(listaPersonas.obtenerValorNodo(i));
                }
            }
            return listaAux;

    }


    /**
     * 3. Obtener los números pares de una lista enlazada simple de números y eliminarlos de la lista
     * @param listaNumeros2
     * @return listaAux**
     */
    private static ListaSimple<Integer> obtenerPares(ListaSimple<Integer> listaNumeros2) {

        ListaSimple<Integer> listaAux = new ListaSimple<Integer>();

        for (int i = 0; i < listaNumeros2.getSize(); i++) {
            if (listaNumeros2.obtenerValorNodo(i) % 2 == 0) {
                listaAux.agregarfinal(listaNumeros2.obtenerValorNodo(i));
                int valorAux = listaNumeros2.obtenerValorNodo(i);
                listaNumeros2.eliminar(valorAux);
            }
        }
        return listaAux;

    }


    /**
     * 4. Obtener una lista enlazada con los valores impares de una lista enlazada simple de números
     * @param listaNumeros3
     * @return listaAux
     */
    private static ListaSimple<Integer> obtenerValorImpares(ListaSimple<Integer> listaNumeros3) {

            ListaSimple<Integer> listaAux = new ListaSimple<Integer>();

            for (int i = 0; i < listaNumeros3.getSize(); i++) {
                if (listaNumeros3.obtenerValorNodo(i) % 2 != 0) {
                    listaAux.agregarfinal(listaNumeros3.obtenerValorNodo(i));
                }
            }
            return listaAux;
    }


    /**
     * 5. Escribir un método que retorne la cantidad de veces que se repite un valor en una lista enlazada.
     * @param listaNumeros4
     * @param valor
     * @return cantidad
     */
    private static int obtenerCantidad(ListaSimple<Integer> listaNumeros4, int valor) {

        int cantidad = 0;

        for (int i = 0; i < listaNumeros4.getSize(); i++) {
            if (listaNumeros4.obtenerValorNodo(i) == valor) {
                cantidad++;
            }
        }
        return cantidad;
    }


    /**
     * 8. Obtener la lista de personas tengan cédula con cantidad de elementos par
     * de una lista enlazada doble de personas.
     * @param listaPersonas2
     * @return listaAux
     */
    private static ListaDoble<Persona> obtenerCedulasPares2(ListaDoble<Persona> listaPersonas2) {

        ListaDoble<Persona> listaAux = new ListaDoble<Persona>();

        for (int i = 0; i < listaPersonas2.getSize(); i++) {
            if (listaPersonas2.obtenerValorNodo(i).getCedula() % 2 == 0) {
                listaAux.agregarfinal(listaPersonas2.obtenerValorNodo(i));
            }
        }
        return listaAux;

    }


    /**
     * 10. Escribir un método que permita “concatenar” dos listas enlazadas simples,
     * el método debe recibir como parámetro dos objetos de tipo Lista, unirlas
     * y retornar una lista que contenga a ambas.
     * @param listaNumeros6
     * @param listaNumeros7
     * @return listaAux
     */
    private static ListaSimple<Integer> concatenarListas(ListaSimple<Integer> listaNumeros6, ListaSimple<Integer> listaNumeros7) {

        ListaSimple<Integer> listaAux = new ListaSimple<Integer>();

        for (int i = 0; i < listaNumeros6.getSize(); i++) {
            listaAux.agregarfinal(listaNumeros6.obtenerValorNodo(i));
        }

        for (int i = 0; i < listaNumeros7.getSize(); i++) {
            listaAux.agregarfinal(listaNumeros7.obtenerValorNodo(i));
        }

        return listaAux;
    }

    /**
     * 12.1 metodo que lee un archivo con numeros y los guarda en una lista
     * @param
     * @return listaAux
     */
    private static ListaCalculo leerArchivo() {

        ListaCalculo listaAux = new ListaCalculo();
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/Laboratorio3/numeros.txt"));
            String linea = br.readLine();
            while (linea != null) {
                double valor = Double.parseDouble(linea);
                listaAux.agregar(valor);
                linea = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo");
        }

        return listaAux;
    }

    /**
     * 12.2 metodo que obtiene la media de una lista
     * @param lista
     * @return media
     */
    private static double obtenerMedia(ListaCalculo lista) {
        double size = lista.obtenersize();

        double suma = lista.obtenerSuma();
        double media = suma / size;

        return media;

    }

    /**
     * 12.3 metodo que obtiene la desviacion estandar de una lista
     * @param lista
     * @param media
     * @return desviacionEstandar
     */
    private static double obtenerDesviacionEstandar(ListaCalculo lista, double media) {
        double size = lista.obtenersize();
        double sumaDiferenciasCuadrado = 0.0;
        NodoCalculo actual = lista.nodoPrimero;

        while (actual != null) {
            sumaDiferenciasCuadrado += Math.pow(actual.getValor() - media, 2);
            actual = actual.getSiguiente();
        }

        double desviacionEstandar = Math.sqrt(sumaDiferenciasCuadrado / (size-1));

        return desviacionEstandar;

    }









}
