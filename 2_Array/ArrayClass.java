// Inbuilt Array class in Java
// Methods of Array class:
// 1. toString() method - returns a string representation of the contents of the specified array.
// 2. equals() method - compares two arrays for equality.
// 3. fill() method - assigns the specified data type value to each element of the specified range of the specified array.
// 4. sort() method - sorts the specified array into ascending numerical order.
// 5. binarySearch() method - searches the specified array for the specified value using the binary search algorithm.

import java.util.Arrays;

public class ArrayClass {
    public static void main(String[] args) {
        // toString() method
        int[] arr = { 10, 20, 30, 40, 50 };
        System.out.println(Arrays.toString(arr)); // [10, 20, 30, 40, 50]

        // equals() method
        int[] arr1 = { 10, 20, 30, 40, 50 };
        int[] arr2 = { 10, 20, 30, 40, 50 };
        System.out.println(Arrays.equals(arr1, arr2)); // true

        // fill() method
        int[] arr3 = { 10, 20, 30, 40, 50 };
        Arrays.fill(arr3, 100);
        System.out.println(Arrays.toString(arr3)); // [100, 100, 100, 100, 100]

        // sort() method
        int[] arr4 = { 50, 40, 30, 20, 10 };
        Arrays.sort(arr4);
        System.out.println(Arrays.toString(arr4)); // [10, 20, 30, 40, 50]

        // binarySearch() method
        int[] arr5 = { 10, 30, 20, 40, 50 };
        Arrays.sort(arr5);
        System.out.println(Arrays.binarySearch(arr5, 30));
    }
}
