package Laboratorio1.model;

import java.util.ArrayList;
import java.util.Objects;

public class Piso {
    /*
    atributos
     */
    private int numeroPiso;
    private Espacio[][] matrizEspacios = new Espacio[5][6];

    /*
    constructor vacio
     */
    public Piso() {
    }

    /*
    constructor con atributos
     */
    public Piso(int numeroPiso, Espacio[][] matrizEspacios) {
        this.numeroPiso = numeroPiso;
        this.matrizEspacios = matrizEspacios;
    }

    /*
    metodos set y get
     */
    public int getNumeroPiso() {
        return numeroPiso;
    }

    public void setNumeroPiso(int numeroPiso) {
        this.numeroPiso = numeroPiso;
    }

    public Espacio[][] getMatrizEspacios() {
        return matrizEspacios;
    }

    public void setMatrizEspacios(Espacio[][] matrizEspacios) {
        this.matrizEspacios = matrizEspacios;
    }

    /*
    metodos equals y hashcode
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piso piso = (Piso) o;
        return numeroPiso == piso.numeroPiso;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroPiso);
    }

    /*
    metodo toString
     */
    @Override
    public String toString() {
        return "Piso{" +
                "numeroPiso=" + numeroPiso +
                ", matrizEspacios=" + matrizEspacios +
                '}';
    }

    /**
     * metodo que me agrega un espacio dentro de la matriz
     * @param espacio
     * @param fila
     * @param columna
     */
    public void agregarEspacio(Espacio espacio, int fila, int columna) {
        matrizEspacios[fila][columna] = espacio;
    }

    /**
     * metodo que me elimina un prisionero de un espacio dentro de a matriz
     * @param fila
     * @param columna
     */
    public void eliminarPrisionero(int fila, int columna) {
        matrizEspacios[fila][columna].setPrisionero(null);
    }

    /**
     * metodo que asigna a un espacio, un prisionero y cambia su estado a ocupado
     * @param fila
     * @param columna
     * @param prisionero
     * @param estado
     */
    public void actualizarEspacio(int fila, int columna, Prisionero prisionero, boolean estado) {
        matrizEspacios[fila][columna].setEstado(estado);
        matrizEspacios[fila][columna].setPrisionero(prisionero);
    }

    /**
     * metodo que me cuenta los prisioneros
     */
    public void contarPrisioneros() {
        int contador = 0;
        for (int i = 0; i < matrizEspacios.length; i++) {
            for (int j = 0; j < matrizEspacios[i].length; j++) {
                if (matrizEspacios[i][j].getPrisionero() != null) {
                    contador++;
                }
            }
        }
        System.out.println("El piso " + numeroPiso + " tiene " + contador + " prisioneros"+"\n");
    }


    /**
     * metodo que me recorre los pasillos y verifica en todas las direcciones las celdas
     * @param x
     * @param y
     * @param celdasVacias
     * @return
     */
    public boolean recorrerPasillos(int x, int y, ArrayList<String> celdasVacias) {
        Espacio copiaMatriz[][] = matrizEspacios.clone();//se debe hacer una copia de la matriz original

        if (x < 0 || x >= copiaMatriz.length || y < 0 || y >= copiaMatriz[x].length) {
            return false; // Si estamos fuera de los límites de la matriz, retornamos false
        }

        TipoEspacio tipoEspacio = copiaMatriz[x][y].getTipoEspacio(); // Obtén el tipo de espacio en esta posición

        //esta es el punto inicial, la entrada y luego busca el pasillo para iniciar el camino
        if (tipoEspacio == TipoEspacio.E) {
            recorrerPasillos(x-1, y, celdasVacias); //arriba
            recorrerPasillos(x, y + 1, celdasVacias);//derecha
            recorrerPasillos(x+1, y, celdasVacias);//abajo
            recorrerPasillos(x, y - 1, celdasVacias);//izquierda
           return true;
        }

        // Verifica si hemos llegado a la salida
        //entonces se imprime la matriz con el recorrido que se hizo con las x
        if (tipoEspacio == TipoEspacio.S) {
            imprimirMatriz(copiaMatriz);
            return true;
        }

        //en esa posicion en ese pasillo, verifica en todas las direcciones todas las celdas
        if (tipoEspacio == TipoEspacio.P) {
            //cuando llega a un pasillo lo marca con una x para no volver a pasar por ahi
            copiaMatriz[x][y].setTipoEspacio(TipoEspacio.X);

            //verifica en todas las direcciones
            verificarCelda(x - 1, y, celdasVacias);//arrriba
            verificarCelda(x, y + 1, celdasVacias);//derecha
            verificarCelda(x+1, y, celdasVacias);//abajo
            verificarCelda(x, y - 1, celdasVacias);//izquierda


            verificarCelda(x - 1, y -1, celdasVacias);//diagonal superior izquierda
            verificarCelda(x - 1, y +1, celdasVacias);//diagonal superior derecha
            verificarCelda(x + 1, y+1, celdasVacias); //diagonal inferior derecha
            verificarCelda(x + 1, y-1, celdasVacias);//diagonal inferior izquierda

            //Busca el siguiente pasillo
            recorrerPasillos(x-1, y, celdasVacias);//arrriba
            recorrerPasillos(x, y + 1, celdasVacias);//derecha
            recorrerPasillos(x+1, y, celdasVacias);//abajo
            recorrerPasillos(x, y - 1, celdasVacias);//izquierda

        }

        return false;
    }

    /**
     * imprime la copia de la matriz original con el camino recorrido
     * @param copiaMatriz
     */
    private void imprimirMatriz(Espacio[][] copiaMatriz) {
        for (int i = 0; i < copiaMatriz.length; i++) {
            for (int j = 0; j < copiaMatriz[i].length; j++) {
                System.out.print(copiaMatriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * metodo que verifica en esa celda, si hay un prisionero o no
     * @param x
     * @param y
     * @param celdasVacias
     */
    private void verificarCelda(int x, int y, ArrayList<String> celdasVacias) {
        if (x < 0 || x >= matrizEspacios.length || y < 0 || y >= matrizEspacios[x].length) {
            return; // Si estamos fuera de los límites de la matriz, retornamos false
        }
        TipoEspacio tipoEspacio = matrizEspacios[x][y].getTipoEspacio(); // Obtén el tipo de espacio en esta posición

        if (tipoEspacio == TipoEspacio.C) {
            if (matrizEspacios[x][y].getPrisionero() == null) {
                celdasVacias.add(x + "," + y);
            }
        }
    }



}
