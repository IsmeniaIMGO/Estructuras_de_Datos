package ejComparator;

import java.util.ArrayList;
import java.util.Collections;

public class test {

    public static void main(String[] args) {

        ArrayList<Estudiante> listaEstudiantes = new ArrayList<>();

        Estudiante e1 = new Estudiante("Juan", 20);
        Estudiante e2 = new Estudiante("Pedro", 18);

        listaEstudiantes.add(e1);
        listaEstudiantes.add(e2);

        System.out.println("lista antes de ordenar: ");
        for (Estudiante estudiante : listaEstudiantes) {
            System.out.println(estudiante.getNombre());
        }

        Collections.sort(listaEstudiantes, new ComparatorEdad());
          /*
        Un objeto debe tener implementado el compare to, para que pueda ser ordenado
        o crear una interface que implemente el compare to de un atributo de una clase,
        de esa manera cuando ordene la lista de objetos con collections.sort tambien le
        agregue en base a que atributo se va a ordenar
         */
        System.out.println("lista despues de ordenar: ");
        for (Estudiante estudiante : listaEstudiantes) {
            System.out.println(estudiante.getNombre());
        }


    }
}
