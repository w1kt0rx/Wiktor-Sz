package zl3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj liczbe z zakresu 1-7 odpowiadająca dniu tygodnia");
        int day = scanner.nextInt();


        switch (day) {
            case 1 -> System.out.println("Poniedziałek");

            case 2 -> System.out.println("Wtorek");

            case 3 -> System.out.println("Środa");

            case 4 -> System.out.println("Czwartek");

            case 5 -> System.out.println("Piątek");

            case 6 -> System.out.println("Sobota");

            case 7 -> System.out.println("Niedziela");

            default -> throw new RuntimeException("Wartość spoza zakresu");
        }

        switch (day) {
            case 1, 2, 3, 4, 5 -> {
                System.out.println("Jest to dzień roboczy");
                System.out.println("Autobus odjeżdza o 05:30");
            }
            case 6 -> {
                System.out.println("Jest to weekend");
                System.out.println("Autobus odjeżdza o 07:00");
            }
            case 7 -> {
                System.out.println("Jest to weekend");
                System.out.println("Autobus odjeżdza o 09:00");
            }
        }

    }
}
