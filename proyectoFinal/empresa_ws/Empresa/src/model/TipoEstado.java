package model;

public enum TipoEstado {
    PENDIENTE(0), TERMINADO(1);

    /**
     * atributos
     */
    private int numTipo;

    /**
     * Constructor
     * @param tipo
     */
    private TipoEstado(int tipo) {
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
