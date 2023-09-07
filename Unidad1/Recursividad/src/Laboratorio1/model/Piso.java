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


    public boolean verificarCeldaSinPrisionero(int x, int y, ArrayList<Espacio> celdasVacias) {
            TipoEspacio tipoEspacio = matrizEspacios[x][y].getTipoEspacio(); // Obtén el tipo de espacio en esta posición

        // Verifica si hemos llegado a la salida
        if (tipoEspacio == TipoEspacio.SALIDA) {
            System.out.println("Las celdas sin prisioneros son: "+ celdasVacias);
            return true;
        }

        // Verifica si estamos en un pasillo (P)
        if (tipoEspacio == TipoEspacio.PASILLO) {
            // Verifica si la celda tiene un prisionero (C)
            if (!celdaTienePrisionero(x, y)) {
                celdasVacias.add(matrizEspacios[x][y]); // Agregamos la celda a la lista de celdas vacías
                return false; // Si no tiene prisionero, retornamos false
            }

        }else if (x < 0 || x >= matrizEspacios.length || y < 0 || y >= matrizEspacios[x].length) {
            return false; // Si estamos fuera de los límites de la matriz, retornamos false
        }

        // Intentamos mover hacia la DERECHA
        if (verificarCeldaSinPrisionero(x, y + 1, celdasVacias)) {
            return true;
        }

        // Intentamos mover hacia ARRIBA
        if (verificarCeldaSinPrisionero(x - 1, y, celdasVacias)) {
            return true;
        }

        // Intentamos mover hacia la IZQUIERDA
        if (verificarCeldaSinPrisionero(x, y - 1, celdasVacias)) {
            return true;
        }

        // Intentamos mover hacia ABAJO
        if (verificarCeldaSinPrisionero(x + 1, y, celdasVacias)) {
            return true;
        }

        return false;
    }

    public boolean celdaTienePrisionero(int x, int y) {
        if (matrizEspacios[x][y].getPrisionero() != null){
            return true; // Verifica si la celda en las coordenadas (x, y) contiene un prisionero
        }
        return false;
    }

    /*

     */






}
