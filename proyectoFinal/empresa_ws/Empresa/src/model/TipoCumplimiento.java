package model;

public enum TipoCumplimiento {
    OBLIGATORIO(0), OPCIONAL(1);
    /**
     * atributos
     */
    private int numTipo;

    /**
     * Constructor
     * @param tipo
     */
    private TipoCumplimiento(int tipo) {
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

