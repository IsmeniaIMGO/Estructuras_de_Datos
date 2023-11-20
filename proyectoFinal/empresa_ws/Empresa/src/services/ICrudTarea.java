package services;

import model.*;

public interface ICrudTarea {
    public void crearTarea(Usuario usuario, Proceso proceso, Actividad actividad, String nombre, String descripcion, int tiempo, TipoEstado estado, TipoCumplimiento cumplimiento) throws Exception;
    public Tarea buscarTarea(String nombre);
    public void eliminarTarea(Tarea tarea) throws Exception;
    public void actualizarTarea(Usuario usuario, Proceso proceso, Actividad actividad, String nombre, String nuevoNombre, String nuevaDescripcion, int nuevoTiempo, TipoEstado nuevoEstado, TipoCumplimiento nuevoCumplimiento);
    public boolean existeTarea(String nombre);
}
