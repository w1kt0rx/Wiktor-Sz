package ZL2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Elo");
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj wage w kilogramach");
        double weightInKg = scan.nextDouble();
        System.out.println("Podaj wzrost w centymetrach");
        double heightInMeters = scan.nextDouble() / 100.0;
        if (heightInMeters <= 0.30 || heightInMeters >= 2.50) {
            System.out.println("Ostrzeżenie");
        }

        double BMI = weightInKg / (heightInMeters * heightInMeters);

        System.out.printf("Twoje BMI to %.2f\n", BMI);

        if (BMI < 18.5) {
            System.out.println("Niedowaga");
        } else if (BMI >= 18.5 && BMI <= 24.9) {
            System.out.println("Norma");
        } else if (BMI >= 25 && BMI <= 29.9) {
            System.out.println("Nadwaga");
        } else {
            System.out.println("Otyłość");
        }

    }
}
