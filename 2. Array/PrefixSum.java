// Problems based on prefix sum / running sum

public class PrefixSum {

    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    static int[] makePrefixSumArray(int[] arr) {
        int n = arr.length;

        // int[] prefixSum = new int[n];
        // prefixSum[0] = arr[0];

        // for (int i = 1; i < n; i++) {
        // prefixSum[i] = prefixSum[i-1] + arr[i];
        // }

        // return prefixSum;

        // Without creating a new array
        for (int i = 1; i < n; i++) {
            arr[i] = arr[i - 1] + arr[i];
        }

        return arr;

    }

    static boolean equalSumPartition(int[] arr) {
        int totalSum = 0;
        for (int i = 0; i < arr.length; i++) {
            totalSum += arr[i];
        }

        int prefixSum = 0;
        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];
            int suffixSum = totalSum - prefixSum;
            if (prefixSum == suffixSum) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        // Given an array of integers, return the prefix sum array.
        int[] arr = { 2, 1, -3, 4, 5 };

        int[] prefixSum = makePrefixSumArray(arr);
        printArray(prefixSum);

        // Program to check if an array can be partitioned into two sub-arrays with equal sum
        // It means check that the prefix sum of a part of the array is equal to the suffix sum of the rest of the array
        arr = new int[] { 15, 5, 6, 4, 8, 2 };
        // Prefix sum array: 15, 20, 26, 30, 38, 40
        // Suffix sum array: 40, 25, 20, 14, 10, 2

        System.out.println(equalSumPartition(arr));

    }
}
