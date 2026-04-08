package pd11;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserRegistrationService registrationService = new UserRegistrationService();

        while (true) {
            try {
                System.out.println("Rejestracja prosze podać dane");

                System.out.print("Imię: ");
                String name = scanner.nextLine();

                System.out.print("Email: ");
                String email = scanner.nextLine();

                System.out.print("Hasło: ");
                String password = scanner.nextLine();

                registrationService.registerUser(name, email, password);

                System.out.println("Rejestracja zakończona sukcesem.");
                registrationService.printUsers();

            } catch (ValidationException e) {
                System.out.println(
                        "Błąd walidacji '" + e.getField() + "': " + e.getMessage()
                );
                System.out.println("Spróbuj ponownie.");

            } catch (DuplicateEmailException e) {
                System.out.println("Email już istnieje: " + e.getEmail());

            } catch (WeakPasswordException e) {
                System.out.println(
                        "Hasło jest za słabe. Siła: " + e.getStrength()
                                + ", szczegóły: " + e.getDetails()
                );

            } catch (RegistrationException e) {
                System.out.println("Błąd rejestracji: " + e.getMessage());
            }
        }
    }
}