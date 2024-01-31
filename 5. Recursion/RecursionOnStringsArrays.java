// Notes: https://drive.google.com/file/d/1Zl3JY_MRoYaNrTGfs6rM2PdZlNjH3pv-/view

// Problem 01 : Frog Jump
// There are N stones, numbered 1,2,...,N. For each i (1 ≤ i ≤ N), the height of Stone i is hi. There is a frog who is initially on Stone 1. 
// He will repeat the following action some number of times to reach Stone N:
// If the frog is currently on Stone i, jump to Stone i+1 or Stone i+2. Here, a cost of |hi - hj| is incurred, where j is the stone to land on.
// Find the minimum possible total cost incurred before the frog reaches Stone N.
// Input n = 4, h = [10, 30, 40, 20] -> Output = 30
// Explanation: If we follow the path 1 → 2 → 4, the total cost incurred would be |10−30| + |30−20| = 30.


// Problem 02 : Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
// Return the answer in any order.
// A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
// Input: digits = "23" -> Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]


public class RecursionOnStringsArrays {
    
    static int minCost(int[] h, int idx) {
        if ( idx == h.length - 1 ) return 0;

        int op1 = Math.abs(h[idx] - h[idx + 1]) + minCost(h, idx + 1);
        if ( idx == h.length -2) return op1;

        int op2 = Math.abs(h[idx] - h[idx + 2]) + minCost(h, idx + 2);

        return Math.min(op1, op2);

        // Time Complexity = Total recursive calls * Time taken by each call
        // T(n) = 2^n * O(1) = O(2^n)
    }


    static void combination(String dig, String [] kp, String res){

        if ( dig.length() == 0 ) {
            System.out.print(res + " ");
            return;
        }

        int currNum = dig.charAt(0) - '0'; // 2
        String currChoices = kp[currNum]; // "abc"

        for ( int i = 0; i < currChoices.length(); i++ ) {
            combination(dig.substring(1), kp, res + currChoices.charAt(i));
        }

    }


    public static void main(String[] args) {
        
        // Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        // int[] h = new int[n];
        // for ( int i = 0; i < n; i++ ) {
        //     h[i] = sc.nextInt();
        // }

        int[] h = {10, 30, 40, 20};

        System.out.println(minCost(h, 0));


        String dig = "23";
        String[] kp = {"" , "" , "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        // Index:      0    1      2      3      4      5      6      7       8      9

        combination(dig, kp, "");

        

    }

}
