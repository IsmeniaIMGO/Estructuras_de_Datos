import java.util.ArrayList;

public class Arbol {

    private NodoArbol raiz;
    private int peso;
    private int altura;
    private int nivel;

    public Arbol() {
        this.raiz = null;
        this.peso = 0;
        this.altura = 0;
        this.nivel = 0;
    }

    public NodoArbol getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoArbol raiz) {
        this.raiz = raiz;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }


    @Override
    public String toString() {
        return "Arbol{" +
                "raiz=" + raiz +
                '}';
    }
    //-------------------Metodos basicos-------------------

    public void recorrerInorden(){
        if (!estaVacío()){
            if (raiz.getHijoIzquierdo() != null){
                raiz.getHijoIzquierdo().recorrerInorden();
            }
            System.out.println(raiz.getDato());
            if (raiz.getHijoDerecho() != null){
                raiz.getHijoDerecho().recorrerInorden();
            }
        }
    }

    public void recorrerPreorden(){
        if (!estaVacío()){
            System.out.println(raiz.getDato());
            if (raiz.getHijoIzquierdo() != null){
                raiz.getHijoIzquierdo().recorrerPreorden();
            }
            if (raiz.getHijoDerecho() != null){
                raiz.getHijoDerecho().recorrerPreorden();
            }
        }
    }

    public void recorrerPostorden(){
        if (!estaVacío()){
            if (raiz.getHijoIzquierdo() != null){
                raiz.getHijoIzquierdo().recorrerPostorden();
            }
            if (raiz.getHijoDerecho() != null){
                raiz.getHijoDerecho().recorrerPostorden();
            }
            System.out.println(raiz.getDato());
        }
    }

    public boolean estaVacío(){
        return raiz == null;
    }

    public void agregarDato(int dato){
        if (estaVacío()) {
            raiz = new NodoArbol(dato);
            nivel = 0; // Establecer el nivel inicial como 0 para la raíz
            peso++;
        } else {
            if (dato < raiz.getDato()) {
                if (raiz.getHijoIzquierdo() == null) {
                    raiz.setHijoIzquierdo(new Arbol());
                }
                raiz.getHijoIzquierdo().agregarDato(dato);
                raiz.getHijoIzquierdo().setNivel(nivel + 1); // Incrementar el nivel en el subárbol izquierdo
            } else {
                if (raiz.getHijoDerecho() == null) {
                    raiz.setHijoDerecho(new Arbol());
                }
                raiz.getHijoDerecho().agregarDato(dato);
                raiz.getHijoDerecho().setNivel(nivel + 1); // Incrementar el nivel en el subárbol derecho
            }
        }
        peso++;
    }

    public void existeDatos(int dato){
        if (estaVacío()){
            System.out.println("El dato no existe");
        }else{
            if (dato == raiz.getDato()){
                System.out.println("El dato existe");
            }else{
                if (dato < raiz.getDato()){
                    if (raiz.getHijoIzquierdo() == null){
                        System.out.println("El dato no existe");
                    }else{
                        raiz.getHijoIzquierdo().existeDatos(dato);
                    }
                }else{
                    if (raiz.getHijoDerecho() == null){
                        System.out.println("El dato no existe");
                    }else{
                        raiz.getHijoDerecho().existeDatos(dato);
                    }
                }
            }
        }
    }

    public int obtenerPeso(){
        return getPeso();
    }

    public int obtenerAltura(){
        return getAltura();
    }

    public int obtenerNivel(int dato){
        if (estaVacío()){
            return 0;
        }else{
            if (dato == raiz.getDato()){
                return getNivel();
            }else{
                if (dato < raiz.getDato()){
                    if (raiz.getHijoIzquierdo() == null){
                        return 0;
                    }else{
                        return raiz.getHijoIzquierdo().obtenerNivel(dato);
                    }
                }else{
                    if (raiz.getHijoDerecho() == null){
                        return 0;
                    }else{
                        return raiz.getHijoDerecho().obtenerNivel(dato);
                    }
                }
            }
        }
    }

    public int contarHojas(){
        if (estaVacío()){
            return 0;
        }else{
            if (raiz.getHijoIzquierdo() == null && raiz.getHijoDerecho() == null){
                return 1;
            }else{
                if (raiz.getHijoIzquierdo() == null){
                    return raiz.getHijoDerecho().contarHojas();
                }else{
                    if (raiz.getHijoDerecho() == null){
                        return raiz.getHijoIzquierdo().contarHojas();
                    }else{
                        return raiz.getHijoIzquierdo().contarHojas() + raiz.getHijoDerecho().contarHojas();
                    }
                }
            }
        }
    }

    public ArrayList<Integer> obtenerDatosHojas(){

        ArrayList<Integer> datosHojas = new ArrayList<Integer>();

        if (estaVacío()){
            return datosHojas;
        }else{
            if (raiz.getHijoIzquierdo() == null && raiz.getHijoDerecho() == null){
                datosHojas.add(raiz.getDato());
                return datosHojas;
            }else{
                if (raiz.getHijoIzquierdo() == null){
                    return raiz.getHijoDerecho().obtenerDatosHojas();
                }else{
                    if (raiz.getHijoDerecho() == null){
                        return raiz.getHijoIzquierdo().obtenerDatosHojas();
                    }else{
                        datosHojas.addAll(raiz.getHijoIzquierdo().obtenerDatosHojas());
                        datosHojas.addAll(raiz.getHijoDerecho().obtenerDatosHojas());
                        return datosHojas;
                    }
                }
            }
        }
    }

    public int obtenerDatoMenor(){
        if (estaVacío()){
            return 0;
        }else{
            if (raiz.getHijoIzquierdo() == null){
                return raiz.getDato();
            }else{
                return raiz.getHijoIzquierdo().obtenerDatoMenor();
            }
        }
    }

    public int obtenerDatoMayor(){
        if (estaVacío()){
            return 0;
        }else{
            if (raiz.getHijoDerecho() == null){
                return raiz.getDato();
            }else{
                return raiz.getHijoDerecho().obtenerDatoMayor();
            }
        }
    }

    public NodoArbol obtenerNodoMenor(){
        if (estaVacío()){
            return null;
        }else{
            if (raiz.getHijoIzquierdo() == null){
                return raiz;
            }else{
                return raiz.getHijoIzquierdo().obtenerNodoMenor();
            }
        }
    }

    public NodoArbol obtenerNodoMayor(){
        if (estaVacío()){
            return null;
        }else{
            if (raiz.getHijoDerecho() == null){
                return raiz;
            }else{
                return raiz.getHijoDerecho().obtenerNodoMayor();
            }
        }
    }

    public NodoArbol obtenerNodo(int dato){
        if (estaVacío()){
            return null;
        }else{
            if (dato == raiz.getDato()){
                return raiz;
            }else{
                if (dato < raiz.getDato()){
                    if (raiz.getHijoIzquierdo() == null){
                        return null;
                    }else{
                        return raiz.getHijoIzquierdo().obtenerNodo(dato);
                    }
                }else{
                    if (raiz.getHijoDerecho() == null){
                        return null;
                    }else{
                        return raiz.getHijoDerecho().obtenerNodo(dato);
                    }
                }
            }
        }
    }

    public void eliminarDato(){
        if (estaVacío()){
            System.out.println("El dato no existe");
        }else{
            if (raiz.getHijoIzquierdo() == null && raiz.getHijoDerecho() == null){
                raiz = null;
            }else{
                if (raiz.getHijoIzquierdo() == null){
                    raiz = raiz.getHijoDerecho().getRaiz();
                }else{
                    if (raiz.getHijoDerecho() == null){
                        raiz = raiz.getHijoIzquierdo().getRaiz();
                    }else{
                        NodoArbol nodoMenor = raiz.getHijoDerecho().obtenerNodoMenor();
                        raiz.setDato(nodoMenor.getDato());
                        raiz.getHijoDerecho().eliminarDato();
                    }
                }
            }
        }
    }


    public void borrarArbol() {
        if (estaVacío()) {
            System.out.println("El arbol ya esta vacio");
        } else {
            if (raiz.getHijoIzquierdo() == null && raiz.getHijoDerecho() == null) {
                raiz = null;
            } else {
                if (raiz.getHijoIzquierdo() == null) {
                    raiz = raiz.getHijoDerecho().getRaiz();
                    raiz.getHijoDerecho().borrarArbol();
                } else {
                    if (raiz.getHijoDerecho() == null) {
                        raiz = raiz.getHijoIzquierdo().getRaiz();
                        raiz.getHijoIzquierdo().borrarArbol();

                    }
                }
            }
        }
    }


    public void imprimirArbolEnConsola(NodoArbol nodo, String prefijo, boolean esHijoIzquierdo) {
        if (nodo != null) {
            System.out.println(prefijo + (esHijoIzquierdo ? "I── " : "D── ") + nodo.getDato());
            if (nodo.getHijoIzquierdo() != null) {
                imprimirArbolEnConsola(nodo.getHijoIzquierdo().getRaiz(), prefijo + (esHijoIzquierdo ? "    " : "|   "), true);
            }
            if (nodo.getHijoDerecho() != null) {
                imprimirArbolEnConsola(nodo.getHijoDerecho().getRaiz(), prefijo + (esHijoIzquierdo ? "    " : "|   "), false);
            }
        }
    }

    public void imprimirArbolEnConsola() {
        if (raiz != null) {
            System.out.println("Raíz");
            imprimirArbolEnConsola(raiz, "", false);
        } else {
            System.out.println("El árbol está vacío.");
        }
    }


/*
    estaVacio
    Agregar dato
    Recorrer árbol (Inorden, Postorden, Preorden).
    existe dato
    obtenerPeso
    obtenerAltura
    obtenerNivel
    contarHojas
    obtenerMenor
    imprimirAmplitud
    Eliminar dato
    contarHojas
    obtenerNodoMayor
    obtenerNodoMenor
    borrar el arbol


     */


}
