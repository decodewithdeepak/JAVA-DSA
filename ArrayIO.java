// Notes 12 : https://drive.google.com/file/d/1x9TPeFrH5Nwvz8sqP_UrwKWhsvTwXaSN/view

// Array : A collection of similar type of elements stored in contiguous memory locations.

import java.util.*;

public class ArrayIO {
    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);

        System.out.print("Enter the size of array : ");
        int n = scn.nextInt();
        int arr[] = new int[n];
        // int[] arr = new int[n];

        System.out.println("Enter the elements in array...");
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        System.out.println("Printing the elements of array...");
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
        
        scn.close();
    }
}

