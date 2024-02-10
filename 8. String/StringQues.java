// String related questions

import java.util.Scanner;

public class StringQues {

    // 1. Print all substrings of a given string.
    public static void printAllSubstrings(String str) { // "abcd"
        int n = str.length(); // 4
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                System.out.println(str.substring(i, j));
            }
        }
    }


    // 2. Toggling the case of each character in a string.
    public static String toggleCase(String st) {
        // ASCII value of 'A' = 65, 'a' = 97 and the difference is 32
        String ans = "";
        for (int i = 0; i < st.length(); i++) {
            char ch = st.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                ans += (char) (ch + 32);
            } else {
                ans += (char) (ch - 32);
            }
        }
        return ans;
    }

    // Another Method Using StringBuilder
    public static StringBuilder toggleCaseSB(StringBuilder sb) {
        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                sb.setCharAt(i, (char) (ch + 32));
            } else {
                sb.setCharAt(i, (char) (ch - 32));
            }
        }
        return sb;
    }


    // 3. Count the number of palindromic substrings in a string.
    public static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static int countPalindromicSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                if (isPalindrome(s.substring(i, j))) {
                    count++;
                }
            }
        }
        return count;
    }

    // 4. Reverse each word in a sentence.
    public static String reverseEachWord(String str) {
        String[] words = str.split(" "); // Split the sentence into words
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            StringBuilder temp = new StringBuilder(word);
            sb.append(temp.reverse());
            sb.append(" ");
        }
        return sb.toString();
    }

    // Without using StringBuilder
    public static String reverseEachWordSB(String str) {
        String[] words = str.split(" "); // Split the sentence into words
        String ans = "";
        for (String word : words) {
            String temp = "";
            for (int i = word.length() - 1; i >= 0; i--) {
                temp += word.charAt(i);
            }
            ans += temp + " ";
        }
        return ans;
    }


    // 5. Compress the given String into a shorter string
    // Input: aaabbbbcdddee -> Output: a3b4cd3e2
    public static String compressString(String s) {
        String ans = "" + s.charAt(0);
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            char curr = s.charAt(i);
            char prev = s.charAt(i - 1);
            if (curr == prev) {
                count++;
            } else {
                if (count > 1) {
                    ans += count;
                }
                ans += curr;
                count = 1;
            }
        }
        if (count > 1) {
            ans += count;
        }
        return ans;
    }

    // Using StringBuilder
    public static String compressStringSB(String s) {
        StringBuilder ans = new StringBuilder();
        ans.append(s.charAt(0));
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            char curr = s.charAt(i);
            char prev = s.charAt(i - 1);
            if (curr == prev) {
                count++;
            } else {
                if (count > 1) {
                    ans.append(count);
                }
                ans.append(curr);
                count = 1;
            }
        }
        if (count > 1) {
            ans.append(count);
        }
        return ans.toString();
    }

    // 6. Return the length of the compressed string (LeetCode Medium) - https://leetcode.com/problems/string-compression/
    // Input: ["a","a","b","b","b", "d", "c","c"] -> Output: ["a","2","b","3,"d","c","2"] -> Return 7
    public static int compress(char[] chars) {
        StringBuilder ans = new StringBuilder();
        ans.append(chars[0]);
        int count = 1;
        for (int i = 1; i < chars.length; i++) {
            char curr = chars[i];
            char prev = chars[i - 1];
            if (curr == prev) {
                count++;
            } else {
                if (count > 1) {
                    ans.append(count);
                }
                ans.append(curr);
                count = 1;
            }
        }
        if (count > 1) {
            ans.append(count);
        }
        for (int i = 0; i < ans.length(); i++) {
            chars[i] = ans.charAt(i);
        }
        return ans.length();
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 1. Print all substrings of a given string.
        String str = "abcd";
        printAllSubstrings(str); // a, ab, abc, abcd, b, bc, bcd, c, cd, d

        // 2. Toggling the case of each character in a string.
        // String st = sc.nextLine();
        String st = "NotesNeo";
        System.out.println(toggleCase(st)); // nOTESnEO

        // Using StringBuilder
        // StringBuilder sb = new StringBuilder(sc.nextLine());
        StringBuilder sb = new StringBuilder("NotesNeo");
        System.out.println("Original String: " + sb);
        System.out.println("Toggled String: " + toggleCaseSB(sb));

        // 3. Count the number of palindromic substrings in a string.
        String s = "abc";
        // printAllSubstrings(s); // a, ab, abc, b, bc, c
        // Palindromic Substrings: a, b, c
        System.out.println(countPalindromicSubstrings(s)); // 3

        // 4. Reverse each word in a sentence.
        String str1 = "Welcome to NotesNeo";
        System.out.println(reverseEachWord(str1)); // emocleW ot oeNsetoN
        // System.out.println(reverseEachWordSB(str1)); // emocleW ot oeNsetoN

        // 5. Compress the given String
        String s1 = "aaabbbbcdddee";
        // System.out.println(compressString(s1)); // a3b4cd3e2
        System.out.println(compressStringSB(s1)); // a3b4cd3e2

        // 6. Return the length of the compressed string
        char[] chars = {'a', 'a', 'b', 'b', 'b', 'd', 'c', 'c'};
        System.out.println(compress(chars)); // 7


        sc.close();
    }
}
