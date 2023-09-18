package Laboratorio2.Services;

public interface ITransaccionPrestamo {

    public void prestarLibro(String idPrestamo, String cedulaUsuario);

    public void devolverLibro(String idprestamo, String cedulaUsuario);
}
