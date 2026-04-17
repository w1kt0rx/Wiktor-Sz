package pd11;

import java.util.Collection;
import java.util.HashMap;

public class ValidUsersRepository {
    private final HashMap<String, User> validUsersByEmail = new HashMap<>();

    public void put(User user) {
        validUsersByEmail.put(user.getEmail(), user);
    }

    public boolean containsEmail(String email) {
        return validUsersByEmail.containsKey(email);
    }

    public void printUsers() {
        validUsersByEmail.forEach((email, user) -> System.out.println(email + " " + user));
    }

}
