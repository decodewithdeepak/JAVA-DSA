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

    static int[][] generatePascalTriangle(int numRows) {
        int[][] triangle = new int[numRows][];
        for (int i = 0; i < numRows; i++) {
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

    // Find the nth row of Pascal's Triangle (1-based index)
    static int[] getNthRowOfPascalTriangle(int rowNum) {
        int[] row = new int[rowNum];
        row[0] = 1;
        for (int i = 1; i < rowNum; i++) {
            row[i] = row[i - 1] * (rowNum - i) / i;
        }
        return row;
    }

    // Find the element at the nth row and rth column in Pascal's Triangle (0-based index)
    // It is like finding nCr (n choose r)
    static int getElementInPascalTriangle(int n, int r) {
        // Bruteforce approach : nCr = n! / (r! * (n - r)!)
        // return factorial(n) / (factorial(r) * factorial(n - r));

        // Efficient approach : nCr = (n*(n-1)*(n-2)*...*(n-r+1)) / (r*(r-1)*(r-2)*...*1)
        return nCr(n, r);
    }

    // Finding nCr in minimal time complexity
    static int nCr(int n, int r) {
        long res = 1;
        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }
        return (int) res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Print Pascal's Triangle
        System.out.print("Enter the number of rows: ");
        int numRows = sc.nextInt(); // rows
        int[][] triangle = generatePascalTriangle(numRows);
        printMatrix(triangle);


        // Find the nth row of Pascal's Triangle
        System.out.print("Enter the row number: ");
        int rowNumber = sc.nextInt();
        int[] row = getNthRowOfPascalTriangle(rowNumber);
        for (int i = 0; i < rowNumber; i++) {
            System.out.print(row[i] + " ");
        }
        System.out.println();


        // Find the element at the nth row and rth column in Pascal's Triangle
        System.out.print("Enter the row and column number (0-based index): ");
        int r = sc.nextInt();
        int c = sc.nextInt();
        System.out.println(getElementInPascalTriangle(r, c));

        sc.close();
    }
}
