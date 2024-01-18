// Rotation of Matrix by 90 degree in clockwise direction without using any extra space
// It is same as Transpose of Matrix and then reversing each row of the matrix.

import java.util.Scanner;

public class RotationOfMatrix {
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

        // Transpose of Matrix
        for (int i = 0; i < c; i++) { // rows
            for (int j = 0; j < r; j++) { // columns
                System.out.print(arr[j][i] + " ");
            }
            System.out.println();
        }

        // Reversing each row of the matrix
        for (int i = 0; i < r; i++) { // rows
            int low = 0;
            int high = c - 1;
            while (low < high) {
                int temp = arr[i][low];
                arr[i][low] = arr[i][high];
                arr[i][high] = temp;
                low++;
                high--;
            }
        }

        System.out.println("\nRotation of the matrix is: ");

        for (int i = 0; i < r; i++) { // rows
            for (int j = 0; j < c; j++) { // columns
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }


    }
}
