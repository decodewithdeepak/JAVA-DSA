// Notes 13 : https://drive.google.com/file/d/1uKhLKd06R7jxFN_XZV7en0VvQaC8QM17/view
// Array Reference in JAVA (Stack and Heap)

// Array is a reference type in Java. It means that array variables store the address of the memory location where the actual array is stored.
// Array variables are stored in stack memory and actual arrays are stored in heap memory.
// When we pass an array to a method, we are actually passing the address of the array in the memory (reference) and not the array itself.

import java.util.Arrays;

public class ArrayReference {

    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

     static void change(int a, int[] arr) {
        a = 15;
        arr[0] = 25;
    }

    public static void main(String[] args) {
      
        int a = 10; // Stack (Primitive)
        int [] arr = new int[1]; // Heap (Reference)
        arr[0] = 20;
        change(a, arr);
        System.out.println(a); // 10
        System.out.println(arr[0]); // 20


        int[] arr1 = new int[3];
        arr1[0] = 10;
        arr1[1] = 20;
        arr1[2] = 30;

        // System.out.println("\nShallow Copy:");
        // int[] arr2 = arr1; // trying to copy arr1 into arr2 will be copying the address of arr1 into arr2 (Shallow Copy)

        // System.out.println("Address of arr1: " + arr1);
        // System.out.println("Address of arr2: " + arr2);

        // System.out.println("Original arr1:");
        // printArray(arr1);

        // System.out.println("Copied arr2:");
        // printArray(arr2);

        // // Changing some values in arr2
        // arr2[0] = 100;
        // arr2[1] = 200;

        // System.out.println("Original arr1 after changing arr2:");
        // printArray(arr1);

        // System.out.println("Copied arr2 after changing arr2:");
        // printArray(arr2);

        // Original arr1 is also changed because arr1 and arr2 are pointing to the same
        // memory location. They have the same address in the stack memory.

        // Reference ki copy banti h stack me, actual array ki copy nhi banti h heap me.
        // Nayi memory allocate nhi hoti h heap me. Wo tav hogi jab new keyword use krenge.
        
        // This is called Shallow Copy. Only the reference(address) is copied and not the actual array.

        // To copy the actual array, we use Deep Copy by using the clone() method.

        System.out.println("\nDeep Copy:");
        
        int[] arr3 = arr1.clone(); // Deep Copy (Actual array is copied in heap memory)
        
        System.out.println("Address of arr1: " + arr1);
        System.out.println("Address of arr3: " + arr3);

        System.out.println("Original arr1:");
        printArray(arr1);

        System.out.println("Copied arr3:");
        printArray(arr3);

        // Changing some values in arr3
        arr3[0] = 1000;
        arr3[1] = 2000;

        System.out.println("Original arr1 after changing arr3:");
        printArray(arr1);

        System.out.println("Copied arr3 after changing arr3:");
        printArray(arr3);

        // Original arr1 is not changed because arr1 and arr3 are pointing to the different memory locations.
        // They have different addresses in the stack memory.

        // This is called Deep Copy. Actual array is copied.
    
        // We can also use the copyOf() method to copy the array.
        int[] arr4 = Arrays.copyOf(arr1, arr1.length);
        System.out.println("\nCopied arr4:");
        printArray(arr4);

        // We can also use the copyOfRange() method to copy the array.
        int[] arr5 = Arrays.copyOfRange(arr1, 0, arr1.length);
        System.out.println("Copied arr5:");
        printArray(arr5);


    }

}
