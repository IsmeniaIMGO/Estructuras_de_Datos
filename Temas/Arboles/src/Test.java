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

        arbol.imprimirArbol();
        System.out.println("Recorrido inorden");
        arbol.recorrerInorden();
        System.out.println("Recorrido postorden");
        arbol.recorrerPostorden();
        System.out.println("Recorrido preorden");
        arbol.recorrerPreorden();

        System.out.println("existencia: ");
        arbol.existeDato(15);
        System.out.println(arbol.obtenerNodo(15).toString());
        System.out.println("peso: "+arbol.obtenerPeso());
        System.out.println("altura: "+arbol.obtenerAltura());
        System.out.println("nivel: "+arbol.obtenerNivel(15));
        System.out.println("amplitud: ");
        System.out.println("cantidad de hojas: "+arbol.contarHojas());
        System.out.println("nodo menor: "+arbol.obtenerNodoMenor());
        System.out.println("nodo mayor: "+arbol.obtenerNodoMayor());
        System.out.println("eliminar nodo");
        arbol.eliminarNodo(15);
        System.out.println("Imprimimos el arbol para verificar que si se elimino el nodo");
        arbol.imprimirArbol();
        System.out.println("borrar arbol");
        arbol.borrarArbol();
        System.out.println("Imprimimos el arbol para verificar que si se borro el arbol");
        arbol.imprimirArbol();






    }
}
