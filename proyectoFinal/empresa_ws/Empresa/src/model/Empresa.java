package model;

import estructures.*;
import exceptions.*;
import services.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class Empresa implements ICrudUsuario, ICrudProceso, ICrudActividad, ICrudTarea, INotificacion, ILogin{
    //Atributos propios
    private String nit;
    private String nombre;

    //relacion con otras clases
    private ArrayList<Proceso> listaProcesos = new ArrayList<>();
    private ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    private ListaDoble<Actividad> listaActividades = new ListaDoble<>();
    private Cola<Tarea> listaTareas = new Cola<>();
    private ArrayList<Usuario> listaLogin = new ArrayList<>();

    //Constructor vacio
    public Empresa() {
    }

    //Constructor con atributos
    public Empresa(String nit, String nombre, ArrayList<Proceso> listaProcesos, ArrayList<Usuario> listaUsuarios, ListaDoble<Actividad> listaActividades, Cola<Tarea> listaTareas, ArrayList<Usuario> listaLogin) {
        this.nit = nit;
        this.nombre = nombre;
        this.listaProcesos = listaProcesos;
        this.listaUsuarios = listaUsuarios;
        this.listaActividades = listaActividades;
        this.listaTareas = listaTareas;
        this.listaLogin = listaLogin;
    }

    //Getters y Setters

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Proceso> getListaProcesos() {
        return listaProcesos;
    }

    public void setListaProcesos(ArrayList<Proceso> listaProcesos) {
        this.listaProcesos = listaProcesos;
    }

    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public ListaDoble<Actividad> getListaActividades() {
        return listaActividades;
    }

    public void setListaActividades(ListaDoble<Actividad> listaActividades) {
        this.listaActividades = listaActividades;
    }

    public Cola<Tarea> getListaTareas() {
        return listaTareas;
    }

    public void setListaTareas(Cola<Tarea> listaTareas) {
        this.listaTareas = listaTareas;
    }

    public ArrayList<Usuario> getListaLogin() {
        return listaLogin;
    }

    public void setListaLogin(ArrayList<Usuario> listaLogin) {
        this.listaLogin = listaLogin;
    }

    //Metodo equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empresa empresa = (Empresa) o;
        return Objects.equals(nit, empresa.nit);
    }

    //Metodo hashCode
    @Override
    public int hashCode() {
        return Objects.hash(nit);
    }

    //Metodo toString

    @Override
    public String toString() {
        return "Empresa{" +
                "nit='" + nit + '\'' +
                ", nombre='" + nombre ;
    }

    //----------------------------------------------------------------------------
    //--------- Metodos implementados de las interfaces---------------------------
    //----------------------------------------------------------------------------
    //--------------------Usuario-------------------------------------------------
    //----------------------------------------------------------------------------

    @Override
    public void crearUsuario(String usser, String password, String nombre, String cedula, TipoUsuario tipoUsuario) throws Exception {
        if (cedula == null || cedula.equals(""))
            throw new NuloVacioException("el id del cliente es nulo o vacio");

        if(existeUsuario(cedula))
            throw new CedulaException("Esta cedula ya se encuentra registrada");

        if(existeUsser(usser))
            throw new UsuarioException("Este usuario ya se encuentra registrado");

        if(nombre.equals("") || tipoUsuario.equals("") || usser.equals("") || password.equals(""))
            throw new NuloVacioException("Alguno de los parámetros indicados es está vacío");

        ArrayList<Proceso> listaProcesos = new ArrayList<Proceso>();

        Usuario usuario = new Usuario(nombre, cedula, usser, password, tipoUsuario, listaProcesos);

        this.listaUsuarios.add(usuario);
    }

    @Override
    public Usuario buscarUsuario(String cedula) {
        for (Usuario usuario: listaUsuarios) {
            if(usuario.getCedula().equals(cedula)){
                return usuario;
            }
        }
        return null;
    }

    @Override
    public void eliminarUsuario(String cedula) throws Exception {
        if (cedula == null || cedula.equals(""))
            throw new NuloVacioException("el id del cliente es nulo o vacio");

        if(!existeUsuario(cedula))
            throw new CedulaException("Esta cedula no se encuentra registrada");

        Iterator<Usuario> iterator = listaUsuarios.iterator();
        while (iterator.hasNext()) {
            Usuario usuario = iterator.next();
            if (usuario.getCedula().equals(cedula)) {
                iterator.remove();
            }
        }
    }

    @Override
    public void actualizarUsuario(String nuevoUsser, String nuevaPassword, String nuevoNombre, String cedula, TipoUsuario nuevoTipo) {
        for (Usuario usuario: listaUsuarios) {
            if(usuario.getCedula().equals(cedula)){
                usuario.setUsser(nuevoUsser);
                usuario.setPassword(nuevaPassword);
                usuario.setNombre(nuevoNombre);
                usuario.setTipoUsuario(nuevoTipo);
            }
        }

    }

    @Override
    public boolean existeUsuario(String cedula) {
        Iterator<Usuario> iterator = listaUsuarios.iterator();
        while (iterator.hasNext()) {
            Usuario usuario = iterator.next();
            if (usuario.getCedula().equals(cedula)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean existeUsser(String usser) throws Exception {
        Iterator<Usuario> iterator = listaUsuarios.iterator();
        while (iterator.hasNext()) {
            Usuario usuario = iterator.next();
            if (usuario.getUsser().equals(usser)) {
                return true;
            }
        }
        return false;
    }

    //----------------------------------------------------------------------------
    //--------------------Proceso-------------------------------------------------
    //----------------------------------------------------------------------------
    @Override
    public void crearProceso(String id, String nombre) throws Exception {
        if (id == null || id.equals(""))
            throw new NuloVacioException("el id del proceso es nulo o vacio");
        if (nombre == null || nombre.equals(""))
            throw new NuloVacioException("el nombre del proceso es nulo o vacio");

        int tiempoMaximo = 0;
        int tiempoMinimo = 0;
        ArrayList<DetalleProceso> listaDetalleProceso = new ArrayList<DetalleProceso>();

        Proceso proceso = new Proceso(id, nombre, tiempoMaximo, tiempoMinimo, listaDetalleProceso);
        this.listaProcesos.add(proceso);

    }

    @Override
    public Proceso buscarProceso(String id) {
        for (Proceso proceso: listaProcesos) {
            if(proceso.getId().equals(id)){
                return proceso;
            }
        }
        return null;


    }

    @Override
    public void eliminarProceso(String id) throws Exception {
        if (id == null || id.equals(""))
            throw new NuloVacioException("el id del proceso es nulo o vacio");

        if(!existeProceso(id))
            throw new ProcesoException("Este proceso no se encuentra registrado");

        Iterator<Proceso> iterator = listaProcesos.iterator();
        while (iterator.hasNext()) {
            Proceso proceso = iterator.next();
            if (proceso.getId().equals(id)) {
                iterator.remove();
            }
        }

    }

    @Override
    public void actualizarProceso(String id, String nuevoNombre) {
        for (Proceso proceso: listaProcesos) {
            if(proceso.getId().equals(id)){
                proceso.setNombre(nuevoNombre);
            }
        }

    }

    @Override
    public boolean existeProceso(String id) {
        Iterator<Proceso> iterator = listaProcesos.iterator();
        while (iterator.hasNext()) {
            Proceso proceso = iterator.next();
            if (proceso.getId().equals(id)) {
                return true;
            }
        }
        return false;

    }


    //----------------------------------------------------------------------------
    //--------------------Actividad-------------------------------------------------
    //----------------------------------------------------------------------------

    @Override
    public void crearActividad(Proceso proceso, String nombre, String descripcion, TipoCumplimiento tipoCumplimiento) throws Exception {
        if (nombre == null || nombre.equals(""))
            throw new NuloVacioException("el nombre de la actividad es nulo o vacio");

        if(existeActividad(nombre))
            throw new ActividadException("Esta actividad ya se encuentra registrada");

        if(descripcion.equals("") || tipoCumplimiento.equals(""))
            throw new NuloVacioException("Alguno de los parámetros indicados es está vacío");

        int tiempoMaximo = 0;
        int tiempoMinimo = 0;
        ArrayList<DetalleActividad> listaDetalleActividad = new ArrayList<DetalleActividad>();
        Actividad actividad = new Actividad(nombre, descripcion, tiempoMaximo, tiempoMinimo, tipoCumplimiento, listaDetalleActividad);

        for (int i = 0; i < listaProcesos.size(); i++) {
            Proceso aux = listaProcesos.get(i);
            if (aux.getId().equals(proceso.getId())) {
                aux.getListaDetalleProceso().add(new DetalleProceso(actividad));
            }
        }

        this.listaActividades.agregarInicio(actividad);

    }

    @Override
    public Actividad buscarActividad(String nombreActividad) throws Exception{
        if (nombreActividad == null || nombreActividad.equals(""))
            throw new NuloVacioException("el nombre de la actividad es nulo o vacio");

        for (int i = 0; i < listaActividades.getSize(); i++) {
            Actividad actividad = listaActividades.obtenerValorNodo(i);
            if (actividad.getNombre().equals(nombreActividad)) {
                return actividad;
            }
        }
        return null;

    }

    @Override
    public void eliminarActividad(Actividad actividad) {
        this.listaActividades.eliminar(actividad);
    }

    @Override
    public void actualizarActividad(Proceso proceso, String nombre, String nuevoNombre, String nuevaDescripcion, TipoCumplimiento nuevoTipoCumplimiento) throws Exception {

        Actividad actividadExistente = buscarActividad(nombre);

        ArrayList<DetalleActividad> listaDetalleActividad = actividadExistente.getListaDetalleActividad();
        int tiempoMaximo = actividadExistente.getTiempoMaximo();
        int tiempoMinimo = actividadExistente.getTiempoMinimo();

        Actividad actividadNueva = new Actividad(nuevoNombre, nuevaDescripcion,tiempoMaximo,tiempoMinimo, nuevoTipoCumplimiento, listaDetalleActividad);

        listaActividades.eliminar(actividadExistente);
        listaActividades.agregarInicio(actividadNueva);

        for (int i = 0; i < listaProcesos.size(); i++) {
            Proceso aux = listaProcesos.get(i);
            if (aux.getId().equals(proceso.getId())) {
                DetalleProceso detalleExistente = new DetalleProceso(actividadExistente);
                if (aux.getListaDetalleProceso().contains(detalleExistente)) {
                    aux.getListaDetalleProceso().remove(detalleExistente);
                    aux.getListaDetalleProceso().add(new DetalleProceso(actividadExistente));
                }
            }
        }

    }

    @Override
    public boolean existeActividad(String nombre) throws Exception {
        if (nombre == null || nombre.equals(""))
            throw new NuloVacioException("el nombre de la actividad es nulo o vacio");

        for (int i = 0; i < listaActividades.getSize(); i++) {
            Actividad actividad = listaActividades.obtenerValorNodo(i);
            if (actividad.getNombre().equals(nombre)) {
                return true;
            }
        }
        return false;
    }



    //----------------------------------------------------------------------------
    //--------------------Tarea-------------------------------------------------
    //----------------------------------------------------------------------------
    @Override
    public void crearTarea(Proceso proceso,Actividad actividad,String nombre, String descripcion, int tiempo, TipoEstado estado, TipoCumplimiento cumplimiento) throws Exception {


    }

    @Override
    public void buscarTarea(String nombre) {

    }

    @Override
    public void eliminarTarea(String nombre) throws Exception {

    }

    @Override
    public void actualizarTarea(String nombre, String nuevoNombre, String nuevaDescripcion, int nuevoTiempo, TipoEstado nuevoEstado, TipoCumplimiento nuevoCumplimiento) {

    }

    @Override
    public boolean existeTarea(String nombre) {
        return false;
    }


    //----------------------------------------------------------------------------
    //--------------------LOGIN-------------------------------------------------
    //----------------------------------------------------------------------------

    @Override
    public boolean verificarRegular(String usser, String password) {
        return false;
    }

    @Override
    public boolean verificarPremium(String usser, String password) {
        return false;
    }

    //----------------------------------------------------------------------------
    //--------------------NOTIFICACION-------------------------------------------------
    //----------------------------------------------------------------------------

    @Override
    public String notificarTareaPendiente() {
        return null;
    }


}
