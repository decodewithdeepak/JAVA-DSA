import java.util.Scanner;

public class Array2D {
    public static void main(String[] args) {
        // Two Dimensional Array (2D)
        // Two dimensional array is an array of arrays. Also known as matrix array.

        // Syntax:
        // datatype[][] array_name = new datatype[rows][columns];

        // 2D array declaration
        int[][] matrix1 = new int[2][3]; // 2 X 3 matrix array (2 rows and 3 columns, 6 elements)

        // 2D array initialization
        matrix1[0][0] = 1; // 1st row 1st column
        matrix1[0][1] = 2; // 1st row 2nd column
        matrix1[0][2] = 3; // 1st row 3rd column

        matrix1[1][0] = 4; // 2nd row 1st column
        matrix1[1][1] = 5; // 2nd row 2nd column
        matrix1[1][2] = 6; // 2nd row 3rd column

        // 2D array declaration and initialization
        int[][] matrix2 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }; // 3 X 3 matrix array (3 rows and 3 columns, 9 elements)
        System.out.println(matrix2[0][0]); // 1st row 1st column
        System.out.println(matrix2[0][1]); // 1st row 2nd column
        System.out.println(matrix2[0][2]); // 1st row 3rd column

        // Length of 2D array
        System.out.println("Length of matrix2 array is: " + matrix2.length); // 3 as it has 3 rows

        // Traversing through the 2D array using for loop
        System.out.println("Traversing through the matrix2 array:");
        for (int i = 0; i < matrix2.length; i++) { // rows
            for (int j = 0; j < matrix2[i].length; j++) { // columns
                System.out.print(matrix2[i][j] + " ");
            }
            System.out.println();
        }

        // 2D array declaration and initialization using Scanner class
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter the number of columns: ");
        int cols = sc.nextInt();
        int[][] matrix3 = new int[rows][cols];

        System.out.println("Enter the elements in matrix3 array: ");
        for (int i = 0; i < rows; i++) { // rows
            for (int j = 0; j < cols; j++) { // columns
                matrix3[i][j] = sc.nextInt();
            }
        }

        System.out.println("\nElements in the matrix3 array are: ");
        for (int i = 0; i < rows; i++) { // rows
            for (int j = 0; j < cols; j++) { // columns
                System.out.print(matrix3[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();

        // Three Dimensional Array (3D)
        // Three dimensional array is an array of arrays of arrays. Also known as cube array.
        
        int [][][] cube = new int[3][4][5]; // 3 X 4 X 5 cube array (3 rows, 4 columns and 5 depth, 60 elements) 
    }
}