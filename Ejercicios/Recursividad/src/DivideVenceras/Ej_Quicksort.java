package DivideVenceras;

public class Ej_Quicksort {

    public static void main(String[] args) {
        /*
        Divide: Divide el problema original en subproblemas más pequeños y más sencillos.
        Esta división puede llevarse a cabo de manera recursiva hasta que los subproblemas
        sean lo suficientemente simples para ser resueltos de manera directa.

        Vence: Resuelve los subproblemas de manera recursiva. Cada subproblema se trata como
        una instancia más pequeña del problema original y se resuelve utilizando la misma
        estrategia de "divide y vencerás". Esto puede implicar la subdivisión adicional
        de los subproblemas si es necesario.

        Combina: Combina las soluciones de los subproblemas para obtener la solución del
        problema original. Esta combinación puede ser tan simple como sumar, promediar u
        operar las soluciones de los subproblemas de acuerdo con la naturaleza del
        problema en cuestión.
         */

        int[] numbers = { 6, 2, 8, 4, 1, 7, 3, 5 };
        int n = numbers.length;

        quickSort(numbers, 0, n - 1);

        System.out.println("Lista ordenada:");
        for (int num : numbers) {
            System.out.print(num + " ");
        }


    }

    /**
     * El método QuickSort para ARREGLOS es un algoritmo de ordenamiento que organiza una
     * lista dividiéndola en dos partes, una con elementos más pequeños que
     * un "pivot" elegido y otra con elementos más grandes. Luego, se repite
     * este proceso en las partes separadas hasta que toda la lista esté ordenada.
      * @param array
     * @param left
     * @param right
     */
        public static void quickSort(int[] array, int left, int right) {
            if (left < right) {
                int pivotIndex = partition(array, left, right);
                quickSort(array, left, pivotIndex - 1);
                quickSort(array, pivotIndex + 1, right);
            }
        }

        public static int partition(int[] array, int left, int right) {
            int pivot = array[right];
            int i = left - 1;

            for (int j = left; j < right; j++) {
                if (array[j] < pivot) {
                    i++;
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }

            int temp = array[i + 1];
            array[i + 1] = array[right];
            array[right] = temp;

            return i + 1;
        }






}
