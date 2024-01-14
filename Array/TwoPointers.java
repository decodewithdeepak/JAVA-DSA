// Notes 16 : https://drive.google.com/file/d/1vR6tOK8h0EZhPCr7maqYA3GmbBusihDQ/view

// Problems based on two-pointer approach

public class TwoPointers {

    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    static void sortZeroesAndOnes(int[] arr) {
        // int n = arr.length;
        // int zeroes = 0;
        // // Count the number of zeroes
        // for (int i = 0; i < n; i++) {
        //     if (arr[i] == 0) {
        //         zeroes++;
        //     }
        // }

        // // 0 to zeroes-1 : 0s, zeroes to n-1 : 1s
        // for (int i = 0; i < n; i++) {
        //     if (i < zeroes) {
        //         arr[i] = 0;
        //     } 
        //     else {
        //         arr[i] = 1;
        //     }

        // }

        // Two-pointer approach
        int i = 0; // left pointer
        int j = arr.length - 1; // right pointer

        while (i < j) {
            if (arr[i] == 1 && arr[j] == 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                i++;
                j--;
            } 
            else if (arr[i] == 0) {
                i++;
            } 
            else if (arr[j] == 1) {
                j--;
            }
        }

    }

    static void sortArrayByParity(int[] arr) {
        int i = 0; // left pointer
        int j = arr.length - 1; // right pointer

        while (i < j) {
            if (arr[i] % 2 == 1 && arr[j] % 2 == 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                i++;
                j--;
            } 
            else if (arr[i] % 2 == 0) {
                i++;
            } 
            else if (arr[j] % 2 == 1) {
                j--;
            }
        }
    }

    static int[] sortedSquares(int[] arr) {
        int n = arr.length;
        int[] squares = new int[n];
        int i = 0; // left pointer
        int j = n - 1; // right pointer
        int k = n - 1; // squares array pointer

        while (i <= j) {
            if (arr[i] * arr[i] > arr[j] * arr[j]) {
                squares[k] = arr[i] * arr[i];
                i++;
            } 
            else {
                squares[k] = arr[j] * arr[j];
                j--;
            }
            k--;
        }

        return squares;
    }


    public static void main(String[] args) {

        // Sort an array consisting of only 0s and 1s
        int[] arr = { 0, 1, 0, 1, 1, 1, 0, 0, 0, 1 };
        sortZeroesAndOnes(arr);
        printArray(arr);


        // Given an array of integers, move all the integers at the beginning of the array followed by all the odd integers. The relative order of odd or even integers doesn't matter. Return an array that satisfies this condition.
        arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8 };
        sortArrayByParity(arr);
        printArray(arr);


        // Given an array sorted in non-decreasing order, return an array of squares of each number sorted in non-decreasing order.
        arr = new int[] { -4, -2, -1, 0, 3, 5 };
        int[] squares = sortedSquares(arr);
        printArray(squares);
        

    }
}
