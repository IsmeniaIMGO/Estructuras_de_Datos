package services;

import model.DetalleActividad;
import model.Proceso;
import model.Usuario;

import java.util.ArrayList;

public interface ICrudProceso {
    public void crearProceso( Usuario usuario, String id, String nombre) throws Exception;
    public Proceso buscarProceso(Usuario usuario, String id);
    public void eliminarProceso(Usuario usuario, String id) throws Exception;
    public void actualizarProceso( Usuario usuario, String id, String nuevoNombre);
    public boolean existeProceso(String id);




}
