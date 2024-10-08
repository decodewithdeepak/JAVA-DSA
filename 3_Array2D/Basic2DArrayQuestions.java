// 1. Sum of all elements in a 2D array
// 2. Sum of each row in a 2D array
// 3. Sum of each column in a 2D array
// 4. Sum of diagonal elements in a 2D array


public class Basic2DArrayQuestions {

    // 1. Sum of all elements in a 2D array
    public static int sumOfAllElements(int[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) { // rows
            for (int j = 0; j < arr[i].length; j++) { // columns
                sum += arr[i][j];
            }
        }
        return sum;
    }

    // 2. Sum of each row in a 2D array
    public static void sumOfEachRow(int[][] arr) {
        for (int i = 0; i < arr.length; i++) { // rows
            int sum = 0;
            for (int j = 0; j < arr[i].length; j++) { // columns
                sum += arr[i][j];
            }
            System.out.println("Sum of row " + i + " is: " + sum);
        }
    }

    // 3. Sum of each column in a 2D array
    public static void sumOfEachColumn(int[][] arr) {
        for (int i = 0; i < arr[0].length; i++) { // columns
            int sum = 0;
            for (int j = 0; j < arr.length; j++) { // rows
                sum += arr[j][i];
            }
            System.out.println("Sum of column " + i + " is: " + sum);
        }
    }

    // 4. Sum of diagonal elements in a 2D array
    public static int sumOfDiagonalElements(int[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) { // rows
            for (int j = 0; j < arr[i].length; j++) { // columns
                if (i == j) {
                    sum += arr[i][j];
                }
            }
        }
        return sum;
    }
    
}
