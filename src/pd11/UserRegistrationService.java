package pd11;

import java.util.HashMap;
import java.util.regex.Pattern;

public class UserRegistrationService {
    private static final Pattern NAME_PATTERN = Pattern.compile("^[A-Za-z -]{2,100}$");
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z]+@+[a-zA-Z]+[.]+[A-Za-z]{3,100}$");

    HashMap<String, User> validUsersByEmail = new HashMap<>();

    public void registerUser(String name, String email, String password) {
        validateName(name);
        validateEmail(email);
        validateUniqueEmail(email);
        validatePassword(password);

        String hashedPassword = "hashed_" + password;

        User user = User.of(name, email, hashedPassword);

        validUsersByEmail.put(user.getEmail(), user);

    }

    private void validateName(String name) {
        if (name == null || !NAME_PATTERN.matcher(name.trim()).matches()) {
            throw new ValidationException("name", "Imię musi mieć od 2 do 100 znaków i zawierać tylko litery");
        }
    }

    private void validateEmail(String email) {
        if (email == null || !EMAIL_PATTERN.matcher(email.trim()).matches()) {
            throw new ValidationException("email", "Niepoprawny format email");
        }
    }

    private void validateUniqueEmail(String email) {
        String normalizedEmail = email.trim().toLowerCase();
        if (validUsersByEmail.containsKey(normalizedEmail)) {
            throw new DuplicateEmailException(normalizedEmail);
        }

    }

    private void validatePassword(String password) {
        if (password == null || password.isBlank()) {
            throw new ValidationException("password", "Hasło nie moze być puste");
        }

        boolean hasUpperCase = password.chars().anyMatch(Character::isUpperCase);
        boolean hasMinLength = password.length() >= 8;
        boolean hasAnyDigit = password.chars().anyMatch(Character::isDigit);
        boolean hasAnySpecial = password.chars().anyMatch(ch -> !Character.isLetterOrDigit(ch));

        if (!hasAnyDigit || !hasAnySpecial || !hasMinLength || !hasUpperCase) {
            PasswordStrength strengthOfPassword = validatePasswordStrength(password);
            throw new WeakPasswordException(strengthOfPassword, "Hasło powinno zawierać co najmniej 8 znaków, wielką literę, cyfrę oraz znak specjalny");
        }
    }

    private PasswordStrength validatePasswordStrength(String password) {
        int score = 0;
        if (password.chars().anyMatch(Character::isUpperCase)) {
            score++;
        }
        if (password.length() >= 8) {
            score++;
        }
        if (password.chars().anyMatch(Character::isDigit)) {
            score++;
        }
        if (password.chars().anyMatch(ch -> !Character.isLetterOrDigit(ch))) {
            score++;
        }
        return switch (score) {
            case 0, 1 -> PasswordStrength.WEAK;
            case 2, 3 -> PasswordStrength.OK;
            case 4 -> PasswordStrength.STRONG;
            default -> throw new IllegalStateException("Nieoczekiwany wynik");
        };
    }

    public void printUsers() {

        if (validUsersByEmail.isEmpty()) {
            System.out.println("Brak użytkowników.");
            return;
        }

        for (User user : validUsersByEmail.values()) {
            System.out.println(user);
        }
    }


}
