public class Arbol<T> {

    private NodoArbol<T> raiz;
    private int peso;
    private int altura;
    private int nivel;

    public Arbol() {
        this.raiz = null;
        this.peso = 0;
        this.altura = 0;
        this.nivel = 0;
    }

    public NodoArbol<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoArbol<T> raiz) {
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

    //-------------------Métodos básicos-------------------

    public boolean estaVacío() {
        return raiz == null;
    }

    public void agregarDato(T dato) {
        if (estaVacío()) {
            raiz = new NodoArbol<>(dato);
            nivel = 0; // Establecer el nivel inicial como 0 para la raíz
        } else {
            if (dato.hashCode() < raiz.getDato().hashCode()) {
                if (raiz.getHijoIzquierdo() == null) {
                    raiz.setHijoIzquierdo(new Arbol<>());
                }
                raiz.getHijoIzquierdo().agregarDato(dato);
                raiz.getHijoIzquierdo().setNivel(nivel + 1); // Incrementar el nivel en el subárbol izquierdo
            } else {
                if (raiz.getHijoDerecho() == null) {
                    raiz.setHijoDerecho(new Arbol<>());
                }
                raiz.getHijoDerecho().agregarDato(dato);
                raiz.getHijoDerecho().setNivel(nivel + 1); // Incrementar el nivel en el subárbol derecho
            }
        }
        peso++;
    }

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

    public <T> void existeDato(T dato) {
        if (estaVacío()) {
            System.out.println("El dato no existe");
        } else {
            if (dato.equals(raiz.getDato())) {
                System.out.println("El dato existe");
            } else {
                if (dato.hashCode() < raiz.getDato().hashCode()) {
                    if (raiz.getHijoIzquierdo() == null) {
                        System.out.println("El dato no existe");
                    } else {
                        raiz.getHijoIzquierdo().existeDato(dato);
                    }
                } else {
                    if (raiz.getHijoDerecho() == null) {
                        System.out.println("El dato no existe");
                    } else {
                        raiz.getHijoDerecho().existeDato(dato);
                    }
                }
            }
        }
    }

    public int obtenerPeso(){
        return getPeso();
    }

    public int obtenerAltura(){
        if (estaVacío()){
            return 0;
        }else{
            if (raiz.getHijoIzquierdo() == null && raiz.getHijoDerecho() == null){
                return 0;
            }else{
                if (raiz.getHijoIzquierdo() == null){
                    return raiz.getHijoDerecho().obtenerAltura() + 1;
                }else{
                    if (raiz.getHijoDerecho() == null){
                        return raiz.getHijoIzquierdo().obtenerAltura() + 1;
                    }else{
                        return Math.max(raiz.getHijoIzquierdo().obtenerAltura(), raiz.getHijoDerecho().obtenerAltura()) + 1;
                    }
                }
            }
        }
    }

    public <T> int obtenerNivel(T dato) {
        if (estaVacío()) {
            return 0;
        } else {
            if (dato.equals(raiz.getDato())) {
                return getNivel();
            } else {
                if (dato.hashCode() < raiz.getDato().hashCode()) {
                    if (raiz.getHijoIzquierdo() == null) {
                        return 0;
                    } else {
                        return raiz.getHijoIzquierdo().obtenerNivel(dato);
                    }
                } else {
                    if (raiz.getHijoDerecho() == null) {
                        return 0;
                    } else {
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

    public NodoArbol<T> obtenerNodo(T dato) {
        if (estaVacío()) {
            return null;
        } else {
            if (dato.equals(raiz.getDato())) {
                return raiz;
            } else {
                if (dato.hashCode() < raiz.getDato().hashCode()) {
                    if (raiz.getHijoIzquierdo() == null) {
                        return null;
                    } else {
                        return raiz.getHijoIzquierdo().obtenerNodo(dato);
                    }
                } else {
                    if (raiz.getHijoDerecho() == null) {
                        return null;
                    } else {
                        return raiz.getHijoDerecho().obtenerNodo(dato);
                    }
                }
            }
        }
    }

    public void eliminarNodo(T dato) {
        Arbol<T> padre = null;
        Arbol<T> actual = this;

        while (actual != null && !actual.getRaiz().getDato().equals(dato)) {
            padre = actual;

            if (dato.hashCode() < actual.getRaiz().getDato().hashCode()) {
                actual = actual.getRaiz().getHijoIzquierdo();
            } else {
                actual = actual.getRaiz().getHijoDerecho();
            }
        }

        if (actual == null) {
            // El dato no se encontró en el árbol
            return;
        }

        // Caso 1: Nodo a eliminar es un nodo hoja (sin hijos)
        if (actual.getRaiz().getHijoIzquierdo() == null && actual.getRaiz().getHijoDerecho() == null) {
            if (padre == null) {
                // El nodo a eliminar es la raíz del árbol
                setRaiz(null);
            } else {
                // Eliminar el nodo hoja
                if (padre.getRaiz().getHijoIzquierdo().getRaiz().equals(actual.getRaiz())) {
                    padre.getRaiz().setHijoIzquierdo(null);
                } else {
                    padre.getRaiz().setHijoDerecho(null);
                }
            }
        }
        // Caso 2: Nodo a eliminar tiene un solo hijo
        else if (actual.getRaiz().getHijoIzquierdo() == null) {
            if (padre == null) {
                // El nodo a eliminar es la raíz del árbol
                setRaiz(actual.getRaiz().getHijoDerecho().getRaiz());
            } else {
                // Conectar el hijo derecho del nodo a eliminar con el padre
                if (padre.getRaiz().getHijoIzquierdo().getRaiz().equals(actual.getRaiz())) {
                    padre.getRaiz().setHijoIzquierdo(actual.getRaiz().getHijoDerecho());
                } else {
                    padre.getRaiz().setHijoDerecho(actual.getRaiz().getHijoDerecho());
                }
            }
        } else if (actual.getRaiz().getHijoDerecho() == null) {
            if (padre == null) {
                // El nodo a eliminar es la raíz del árbol
                setRaiz(actual.getRaiz().getHijoIzquierdo().getRaiz());
            } else {
                // Conectar el hijo izquierdo del nodo a eliminar con el padre
                if (padre.getRaiz().getHijoIzquierdo().getRaiz().equals(actual.getRaiz())) {
                    padre.getRaiz().setHijoIzquierdo(actual.getRaiz().getHijoIzquierdo());
                } else {
                    padre.getRaiz().setHijoDerecho(actual.getRaiz().getHijoIzquierdo());
                }
            }
        }
        // Caso 3: Nodo a eliminar tiene dos hijos
        else {
            NodoArbol<T> sucesor = obtenerNodoSucesor(actual.getRaiz().getHijoDerecho());
            actual.getRaiz().setDato(sucesor.getDato());
            actual.getRaiz().getHijoDerecho().eliminarNodo(sucesor.getDato());
        }
    }

    private NodoArbol<T> obtenerNodoSucesor(Arbol<T> subarbol) {
        NodoArbol<T> sucesor = subarbol.getRaiz();
        while (sucesor.getHijoIzquierdo() != null) {
            sucesor = sucesor.getHijoIzquierdo().getRaiz();
        }
        return sucesor;
    }

    public void borrarArbol() {
        raiz=null;
    }

    //-------------------Métodos de mostrar arbol-------------------
    public void imprimirArbol() {
        if (raiz != null) {
            System.out.println("Raíz");
            imprimir(raiz, "", false);
        } else {
            System.out.println("El árbol está vacío.");
        }
    }

    public void imprimir(NodoArbol nodo, String prefijo, boolean esHijoIzquierdo) {
        if (nodo != null) {
            System.out.println(prefijo + (esHijoIzquierdo ? "I── " : "D── ") + nodo.getDato());
            if (nodo.getHijoIzquierdo() != null) {
                imprimir(nodo.getHijoIzquierdo().getRaiz(), prefijo + (esHijoIzquierdo ? "    " : "|   "), true);
            }
            if (nodo.getHijoDerecho() != null) {
                imprimir(nodo.getHijoDerecho().getRaiz(), prefijo + (esHijoIzquierdo ? "    " : "|   "), false);
            }
        }
    }

    //-------------------Metodos opcionales-------------------
    //son opcionales por que solo funciona si el arbol es de enteros
/*
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
    public void eliminarDato(int dato){
        if (estaVacío()){
            System.out.println("El arbol esta vacio");
        }else{
            if (dato == raiz.getDato()){
                if (raiz.getHijoIzquierdo() == null && raiz.getHijoDerecho() == null){
                    raiz = null;
                }else{
                    if (raiz.getHijoIzquierdo() == null){
                        raiz = raiz.getHijoDerecho().getRaiz();
                        raiz.getHijoDerecho().borrarArbol();
                    }else{
                        if (raiz.getHijoDerecho() == null){
                            raiz = raiz.getHijoIzquierdo().getRaiz();
                            raiz.getHijoIzquierdo().borrarArbol();
                        }else{
                            raiz.setDato(raiz.getHijoDerecho().obtenerDatoMenor());
                            raiz.getHijoDerecho().eliminarDato(raiz.getDato());
                        }
                    }
                }
            }else{
                if (dato < raiz.getDato()){
                    if (raiz.getHijoIzquierdo() == null){
                        System.out.println("El dato no existe");
                    }else{
                        raiz.getHijoIzquierdo().eliminarDato(dato);
                    }
                }else{
                    if (raiz.getHijoDerecho() == null){
                        System.out.println("El dato no existe");
                    }else{
                        raiz.getHijoDerecho().eliminarDato(dato);
                    }
                }
            }
        }

    }
*/



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
