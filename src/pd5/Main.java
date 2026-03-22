package pd5;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        int[][] matrix = fillMatrix();
        printMatrix(matrix);
        System.out.println();
        calculateAndPrintTranspose(matrix);
        System.out.println();
        turnMatrix90(matrix);
        System.out.println();
        printColumnsSum(matrix);
        System.out.println();
        printRowSum(matrix);
        System.out.println();
        if(isSymmetric(matrix)){
            System.out.println("Macierz jest symetryczna");
        } else {
            System.out.println("Macierz nie jest symetryczna");
        }
    }

    static private int[][] fillMatrix(){
        int[][] matrix = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.printf("Prosze podać %d liczbę ", (j+1)+(3*i));
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }


    static private void printMatrix(int[][] matrix) {
        for (int[] rows : matrix) {
            for (int numbers : rows) {
                System.out.print(numbers + " ");
            }
            System.out.println();
        }
    }

    static private void calculateAndPrintTranspose(int[][] matrix) {
        int[][] transposedMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }
        printMatrix(transposedMatrix);
    }

    static private void turnMatrix90(int[][] matrix) {
        int[][] twistedMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                twistedMatrix[j][2 - i] = matrix[i][j];

            }
        }
        printMatrix(twistedMatrix);
    }

    static private void printColumnsSum(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            int columnSum = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                columnSum += matrix[j][i];
            }
            System.out.printf("Suma kolumny nr %d wynosi: %d%n", i + 1, columnSum);
        }
    }

    static private void printRowSum(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            int rowSum = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                rowSum += matrix[i][j];
            }
            System.out.printf("Suma rzędu nr %d wynosi: %d%n", i + 1, rowSum);
        }
    }

    static private boolean isSymmetric(int[][] matrix) {
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

