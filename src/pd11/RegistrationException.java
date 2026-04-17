package pd11;

public class RegistrationException extends RuntimeException {

    public RegistrationException(String message) {
        super("Bład rejestracji użytkownika. " + message);
    }
}
