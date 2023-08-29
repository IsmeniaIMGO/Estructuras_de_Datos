package DivideVenceras;

public class Ej_BusquedaBinaria {

    public static void main(String[] args) {
        /*
        La búsqueda binaria es un algoritmo de búsqueda eficiente utilizado
        para encontrar la posición de un elemento en una lista ordenada.

      */

        int[] sortedArray = { 1, 3, 5, 7, 9, 11, 13, 15, 17, 19 };
        int target = 11;
        int index = binarySearch(sortedArray, target);
        if (index != -1) {
            System.out.println("El elemento " + target + " se encuentra en la posición " + index);
        } else {
            System.out.println("El elemento " + target + " no se encuentra en la lista.");
        }

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
