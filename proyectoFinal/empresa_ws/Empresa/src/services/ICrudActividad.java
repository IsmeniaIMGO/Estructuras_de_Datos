package services;

import model.TipoCumplimiento;

public interface ICrudActividad {
    public void crearActividad(String nombre, String descripcion, TipoCumplimiento tipoCumplimiento) throws Exception;
    public void buscarActividad(String nombre);
    public void eliminarActividad(String nombre) throws Exception;
    public void actualizarActividad(String nombre, String nuevoNombre, String nuevaDescripcion, TipoCumplimiento TipoCumplimiento);
    public boolean existeActividad(String nombre);
}
