package Services;

public interface ITransaccionPrestamo {

    public void prestarLibro(String idLibro, String cedulaUsuario);
    public void devolverLibro(String idLibro, String cedulaUsuario);
}
