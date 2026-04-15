package pd11;

import java.util.regex.Pattern;

public class Validators {
    private static final Pattern NAME_PATTERN = Pattern.compile("^[A-Za-z -]{2,100}$");
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z]+@+[a-zA-Z]+[.]+[A-Za-z]{3,100}$");

    public static void validateName(String name, ValidUsersRepository repo) {
        if (name == null || !NAME_PATTERN.matcher(name.trim()).matches()) {
            throw new ValidationException("name", "Imię musi mieć od 2 do 100 znaków i zawierać tylko litery");
        }
    }

    public static void validateEmail(String email, ValidUsersRepository repo) {
        if (email == null || !EMAIL_PATTERN.matcher(email.trim()).matches()) {
            throw new ValidationException("email", "Niepoprawny format email");
        }
    }

    public static void validateUniqueEmail(String email, ValidUsersRepository repo) {
        String normalizedEmail = email.trim().toLowerCase();
        if (repo.containsEmail(normalizedEmail)) {
            throw new DuplicateEmailException(normalizedEmail);
        }

    }

    public static void validatePassword(String password, ValidUsersRepository repo) {
        if (password == null || password.isBlank()) {
            throw new ValidationException("password", "Hasło nie moze być puste");
        }

        PasswordStrength strengthOfPassword = validatePasswordStrength(password, repo);
        if (!strengthOfPassword.equals(PasswordStrength.STRONG)) {
            throw new WeakPasswordException(strengthOfPassword, "Hasło powinno zawierać co najmniej 8 znaków, wielką literę, cyfrę oraz znak specjalny");
        }
    }

    public static PasswordStrength validatePasswordStrength(String password, ValidUsersRepository repo) {
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
}
