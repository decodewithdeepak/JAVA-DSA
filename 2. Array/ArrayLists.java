// Notes 20 : https://drive.google.com/file/d/13aXH0LqxSlJnIB1AKOMQz2ryQGHw8c2w/view
// Array List - Dynamic Array

import java.util.ArrayList;

public class ArrayLists {
    public static void main(String[] args) {
        
        // Wrapper Classes - Used to convert primitive data types into objects
        // Integer, Double, Character, Boolean, Float, Long, Short, Byte

        Integer i = Integer.valueOf(10);
        System.out.println(i);

        Float f = Float.valueOf(10.5f);
        System.out.println(f);

        // ArrayList - Array List is a class which is used to create dynamic arrays in Java
        // It means that the size of the array list can be increased or decreased as per requirement

        // Creating an array list
        ArrayList<Integer> list = new ArrayList<>();

        // Get size of the array list
        System.out.println(list.size()); // Initially size is 0
        
        // Adding elements to Array List (at the end)
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        
        // Get size of the array list
        System.out.println(list.size()); // Now size is 4

        // Print elements of Array List
        // using for loop
        for(int j = 0; j < list.size(); j++) {
            System.out.println(list.get(j));
        }

        // directly
        System.out.println(list);

        // Get element at a specific index
        System.out.println(list.get(2));

        // Adding element at a specific index
        list.add(1, 100);
        System.out.println(list);

        // Modifying element at a specific index
        list.set(2, 200);
        System.out.println(list);
        // set() vs add() - set replaces the element at the index, add adds the element at the index

        // Removing element at a specific index
        list.remove(3);
        System.out.println(list);

        // Removing element by value
        list.remove(Integer.valueOf(40)); // remove if exists else do nothing
        System.out.println(list);

        // Checking if an element exists
        System.out.println(list.contains(10));

        // Clearing the array list
        list.clear();
        System.out.println(list);

        // Checking if the array list is empty
        System.out.println(list.isEmpty());

        // Array List without specifying the data type
        // It can store any type of data

        ArrayList<Object> l1 = new ArrayList<>();
        l1.add(18);
        l1.add("Hello");
        l1.add(10.5f);
        l1.add(true);

        System.out.println(l1);



    }
}
