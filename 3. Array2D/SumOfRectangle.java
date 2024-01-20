// Notes 19 : https://drive.google.com/file/d/1W-GbpAkozCXFJLTX5GRTZn0ZCMpOp9Zs/view

// For a given matrix of dimension r x c and two coordinates (l1, r1) and (l2, r2), return the sum of rectangle from (l1, r1) to (l2, r2)

// l2 >= l1 and r2 >= r1
// 0 <= l1, l2 < r
// 0 <= r1, r2 < c

import java.util.Scanner;

public class SumOfRectangle {
    
    static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) { // rows
            for (int j = 0; j < matrix[i].length; j++) { // columns
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Simple Sum of all elements in the given matrix
    static int sumOfMatrix(int[][] matrix, int r, int c) {

        int sum = 0;

        for (int i = 0; i < r; i++) { // rows
            for (int j = 0; j < c; j++) { // columns
                sum += matrix[i][j];
            }
        }

        return sum;

    }

    // Sum of all elements in the given rectangle (l1, r1) to (l2, r2)
    // Method 1: Brute Force Approach

    static int findSumOfRectangle(int[][] matrix, int l1, int r1, int l2, int r2) {

        int sum = 0;

        for (int i = l1; i <= l2; i++) { // rows
            for (int j = r1; j <= r2; j++) { // columns
                sum += matrix[i][j];
            }
        }

        return sum;

    }

    // Method 2: Using Prefix Sum Matrix (rows and columns both)

    static int[][] makePrefixSumArray(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;

        // Calculate prefix sum for each row
        for (int i = 0; i < r; i++) {
            for (int j = 1; j < c; j++) {
                matrix[i][j] += matrix[i][j - 1];
            }
        }

        // Calculate prefix sum for each column
        for (int j = 0; j < c; j++) {
            for (int i = 1; i < r; i++) {
                matrix[i][j] += matrix[i - 1][j];
            }
        }

        return matrix;
    }

    static int findSumOfRectangle2(int[][] matrix, int l1, int r1, int l2, int r2) {
            
        int[][] prefixSumMatrix = makePrefixSumArray(matrix);

        int sum = prefixSumMatrix[l2][r2];

        if (l1 > 0) {
            sum -= prefixSumMatrix[l1 - 1][r2];
        }

        if (r1 > 0) {
            sum -= prefixSumMatrix[l2][r1 - 1];
        }

        if (l1 > 0 && r1 > 0) {
            sum += prefixSumMatrix[l1 - 1][r1 - 1];
        }

        return sum;

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows and columns: ");
        int r = sc.nextInt(); // rows
        int c = sc.nextInt(); // columns

        int[][] matrix = new int[r][c];

        System.out.println("Enter " + r*c + " the elements: ");
        for (int i = 0; i < r; i++) { // rows
            for (int j = 0; j < c; j++) { // columns
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.println("Input Matrix: ");
        for (int i = 0; i < r; i++) { // rows
            for (int j = 0; j < c; j++) { // columns
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Enter the rectangle coordinates (l1, r1) and (l2, r2): ");
        int l1 = sc.nextInt();
        int r1 = sc.nextInt();
        int l2 = sc.nextInt();
        int r2 = sc.nextInt();

        // int sum = findSumOfRectangle(matrix, l1, r1, l2, r2);
        int sum = findSumOfRectangle2(matrix, l1, r1, l2, r2);
        System.out.println("Sum of rectangle from (" + l1 + ", " + r1 + ") to (" + l2 + ", " + r2 + ") is: " + sum);


        
        sc.close();

    }
}
