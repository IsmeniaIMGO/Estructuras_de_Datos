package Laboratorio1.model;

public enum TipoEspacio {

    E(0), S(1), C(2), P(3), X(4);

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
