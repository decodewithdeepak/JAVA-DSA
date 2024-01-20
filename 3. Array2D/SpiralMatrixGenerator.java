// Given a positive integer n, generate a n x n matrix filled with elements from 1 to n^2 in spiral order.

import java.util.Scanner;

public class SpiralMatrixGenerator {

    static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    static int[][] generateSpiralMatrix(int n) {
        int[][] matrix = new int[n][n];

        int top = 0, bottom = n - 1;
        int left = 0, right = n - 1;
        int curr = 1; // current element to be filled

        while (curr <= n*n) {
            // Traverse top row
            for (int j = left; j <= right && curr <= n*n; j++) {
                matrix[top][j] = curr++;
            }
            top++;

            // Traverse right column
            for (int i = top; i <= bottom && curr <= n*n; i++) {
                matrix[i][right] = curr++;
            }
            right--;

            // Traverse bottom row
            if (top <= bottom) {
                for (int j = right; j >= left && curr <= n*n; j--) {
                    matrix[bottom][j] = curr++;
                }
                bottom--;
            }

            // Traverse left column
            if (left <= right) {
                for (int i = bottom; i >= top && curr <= n*n;  i--) {
                    matrix[i][left] = curr++;
                }
                left++;
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of n: ");
        int n = sc.nextInt();

        int[][] matrix = generateSpiralMatrix(n);
        printMatrix(matrix);


        sc.close();

    }
}
