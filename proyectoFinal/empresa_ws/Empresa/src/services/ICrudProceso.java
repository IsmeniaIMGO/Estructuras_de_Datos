package services;

import model.DetalleActividad;
import model.Proceso;
import model.Usuario;

import java.util.ArrayList;

public interface ICrudProceso {
    public void crearProceso(String id, String nombre) throws Exception;
    public Proceso buscarProceso(String id);
    public void eliminarProceso(String id) throws Exception;
    public void actualizarProceso(String id, String nuevoNombre);
    public boolean existeProceso(String id);




}
