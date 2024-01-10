import java.util.Arrays;

public class ArrayQuestions {
    public static void main(String[] args) {

        int[] arr = { 3, 2, 1, 5, 4 };
        // index :    0  1  2  3  4

        // Sum of all elements in an array
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i]; // sum += arr[i];
        }

        System.out.println("Sum of all elements in an array is: " + sum);

        // Find the largest element in an array
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }

        System.out.println("Largest element in an array is: " + max);

        // Find the smallest element in an array
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min)
                min = arr[i];
        }

        System.out.println("Smallest element in an array is: " + min);

        // Find the second largest element in an array
        int secondMax = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > secondMax && arr[i] < max)
                secondMax = arr[i];
        }

        System.out.println("Second largest element in an array is: " + secondMax);

        // Find the second smallest element in an array
        int secondMin = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < secondMin && arr[i] > min)
                secondMin = arr[i];
        }

        System.out.println("Second smallest element in an array is: " + secondMin);

        // Find the sum of all even elements in an array
        int evenSum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0)
                evenSum += arr[i]; // evenSum = evenSum + arr[i];
        }

        System.out.println("Sum of all even elements in an array is: " + evenSum);

        // Find the sum of all odd elements in an array
        int oddSum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0)
                oddSum += arr[i]; // oddSum = oddSum + arr[i];
        }

        System.out.println("Sum of all odd elements in an array is: " + oddSum);

        // Find the count of all even elements in an array
        int evenCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0)
                evenCount++;
        }

        System.out.println("Count of all even elements in an array is: " + evenCount);

        // Find the count of all odd elements in an array
        int oddCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0)
                oddCount++;
        }

        System.out.println("Count of all odd elements in an array is: " + oddCount);


        // Search an element in an array (Linear Search)
        arr = new int[] { 3, 2, 1, 5, 4 }; // re-initialize the array using new keyword

        int searchElement = 5;
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == searchElement) {
                index = i;
                break;
            }
        }

        System.out.println("Element " + searchElement + " found at index " + index);
        
        // Find the frequency of an element in an array
        arr = new int[] { 1, 2, 3, 2, 1, 2, 3, 2, 1 };
        int element = 2;
        int freq = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element)
                freq++;
        }

        System.out.println("Frequency of " + element + " is: " + freq);

        
        // Find the last occurrence of an element in an array
        arr = new int[] { 1, 2, 3, 2, 1, 2, 3, 2, 1 };
        element = 2;
        index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element) {
                index = i;
            }
        }

        System.out.println("Last occurrence of " + element + " is at index " + index);

        // Find the first occurrence of an element in an array
        arr = new int[] { 1, 2, 3, 2, 1, 2, 3, 2, 1 };
        element = 2;
        index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element) {
                index = i;
                break;
            }
        }

        System.out.println("First occurrence of " + element + " is at index " + index);


        // Count the number of elements strictly greater than value x
        arr = new int[] { 1, 3, 3, 2, 4, 5};
        int x = 2;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > x)
                count++;
        }

        System.out.println("Number of elements strictly greater than " + x + " is: " + count);


        // Check if an array is sorted or not
        arr = new int[] { 1, 2, 3, 4, 5 };
        boolean isSorted = true;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] < arr[i]) {
                isSorted = false;
                break;
            }
        }

        if (isSorted)
            System.out.println("Array is sorted");
        else
            System.out.println("Array is not sorted");


        // For a given array, print an array such that its first element is smallest and second element is largest
        arr = new int[] { 5, 8, 1, 3, 6, 2 };
        Arrays.sort(arr);
        System.out.println("Sorted array is: " + Arrays.toString(arr));

        System.out.println("Smallest element: " + arr[0]);
        System.out.println("Largest element: " + arr[arr.length - 1]);

        int [] ans = { arr[0], arr[arr.length - 1] };
        System.out.println("Array[Smallest, Largest]: " + Arrays.toString(ans));

    }
}
