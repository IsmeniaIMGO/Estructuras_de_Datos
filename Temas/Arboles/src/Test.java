public class Test {

    public static void main(String[] args) {

        Arbol arbol = new Arbol();
        arbol.agregarDato(6);
        arbol.agregarDato(15);
        arbol.agregarDato(4);
        arbol.agregarDato(5);
        arbol.agregarDato(8);
        arbol.agregarDato(16);
        arbol.agregarDato(1);

        arbol.imprimirArbolEnConsola();
        System.out.println("Recorrido inorden");
        arbol.recorrerInorden();
        System.out.println("Recorrido postorden");
        arbol.recorrerPostorden();
        System.out.println("Recorrido preorden");
        arbol.recorrerPreorden();

        System.out.println("\n Consultar los hijos de un nodo");
        System.out.println(arbol.obtenerNodo(15).toString());

    }
}
