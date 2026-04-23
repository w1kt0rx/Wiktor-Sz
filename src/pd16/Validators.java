package pd16;

import java.math.BigDecimal;
import java.util.regex.Pattern;

public class Validators {
    private static final Pattern NAME_PATTERN = Pattern.compile("^[A-Za-z -]{2,100}$");
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z]+@+[a-zA-Z]+[.]+[A-Za-z]{3,100}$");

    public static void validateName(String name) {
        if (name == null || !NAME_PATTERN.matcher(name.trim()).matches()) {
            throw new RuntimeException("Imię musi mieć od 2 do 100 znaków i zawierać tylko litery");
        }
    }

    public static void validateEmail(String email) {
        if (email == null || !EMAIL_PATTERN.matcher(email.trim()).matches()) {
            throw new RuntimeException("Niepoprawny format email");
        }
    }

    public static void validateUniqueEmail(String email, ClientRepository repo) {
        String normalizedEmail = email.trim().toLowerCase();
        if (repo.containsEmail(normalizedEmail)) {
            throw new RuntimeException("Email jest już w użyciu");
        }

    }

    public static void validatePassword(String password) {
        if (password == null || password.isBlank()) {
            throw new RuntimeException("Hasło nie moze być puste");
        }
        boolean hasUpperCase = password.chars().anyMatch(Character::isUpperCase);
        boolean has8Letters = password.length() >= 8;
        boolean hasDigit = password.chars().anyMatch(Character::isDigit);
        boolean hasSign = password.chars().anyMatch(ch -> !Character.isLetterOrDigit(ch));
        if (!hasUpperCase || !has8Letters || !hasDigit || !hasSign) {
            throw new RuntimeException("Hasło powinno zawierać co najmniej 8 znaków, wielką literę, cyfrę oraz znak specjalny");
        }
    }
    public static void validateGame(String name, BigDecimal price) {
        if (name == null || name.isBlank()) throw new RuntimeException();
        if (price.compareTo(BigDecimal.ZERO) <= 0) throw new RuntimeException();
    }
}
