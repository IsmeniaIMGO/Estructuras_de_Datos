package exceptions;

public class NuloVacioException extends Exception{
    public NuloVacioException(String s) {
        super (s);
    }

    public NuloVacioException() {
        super ();
    }
}