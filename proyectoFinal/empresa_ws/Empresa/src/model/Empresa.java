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
            throw new CedulaYaExisteException("Esta cedula ya se encuentra registrada");

        if(existeUsser(usser))
            throw new UsserYaExisteException("Este usuario ya se encuentra registrado");

        if(nombre.equals("") || tipoUsuario.equals("") || usser.equals("") || password.equals(""))
            throw new ParametroVacioException("Alguno de los parámetros indicados es está vacío");
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

    }

    @Override
    public void actualizarUsuario(String nuevoUsser, String nuevaPassword, String nuevoNombre, String cedula, TipoUsuario nuevoTipo) {

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

    }

    @Override
    public void buscarProceso(String id) {

    }

    @Override
    public void eliminarProceso(String id) throws Exception {

    }

    @Override
    public void actualizarProceso(String id, String nuevoNombre) {

    }

    @Override
    public boolean existeProceso(String id) {
        return false;
    }

    //----------------------------------------------------------------------------
    //--------------------Actividad-------------------------------------------------
    //----------------------------------------------------------------------------

    @Override
    public void crearActividad(String nombre, String descripcion, TipoCumplimiento tipoCumplimiento) throws Exception {

    }

    @Override
    public void buscarActividad(String nombre) {

    }

    @Override
    public void eliminarActividad(String nombre) throws Exception {

    }

    @Override
    public void actualizarActividad(String nombre, String nuevoNombre, String nuevaDescripcion, TipoCumplimiento tipoCumplimiento) {

    }

    @Override
    public boolean existeActividad(String nombre) {
        return false;
    }

    //----------------------------------------------------------------------------
    //--------------------Tarea-------------------------------------------------
    //----------------------------------------------------------------------------
    @Override
    public void crearTarea(String nombre, String descripcion, int tiempo, TipoEstado estado, TipoCumplimiento cumplimiento) throws Exception {

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
