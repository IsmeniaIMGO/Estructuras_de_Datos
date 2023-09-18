package Services;

public interface ILogin {
    public boolean verificarBibliotecario(String usuario, String password);
    public boolean verificarEstudiante(String usuario, String password);
}
