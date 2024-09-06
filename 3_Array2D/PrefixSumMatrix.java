// Source: https://www.geeksforgeeks.org/prefix-sum-2d-array/

import java.util.Scanner;

public class PrefixSumMatrix {

    static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int[][] makePrefixSumArray(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;

        // Calculate prefix sum for each row
        for (int i = 0; i < r; i++) {
            for (int j = 1; j < c; j++) {
                matrix[i][j] += matrix[i][j - 1];
            }
        }

        // Calculate prefix sum for each column
        for (int j = 0; j < c; j++) {
            for (int i = 1; i < r; i++) {
                matrix[i][j] += matrix[i - 1][j];
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows and columns: ");

        int r = sc.nextInt();
        int c = sc.nextInt();

        int[][] matrix = new int[r][c];

        System.out.println("Enter " + r * c + " the elements: ");

        for (int i = 0; i < r; i++) { // rows
            for (int j = 0; j < c; j++) { // columns
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.println("Original Matrix:");
        printMatrix(matrix);

        int[][] prefixSumMatrix = makePrefixSumArray(matrix);

        System.out.println("\nPrefix Sum Matrix:");
        printMatrix(prefixSumMatrix);


        sc.close();
    }
}
