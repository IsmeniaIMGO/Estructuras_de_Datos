package Laboratorio3;

public class Test {

    public static void main(String[] args) {

        ListaSimple<Integer> listaNumeros = new ListaSimple<Integer>();
        listaNumeros.agregarfinal(3);
        listaNumeros.agregarfinal(4);
        listaNumeros.agregarfinal(5);

        ListaSimple<Integer> posicionesImpares = new ListaSimple<Integer>();
        posicionesImpares = obtenerImpares(listaNumeros);

        System.out.println("1. Lista de posiciones impares: "+ posicionesImpares);

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









}
