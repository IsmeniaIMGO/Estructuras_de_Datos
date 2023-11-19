package services;

import exceptions.NuloVacioException;
import model.Actividad;
import model.Proceso;
import model.TipoCumplimiento;

public interface ICrudActividad {
    public void crearActividad(Proceso proceso, String nombre, String descripcion, TipoCumplimiento tipoCumplimiento) throws Exception;
    public Actividad buscarActividad(String nombreActividad) throws Exception;
    public void eliminarActividad(Actividad actividad);
    public void actualizarActividad(Proceso proceso, String nombre, String nuevoNombre, String nuevaDescripcion, TipoCumplimiento TipoCumplimiento) throws Exception;
    public boolean existeActividad(String nombre) throws Exception;
}
