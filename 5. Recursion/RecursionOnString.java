// Notes: https://drive.google.com/file/d/1HEHOm9RbjyKG0nNNmxQnlElIuG7nD49O/view

// Recursion on Strings | Remove occurences

// 1. Remove all occurences of a character from the string.
// 2. Reverse a string using recursion.
// 3. Check if a string is palindrome or not.

import java.util.Scanner;

public class RecursionOnString {
    
    // iterative function to remove all occurences of a character from the string.
    static String remove(String str, char ch) {
        String ans = "";
        for(int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ch) {
                ans += str.charAt(i); // + for concatenation
            }
        }
        return ans;
    }

    // recursive function to remove all occurences of a character from the string.
    static String removeR(String str, char ch, int idx) {
        if (idx == str.length()) return ""; // base case
        String smallAns = removeR(str, ch, idx + 1); // recursive call
        char currChar = str.charAt(idx); // self work
        if (currChar == ch) {
            return smallAns;
        } else {
            return currChar + smallAns; // string concatenation is linear time operation => O(n)
        }
        
        // Time Complexity = No. of calls * Time taken by each call
        // T(n) = n * (c + n) = n * n = n^2 = O(n^2)
    }

    // Another method - without using idx
    static String removeRec(String str, char ch) {
        if (str.length() == 0) return ""; // base case
        String smallAns = removeRec(str.substring(1), ch); // recursive call => O(n)
        char currChar = str.charAt(0); // self work
        if (currChar == ch) {
            return smallAns;
        } else {
            return currChar + smallAns; // linear time operation => O(n)
        }

        // Time Complexity = No. of calls * Time taken by each call
        // T(n) = n * (n + n) = n * 2n = 2n^2 = O(n^2)
    }

    // iterative function to reverse a string
    static String reverse(String str) {
        String ans = "";
        for(int i = str.length() - 1; i >= 0; i--) {
            ans += str.charAt(i);
        }
        return ans;
    }

    // recursive function to reverse a string
    static String reverseRec(String str) { // O(n^2)
        if (str.length() == 0) return ""; // base case => O(1)
        String smallAns = reverseRec(str.substring(1)); // recursive call => O(n)
        return smallAns + str.charAt(0); // self work => O(n)

        // Time Complexity = No. of calls * Time taken by each call
        // T(n) = n * (n + n) = O(n^2)
    }

    // iterative function to check if a string is palindrome or not
    static boolean isPalindrome(String str) {
        int start = 0; // left pointer
        int end = str.length() - 1; // right pointer
        while(start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // recursive function to check if a string is palindrome or not
    static boolean isPalindromeRec(String str) {
        int start = 0;
        int end = str.length() - 1;
        if (start >= end) return true; // base case
        if (str.charAt(start) != str.charAt(end)) return false; // base case
        return isPalindromeRec(str.substring(start + 1, end)); // recursive call
    }


    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // String str = sc.nextLine();

        String str = "NotesNeo";
        // Index:     01234567

        // System.out.println(str);

        // for(int i = 0; i < str.length(); i++) {
        //     System.out.println(str.charAt(i));
        // }

        // System.out.println(str.substring(0, 5)); // Notes
        // System.out.println(str.substring(5)); // Neo

        // System.out.println(removeR(str, 'N', 0));
        System.out.println(removeRec(str, 'N'));

        // System.out.println(reverse(str));
        System.out.println(reverseRec(str));

        // Checking Palindrome
        String rev = reverseRec(str);
        // if (str.equals(rev)) {
        //     System.out.println("Palindrome");
        // } else {
        //     System.out.println("Not Palindrome");
        // }        

        System.out.println(str.equals(rev) ? "Palindrome" : "Not Palindrome");


        str = "abcba";
        System.out.println(isPalindromeRec(str));

    }

}
