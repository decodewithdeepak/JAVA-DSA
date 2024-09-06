// Spiral order traversal of a matrix
// Given a 2D array, print it in spiral form.

import java.util.Scanner;

public class SpiralMatrixTraversal {

    static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) { // rows
            for (int j = 0; j < matrix[i].length; j++) { // columns
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void spiralOrderTraversal(int[][] matrix, int r, int c) {

        int top = 0, bottom = r - 1; // top and bottom row
        int left = 0, right = c - 1; // left and right column
        int total = 0; // total number of elements

        while (total < r * c) {

            // Print top row -> left to right
            for (int j = left; j <= right && total < r * c; j++) {
                System.out.print(matrix[top][j] + " ");
                total++;
            }
            top++;

            // Print right column -> top to bottom
            for (int i = top; i <= bottom && total < r * c; i++) {
                System.out.print(matrix[i][right] + " ");
                total++;
            }
            right--;

            // Print bottom row -> right to left
            for (int j = right; j >= left && total < r * c; j--) {
                System.out.print(matrix[bottom][j] + " ");
                total++;
            }
            bottom--;

            // Print left column -> bottom to top
            for (int i = bottom; i >= top && total < r * c; i--) {
                System.out.print(matrix[i][left] + " ");
                total++;
            }
            left++;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows and columns: ");
        int r = sc.nextInt(); // rows
        int c = sc.nextInt(); // columns

        int[][] matrix = new int[r][c];

        System.out.println("Enter " + r * c + " elements: ");
        for (int i = 0; i < r; i++) { // rows
            for (int j = 0; j < c; j++) { // columns
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.println("\nInput matrix is: ");
        printMatrix(matrix);

        System.out.println("\nSpiral order traversal of the matrix is: ");
        spiralOrderTraversal(matrix, r, c);

        sc.close();

    }

}