package metodosTimSort;

import java.util.ArrayList;
import java.util.Collections;

public class Ej_CollectionsSort {

    public static void main(String[] args) {
        /*
         Este método toma una lista y la ordena utilizando un algoritmo de ordenamiento: TimSort
         sirve para lista, arraylist, etc.
         */

        ArrayList numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(2);
        numbers.add(9);
        numbers.add(1);
        numbers.add(3);

        System.out.println("Lista antes de ordenar: " + numbers);

        Collections.sort(numbers);  // Utilizar Collections.sort para ordenar la lista

        System.out.println("Lista después de ordenar: " + numbers);
    }
}