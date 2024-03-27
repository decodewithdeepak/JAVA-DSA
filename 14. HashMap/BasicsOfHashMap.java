// Notes : https://drive.google.com/file/d/1tsJJiaz4tD8TZQZO6fkfHvPefAOMeuYP/view

// Map Interface -> HashMap | LinkedHashMap | TreeMap

// HashMap is a associative array or dictionary which stores data in key-value pairs.
// It is unordered collection of key-value pairs.
// It internally uses a technique called Hashing or Hash Table.

// Value can be accessed its using key.
// The key should be unique but the value can be duplicated.
// It allows only one null key and multiple null values.
// HashMap is not synchronized. It is not thread-safe.

// Methods of HashMap : put(), putAll(), get(), remove(), clear(), containsKey(), containsValue(), keySet(), values(), entrySet(), isEmpty(), size(), etc.

// Time Complexity: O(1) for insertion, deletion, search operations.

import java.util.*;

public class BasicsOfHashMap {

    // HashMap Methods
    static void hashMapMethod() {

        // Create a HashMap (with key as String and value as Integer)
        HashMap<String, Integer> hm = new HashMap<>();

        // Add elements to the HashMap -> put(key, value)
        hm.put("Apple", 10);
        hm.put("Banana", 20);
        hm.put("Orange", 15);

        // Print the HashMap
        System.out.println(hm); // {Apple=10, Orange=15, Banana=20} => Unordered

        // Get the value associated with a key -> get(key)
        System.out.println(hm.get("Banana")); // 20 -> Value
        System.out.println(hm.get("Mango")); // null (if key not found)

        // Changing/Updating the value of a key -> put(key, value)
        hm.put("Banana", 25); // Update (Overwrite) the value of key "Banana"
        System.out.println(hm); // {Apple=10, Orange=15, Banana=25} => Overwritten

        hm.put("Mango", 30); // Add a new key-value pair if key not found
        System.out.println(hm); // {Apple=10, Orange=15, Banana=25, Mango=30} => Added unorderly

        // Add a new element only if the new key is not present already -> putIfAbsent(key, value)
        hm.putIfAbsent("Banana", 35); // Add a new key-value pair if key not found
        System.out.println(hm); // {Apple=10, Orange=15, Banana=25, Mango=30} => Not Added

        // Remove a key-value pair -> remove(key)
        System.out.println(hm.remove("Orange")); // 15 => Returns value
        System.out.println(hm); // {Apple=10, Banana=25, Mango=30} => Removed
        
        // System.out.println(hm.remove("Mango", 30)); // true => Returns boolean
        System.out.println(hm.remove("Grapes")); // null => If key not found

        // Check if a key exists -> containsKey()
        System.out.println(hm.containsKey("Apple")); // true

        // Check if a value exists -> containsValue()
        System.out.println(hm.containsValue(15)); // false

        // Size of the HashMap -> size()
        System.out.println(hm.size()); // 3

        // Check if the HashMap is empty -> isEmpty()
        System.out.println(hm.isEmpty()); // false


        // Get all the keys -> keySet()
        System.out.println(hm.keySet()); // [Apple, Banana, Mango]

        // Iterate over keys -> keySet()
        for (String key : hm.keySet()) {
            System.out.println(key);
        }

        // Get all the values -> values()
        System.out.println(hm.values()); // [10, 25, 30]

        // Iterate over values -> values()
        for (int value : hm.values()) {
            System.out.println(value);
        }

        // Iterate over key-value pairs using keySet()
        for (String key : hm.keySet()) {
            System.out.println(key + " = " + hm.get(key));
        }

        // Iterate over key-value pairs using entrySet()
        // for (Map.Entry<String, Integer> entry : hm.entrySet()) {
        for (var entry : hm.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        // Clear the HashMap
        hm.clear();
        System.out.println(hm); // {}
    }
    

    // Example: Create a HashMap using Java HashMap class to store the following pairs(Person, Age) and display them.
    public static void hashMapExample() {
        // Create a HashMap
        HashMap<String, Integer> hm = new HashMap<>();

        // Add key-value pairs -> put(key, value)
        hm.put("Deepak", 21);
        hm.put("Sheetal", 20);
        hm.put("Divya", 17);
        hm.put("Sapna", 13);
        hm.put("Ritvik", 10);

        // Display key-value pairs using entrySet()
        for (var i : hm.entrySet()) {
            System.out.println("Age of " + i.getKey() + " is " + i.getValue());
        }

        System.out.println();
        
        // Display key-value pairs using keySet()
        for (var i : hm.keySet()) {
            System.out.println("Age of " + i + " is " + hm.get(i));
        }
    }
    
    // Question: Most frequent element in an array
    public static void mostFrequentElement(int[] arr) {
        // Key -> Element, Value -> Frequency
        HashMap<Integer, Integer> freq = new HashMap<>();
        
        for (int e : arr) {
            if (freq.containsKey(e)) {
                freq.put(e, freq.get(e) + 1);
            } else {
                freq.put(e, 1);
            }
        }

        System.out.println(freq); // {1=2, 5=4, 6=3, 4=2, 7=1}
        
        int maxFreq = 0;
        int ansKey = 0;

        for (var i : freq.entrySet()) {
            if (i.getValue() > maxFreq) {
                maxFreq = i.getValue();
                ansKey = i.getKey();
            }
        }

        System.out.println("Most frequent element is " + ansKey + " with frequency " + maxFreq);
    }

    public static void main(String[] args) {

        // hashMapMethod();

        // hashMapExample();

        int[] arr = {1, 5, 5, 6, 1, 6, 4, 5, 7, 4 , 5, 6};
        mostFrequentElement(arr);

        
    }
}
