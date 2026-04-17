package pd11;

import lombok.Getter;


public class UserRegistrationService {
    @Getter
    private final ValidUsersRepository usersRepository = new ValidUsersRepository();

    public void registerUser(String name, String email, String password) {
        Validators.validateName(name, usersRepository);
        Validators.validateEmail(email, usersRepository);
        Validators.validateUniqueEmail(email, usersRepository);
        Validators.validatePassword(password, usersRepository);

        String hashedPassword = "hashed_" + password;

        User user = User.of(name, email, hashedPassword);

        usersRepository.put(user);

    }

}
