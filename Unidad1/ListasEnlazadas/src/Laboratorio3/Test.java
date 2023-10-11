package Laboratorio3;

public class Test {

    public static void main(String[] args) {

        //------------------------Ejercicio 1----------------------------
        ListaSimple<Integer> listaNumeros = new ListaSimple<Integer>();
        listaNumeros.agregarfinal(3);
        listaNumeros.agregarfinal(4);
        listaNumeros.agregarfinal(5);

        ListaSimple<Integer> posicionesImpares = new ListaSimple<Integer>();
        posicionesImpares = obtenerImpares(listaNumeros);

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

    }

    /**
     * 1. Obtener los números de las posiciones impares de una lista enlazada simple de números
     * @param listaNumeros
     * @return
     */
    public static ListaSimple<Integer> obtenerImpares(ListaSimple<Integer> listaNumeros) {

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
     * @return
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
     * @return
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










}
