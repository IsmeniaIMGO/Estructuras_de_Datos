package Services;

import Model.Usuario;

public interface ICrudUsuario {
    public void crearUsuario(String usser, String password,String nombre, String cedula, String tipoUsuario);
    public Usuario buscarUsuario(String cedula);
    public void eliminarUsuario(String cedula);
    public void actualizarUsuario(String usser, String password,String nombre, String cedula, String tipoUsuario);

    public boolean existeUsuario(String cedula);


}
