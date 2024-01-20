// Rotation of a Square Matrix by 90 degree in clockwise direction without using any extra space
// It is same as Transpose of Matrix and then reversing each row of the matrix.

import java.util.Scanner;

public class RotationOfMatrix {

    static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }


    static void transposeMatrix(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;

        for (int i = 0; i < r; i++) {
            for (int j = i + 1; j < c; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }


    static void reverseArray(int[] arr) {
        int i = 0, j = arr.length - 1;

        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            i++; 
            j--;
        }
    }


    static void rotateMatrixClockwise(int[][] matrix) {
        
        // transpose of matrix
        transposeMatrix(matrix);

        // reverse each row of transposed matrix
        for (int i = 0; i < matrix.length; i++) { // rows
            reverseArray(matrix[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of rows and columns: ");
        int r = sc.nextInt();
        int c = sc.nextInt();

        int[][] matrix = new int[r][c];

        System.out.println("Enter " + r*c + " elements in the matrix: ");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.println("\nOriginal Matrix:");
        printMatrix(matrix);

        rotateMatrixClockwise(matrix);

        System.out.println("\nMatrix after rotation by 90 degrees clockwise:");
        printMatrix(matrix);

        sc.close();
    }
}
