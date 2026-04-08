package pd11;

import lombok.Getter;

public class DuplicateEmailException extends RegistrationException {
    @Getter
    private final String email;

    public DuplicateEmailException(String email) {
        super("Email już istnieje");
        this.email = email;
    }
}
