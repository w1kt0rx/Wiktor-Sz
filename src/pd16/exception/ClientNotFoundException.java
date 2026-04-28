package pd16.exception;

public class ClientNotFoundException extends RuntimeException {
    public ClientNotFoundException(String email) {
        super("Nie znaleziono użytkownika z emailem: " + email);
    }
}
