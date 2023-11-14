package Laboratorio1.test;

import Laboratorio1.model.*;

import java.util.ArrayList;

public class PrisionPrueba {


    public static void main(String[] args) throws Exception {

        //quema datos con una nueva prision, con un piso, llenar la matriz con espacios de ese piso
        // y crear prisioners y asignarlos a espacios

        ArrayList< Prisionero> listaPrisioneros = new ArrayList<>();
        ArrayList<Piso> listaPisos = new ArrayList<>();

        Prision prision = new Prision("1", "La carcel del fin del mundo", listaPrisioneros, listaPisos);

        prision.crearPiso(1);

        prision.crearEspacio(1, 0, 0, TipoEspacio.C);
        prision.crearEspacio(1, 1, 0, TipoEspacio.C);
        prision.crearEspacio(1, 2, 0, TipoEspacio.C);
        prision.crearEspacio(1, 3, 0, TipoEspacio.C);
        prision.crearEspacio(1, 0, 1, TipoEspacio.C);
        prision.crearEspacio(1, 0, 2, TipoEspacio.C);
        prision.crearEspacio(1, 0, 3, TipoEspacio.C);
        prision.crearEspacio(1, 0, 4, TipoEspacio.C);
        prision.crearEspacio(1, 1, 4, TipoEspacio.C);
        prision.crearEspacio(1, 2, 4, TipoEspacio.C);
        prision.crearEspacio(1, 2, 2, TipoEspacio.C);
        prision.crearEspacio(1, 3, 2, TipoEspacio.C);
        prision.crearEspacio(1, 4, 2, TipoEspacio.C);
        prision.crearEspacio(1, 4, 3, TipoEspacio.C);

        prision.crearEspacio(1, 4, 0, TipoEspacio.E);
        prision.crearEspacio(1, 4, 1, TipoEspacio.P);
        prision.crearEspacio(1, 3, 1, TipoEspacio.P);
        prision.crearEspacio(1, 2, 1, TipoEspacio.P);
        prision.crearEspacio(1, 1, 1, TipoEspacio.P);
        prision.crearEspacio(1, 1, 2, TipoEspacio.P);
        prision.crearEspacio(1, 1, 3, TipoEspacio.P);
        prision.crearEspacio(1, 2, 3, TipoEspacio.P);
        prision.crearEspacio(1, 3, 3, TipoEspacio.P);
        prision.crearEspacio(1, 3, 4, TipoEspacio.P);
        prision.crearEspacio(1, 4, 4, TipoEspacio.P);
        prision.crearEspacio(1, 4, 5, TipoEspacio.P);
        prision.crearEspacio(1, 3, 5, TipoEspacio.P);
        prision.crearEspacio(1, 2, 5, TipoEspacio.P);
        prision.crearEspacio(1, 1, 5, TipoEspacio.P);
        prision.crearEspacio(1, 0, 5, TipoEspacio.S);


        prision.crearPrisionero("1", "Juan");
        prision.crearPrisionero("2", "Roberto");
        prision.crearPrisionero("3", "Pedro");
        prision.crearPrisionero("4", "Carlos");
        prision.crearPrisionero("5", "Jose");
        prision.crearPrisionero("6", "Luis");
        prision.crearPrisionero("7", "Jorge");
        prision.crearPrisionero("8", "Mario");
        prision.crearPrisionero("9", "Miguel");
        prision.crearPrisionero("10", "Raul");
        prision.crearPrisionero("11", "Ricardo");
        prision.crearPrisionero("12", "Rodrigo");
        prision.crearPrisionero("13", "Ramon");
        prision.crearPrisionero("14", "Raul");

        prision.asignarEspacioAPrisionero("1", 1, 0, 0);
        prision.asignarEspacioAPrisionero("2", 1, 1, 0);
        prision.asignarEspacioAPrisionero("3", 1, 2, 0);
        prision.asignarEspacioAPrisionero("4", 1, 3, 0);
        prision.asignarEspacioAPrisionero("5", 1, 0, 1);
        prision.asignarEspacioAPrisionero("6", 1, 0, 2);
        prision.asignarEspacioAPrisionero("7", 1, 0, 3);
        prision.asignarEspacioAPrisionero("8", 1, 0, 4);
        prision.asignarEspacioAPrisionero("9", 1, 1, 4);
        prision.asignarEspacioAPrisionero("10", 1, 2, 4);
        prision.asignarEspacioAPrisionero("11", 1, 2, 2);
        prision.asignarEspacioAPrisionero("12", 1, 3, 2);
        prision.asignarEspacioAPrisionero("13", 1, 4, 2);
        prision.asignarEspacioAPrisionero("14", 1, 4, 3);

        prision.contarPrisioneros(1);
        System.out.println("Matriz inicial \n"+prision.imprimirPiso(1)+"\n");

        prision.eliminarPrisionero(1,2, 0);

        System.out.println("\n Matriz con el camino que recorrio");
        ArrayList<String> celdasVacias = new ArrayList<>();
        prision.recorrerPasillos(1,4,0, celdasVacias);

        System.out.println("\n Las celdas sin prisioneros son: "+ celdasVacias);
        //es posible que muestre las coordenadas varias veces por que se verifico la celda desde distintos puntos










    }
}
