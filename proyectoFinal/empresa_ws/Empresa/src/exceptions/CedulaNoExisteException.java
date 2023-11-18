package exceptions;

public class CedulaNoExisteException extends Exception{
    public CedulaNoExisteException(String s) {
        super (s);
    }

    public CedulaNoExisteException() {
        super ();
    }
}
