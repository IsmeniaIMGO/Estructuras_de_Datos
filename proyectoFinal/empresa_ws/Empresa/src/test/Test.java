package test;

import estructures.*;
import model.*;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) throws Exception {
        Empresa empresa = new Empresa();
        empresa.setNit("1");
        empresa.setNombre("Software");

        try {
            empresa.crearUsuario("Marce", "123", "Marcela", "123", TipoUsuario.REGULAR);
            empresa.crearUsuario("Juan", "123", "Juan", "456", TipoUsuario.PREMIUM);


            Usuario usuario = empresa.buscarUsuario("123");
            empresa.crearProceso(usuario, "1", "Hacer Desayuno");
            empresa.crearProceso(usuario, "2", "Hacer Almuerzo");



            Proceso proceso = empresa.buscarProceso("1");
            empresa.crearActividad(usuario, proceso, "comprar", "comprar ingredientes para el desayuno", TipoCumplimiento.OBLIGATORIO, "final", null);
            Actividad actividad1 = empresa.buscarActividad("comprar");
            empresa.crearActividad(usuario, proceso, "preparar", "preparar ingredientes para el desayuno", TipoCumplimiento.OPCIONAL, "despues", actividad1);


            Actividad actividad2 = empresa.buscarActividad("preparar");
            empresa.crearTarea(usuario, proceso, actividad2, "huevosCocinados", "cocinar Huevos", 2, TipoEstado.PENDIENTE, TipoCumplimiento.OPCIONAL, "final", null);
            Tarea tarea = empresa.buscarTarea("huevosCocinados");
            empresa.crearTarea(usuario, proceso, actividad2, "huevosFritos", "freir Huevos", 2, TipoEstado.PENDIENTE, TipoCumplimiento.OBLIGATORIO, "despues", tarea);

            empresa.calcularTiempos();

            System.out.println("Usuarios: " + empresa.getListaUsuarios()+"\n");
            System.out.println("Procesos: " + empresa.getListaProcesos()+"\n");
            System.out.println("Actividades: " + empresa.getListaActividades()+"\n");
            System.out.println("Tareas: " + empresa.getListaTareas()+"\n");

            empresa.intercambiarActividades(actividad1, actividad2);

            System.out.println("Actividades intercambiadas: " + empresa.getListaActividades()+"\n");


        }catch (Exception e) {
            System.out.println(e.getMessage());
        }



    }



}
