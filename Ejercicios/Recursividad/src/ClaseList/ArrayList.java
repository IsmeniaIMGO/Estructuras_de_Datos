package ClaseList;

import java.util.Arrays;

public class ArrayList {
    public static void main(String[] args) {

        /*
         Este método toma un arreglo y lo ordena utilizando un algoritmo de ordenamiento: TimSort
         solo sirve para arreglos
         */
        java.util.ArrayList numbersList = new java.util.ArrayList<>();
        numbersList.add(5);
        numbersList.add(2);
        numbersList.add(9);
        numbersList.add(1);
        numbersList.add(3);

        System.out.println("Lista antes de ordenar: " + numbersList);

        Object[] numbersArray = numbersList.toArray(new Integer[0]);
        Arrays.sort(numbersArray);  // Utilizar Arrays.sort para ordenar el arreglo

        System.out.println("Lista después de ordenar: " + numbersList);

        /*
        hacer ejemplos de metodos mas importantes con arraylist

         */
    }
}
