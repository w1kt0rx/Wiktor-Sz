package pd3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberFromUser;
        do {
            System.out.println("Podaj numer");
            numberFromUser = scanner.nextInt();
            if (numberFromUser == 0) {
                System.out.println("Numer nie może być równy 0");
            }
        } while (numberFromUser == 0);

        Number analyzedNumber = new Number(numberFromUser);
        System.out.println(analyzedNumber);
    }
}
