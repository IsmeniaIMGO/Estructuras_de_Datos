package Laboratorio2.Services;

import Laboratorio2.Model.*;

public interface ICrudLibro {
    public void crearLibro(String id, String nombre, String autor, int fechaPublicacion);

    public Libro buscarLibro(String id);

    public void eliminarLibro(String id);

    public void actualizarLibro(String id, String nombre, String autor, int fechaPublicacion);

    public boolean existeLibro(String id);

}
