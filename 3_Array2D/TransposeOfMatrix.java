// Notes 18 : https://drive.google.com/file/d/1IWUKT7by8vetfmaCsqMRFXiNw87CwDUI/view

// Transpose of a matrix
// Transpose of a matrix is obtained by changing rows to columns and columns to rows. 
// In other words, transpose of A[][] is obtained by changing A[i][j] to A[j][i].

import java.util.Scanner;

public class TransposeOfMatrix {

    static void printArray(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) { // rows (arr.length gives number of rows)
            for (int j = 0; j < matrix[i].length; j++) { // column (arr[i].length gives number of columns)
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int[][] transposeMatrix(int[][] matrix) {

        int r = matrix.length;
        int c = matrix[0].length;

        int[][] transpose = new int[c][r];

        for (int i = 0; i < c; i++) { // rows
            for (int j = 0; j < r; j++) { // columns
                transpose[i][j] = matrix[j][i];
            }
        }

        return transpose;

    }

    static void transposeMatrixInPlace(int[][] matrix) { // only for square matrix

        int r = matrix.length;
        int c = matrix[0].length;

        for (int i = 0; i < c; i++) { // rows
            for (int j = i; j < r; j++) { // columns
                // swap(matrix[i][j], matrix[j][i]);
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
                // matrix[i][j] = matrix[i][j] + matrix[j][i];
                // matrix[j][i] = matrix[i][j] - matrix[j][i];
                // matrix[i][j] = matrix[i][j] - matrix[j][i];
            }
        }

    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows and columns: ");
        int r = sc.nextInt(); // rows
        int c = sc.nextInt(); // columns

        int[][] matrix = new int[r][c]; // Total number of elements: r * c

        System.out.println("Enter " + r*c + " elements in the matrix: ");
        for (int i = 0; i < r; i++) { // rows
            for (int j = 0; j < c; j++) { // columns
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.println("\nInput Matrix: ");
        printArray(matrix);
        

        System.out.println("\nTranspose Matrix: ");
        int[][] transpose = transposeMatrix(matrix);
        printArray(transpose);

        // transposeMatrixInPlace(matrix);
        // printArray(matrix);



        sc.close();

    }

}
