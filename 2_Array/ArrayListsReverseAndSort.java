// Reverse the elements in an ArrayList

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListsReverseAndSort {

    static void reverseList(ArrayList<Integer> list) {
        int start = 0; // start index
        int end = list.size() - 1; // end index

        while(start < end) {
            int temp = list.get(start); // temp = start
            list.set(start, list.get(end)); // start = end
            list.set(end, temp); // end = temp

            start++;
            end--;
        }
    }
    
    public static void main(String[] args) {
        
        ArrayList<Integer> list = new ArrayList<>();
        list.add(40);
        list.add(20);
        list.add(50);
        list.add(10);
        list.add(30);

        System.out.println("Original ArrayList: " + list);

        // reverseList(list);

        Collections.reverse(list); // Using Collections class

        System.out.println("Reversed ArrayList: " + list);

        System.out.println("Sorted ArrayList in ascending order: ");
        Collections.sort(list); // Using Collections class
        System.out.println(list);

        System.out.println("Sorted ArrayList in descending order: ");
        Collections.sort(list, Collections.reverseOrder()); // comparator - reverseOrder()
        System.out.println(list);


        // Question: Sort the ArrayList of Strings
        ArrayList<String> l1 = new ArrayList<>();
        l1.add("Mango");
        l1.add("Apple");
        l1.add("Banana");
        l1.add("Pineapple");
        l1.add("Papaya");

        System.out.println("\nOriginal ArrayList: " + l1);

        System.out.println("Sorted ArrayList in ascending order: ");
        Collections.sort(l1);
        System.out.println(l1);

        System.out.println("Sorted ArrayList in descending order: ");
        Collections.sort(l1, Collections.reverseOrder());
        System.out.println(l1);



    }

}
