package Services;

import Model.Libro;

public interface ICrudLibro {
    public void crearLibro(String id, String nombre, String autor, String fechaPublicacion, String cantidad);
    public Libro buscarLibro(String id);
    public void eliminarLibro(String id);
    public void actualizarLibro(String id, String nombre, String autor, String fechaPublicacion, String cantidad);

    public boolean existeLibro(String id);

}
