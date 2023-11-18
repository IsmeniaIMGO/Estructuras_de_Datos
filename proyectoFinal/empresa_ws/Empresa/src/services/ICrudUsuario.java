package services;

import model.*;

public interface ICrudUsuario {
    public void crearUsuario(String usser, String password, String nombre, String cedula, TipoUsuario tipoUsuario) throws Exception;

    public Usuario buscarUsuario(String cedula);

    public void eliminarUsuario(String cedula) throws Exception;

    public void actualizarUsuario(String nuevoUsser, String nuevaPassword, String nuevoNombre, String cedula, TipoUsuario nuevoTipo);

    public boolean existeUsuario(String cedula);

    public boolean existeUsser(String usser) throws Exception;
}
