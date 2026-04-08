package pd11;

import lombok.Getter;

public class ValidationException extends RegistrationException {
    @Getter
    private final String field;

    public ValidationException(String message, String field) {
        super(message);
        this.field = field;
    }
}
