package DivideVenceras;

public class Ej_Quicksort {

    public static void main(String[] args) {
        /*
        Selecciona un elemento como pivote y divide el arreglo en dos sub-arreglos:
        uno con elementos menores que el pivote y otro con elementos mayores.
        Luego, ordena recursivamente ambos sub-arreglos.
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
