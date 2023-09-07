package ejComparator;

import java.util.Comparator;

public class ComparatorEdad implements Comparator<Estudiante> {
    @Override
    public int compare(Estudiante o1, Estudiante o2) {

        //Integer es una clase que representa a un entero
        Integer edad1 = o1.getEdad();
        Integer edad2 = o2.getEdad();
        return edad1.compareTo(edad2);
    }
}
