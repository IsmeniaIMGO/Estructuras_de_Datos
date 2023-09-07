package Laboratorio1.test;

import Laboratorio1.model.*;

import java.util.ArrayList;

public class PrisionPrueba {


    public static void main(String[] args) throws Exception {

        //quema datos con una nueva prision, con un piso, llenar la matriz con espacios de ese piso y crear prisioners y asignarlos a espacios
        //crear un prisionero y asignarlo a un espacio
        ArrayList< Prisionero> listaPrisioneros = new ArrayList<>();
        ArrayList<Piso> listaPisos = new ArrayList<>();

        Prision prision = new Prision("1", "La carcel del fin del mundo", listaPrisioneros, listaPisos);

        prision.crearPiso(1);

        prision.crearPrisionero("1", "Juan");


        prision.crearEspacio(1, 0, 0, TipoEspacio.CELDA);
        prision.crearEspacio(1, 1, 0, TipoEspacio.CELDA);
        prision.crearEspacio(1, 2, 0, TipoEspacio.CELDA);
        prision.crearEspacio(1, 3, 0, TipoEspacio.CELDA);
        prision.crearEspacio(1, 0, 1, TipoEspacio.CELDA);
        prision.crearEspacio(1, 0, 2, TipoEspacio.CELDA);
        prision.crearEspacio(1, 0, 3, TipoEspacio.CELDA);
        prision.crearEspacio(1, 0, 4, TipoEspacio.CELDA);
        prision.crearEspacio(1, 1, 4, TipoEspacio.CELDA);
        prision.crearEspacio(1, 2, 4, TipoEspacio.CELDA);
        prision.crearEspacio(1, 2, 2, TipoEspacio.CELDA);
        prision.crearEspacio(1, 3, 2, TipoEspacio.CELDA);
        prision.crearEspacio(1, 4, 2, TipoEspacio.CELDA);
        prision.crearEspacio(1, 4, 3, TipoEspacio.CELDA);

        prision.crearEspacio(1, 4, 0, TipoEspacio.ENTRADA);
        prision.crearEspacio(1, 4, 1, TipoEspacio.PASILLO);
        prision.crearEspacio(1, 3, 1, TipoEspacio.PASILLO);
        prision.crearEspacio(1, 2, 1, TipoEspacio.PASILLO);
        prision.crearEspacio(1, 1, 1, TipoEspacio.PASILLO);
        prision.crearEspacio(1, 1, 2, TipoEspacio.PASILLO);
        prision.crearEspacio(1, 1, 3, TipoEspacio.PASILLO);
        prision.crearEspacio(1, 2, 3, TipoEspacio.PASILLO);
        prision.crearEspacio(1, 3, 3, TipoEspacio.PASILLO);
        prision.crearEspacio(1, 3, 4, TipoEspacio.PASILLO);
        prision.crearEspacio(1, 4, 4, TipoEspacio.PASILLO);
        prision.crearEspacio(1, 4, 5, TipoEspacio.PASILLO);
        prision.crearEspacio(1, 3, 5, TipoEspacio.PASILLO);
        prision.crearEspacio(1, 2, 5, TipoEspacio.PASILLO);
        prision.crearEspacio(1, 1, 5, TipoEspacio.PASILLO);
        prision.crearEspacio(1, 0, 5, TipoEspacio.SALIDA);

        prision.asignarEspacioAPrisionero("1", 1, 0, 0);


        //imprimir matriz del piso
        for (int i = 0; i < prision.getListaPisos().get(0).getMatrizEspacios().length; i++) {
            for (int j = 0; j < prision.getListaPisos().get(0).getMatrizEspacios()[i].length; j++) {
                System.out.print(prision.getListaPisos().get(0).getMatrizEspacios()[i][j] + " ");
            }
            System.out.println();
        }





    }
}
