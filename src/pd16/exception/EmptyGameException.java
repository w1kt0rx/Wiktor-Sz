package pd16.exception;

public class EmptyGameException extends RuntimeException {
    public EmptyGameException() {
        super("Gra nie może być pusta");
    }
}
