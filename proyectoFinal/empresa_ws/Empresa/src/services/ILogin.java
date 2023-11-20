package services;

import model.Usuario;

public interface ILogin {
    public boolean verificarRegular(String usser, String password);
    public boolean verificarPremium(String usser, String password);
    public  Usuario buscarUsser(String usser);
    public void cerrarSesion();


}
