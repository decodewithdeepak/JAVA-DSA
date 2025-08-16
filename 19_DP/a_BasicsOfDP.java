// Dynamic Programming

// Dynamic Programming (DP) solves problems by breaking them into overlapping subproblems and storing their results to avoid redundant calculations. DP is useful for optimization and reduces time complexity from exponential to polynomial in many cases. 
// Implemented using either a top-down approach (memoization) or a bottom-up approach (tabulation).
// Common examples: Fibonacci, factorial, knapsack, and longest common subsequence.

class a_BasicsOfDP {

    // Function to calculate Fibonacci number using DP
    static int fibonacci(int n) {
        if (n <= 1) return n;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // Function to calculate factorial using DP
    static int factorial(int n) {
        if (n == 0 || n == 1) return 1;
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = i * dp[i - 1];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        // 1. Fibonacci Sequence using Dynamic Programming
        int n = 10; // Calculate the 10th Fibonacci number
        System.out.println("Fibonacci of " + n + ": " + fibonacci(n));

        // 2. Factorial using Dynamic Programming
        int m = 5; // Calculate the factorial of 5
        System.out.println("Factorial of " + m + ": " + factorial(m));
    }
    
}