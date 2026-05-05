package pd16.exception;

public class EmailAlreadyUsedException extends RuntimeException {
    public EmailAlreadyUsedException(String email) {
        super("Email: " + email + " jest już w użyciu");
    }
}
