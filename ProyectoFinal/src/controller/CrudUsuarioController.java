package controller;

import application.Aplicacion;

public class CrudUsuarioController {
    Empresa empresa = Singleton.getInstance().getEmpresa();

    Singleton singleton = Singleton.getInstance();
    Aplicacion aplicacion;

    //Metodo set de aplicacion
    public void setAplicacion(Aplicacion aplicacion) {
        this.aplicacion = aplicacion;
        singleton.setAplicacion(aplicacion);
    }

}
