package divideVenceras;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ej_BusquedaBinaria{


    public static void main(String[] args) {

        /*
        La búsqueda binaria es un algoritmo de búsqueda eficiente utilizado
        para encontrar la posición de un elemento en una lista ordenada.
        EL ARREGLO DEBE ESTAR ORDENADO
      */
        int contador = 0;
        int[] arreglo = {2,5,1,7,8,0,2,0,4,0,0};
        int numero = 0;

        obtenerCantidadCeros(arreglo, numero, 0);



        //----------------------------------------------------------------------------------------------
        String secuencia[] = {
                "AEDRTYU",
                "FAUIHVG",
                "AYAIHNM",
                "IPUAHOL"
        };

        if (RepetidosEnDiagonal(secuencia, 0, 0, secuencia[0].charAt(0), 0)) {
            System.out.println("La secuencia tiene cuatro caracteres repetidos en la diagonal principal.\n");
        } else {
            System.out.println("La secuencia no tiene cuatro caracteres repetidos en la diagonal principal.\n");
        }

        //----------------------------------------------------------------------------------------------
        ArrayList<Integer> lista = new ArrayList<>();
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.add(4);
        lista.add(5);
        lista.add(6);

        int resultado = determinarResultadoRecursivo(lista, lista.size() - 1);
        System.out.println("Resultado: " + resultado);

        //----------------------------------------------------------------------------------------------

        int[] numeros = {0, 1, 0, 0, 2, 0, 3};
        int cantidadCeros = contarCeros(numeros, 0, numeros.length - 1);
        System.out.println("Cantidad de ceros: " + cantidadCeros + "\n");



    }


    public static void obtenerCantidadCeros (int[] arreglo, int numero, int contador){

        Arrays.sort(arreglo);

        int posicion = Arrays.binarySearch(arreglo, numero);
        if (posicion < 0) {
            System.out.println("El elemento: "+numero+" se repite " + contador+" veces \n");

        } else {
            contador+= 1;
            arreglo[posicion]=2;
            obtenerCantidadCeros(arreglo,numero, contador);
        }

    }

    public static boolean RepetidosEnDiagonal(String[] secuencia, int fila, int columna, char caracter, int contador) {

        if (contador == 4) {
            return true;
        } else if (fila < 0 || fila >= secuencia.length || columna < 0 || columna >= secuencia[fila].length()) {
            return false; // Si estamos fuera de los límites de la matriz, retornamos false
        } else if (secuencia[fila].charAt(fila) == caracter){
            contador += 1;
        }
        return RepetidosEnDiagonal(secuencia, fila + 1, columna +1 ,caracter, contador);
    }


    private static int determinarResultadoRecursivo(ArrayList<Integer> lista, int tamanio) {
        if (tamanio < 0) { //Si la lista se recibe vacía el método devolverá el valor 0.
            return 0;
        }

        int ultimoNumero = lista.get(tamanio);

        if (ultimoNumero == lista.size()) {
            return 0; //0, si el valor del último nodo coincide con el número de nodos de la lista.
        } else if (ultimoNumero < lista.size()) {
            return -1; //-1, si el valor del último nodo es menor que el número de nodos de la lista.
        } else {
            return 1; //+1, si el valor del último nodo es mayor que el número de nodos de la lista.
        }
    }


    public static int contarCeros(int[] arreglo, int inicio, int fin) {
        // Caso base: cuando el subarreglo tiene un solo elemento
        if (inicio == fin) {
            if (arreglo[inicio] == 0) {
                return 1;
            } else {
                return 0;
            }
        }

        // Divide el subarreglo en dos mitades
        int mitad = (inicio + fin) / 2;

        // Combina los resultados de ambas mitades
        int cerosIzquierda = contarCeros(arreglo, inicio, mitad);
        int cerosDerecha = contarCeros(arreglo, mitad + 1, fin);

        // Retorna la suma de ceros en ambas mitades
        return cerosIzquierda + cerosDerecha;
    }












    /**
     * 1. Compara el valor a buscar con el valor en el centro de la lista.
     * 2. Si el valor es igual al valor en el centro, se ha encontrado el elemento.
     * 3. Si el valor es menor que el valor en el centro, descarta la mitad derecha
     *    de la lista y repite el proceso en la mitad izquierda.
     * 4. Si el valor es mayor que el valor en el centro, descarta la mitad izquierda
     *    de la lista y repite el proceso en la mitad derecha.
     * @param array
     * @param target
     * @return
     */
        public static int binarySearch(int[] array, int target) {
            int left = 0;
            int right = array.length - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (array[mid] == target) {
                    return mid; // Elemento encontrado, devuelve el índice
                } else if (array[mid] < target) {
                    left = mid + 1; // Descarta la mitad izquierda
                } else {
                    right = mid - 1; // Descarta la mitad derecha
                }
            }

            return -1; // El elemento no se encuentra en la lista
        }

}
