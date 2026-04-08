package pd11;

import lombok.Getter;

@Getter
public class WeakPasswordException extends RegistrationException {
    private final PasswordStrength strength;
    private final String details;

    public WeakPasswordException(PasswordStrength strength, String details) {
        super("Weak password");
        this.strength = strength;
        this.details = details;
    }
}
