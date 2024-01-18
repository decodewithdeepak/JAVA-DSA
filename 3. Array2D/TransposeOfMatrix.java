// Transpose of a matrix
// Transpose of a matrix is obtained by changing rows to columns and columns to rows. 
// In other words, transpose of A[][] is obtained by changing A[i][j] to A[j][i].

import java.util.Scanner;

public class TransposeOfMatrix {


    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int r = sc.nextInt(); // rows
        System.out.print("Enter the number of columns: ");
        int c = sc.nextInt(); // columns

        int[][] arr = new int[r][c]; // Total number of elements: r * c

        System.out.println("Enter " + r*c + " elements in the array: ");
        for (int i = 0; i < r; i++) { // rows
            for (int j = 0; j < c; j++) { // columns
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println("\nElements in the matrix are: ");

        for (int i = 0; i < r; i++) { // rows
            for (int j = 0; j < c; j++) { // columns
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("\nTranspose of the matrix is: ");

        for (int i = 0; i < c; i++) { // rows
            for (int j = 0; j < r; j++) { // columns
                System.out.print(arr[j][i] + " ");
            }
            System.out.println();
        }


        sc.close();

    }

}
