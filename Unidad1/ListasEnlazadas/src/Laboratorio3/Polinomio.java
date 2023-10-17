package Laboratorio3;

public class Polinomio {
    NodoTermino primerTermino;

    public Polinomio() {
        this.primerTermino = null;
    }

    public NodoTermino getPrimerTermino() {
        return primerTermino;
    }

    public void setPrimerTermino(NodoTermino primerTermino) {
        this.primerTermino = primerTermino;
    }


    @Override
    public String toString() {
        return "Polinomio{" +
                "primerTermino=" + primerTermino +
                '}';
    }

    public void agregarTermino(double coeficiente, int exponente) {
        NodoTermino nuevoTermino = new NodoTermino(coeficiente, exponente);

        if (this.primerTermino == null) {
            this.primerTermino = nuevoTermino;
        } else {
            NodoTermino actual = this.primerTermino;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoTermino;
        }
    }

    public double evaluar(double x) {
        double resultado = 0.0;
        NodoTermino actual = this.primerTermino;

        while (actual != null) {
            resultado += actual.coeficiente * Math.pow(x, actual.exponente);
            actual = actual.siguiente;
        }

        return resultado;
    }


   public void imprimirPolinomio() {
        NodoTermino actual = this.primerTermino;
        while (actual != null) {
            if (actual.coeficiente != 0) {
                if (actual.coeficiente > 0) {
                    System.out.print("+" + actual.coeficiente);
                } else {
                    System.out.print(actual.coeficiente);
                }

                if (actual.exponente != 0) {
                    System.out.print("x^" + actual.exponente);
                }
            }
            actual = actual.siguiente;
        }
        System.out.println();
    }



}
