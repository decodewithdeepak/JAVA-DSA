// Notes 12 : https://drive.google.com/file/d/1x9TPeFrH5Nwvz8sqP_UrwKWhsvTwXaSN/view

// Array : A collection of similar type of elements stored in contiguous memory locations.
// Array follows zero based indexing.
// Types of array : 1D, 2D, 3D, ...
// An array can be created using a new keyword in Java.

 //Types of array : Single Dimensional Array (1D), Multi Dimensional Array (2D, 3D, ...)
    // 1. Single Dimensional Array - One dimensional or linear array
    // 2. Multi Dimensional Array - Two dimensional or matrix array, Three dimensional array, etc.


import java.util.*;

public class Array {
    public static void main(String[] args) {
      // Single Dimensional Array (1D)
        // One dimensional or linear array

        // Syntax:
        // datatype[] array_name = new datatype[size];

        // 1D array declaration
        int[] arr1 = new int[3];
        // int arr1[] = new int[3];

        // 1D array initialization
        arr1[0] = 10;
        arr1[1] = 20;
        arr1[2] = 30;

        // 1D array declaration and initialization
        int[] arr2 = { 10, 20, 30 }; // Array Literal

        // Length of an array
        System.out.println("Length of arr2 array is: " + arr2.length);

        System.out.println("Traversing through the array:");
        
        //Traversing through the array using for loop
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(arr2[i]);
        }

        // Traversing through the array using for-each loop
        for (int i : arr2) {
            System.out.println(i);
        }

        // Traversing through the array using while loop
        int x = 0;
        while (x < arr2.length) {
            System.out.println(arr2[x]);
            x++;
        }


        // 1D array declaration and initialization using Scanner class
        // Taking array input from the user
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the size of array : ");
        int n = sc.nextInt();

        int[] arr3 = new int[n];

        System.out.println("Enter the elements in array: ");
        for (int i = 0; i < n; i++) {
            arr3[i] = sc.nextInt();
        }

        System.out.println("Elements in the array are: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr3[i] + " ");
        }

        sc.close();

        // Integer Array
        System.out.println("\n\nInteger Array:");
        int [] ages = new int[3]; // ages[0] = 0, ages[1] = 0, ages[2] = 0
        ages[0] = 25;
        ages[1] = 30;
        ages[2] = 15;
        // ages[3] = 40; // Error: ArrayIndexOutOfBoundsException
       
        System.out.println(ages[0]);
        System.out.println(ages[1]);
        System.out.println(ages[2]);    
    
        // Float Array
        System.out.println("\nFloat Array:");
        float [] weights = new float[3]; // weights[0] = 0.0, weights[1] = 0.0, weights[2] = 0.0
        weights[0] = 25.5f;
        weights[1] = 30.5f;
        weights[2] = 15.5f;

        System.out.println(weights[0]);
        System.out.println(weights[1]);
        System.out.println(weights[2]);

        // Character Array
        System.out.println("\nCharacter Array:");
        String [] names = new String[3]; // names[0] = null, names[1] = null, names[2] = null
        names[0] = "Deepak";
        names[1] = "Krishna";
        names[2] = "Shilpa";

        System.out.println(names[0]);
        System.out.println(names[1]);
        System.out.println(names[2]);

        
    }

}