package exceptions;

public class ProcesoException extends Exception{
    public ProcesoException(String s) {
        super (s);
    }

    public ProcesoException() {
        super ();
    }
}
