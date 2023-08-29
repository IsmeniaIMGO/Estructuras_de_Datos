package DivideVenceras;

public class Ej_MergeSort {

    public static void main(String[] args) {
        /*
        1.Divide el arreglo en dos mitades.
        2.Llama recursivamente al algoritmo de Merge Sort en ambas mitades
        3. Combina las dos mitades ordenadas en un solo arreglo ordenado.
         */

        int[] array = { 38, 27, 43, 3, 9, 82, 10 };
        mergeSort(array, 0, array.length - 1);

        System.out.println("Lista ordenada:");
        for (int num : array) {
            System.out.print(num + " ");
        }

    }
        public static void mergeSort(int[] array, int left, int right) {
            if (left < right) {
                int mid = left + (right - left) / 2;

                mergeSort(array, left, mid);
                mergeSort(array, mid + 1, right);

                merge(array, left, mid, right);
            }
        }

        public static void merge(int[] array, int left, int mid, int right) {
            int n1 = mid - left + 1;
            int n2 = right - mid;

            int[] leftArray = new int[n1];
            int[] rightArray = new int[n2];

            for (int i = 0; i < n1; i++) {
                leftArray[i] = array[left + i];
            }
            for (int j = 0; j < n2; j++) {
                rightArray[j] = array[mid + 1 + j];
            }

            int i = 0, j = 0, k = left;

            while (i < n1 && j < n2) {
                if (leftArray[i] <= rightArray[j]) {
                    array[k] = leftArray[i];
                    i++;
                } else {
                    array[k] = rightArray[j];
                    j++;
                }
                k++;
            }

            while (i < n1) {
                array[k] = leftArray[i];
                i++;
                k++;
            }

            while (j < n2) {
                array[k] = rightArray[j];
                j++;
                k++;
            }
        }


}
