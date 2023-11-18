package controller;

import application.Aplicacion;

public class Singleton {
    /**
     * atributos
     */
    Empresa empresa;
    private Aplicacion aplicacion;


    private static class SingletonHolder{
        private final static Singleton eInstance = new Singleton();
    }
    public static Singleton getInstance(){
        return SingletonHolder.eInstance;
    }

    /**
     * metodo set de aplicacion
     * @param aplicacion
     */
    public void setAplicacion(Aplicacion aplicacion){
        this.aplicacion = aplicacion;
    }

    /**
     * metodo get de empresa
     * @return
     */
    public Empresa getEmpresa() {
        return empresa;
    }

   /*public Singleton(){
        inicializarDatos();
    }*/


}
