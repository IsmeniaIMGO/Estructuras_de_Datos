package model;

import estructures.*;
import services.*;

import java.util.ArrayList;
import java.util.Objects;

public class Empresa implements ICrudUsuario, ICrudProceso, ICrudActividad, ICrudTarea, INotificacion, ILogin{
    //Atributos propios
    private String nit;
    private String nombre;

    //relacion con otras clases
    private ArrayList<Proceso> procesos = new ArrayList<>();
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private ListaDoble<Actividad> listaActividades = new ListaDoble<>();
    private Cola<Tarea> listaTareas = new Cola<>();
    private ArrayList<Usuario> listaLogin = new ArrayList<>();

    //Constructor vacio
    public Empresa() {
    }

    //Constructor con atributos
    public Empresa(String nit, String nombre, ArrayList<Proceso> procesos, ArrayList<Usuario> usuarios, ListaDoble<Actividad> listaActividades, Cola<Tarea> listaTareas, ArrayList<Usuario> listaLogin) {
        this.nit = nit;
        this.nombre = nombre;
        this.procesos = procesos;
        this.usuarios = usuarios;
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

    public ArrayList<Proceso> getProcesos() {
        return procesos;
    }

    public void setProcesos(ArrayList<Proceso> procesos) {
        this.procesos = procesos;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
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

    //----------------------------------------------------------------------------------
    // Metodos implementados de las interfaces
    //----------------------------------------------------------------------------------

    @Override
    public void crearUsuario(String usser, String password, String nombre, String cedula, TipoUsuario tipoUsuario) throws Exception {

    }

    @Override
    public Usuario buscarUsuario(String cedula) {
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
        return false;
    }

    @Override
    public boolean existeUsser(String usser) throws Exception {
        return false;
    }

    @Override
    public boolean verificarRegular(String usser, String password) {
        return false;
    }

    @Override
    public boolean verificarPremium(String usser, String password) {
        return false;
    }


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



}
