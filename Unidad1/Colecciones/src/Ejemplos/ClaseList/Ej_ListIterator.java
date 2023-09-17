package ClaseList;

import java.util.ArrayList;
import java.util.ListIterator;

public class Ej_ListIterator {

    public static void main(String[] args) {

        ArrayList<String> lista = new ArrayList<String>();
        lista.add("uno");
        lista.add("dos");


        /*
        Existe el Iterator y el ListIterator
        ListIterator es una interfaz que extiende de Iterator

         */
        ListIterator<String> listIterator = lista.listIterator();

        while (listIterator.hasNext()) {
            String next = listIterator.next();
        }
        while (listIterator.hasPrevious()) {
            String previous = listIterator.previous();
        }
        System.out.println(lista);
    }
}
