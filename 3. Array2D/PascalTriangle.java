// Pascal Triangle : Given an integer n, return the first n rows of Pascal's triangle.
// In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
// For example, if n = 5, then output will be:
//     1
//    1 1
//   1 2 1
//  1 3 3 1
// 1 4 6 4 1

// The first and the last number of each row in the triangle is 1.
// ith row has (i + 1) elements.


import java.util.Scanner;

public class PascalTriangle {

    static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) { // rows
            for (int j = 0; j < matrix[i].length; j++) { // columns
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int[][] pascalTriangle(int n) {
        int[][] triangle = new int[n][];
        for (int i = 0; i < n; i++) {
            // ith row has (i + 1) elements.
            triangle[i] = new int[i + 1];
            // First and last element of each row is 1.
            triangle[i][0] = triangle[i][i] = 1;
            // Other elements are sum of the elements just above and left of the above.
            for (int j = 1; j < i; j++) {
                triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
            }

        }

        return triangle;
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int n = sc.nextInt(); // rows

        int[][] triangle = pascalTriangle(n);
        printMatrix(triangle);


        sc.close();

    }
}
