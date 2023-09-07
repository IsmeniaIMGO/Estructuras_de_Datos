package rDirectaCruzada;

public class Ejemplos {

    public static void main(String[] args) {

        /*
        La recursividad directa ocurre cuando una función se llama a sí misma
        dentro de su propia definición. Esto significa que la función principal
        invoca una copia exacta de sí misma con argumentos diferentes,
         */
        int number1 = 5;
        int result1 = factorial(number1);
        System.out.println("Factorial de " + number1 + " es: " + result1);
        factorial(5);


        /*
        La recursividad cruzada ocurre cuando dos o más funciones se llaman entre sí
        para resolver un problema de manera cooperativa. En lugar de una función
        llamándose a sí misma directamente, varias funciones trabajan juntas para dividir
        y resolver un problema complejo en partes más pequeñas.
         */

        int number2 = 5;
        int result2 = fibonacciA(number2);
        System.out.println("Fibonacci de " + number2 + " es: " + result2);

    }

    /**
     * factorial de un número n se calcula multiplicando todos
     * los números enteros positivos desde 1 hasta n.
     * @param n
     * @return
     */
    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }


    /**
     * La serie de Fibonacci es una secuencia matemática que comienza con dos números iniciales
     * y cada número subsiguiente en la serie es la suma de los dos números anteriores.
     * @param n
     * @return
     */
    public static int fibonacciA(int n) {
        if (n == 0) {
            return 0;
        } else {
            return n + fibonacciB(n - 1);
        }
    }

    public static int fibonacciB(int n) {
        if (n == 0) {
            return 0;
        } else {
            return n + fibonacciA(n - 1);
        }
    }





}
