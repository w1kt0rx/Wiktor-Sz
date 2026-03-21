package pd4;

public class Task2 {
    public static void main(String[] args) {
        for (int i = 2; i <= 50; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }


        printPyramid();
    }

    private static boolean isPrime(int number) {
        if (number == 2) return true;
        if (number % 2 == 0) return false;

        for (int j = 3; j < number; j += 2) {
            if (number % j == 0) {
                return false;
            }
        }
        return true;
    }

    private static void printPyramid() {
        int amountOfSpaces = 5;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < amountOfSpaces; j++) {
                System.out.print(" ");
            }
            if (i == 0) {
                System.out.println("*");
            } else if (i == 1){
                System.out.println("");
            } else {
                System.out.print("*");
                System.out.println("*");
            }
            amountOfSpaces--;
        }

    }
}
