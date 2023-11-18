package services;

import model.TipoCumplimiento;
import model.TipoEstado;

public interface ICrudTarea {
    public void crearTarea(String nombre, String descripcion, int tiempo, TipoEstado estado, TipoCumplimiento cumplimiento) throws Exception;
    public void buscarTarea(String nombre);
    public void eliminarTarea(String nombre) throws Exception;
    public void actualizarTarea(String nombre, String nuevoNombre, String nuevaDescripcion, int nuevoTiempo, TipoEstado nuevoEstado, TipoCumplimiento nuevoCumplimiento);
    public boolean existeTarea(String nombre);
}
