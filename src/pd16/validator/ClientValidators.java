package pd16.validator;

import pd16.exception.*;
import pd16.repository.ClientRepository;

import java.util.regex.Pattern;

public class ClientValidators {
    private static final Pattern NAME_PATTERN = Pattern.compile("^[A-Za-z -]{2,100}$");
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z]+@+[a-zA-Z]+[.]+[A-Za-z]{3,100}$");

    public static void validateName(String name) {
        if (name == null || !NAME_PATTERN.matcher(name.trim()).matches()) {
            throw new InvalidClientNameException(name);
        }
    }

    public static void validateEmail(String email) {
        if (email == null || !EMAIL_PATTERN.matcher(email.trim()).matches()) {
            throw new InvalidEmailFormatException(email);
        }
    }

    public static void validateUniqueEmail(String email, ClientRepository repo) {
        String normalizedEmail = email.trim().toLowerCase();
        if (repo.existsByEmail(normalizedEmail)) {
            throw new EmailAlreadyUsedException(normalizedEmail);
        }

    }

    public static void validatePassword(String password) {
        if (password == null || password.isBlank()) {
            throw new EmptyPasswordException();
        }
        boolean hasUpperCase = password.chars().anyMatch(Character::isUpperCase);
        boolean has8Letters = password.length() >= 8;
        boolean hasDigit = password.chars().anyMatch(Character::isDigit);
        boolean hasSign = password.chars().anyMatch(ch -> !Character.isLetterOrDigit(ch));
        if (!hasUpperCase || !has8Letters || !hasDigit || !hasSign) {
            throw new WeakPasswordException();
        }
    }
}
