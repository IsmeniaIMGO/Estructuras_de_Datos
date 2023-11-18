package exceptions;

public class UsserYaExisteException extends Exception{
    public UsserYaExisteException(String s) {
        super (s);
    }

    public UsserYaExisteException() {
        super ();
    }
}
