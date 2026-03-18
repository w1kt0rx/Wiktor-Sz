package pd3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = 0;
        do {
            System.out.println("Podaj numer inny od 0");
            number = scanner.nextInt();
        } while (number == 0);
        scanner.nextLine();
        Number number1 = new Number(number);
        System.out.println(number1.getInformation());
    }
}
