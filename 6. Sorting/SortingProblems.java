// Notes: https://drive.google.com/file/d/1KIXBqHy988U-QjxwK-s2-6Z2cjzcpYXO/view

// Problems based on Sorting

// 1. Move all 0's to end, maintaining the relative order of non-zero elements.
// Example: Input: [0, 5, 0, 3, 4, 2] -> Output: [5, 3, 4, 2, 0, 0]

// 2. Sort the names of fruits in lexicographical (dictionary) order.
// Example: Input: ["Apple", "Banana", "Pineapple", "Papaya"] -> Output: ["Apple", "Banana", "Papaya", "Pineapple"]

public class SortingProblems {

    static void moveZerosToEnd(int[] arr) { // Bubble Sort
        int n = arr.length;
        for (int i = 0; i < n -1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] == 0 && arr[j + 1] != 0) {
                    // swap arr[j] and arr[j + 1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    static void sortFruits(String[] fruits) { // Selection Sort
        int n = fruits.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (fruits[j].compareTo(fruits[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            // swap fruits[i] and fruits[minIndex]
            String temp = fruits[i];
            fruits[i] = fruits[minIndex];
            fruits[minIndex] = temp;
        }
    }

    
    public static void main(String[] args) {
        
        // Problem 1: Move all 0's to end, maintaining the relative order.
        int[] arr = { 0, 5, 0, 3, 4, 2 };
        moveZerosToEnd(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        
        // Problem 2: Sort the names of fruits in lexicographical order.
        String[] fruits = { "Apple", "Banana", "Pineapple", "Papaya" };
        sortFruits(fruits);
        for (String fruit : fruits) {
            System.out.print(fruit + " ");
        }

    }
    
}