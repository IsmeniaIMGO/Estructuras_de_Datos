package ejercicios;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class multiplicarArreglo {
    public static void main(String[] args) {

        int numeros [] = {3,5,7,3,4};

        System.out.println("Recorrer sin recursividad: ");
        recorrerSin(numeros, 0);

        System.out.println("recorrer con recursividad");
        recorrerCon(numeros,0);

        multiplicar(numeros, 0, 1);

        //pido el dato = valor

        multiplicarSegun(numeros, 0, 2, 1);
        }


    private static void recorrerSin(int[] numeros, int indice) {
        for (int i = 0; i < numeros.length ; i++) {
            int resultado = 1;
            resultado *= numeros[i];
            System.out.println(resultado);
        }
    }

    private static void recorrerCon(int[] numeros, int indice) {
        //caso base
        if (indice == numeros.length-1){
            System.out.println("Elemento "+numeros[indice]);
        }else{
            System.out.println("Elemento "+numeros[indice]);
            recorrerCon(numeros, indice+1);
        }
    }

    /*ejercicio
    realizar un metodo recursivo que obtenga el resultado de multiplicar
    todos los valores mayores que un resultado dado
    */
    private static void multiplicar(int[] numeros, int indice, int resultado) {
        //caso base
        if (indice == numeros.length){
            System.out.println("Resultado: "+resultado);
        }else{
            System.out.println("Elemento "+numeros[indice]);
            int num = numeros[indice];
            resultado= resultado*num;
            multiplicar(numeros, indice+1, resultado);
        }
    }

    private static void multiplicarSegun(int[] numeros, int indice, int valor, int resultado) {
        //caso base
        if (indice == numeros.length){
            System.out.println("Resultado: "+resultado);
        }else{
            System.out.println("Elemento "+numeros[indice]);
            int num = numeros[indice];
            resultado= resultado*num;
            multiplicarSegun(numeros, indice+1, valor, resultado);
        }
    }



    /*realizar un metodo recursivo que obtenga el mayor de los numeros del arreglo
    */

    //divide y venceras, que obtenga el numero mayor de un arreglo
    //metodo busquedaBinaria usando divide y venceras
}