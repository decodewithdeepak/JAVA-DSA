// Pascal

import java.util.Scanner;

public class PascalTriangle {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int r = sc.nextInt(); // rows

        int[][] arr = new int[r][r]; // Total number of elements: r * r

        for (int i = 0; i < r; i++) { // rows
            for (int j = 0; j <= i; j++) { // columns
                if (j == 0 || j == i) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
                }
            }
        }

        System.out.println("\nPascal Triangle: ");

        for (int i = 0; i < r; i++) { // rows
            for (int j = 0; j <= i; j++) { // columns
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        
        sc.close();

    }
}
