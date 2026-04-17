package pd11;

public class DuplicateEmailException extends RegistrationException {

    public DuplicateEmailException(String email) {
        super("Email już istnieje");
    }
}
