package pd5;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int[][] matrix = fillMatrix();
        ;
        printMatrix(matrix);
        calculateAndPrintTranspose(matrix);
        turnMatrix90(matrix);
        printColumnsSum(matrix);
        printRowSum(matrix);
        if (isSymmetric(matrix)) {
            System.out.println("Macierz jest symetryczna");
        } else {
            System.out.println("Macierz nie jest symetryczna");
        }
    }

    private static int[][] fillMatrix() {
        int[][] matrix = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.printf("Prosze podać %d liczbę ", (j + 1) + (3 * i));
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] rows : matrix) {
            for (int numbers : rows) {
                System.out.print(numbers + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void calculateAndPrintTranspose(int[][] matrix) {
        int[][] transposedMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }
        System.out.println("Transposed matrix");
        printMatrix(transposedMatrix);
    }

    private static void turnMatrix90(int[][] matrix) {
        int[][] twistedMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                twistedMatrix[j][2 - i] = matrix[i][j];
            }
        }
        System.out.println("Twisted matrix");
        printMatrix(twistedMatrix);
    }

    private static void printColumnsSum(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            int columnSum = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                columnSum += matrix[j][i];
            }
            System.out.printf("Suma kolumny nr %d wynosi: %d%n", i + 1, columnSum);
        }
    }

    private static void printRowSum(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            int rowSum = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                rowSum += matrix[i][j];
            }
            System.out.printf("Suma rzędu nr %d wynosi: %d%n", i + 1, rowSum);
        }
    }

    private static boolean isSymmetric(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != matrix[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }
}

