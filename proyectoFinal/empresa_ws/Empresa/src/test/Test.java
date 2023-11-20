package test;

import estructures.*;
import model.*;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) throws Exception {



        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        ArrayList<Proceso> listaProcesos = new ArrayList<>();
        ListaDoble<Actividad> listaActividades = new ListaDoble<>();
        Cola<Tarea> listaTareas = new Cola<>();
        ArrayList<Usuario> listaLogin = new ArrayList<>();

        Empresa empresa = new Empresa("1", "soft", listaProcesos, listaUsuarios, listaActividades, listaTareas, listaLogin);

        System.out.println("Empresa: " + empresa.getNombre());

        String usser = "admin";
        String password = "admin";
        String nombre = "admin";
        String cedula = "123";
        TipoUsuario tipoUsuario = TipoUsuario.REGULAR;

        empresa.crearUsuario(usser, password, nombre, cedula, tipoUsuario);

        System.out.println("Usuario: " + empresa.getListaUsuarios());


        String idProceso = "1";
        String nombreProceso = "Proceso 1";

        ArrayList<Proceso>prueba = new ArrayList<>();
        Usuario usuario = new Usuario("usser", "password", "nombre", "cedula", TipoUsuario.PREMIUM, prueba);
        empresa.crearProceso(usuario, idProceso, nombreProceso);

        System.out.println("Proceso: " + empresa.getListaProcesos());

        String nombreActividad = "Actividad 1";
        String descripcionActividad = "Descripcion 1";
        TipoCumplimiento tipoCumplimiento = TipoCumplimiento.OBLIGATORIO;
        ArrayList<DetalleActividad> listaDetalleActividad = new ArrayList<>();

        String idProcesoprueba = "1";
        String nombreProcesoprueba = "Proceso 1";
        int tiempoMaximo = 1;
        int tiempoMinimo = 1;
        ArrayList<DetalleProceso> listaDetalleProceso = new ArrayList<>();
        Proceso proceso = new Proceso(idProcesoprueba, nombreProcesoprueba,tiempoMaximo, tiempoMinimo, listaDetalleProceso);

        empresa.crearActividad(usuario, proceso, nombreActividad, descripcionActividad, tipoCumplimiento,"final", null);

        System.out.println("Actividad: " + empresa.getListaActividades());

        String nombreTarea = "Tarea 1";
        String descripcionTarea = "Descripcion 1";
        int tiempoTarea = 1;
        TipoEstado tipoEstado = TipoEstado.PENDIENTE;
        TipoCumplimiento cumplimiento = TipoCumplimiento.OBLIGATORIO;

        String nombreActividadprueba = "Actividad 1";
        String descripcionActividadprueba = "Descripcion 1";
        int tiempoMaximoprueba = 1;
        int tiempoMinimoprueba = 1;
        TipoCumplimiento tipoCumplimientoprueba = TipoCumplimiento.OBLIGATORIO;
        ArrayList<DetalleActividad> listaDetalleActividadprueba = new ArrayList<>();
        Actividad actividad = new Actividad(nombreActividadprueba, descripcionActividadprueba, tiempoMaximoprueba, tiempoMinimoprueba, tipoCumplimientoprueba, listaDetalleActividadprueba);


        empresa.crearTarea(usuario, proceso, actividad, nombreTarea, descripcionTarea, tiempoTarea, tipoEstado, cumplimiento, "final", null);

        System.out.println("Tarea: " + empresa.getListaTareas());
    }
}
