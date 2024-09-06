// Multiplication of two matrices
// No. of columns in first matrix must be equal to no. of rows in second matrix.
// The product of two matrices A and B will be a matrix which has the same number of rows as A and the same number of columns as B.


import java.util.Scanner;

public class MultiplicationOfMatrix {

    static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) { // rows
            for (int j = 0; j < matrix[i].length; j++) { // columns
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void multiplyMatrices(int[][] matrix1, int[][] matrix2) {

        int r1 = matrix1.length;
        int c1 = matrix1[0].length;

        int r2 = matrix2.length;
        int c2 = matrix2[0].length;

        if (c1 != r2) {
            System.out.println("Matrices cannot be multiplied!");
            return;
        }

        int[][] product = new int[r1][c2];

        for (int i = 0; i < r1; i++) { // rows
            for (int j = 0; j < c2; j++) { // columns
                for (int k = 0; k < c1; k++) { // columns of matrix1 or rows of matrix2
                    product[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        printMatrix(product);

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

        System.out.println("Product of the matrices is: ");
        multiplyMatrices(matrix1, matrix2);

        
        
        sc.close();

    }
}
