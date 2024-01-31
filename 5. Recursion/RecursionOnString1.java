// Notes: https://drive.google.com/file/d/1dxvFs2a82b7VKVgDr1uh1Em11BLR6SR2/view

// Find Subsequences | Subsets

import java.util.ArrayList;

public class RecursionOnString1 {
    
    // 1. Given a string, return all its subsequences in an arraylist
    // Example for str = "abc" -> ["abc", "ab", "ac", "a", "bc", "b", "c", ""]

    static ArrayList<String> getSubsequences(String str) { // "abc"
        ArrayList<String> ans = new ArrayList<>();

        if ( str.length() == 0 ) { // base case
            ans.add("");
            return ans;
        }
    
        char ch = str.charAt(0); // a
        ArrayList<String> smallAns = getSubsequences(str.substring(1)); // ["bc", "b", "c", ""]

        // smallAns = ["bc", "b", "c", ""]
        // ans = ["bc", "abc", "b", "ab", "c", "ac", "", "a"]
        for ( String s : smallAns ) {
            ans.add(s); 
            ans.add(ch + s);
        }

        return ans;
    }

    // 2. Given a string, print all its subsequences
    // Example for str = "abc" -> "abc" "ab" "ac" "a" "bc" "b" "c" ""

    static void printSubsequences(String str, String ans) { // "abc", ""
        if ( str.length() == 0 ) { // base case
            System.out.println(ans);
            return;
        }

        char ch = str.charAt(0); // a
        String remString = str.substring(1); // "bc"

        printSubsequences(remString, ans + ch); // "bc", "a"
        printSubsequences(remString, ans); // "bc", ""
    }

    
    // 3. Given an array of integers, print sums of all subsets in it
    // Example for arr = [1, 2, 3] -> Subsets : [1, 2, 3] [1, 2] [1, 3] [1] [2, 3] [2] [3] []
    // Then, Sum of Subsets : 6 3 4 1 5 2 3 0

    static void sumOfSubsets(int[] arr, int idx, int sum) {
        if ( idx == arr.length ) {
            System.out.print(sum + " ");
            return;
        }

        sumOfSubsets(arr, idx + 1, sum + arr[idx]);
        sumOfSubsets(arr, idx + 1, sum);
    }

    public static void main(String[] args) {

        String str = "abc";

        System.out.println(getSubsequences(str));

        printSubsequences(str, "");

        int[] arr = {1, 2, 3};
        sumOfSubsets(arr, 0, 0);


    }

    

}
