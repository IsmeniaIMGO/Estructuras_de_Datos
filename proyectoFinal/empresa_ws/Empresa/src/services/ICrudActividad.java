package services;

public interface ICrudActividad {
    public void crearActividad(String nombre, String descripcion) throws Exception;
    public void buscarActividad(String nombre);
    public void eliminarActividad(String nombre) throws Exception;
    public void actualizarActividad(String nombre, String nuevoNombre, String nuevaDescripcion);
    public boolean existeActividad(String nombre);
}
