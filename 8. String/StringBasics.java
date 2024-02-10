// String in Java -
// String is a sequence of characters. 
// In Java, objects of String are immutable which means a constant and cannot be changed once created.

import java.util.Scanner;

public class StringBasics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // char[] arr = new char[10]; // Array of characters
        
        // String Declaration and Initialization
        String str = "Hello Decoders"; // String Literal
        System.out.println(str);

        // Taking input from the user
        // String str = sc.next(); // reads only one word
        // String str = sc.nextLine(); // reads the whole line
        // System.out.println(str);

        // length() method - returns the length of the string
        System.out.println(str.length()); // 14

        // charAt() method - returns the character at the specified index
        System.out.println(str.charAt(0)); // H
        System.out.println(str.charAt(6)); // D

        // indexOf() method
        System.out.println(str.indexOf('o')); // 4

        // compareTo() method - compares two strings lexicographically
        String str1 = "abc";
        String str2 = "abc";
        String str3 = "dac";
        System.out.println(str1.compareTo(str2)); // 0
        System.out.println(str1.compareTo(str3)); // < 0
        System.out.println(str3.compareTo(str1)); // > 0

        // equals() method - compares the content of the string (== compares the reference of the string)
        System.out.println(str.equals("Hello Decoders")); // true
        System.out.println(str.equals("hello decoders")); // false

        // contains() method - checks if the string contains the specified sequence of char values
        System.out.println(str.contains("Hell")); // true
        System.out.println(str.contains("Coder")); // false

        // startsWith() method - checks if the string starts with the specified prefix
        System.out.println(str.startsWith("He")); // true
        System.out.println(str.startsWith("coders")); // false

        // endsWith() method - checks if the string ends with the specified suffix
        System.out.println(str.endsWith("coders")); // true
        System.out.println(str.endsWith("Decode")); // false

        // toUpperCase() method and toLowerCase() method
        System.out.println(str.toUpperCase()); // HELLO DECODERS
        System.out.println(str.toLowerCase()); // hello decoders

        // replace() method - replaces all occurrences of a character with another character
        System.out.println(str.replace('l', 'L')); // HeLLo Decoders
        System.out.println(str.replace("Hello", "Hi")); // Hi Decoders

        // concat() method - concatenates the specified string to the end of this string
        System.out.println(str.concat(" Welcome")); // Hello Decoders Welcome

        // String + int/char/string
        String s = "abc";
        // s = s + "xyz";
        s += "xyz";
        s+= 10;
        System.out.println(s);
        System.out.println("abc" + 10 + 20); // abc1020
        System.out.println(10 + 20 + "abc"); // 30abc
        System.out.println("abc" + (10 + 20)); // abc30

        // substring() method - returns a part of the string
        System.out.println(str.substring(6)); // Decoders
        System.out.println(str.substring(6, 11)); // Decode

        // trim() method - eliminates leading and trailing spaces
        String s1 = "  Hello Decoders  ";
        System.out.println(s1.trim()); // Hello Decoders

        // split() method - splits the string based on the given regular expression
        String s2 = "Hello,Decoders";
        String[] arr = s2.split(",");
        for (String i : arr) {
            System.out.println(i);
        }

        // toCharArray() method - converts the string into a sequence of characters
        char[] ch = str.toCharArray();
        for (char c : ch) {
            System.out.print(c + " ");
        }

        System.out.println();

        // Interning and new
        // Interning is done by JVM to save memory.
        String st1 = "Hello";
        String st2 = "Hello";
        String st3 = new String("Hello");
        System.out.println(st1 == st2); // true - st1 and st2 are pointing to the same memory location
        System.out.println(st1 == st3); // false - st3 is pointing to a different memory location
        System.out.println(st1.equals(st3)); // true - content is same

        // Immutability of String - Change in the value of the string will create a new string
        String x = "Hello";
        // x.charAt(0) = 'M'; // Error - String is immutable
        // x = "Mello"; // It is not changing the value of x, it is creating a new string and x is pointing to the new string

        // Hello -> Heylo - replace 'l' with 'y'
        x = x.substring(0, 2) + "y" + x.substring(3);
        System.out.println(x); // Heylo - new string is created and x is pointing to the new string




        sc.close();

    }
}
