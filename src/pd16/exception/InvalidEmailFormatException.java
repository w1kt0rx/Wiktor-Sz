package pd16.exception;

public class InvalidEmailFormatException extends RuntimeException {
    public InvalidEmailFormatException(String email) {
        super("Nieprawidłowy format email: " + email);
    }
}
