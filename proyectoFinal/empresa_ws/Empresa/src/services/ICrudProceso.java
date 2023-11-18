package services;

import model.DetalleActividad;
import model.Usuario;

import java.util.ArrayList;

public interface ICrudProceso {
    public void crearProceso(String id, String nombre, int tiempoMaximo, int tiempoMinimo, Usuario usuario) throws Exception;



}
