package pd16.exception;

public class WeakPasswordException extends RuntimeException {
    public WeakPasswordException() {
        super("Hasło jest zbyt słabe");
    }
}
