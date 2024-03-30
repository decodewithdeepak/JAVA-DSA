// Permutations of a given string - GFG (https://www.geeksforgeeks.org/problems/permutations-of-a-given-string2041/1)
// Time Complexity: O(N!), where N is the length of the string S.

import java.util.*;

public class PermutationString {

    public static List<String> findPermutation(String S) {
        List<String> ans = new ArrayList<>(); // List to store all permutations
        Set<String> set = new HashSet<>(); // Set to store unique permutations
        helper(S, "", ans, set);
        return ans;
    }

    public static void helper(String S, String curr, List<String> ans, Set<String> set) {
        if (S.equals("")) {
            if (!set.contains(curr)) { // Check if the permutation is unique
                ans.add(curr);
                set.add(curr); // Add to set to mark it as generated
            }
            return;
        }

        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            String left = S.substring(0, i);
            String right = S.substring(i + 1);
            String rest = left + right;
            helper(rest, curr + ch, ans, set);
        }
    }

    public static void main(String[] args) {
        String S = "ABC";
        List<String> ans = findPermutation(S);
        for (String s : ans) {
            System.out.print(s + " ");
        }

        System.out.println();

        S = "ABB";
        ans = findPermutation(S);
        for (String s : ans) {
            System.out.print(s + " ");
        }
    }
}
