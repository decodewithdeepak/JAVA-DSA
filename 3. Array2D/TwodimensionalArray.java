// Notes 17 : https://drive.google.com/file/d/1ODbxp0kFuIXXw0rEaykLfezSgSNIBckP/view

// Multidimensional Array: 2D, 3D, 4D, 5D, etc.

import java.util.Scanner;

public class TwodimensionalArray {

    static void printArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) { // rows (arr.length gives number of rows)
            for (int j = 0; j < arr[i].length; j++) { // column (arr[i].length gives number of columns)
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        
        // 2D Array Declaration
        int[][] arr = new int[2][3]; // 2 rows and 3 columns (2 X 3 matrix array, 6 elements)

        // 2D Array Initialization
        arr[0][0] = 1; // 1st row 1st column
        arr[0][1] = 2; // 1st row 2nd column
        arr[0][2] = 3; // 1st row 3rd column

        arr[1][0] = 4; // 2nd row 1st column
        arr[1][1] = 5; // 2nd row 2nd column
        arr[1][2] = 6; // 2nd row 3rd column

        // 2D Array Declaration and Initialization (array literal)
        int[][] arr2 = { { 1, 2, 3 }, { 4, 5, 6 } }; // 2 rows and 3 columns


        // Traversing through the 2D array using for loop

        // for (int i = 0; i < 2; i++) { // rows
        //     for (int j = 0; j < 3; j++) { // columns
        //         System.out.print(arr2[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        // printArray(arr2);

        // Taking input from user
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int r = sc.nextInt(); // rows
        System.out.print("Enter the number of columns: ");
        int c = sc.nextInt(); // columns

        int[][] arr3 = new int[r][c]; // Total number of elements: r * c

        System.out.println("Enter " + r*c + " elements in the array: ");
        for (int i = 0; i < r; i++) { // rows
            for (int j = 0; j < c; j++) { // columns
                arr3[i][j] = sc.nextInt();
            }
        }

        System.out.println("\nElements in the array are: ");

        // for (int i = 0; i < r; i++) { // rows
        //     for (int j = 0; j < c; j++) { // columns
        //         System.out.print(arr3[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        
        printArray(arr3); 


        sc.close();

    }
}
