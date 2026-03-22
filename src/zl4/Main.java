package zl4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String correctPassword = "java123";
        int attempts = 0;

        while (attempts < 3) {
            System.out.println("Prosze podac hasło: ");
            String password = scanner.nextLine();

            if (password.length() < 3) {
                System.out.println("Password too short");
                continue;
            }
            if (password.equals(correctPassword)) {
                System.out.println("Login successful");
                return;
            }
            System.out.println("Wrong password");
            attempts++;

        }
        System.out.println("Account Locked");
    }
}
