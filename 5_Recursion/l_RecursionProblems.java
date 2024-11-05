// 1. Recursive Implementation of String to Integer (atoi) (LeetCode 8) - [https://leetcode.com/problems/string-to-integer-atoi/]
// 2. Pow(x, n) (LeetCode 50) - [https://leetcode.com/problems/powx-n/]
// 3. Count Good Numbers (LeetCode 1922) - [https://leetcode.com/problems/count-good-numbers/]
// 4. Sort a stack (GFG) - [https://www.geeksforgeeks.org/problems/sort-a-stack/1]
// 5. Reverse a Stack (GFG) - [https://www.geeksforgeeks.org/problems/reverse-a-stack/1]

public class l_RecursionProblems {

    // 1. Recursive Implementation of String to Integer (atoi) (LeetCode 8)
    
    // 2. Pow(x, n) (LeetCode 50)
    public double myPow(double x, int n) {
        if (n == 0) return 1; // base case

        // smaller subproblem
        double smallPow = myPow(x, n / 2);

        // if n is negative -> x^-n = 1 / x^n = (1 / x)^n
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }

        // if n is even -> x^n = x^(n/2) * x^(n/2)
        if (n % 2 == 0) return smallPow * smallPow;

        // if n is odd -> x^n = x^(n/2) * x^(n/2) * x
        else return smallPow * smallPow * x;
    }

    // 3. Count Good Numbers (LeetCode 1922)

    // 4. Sort a stack (GFG)

    // 5. Reverse a Stack (GFG)

}
