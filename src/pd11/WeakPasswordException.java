package pd11;

public class WeakPasswordException extends RegistrationException {

    public WeakPasswordException(PasswordStrength strength, String details) {
        super("Słabe hasło. " + strength + ". " + details);

    }
}
