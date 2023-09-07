package Laboratorio1.model;

import java.util.ArrayList;
import java.util.Objects;

public class Piso {
    private int numeroPiso;
    private Espacio[][] matrizEspacios = new Espacio[5][6];

    public Piso() {
    }

    public Piso(int numeroPiso, Espacio[][] matrizEspacios) {
        this.numeroPiso = numeroPiso;
        this.matrizEspacios = matrizEspacios;
    }

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

    @Override
    public String toString() {
        return "Piso{" +
                "numeroPiso=" + numeroPiso +
                ", matrizEspacios=" + matrizEspacios +
                '}';
    }

    public void agregarEspacio(Espacio espacio, int fila, int columna) {
        matrizEspacios[fila][columna] = espacio;
    }

    public void eliminarPrisionero(int fila, int columna) {
        matrizEspacios[fila][columna].setPrisionero(null);
    }


    public void contarPrisioneros() {
        int contador = 0;
        for (int i = 0; i < matrizEspacios.length; i++) {
            for (int j = 0; j < matrizEspacios[i].length; j++) {
                if (matrizEspacios[i][j].getPrisionero() != null) {
                    contador++;
                }
            }
        }
        System.out.println("El piso " + numeroPiso + " tiene " + contador + " prisioneros");
    }


    public boolean verificarCeldaSinPrisionero(int x, int y, ArrayList<String> celdasVacias) {
        Espacio copiaMatriz[][] = matrizEspacios.clone();
        if (x < 0 || x >= copiaMatriz.length || y < 0 || y >= copiaMatriz[x].length) {
            return false; // Si estamos fuera de los límites de la matriz, retornamos false
        }

        TipoEspacio tipoEspacio = copiaMatriz[x][y].getTipoEspacio(); // Obtén el tipo de espacio en esta posición

        if (tipoEspacio == TipoEspacio.ENTRADA) {
            verificarCeldaSinPrisionero(x-1, y, celdasVacias); //arriba
            verificarCeldaSinPrisionero(x, y + 1, celdasVacias);//derecha
            verificarCeldaSinPrisionero(x+1, y, celdasVacias);//abajo
            verificarCeldaSinPrisionero(x, y - 1, celdasVacias);//izquierda
           return true;
        }

        // Verifica si hemos llegado a la salida
        if (tipoEspacio == TipoEspacio.SALIDA) {
            return true;
        }

        if (tipoEspacio == TipoEspacio.PASILLO) {
            copiaMatriz[x][y].setTipoEspacio(TipoEspacio.X);

            verificarCelda(x - 1, y, celdasVacias);//arrriba
            verificarCelda(x, y + 1, celdasVacias);//derecha
            verificarCelda(x+1, y, celdasVacias);//abajo
            verificarCelda(x, y - 1, celdasVacias);//izquierda


            verificarCelda(x - 1, y -1, celdasVacias);//diagonal superior izquierda
            verificarCelda(x - 1, y +1, celdasVacias);//diagonal superior derecha
            verificarCelda(x + 1, y+1, celdasVacias); //diagonal inferior derecha
            verificarCelda(x + 1, y-1, celdasVacias);//diagonal inferior izquierda


            verificarCeldaSinPrisionero(x-1, y, celdasVacias);//arrriba
            verificarCeldaSinPrisionero(x, y + 1, celdasVacias);//derecha
            verificarCeldaSinPrisionero(x+1, y, celdasVacias);//abajo
            verificarCeldaSinPrisionero(x, y - 1, celdasVacias);//izquierda

        }

        return false;
    }

    private void verificarCelda(int x, int y, ArrayList<String> celdasVacias) {
        if (x < 0 || x >= matrizEspacios.length || y < 0 || y >= matrizEspacios[x].length) {
            return; // Si estamos fuera de los límites de la matriz, retornamos false
        }
        TipoEspacio tipoEspacio = matrizEspacios[x][y].getTipoEspacio(); // Obtén el tipo de espacio en esta posición

        if (tipoEspacio == TipoEspacio.CELDA) {
            if (matrizEspacios[x][y].getPrisionero() == null) {
                celdasVacias.add(x + "," + y);
            }
        }
    }


}
