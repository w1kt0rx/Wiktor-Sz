package pd16.exception;

public class EmptyPasswordException extends RuntimeException {
    public EmptyPasswordException() {
        super("Hasło nie może być puste");
    }
}
