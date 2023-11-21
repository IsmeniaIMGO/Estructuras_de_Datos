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


        ArrayList<Proceso>procesos = new ArrayList<>();

        Usuario usuario = new Usuario("usser", "password", "nombre", "cedula", TipoUsuario.PREMIUM, procesos);
        empresa.getListaUsuarios().add(usuario);


        String idProceso = "1";
        String nombreProceso = "Proceso 1";
        int tiempoMaximo = 0;
        int tiempoMinimo = 0;
        ArrayList<DetalleProceso> listaDetalleProceso = new ArrayList<>();

        Proceso proceso1 = new Proceso(idProceso, nombreProceso, tiempoMaximo, tiempoMinimo, listaDetalleProceso);
        empresa.getListaProcesos().add(proceso1);


        String nombreActividad = "Actividad 1";
        String descripcionActividad = "Descripcion 1";
        TipoCumplimiento tipoCumplimiento = TipoCumplimiento.OBLIGATORIO;
        ArrayList<DetalleActividad> listaDetalleActividad = new ArrayList<>();
        Actividad actividad1 = new Actividad(nombreActividad, descripcionActividad, 0, 0, tipoCumplimiento, listaDetalleActividad);
        empresa.getListaActividades().agregarInicio(actividad1);
        proceso1.getListaDetalleProceso().add(new DetalleProceso(actividad1));


        String nombreTarea = "Tarea 1";
        String descripcionTarea = "Descripcion 1";
        int tiempoTarea = 1;
        TipoEstado tipoEstado = TipoEstado.PENDIENTE;
        TipoCumplimiento cumplimiento = TipoCumplimiento.OBLIGATORIO;
        Tarea tarea1 = new Tarea(nombreTarea, descripcionTarea, tiempoTarea, tipoEstado, cumplimiento);
        empresa.getListaTareas().encolar(tarea1);
        actividad1.getListaDetalleActividad().add(new DetalleActividad(tarea1));


        //empresa.calcularTiemposUsuario(usuario);
        empresa.calcularTiempos();

        System.out.println("Usuario: " + empresa.getListaUsuarios()+"\n");
        System.out.println("Proceso: " + empresa.getListaProcesos()+"\n");
        System.out.println("Actividad: " + empresa.getListaActividades()+"\n");
        System.out.println("Tarea: " + empresa.getListaTareas());



    }



}
