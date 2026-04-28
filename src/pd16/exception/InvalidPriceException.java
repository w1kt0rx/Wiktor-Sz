package pd16.exception;

public class InvalidPriceException extends RuntimeException {
    public InvalidPriceException() {
        super("Cena nie może być mniejsza od 0");
    }
}
