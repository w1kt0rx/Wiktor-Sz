package pd6;

import java.util.Scanner;

public class MathLibrary {
    static Scanner scanner = new Scanner(System.in);
    /**
     * Method calculates the factorial of a number using iteration
     *
     * @param n - number that will be factorialized
     * @return result of calculating factorial
     */
    private static long factorialIteration(final int n) {
        if (n == 0) {
            return 1;
        }
        long factorial = 1;
        for (int i = 2; i <= n; i++) {
            factorial *= i;

        }
        return factorial;
    }

    /**
     * Method calculates the factorial of a number using recursion
     *
     * @param n - number that will be factorialized
     * @return result of calculating factorial
     */
    private static long factorialRecursion(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorialRecursion(n - 1);
    }
    /**
     * Method checks if number given by the user is a prime number
     *
     * @param n - number that is supposed to be checked
     * @return true or false
     */
    private static boolean isPrime(int n) {
        double sqrtOfNumber = Math.sqrt(n);
        for (int i = 2; i <= sqrtOfNumber; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    /**
     * Method calculates sieveOfEratosthenes with limit set by the user
     *
     * @param limit boundary of sieve
     * @return array that is build of numbers in sieveOfEratosthenes
     */
    private static int[] sieveOfEratosthenes(int limit) {
        int[] tabOfNumbers = new int[limit - 2];
        int amountOfDigitsToDelete = 0;
        //filling array with numbers from 2 to limit
        for (int i = 2; i < limit; i++) {
            tabOfNumbers[i - 2] = i;
        }
        //finding numbers that multiplicity of prime numbers and setting them to 1
        for (int i = 2; i < limit; i++) {
            if (tabOfNumbers[i - 2] != 1 || i * i < limit) {
                for (int j = i + 1; j < limit; j++) {
                    if (tabOfNumbers[j - 2] % i == 0) {
                        tabOfNumbers[j - 2] = 1;
                        amountOfDigitsToDelete++;
                    }
                }
            }
        }
        int[] sieveOfEratosthenes = new int[tabOfNumbers.length - amountOfDigitsToDelete];
        int amountOfDigitsInSieve = 0;
        for (int i = 0; i < tabOfNumbers.length; i++) {
            if (tabOfNumbers[i] != 1) {
                sieveOfEratosthenes[amountOfDigitsInSieve] = tabOfNumbers[i];
                amountOfDigitsInSieve++;
            }
        }
        return sieveOfEratosthenes;
    }

    /**
     * Method calculates greatest common divisior
     *
     * @param a,b - numbers from which method finds gcd
     * @return gcd found using Euclides algorithm
     */
    private static int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }

    /**
     * Method that controls menu
     */
    static void menu() {
        boolean isFinished = false;
        System.out.println("Witam w interaktywnym menu");
        while (!isFinished) {
            System.out.println("""
                    1.Iteracyjna silnia
                    2.Rekurencyjna silnia
                    3.Sprawdzenie czy liczba jest liczbą pierwszą
                    4.Utworzenie sita Eratostenesa
                    5.Obliczenie największego wspólnego dzielnika
                    6.Wyjście
                    """);
            System.out.println("Prosze podać liczbę odpowiadającą funkcji którą chcesz wybrać ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> factorialIterationMenu();
                case 2 -> factorialRecursionMenu();
                case 3 -> isPrimeMenu();
                case 4 -> sieveOfEratosthenesMenu();
                case 5 -> gcdMenu();
                case 6 -> isFinished = true;
                default -> System.out.println("Nie ma takiej opcji");
            }
            System.out.println("Czy chcesz wyjść z programu?");
            System.out.println("1-tak, enter-nie");
            if (scanner.nextLine().equals("1")) {
                isFinished = true;
            }
        }
        System.out.println("Żegnam");

    }

    /**
     * Method print the result from method factorialIteration
     */
    private static void factorialIterationMenu() {
        System.out.println("Prosze podac liczbę z której mamy obliczyć silnie");
        int number = scanner.nextInt();
        scanner.nextLine();
        System.out.printf("Wynik silni z liczby %d to: %d%n", number, factorialIteration(number));
    }

    /**
     * Method print the result from method factorialRecursion
     */
    private static void factorialRecursionMenu() {
        System.out.println("Prosze podac liczbę z której mamy obliczyć silnie");
        int number = scanner.nextInt();
        scanner.nextLine();
        System.out.printf("Wynik silni z liczby %d to: %d%n", number, factorialRecursion(number));
    }

    /**
     * Method print the result from method isPrime
     */

    private static void isPrimeMenu() {
        System.out.println("Prosze podac liczbę którą mam sprawdzić");
        int number = scanner.nextInt();
        scanner.nextLine();
        System.out.printf("Liczba %d %s%n", number, isPrime(number) ? "jest liczbą pierwszą" : "nie jest liczbą pierwszą");
    }

    /**
     * Method print the result from method sieveOfEratosthenes
     */
    private static void sieveOfEratosthenesMenu() {
        System.out.println("Prosze podac liczbę która będzie granicą sita Eratostenesa");
        int number = scanner.nextInt();
        scanner.nextLine();
        int[] sieve = sieveOfEratosthenes(number);
        System.out.println("Sito Eratostenesa jest przedstawione poniżej");
        for (int i = 0; i < sieve.length; i++) {
            System.out.print(sieve[i] + ",");
        }
        System.out.println();
    }

    /**
     * Method print the result from method gcd
     */
    private static void gcdMenu() {
        System.out.println("Prosze podac dwie liczby do obliczenia NWD");
        int number = scanner.nextInt();
        int number2 = scanner.nextInt();
        scanner.nextLine();
        System.out.printf("Największy wspólny dzielnik liczb %d, %d to: %d%n", number, number2, gcd(number, number2));
    }

}
