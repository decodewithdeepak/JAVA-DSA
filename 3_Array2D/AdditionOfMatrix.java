// Addition of two matrices
// Two matrices can be added only if they have the same dimensions.
// The sum of two matrices A and B will be a matrix which has the same dimensions as A and B.

import java.util.Scanner;

public class AdditionOfMatrix {

    static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) { // rows
            for (int j = 0; j < matrix[i].length; j++) { // columns
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void addMatrices(int[][] matrix1, int[][] matrix2) {

        int r1 = matrix1.length;
        int c1 = matrix1[0].length;

        int r2 = matrix2.length;
        int c2 = matrix2[0].length;

        if (r1 != r2 || c1 != c2) {
            System.out.println("Matrices cannot be added!");
            return;
        }

        int[][] sum = new int[r1][c1];

        for (int i = 0; i < r1; i++) { // rows
            for (int j = 0; j < c1; j++) { // columns
                sum[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        printMatrix(sum);

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows and columns of matrix 1: ");
        int r1 = sc.nextInt();
        int c1 = sc.nextInt();

        int[][] matrix1 = new int[r1][c1];

        System.out.println("Enter the elements in matrix 1: ");
        for (int i = 0; i < r1; i++) { // rows
            for (int j = 0; j < c1; j++) { // columns
                matrix1[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter the number of rows and columns of matrix 2: ");
        int r2 = sc.nextInt();
        int c2 = sc.nextInt();

        int[][] matrix2 = new int[r2][c2];

        System.out.println("Enter the elements in matrix 2: ");
        for (int i = 0; i < r2; i++) { // rows
            for (int j = 0; j < c2; j++) { // columns
                matrix2[i][j] = sc.nextInt();
            }
        }

        System.out.println("\nMatrix 1: ");
        printMatrix(matrix1);

        System.out.println("\nMatrix 2: ");
        printMatrix(matrix2);

        System.out.println("\nSum of Matrix 1 and Matrix 2: ");
        addMatrices(matrix1, matrix2);




        sc.close();

    }
}
