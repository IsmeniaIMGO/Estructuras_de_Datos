package Laboratorio3;

public class Polinomio {
    private NodoTermino primerTermino;

    /**
     * Constructor por defecto de la clase Polinomio
     */
    public Polinomio() {
        this.primerTermino = null;
    }

    //metodos get y set
    public NodoTermino getPrimerTermino() {
        return primerTermino;
    }

    public void setPrimerTermino(NodoTermino primerTermino) {
        this.primerTermino = primerTermino;
    }

    /**
     * Metodo toString de la clase Polinomio
     * @return
     */
    @Override
    public String toString() {
        return "Polinomio{" +
                "primerTermino=" + primerTermino +
                '}';
    }

    //metodos basicos

    /**
     * Metodo que agrega un termino al polinomio
     * @param coeficiente
     * @param exponente
     */
    public void agregarTermino(double coeficiente, int exponente) {
        NodoTermino nuevoTermino = new NodoTermino(coeficiente, exponente);

        if (this.primerTermino == null) {
            this.primerTermino = nuevoTermino;
        } else {
            NodoTermino actual = this.primerTermino;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevoTermino);
        }
    }

    /**
     * Metodo que evalua el polinomio en un valor x
     * @param x
     * @return
     */
    public double evaluar(double x) {
        double resultado = 0.0;
        NodoTermino actual = this.primerTermino;

        while (actual != null) {
            resultado += actual.getCoeficiente() * Math.pow(x, actual.getExponente());
            actual = actual.getSiguiente();
        }

        return resultado;
    }


    /**
     * Metodo que imprime el polinomio
     */
   public void imprimirPolinomio() {
        NodoTermino actual = this.primerTermino;
        while (actual != null) {
            if (actual.getCoeficiente() != 0) {
                if (actual.getCoeficiente() > 0) {
                    System.out.print("+" + actual.getCoeficiente());
                } else {
                    System.out.print(actual.getCoeficiente());
                }

                if (actual.getExponente() != 0) {
                    System.out.print("x^" + actual.getExponente());
                }
            }
            actual = actual.getSiguiente();
        }
        System.out.println();
    }



}
