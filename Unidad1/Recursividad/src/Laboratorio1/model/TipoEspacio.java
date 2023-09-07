package Laboratorio1.model;

public enum TipoEspacio {

    ENTRADA(0), SALIDA(1), CELDA(2), PASILLO(3), X(4);

    /**
     * atributos
     */
    private int numTipo;

    /**
     * Constructor
     * @param tipo
     */
    private TipoEspacio(int tipo) {
        numTipo = tipo;
    }

    /**
     * Metodo Get
     * @return
     */
    public int getNumTipo() {
        return numTipo;
    }



}
