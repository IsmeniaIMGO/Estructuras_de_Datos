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

        ArrayList<Proceso> Procesos = new ArrayList<Proceso>();

        Usuario usuario = new Usuario(nombre, cedula, usser, password, tipoUsuario, Procesos);

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
    public void crearProceso( Usuario usuario, String id, String nombre) throws Exception {
        if (id == null || id.equals(""))
            throw new NuloVacioException("el id del proceso es nulo o vacio");
        if (nombre == null || nombre.equals(""))
            throw new NuloVacioException("el nombre del proceso es nulo o vacio");

        int tiempoMaximo = 0;
        int tiempoMinimo = 0;
        ArrayList<DetalleProceso> listaDetalleProceso = new ArrayList<DetalleProceso>();

        Proceso proceso = new Proceso(id, nombre, tiempoMaximo, tiempoMinimo, listaDetalleProceso);
        this.listaProcesos.add(proceso);

        for (Usuario aux : listaUsuarios) {
            if (aux.getCedula().equals(usuario.getCedula())) {
                aux.getProcesos().add(proceso);
            }
        }

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

        for ( Usuario usuario: listaUsuarios) {
            Iterator<Proceso> iterator2 = usuario.getProcesos().iterator();
            while (iterator2.hasNext()) {
                Proceso proceso = iterator2.next();
                if (proceso.getId().equals(id)) {
                    iterator2.remove();
                }
            }
        }

    }

    @Override
    public void actualizarProceso(Usuario usuario, String id, String nuevoNombre ) {
        for(Usuario aux: listaUsuarios){
            if(aux.getCedula().equals(usuario.getCedula())){
                for(Proceso proceso: aux.getProcesos()){
                    if(proceso.getId().equals(id)){
                        proceso.setNombre(nuevoNombre);
                    }
                }
            }
        }

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
    public void crearActividad(Usuario usuario, Proceso proceso, String nombre, String descripcion, TipoCumplimiento tipoCumplimiento, String posicion, Actividad actividadAntigua) throws Exception {
        if (nombre == null || nombre.equals(""))
            throw new NuloVacioException("el nombre de la actividad es nulo o vacio");

        if(existeActividad(nombre))
            throw new ActividadException("Esta actividad ya se encuentra registrada");

        if(descripcion.isEmpty() || tipoCumplimiento.equals("") || posicion.isEmpty())
            throw new NuloVacioException("Alguno de los parámetros indicados es está vacío");

        int tiempoMaximo = 0;
        int tiempoMinimo = 0;
        ArrayList<DetalleActividad> listaDetalleActividad = new ArrayList<DetalleActividad>();
        Actividad actividadNueva = new Actividad(nombre, descripcion, tiempoMaximo, tiempoMinimo, tipoCumplimiento, listaDetalleActividad);

        if (posicion.equals("despues")){
            if (actividadAntigua ==null){
                throw new NuloVacioException("No se ha seleccionado una actividad");
            }else {
                int pos = listaActividades.obtenerPosicionNodo(actividadAntigua);
                this.listaActividades.agregarDespuesDe(actividadNueva, pos);
            }
        }

        if (posicion.equals("final"))
            this.listaActividades.agregarFinal(actividadNueva);


        for(Usuario aux: listaUsuarios){
            if(aux.getCedula().equals(usuario.getCedula())){
                for(Proceso aux2: aux.getProcesos()){
                    if(aux2.getId().equals(proceso.getId())){
                        aux2.getListaDetalleProceso().add(new DetalleProceso(actividadNueva));
                    }
                }
            }
        }

        for (int i = 0; i < listaProcesos.size(); i++) {
            Proceso aux = listaProcesos.get(i);
            if (aux.getId().equals(proceso.getId())) {
                aux.getListaDetalleProceso().add(new DetalleProceso(actividadNueva));
            }
        }



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

        for(Proceso aux: listaProcesos){
            for(DetalleProceso detalleProceso: aux.getListaDetalleProceso()){
                if(detalleProceso.getActividad().getNombre().equals(actividad.getNombre())){
                    aux.getListaDetalleProceso().remove(detalleProceso);
                }
            }
        }

        for(Usuario aux: listaUsuarios){
            for(Proceso aux2: aux.getProcesos()){
                for(DetalleProceso detalleProceso: aux2.getListaDetalleProceso()){
                    if(detalleProceso.getActividad().getNombre().equals(actividad.getNombre())){
                        aux2.getListaDetalleProceso().remove(detalleProceso);
                    }
                }
            }
        }

        this.listaActividades.eliminar(actividad);
    }

    @Override
    public void actualizarActividad(Usuario usuario, Proceso proceso, String nombre, String nuevoNombre, String nuevaDescripcion, TipoCumplimiento nuevoTipoCumplimiento) throws Exception {

        Actividad actividadExistente = buscarActividad(nombre);

        ArrayList<DetalleActividad> listaDetalleActividad = actividadExistente.getListaDetalleActividad();
        int tiempoMaximo = actividadExistente.getTiempoMaximo();
        int tiempoMinimo = actividadExistente.getTiempoMinimo();

        Actividad actividadNueva = new Actividad(nuevoNombre, nuevaDescripcion,tiempoMaximo,tiempoMinimo, nuevoTipoCumplimiento, listaDetalleActividad);

        listaActividades.eliminar(actividadExistente);
        listaActividades.agregarInicio(actividadNueva);

        for(Proceso aux : listaProcesos){
            for(DetalleProceso detalleProceso: aux.getListaDetalleProceso()){
                if(detalleProceso.getActividad().getNombre().equals(actividadExistente.getNombre())){
                    detalleProceso.setActividad(actividadNueva);
                }
            }
        }

        for(Usuario aux: listaUsuarios){
            if (aux.getCedula().equals(usuario.getCedula())) {
                for(Proceso aux2: aux.getProcesos()){
                    if (aux2.getId().equals(proceso.getId())) {
                        for (DetalleProceso detalleProceso : aux2.getListaDetalleProceso()) {
                            if (detalleProceso.getActividad().getNombre().equals(actividadExistente.getNombre())) {
                                detalleProceso.setActividad(actividadNueva);
                            }
                        }
                    }
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
    public void crearTarea(Usuario usuario, Proceso proceso,Actividad actividad,String nombre, String descripcion, int tiempo, TipoEstado estado, TipoCumplimiento cumplimiento, String posicion, Tarea tareaAntigua) throws Exception {
        if (nombre == null || nombre.equals(""))
            throw new NuloVacioException("el nombre de la tarea es nulo o vacio");

        if(existeTarea(nombre))
            throw new TareaException("Esta tarea ya se encuentra registrada");

        if(descripcion.equals("") || estado.equals("") || cumplimiento.equals(""))
            throw new NuloVacioException("Alguno de los parámetros indicados es está vacío");

        Tarea tareaNueva = new Tarea(nombre, descripcion, tiempo, estado, cumplimiento);



        if (posicion.equals("despues")){
            if (tareaAntigua ==null){
                throw new NuloVacioException("No se ha seleccionado una tarea");
            }else {
                listaTareas.agregarDespuesDe(tareaNueva,tareaAntigua);
            }
        }

        if (posicion.equals("final"))
            listaTareas.encolar(tareaNueva);


        for(Proceso aux: listaProcesos){
            if(aux.getId().equals(proceso.getId())){
                for(DetalleProceso detalleProceso: aux.getListaDetalleProceso()){
                    if(detalleProceso.getActividad().getNombre().equals(actividad.getNombre())){
                        detalleProceso.getActividad().getListaDetalleActividad().add(new DetalleActividad(tareaNueva));
                    }
                }
            }
        }

        for (Usuario aux : listaUsuarios) {
            if (aux.getCedula().equals(usuario.getCedula())) {
                for (Proceso aux2 : aux.getProcesos()) {
                    if (aux2.getId().equals(proceso.getId())) {
                        for (DetalleProceso detalleProceso : aux2.getListaDetalleProceso()) {
                            if (detalleProceso.getActividad().getNombre().equals(actividad.getNombre())) {
                                detalleProceso.getActividad().getListaDetalleActividad().add(new DetalleActividad(tareaNueva));
                            }
                        }
                    }
                }
            }
        }

        for(int i = 0; i < listaActividades.getSize(); i++){
            Actividad aux = listaActividades.obtenerValorNodo(i);
            if(aux.getNombre().equals(actividad.getNombre())){
                aux.getListaDetalleActividad().add(new DetalleActividad(tareaNueva));
            }
        }

        calcularTiempos();
        calcularTiemposUsuario(usuario);
        calcularTiemposActividad(actividad);


    }

    @Override
    public Tarea buscarTarea(String nombre) {
        for (int i = 0; i < listaTareas.getTamano(); i++) {
            Tarea tarea = listaTareas.desencolar();
            if (tarea.getNombre().equals(nombre)) {
                listaTareas.encolar(tarea); // vuelvo a encolar la tarea para no eliminarla de la lista
                return tarea;
            }
            listaTareas.encolar(tarea); // vuelvo a encolar la tarea para no eliminarla de la lista
        }
        return null;


    }

    @Override
    public void eliminarTarea(Proceso proceso, Actividad actividad, Usuario usuario,Tarea tarea) throws Exception {

        Cola<Tarea> colaAuxiliar = new Cola<>(); // cola auxiliar para no perder tareas
        boolean tareaEncontrada = false;

        while (!listaTareas.estaVacia()) {
            Tarea aux = listaTareas.desencolar();
            if (aux.getNombre().equals(nombre)) {
                tareaEncontrada = true;
            } else {
                colaAuxiliar.encolar(aux);
            }
        }

        while (!colaAuxiliar.estaVacia()) {
            listaTareas.encolar(colaAuxiliar.desencolar());
        }

        if (!tareaEncontrada) {
            throw new TareaException("Tarea no encontrada");
        }

        for (Proceso aux : listaProcesos) {
            if (aux.getId().equals(proceso.getId())) {
                for (DetalleProceso detalleProceso : aux.getListaDetalleProceso()) {
                    for (DetalleActividad detalleActividad : detalleProceso.getActividad().getListaDetalleActividad()) {
                        if (detalleActividad.getTarea().getNombre().equals(tarea.getNombre())) {
                            detalleProceso.getActividad().getListaDetalleActividad().remove(detalleActividad);
                        }
                    }
                }
            }
        }

        for(Usuario aux: listaUsuarios) {
            if (aux.getCedula().equals(usuario.getCedula())) {
                for (Proceso aux2 : aux.getProcesos()) {
                    if (aux2.getId().equals(proceso.getId())) {
                        for (DetalleProceso detalleProceso : aux2.getListaDetalleProceso()) {
                            for (DetalleActividad detalleActividad : detalleProceso.getActividad().getListaDetalleActividad()) {
                                if (detalleActividad.getTarea().getNombre().equals(tarea.getNombre())) {
                                    detalleProceso.getActividad().getListaDetalleActividad().remove(detalleActividad);
                                }
                            }
                        }
                    }
                }
            }
        }
        for(int i = 0; i < listaActividades.getSize(); i++){
            Actividad aux = listaActividades.obtenerValorNodo(i);
            if (aux.getNombre().equals(actividad.getNombre())) {
                for(DetalleActividad detalleActividad: aux.getListaDetalleActividad()){
                    if(detalleActividad.getTarea().getNombre().equals(tarea.getNombre())){
                        aux.getListaDetalleActividad().remove(detalleActividad);
                    }
                }
            }
        }

        calcularTiempos();
        calcularTiemposUsuario(usuario);
        calcularTiemposActividad(actividad);

    }

    @Override
    public void actualizarTarea(Usuario usuario, Proceso proceso, Actividad actividad, String nombre, String nuevoNombre, String nuevaDescripcion, int nuevoTiempo, TipoEstado nuevoEstado, TipoCumplimiento nuevoCumplimiento) {

        Cola<Tarea> colaAuxiliar = new Cola<>(); // cola auxiliar para no perder tareas
        boolean tareaEncontrada = false;

        while (!listaTareas.estaVacia()) {
            Tarea tarea = listaTareas.desencolar();
            if (tarea.getNombre().equals(nombre)) {
                tarea.setNombre(nuevoNombre);
                tarea.setDescripcion(nuevaDescripcion);
                tarea.setTiempo(nuevoTiempo);
                tarea.setEstado(nuevoEstado);
                tarea.setCumplimiento(nuevoCumplimiento);
                tareaEncontrada = true;
            }
            colaAuxiliar.encolar(tarea);
        }

        while (!colaAuxiliar.estaVacia()) {
            listaTareas.encolar(colaAuxiliar.desencolar());
        }

        if (!tareaEncontrada) {
            System.out.println("Tarea no encontrada");
        }

        for(Proceso aux: listaProcesos){
            if (aux.getId().equals(proceso.getId())) {
                for(DetalleProceso detalleProceso: aux.getListaDetalleProceso()){
                    if(detalleProceso.getActividad().getNombre().equals(actividad.getNombre())){
                        for(DetalleActividad detalleActividad: detalleProceso.getActividad().getListaDetalleActividad()){
                            if(detalleActividad.getTarea().getNombre().equals(nombre)){
                                detalleActividad.getTarea().setNombre(nuevoNombre);
                                detalleActividad.getTarea().setDescripcion(nuevaDescripcion);
                                detalleActividad.getTarea().setTiempo(nuevoTiempo);
                                detalleActividad.getTarea().setEstado(nuevoEstado);
                                detalleActividad.getTarea().setCumplimiento(nuevoCumplimiento);
                            }
                        }
                    }
                }
            }

        }

        for(Usuario aux: listaUsuarios){
            if (aux.getCedula().equals(usuario.getCedula())) {
                for(Proceso aux2: aux.getProcesos()){
                    if (aux2.getId().equals(proceso.getId())) {
                        for(DetalleProceso detalleProceso: aux2.getListaDetalleProceso()){
                            if(detalleProceso.getActividad().getNombre().equals(actividad.getNombre())){
                                for(DetalleActividad detalleActividad: detalleProceso.getActividad().getListaDetalleActividad()){
                                    if(detalleActividad.getTarea().getNombre().equals(nombre)){
                                        detalleActividad.getTarea().setNombre(nuevoNombre);
                                        detalleActividad.getTarea().setDescripcion(nuevaDescripcion);
                                        detalleActividad.getTarea().setTiempo(nuevoTiempo);
                                        detalleActividad.getTarea().setEstado(nuevoEstado);
                                        detalleActividad.getTarea().setCumplimiento(nuevoCumplimiento);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        for(int i = 0; i < listaActividades.getSize(); i++){
            Actividad aux = listaActividades.obtenerValorNodo(i);
            if(aux.getNombre().equals(actividad.getNombre())){
                for(DetalleActividad detalleActividad: aux.getListaDetalleActividad()){
                    if(detalleActividad.getTarea().getNombre().equals(nombre)){
                        detalleActividad.getTarea().setNombre(nuevoNombre);
                        detalleActividad.getTarea().setDescripcion(nuevaDescripcion);
                        detalleActividad.getTarea().setTiempo(nuevoTiempo);
                        detalleActividad.getTarea().setEstado(nuevoEstado);
                        detalleActividad.getTarea().setCumplimiento(nuevoCumplimiento);
                    }
                }
            }
        }

        calcularTiempos();
        calcularTiemposUsuario(usuario);
        calcularTiemposActividad(actividad);

    }

    @Override
    public boolean existeTarea(String nombre) {
        return buscarTarea(nombre) != null;
    }


    //----------------------------------------------------------------------------
    //--------------------LOGIN-------------------------------------------------
    //----------------------------------------------------------------------------

    @Override
    public boolean verificarRegular(String usser, String password) {
        Usuario usuario = buscarUsser(usser);

        if ((usuario != null) && (usuario.getPassword().equals(password)) && (usuario.getTipoUsuario() == TipoUsuario.REGULAR)) {
            listaLogin.add(usuario);
            return true;
        }
        return false;

    }
    @Override
    public boolean verificarPremium(String usser, String password) {
        Usuario usuario = buscarUsser(usser);

        if ((usuario != null) && (usuario.getPassword().equals(password)) && (usuario.getTipoUsuario() == TipoUsuario.PREMIUM)) {
            listaLogin.add(usuario);
            return true;
        }
        return false;
    }

    @Override
    public Usuario buscarUsser(String usser) {
        Iterator<Usuario> iterator = listaUsuarios.iterator();
        while (iterator.hasNext()) {
            Usuario usuario = iterator.next();
            if (usuario.getUsser().equals(usser)) {
                return usuario;
            }
        }
        return null;
    }

    @Override
    public void cerrarSesion() {
        listaLogin.clear();
    }



    //----------------------------------------------------------------------------
    //--------------------NOTIFICACION-------------------------------------------------
    //----------------------------------------------------------------------------

    @Override
    public String notificarTareaPendiente() {

        for (int i = 0; i < listaTareas.getTamano(); i++) {
            Tarea tarea = listaTareas.desencolar();
            if (tarea.getEstado() == TipoEstado.PENDIENTE) {
                listaTareas.encolar(tarea);
                return "Tarea pendiente: " + tarea.getNombre();
            }
            listaTareas.encolar(tarea);
        }
        return "No hay tareas pendientes";
    }

    public void calcularTiempos() {
        for (Proceso aux : listaProcesos) {
            for (DetalleProceso detalleProceso : aux.getListaDetalleProceso()) {
                aux.setTiempoMaximo(aux.getTiempoMaximo() + detalleProceso.calcularTiempoMaximo());
                aux.setTiempoMinimo(aux.getTiempoMinimo() + detalleProceso.calcularTiempoMinimo());
            }

        }
    }

    public void calcularTiemposUsuario(Usuario usuario) {
        for (Proceso aux : usuario.getProcesos()) {
            for (DetalleProceso detalleProceso : aux.getListaDetalleProceso()) {
                aux.setTiempoMaximo(aux.getTiempoMaximo() + detalleProceso.calcularTiempoMaximo());
                aux.setTiempoMinimo(aux.getTiempoMinimo() + detalleProceso.calcularTiempoMinimo());
            }

        }
    }

    public void calcularTiemposActividad(Actividad actividad) {
        for (DetalleActividad detalleActividad : actividad.getListaDetalleActividad()) {
            actividad.setTiempoMaximo(actividad.getTiempoMaximo() + detalleActividad.calcularTiempoMaximo());
            actividad.setTiempoMinimo(actividad.getTiempoMinimo() + detalleActividad.calcularTiempoMinimo());
        }
    }



}
