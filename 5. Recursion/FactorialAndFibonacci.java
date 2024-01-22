// Notes : https://drive.google.com/file/d/1TXtmw0Lx8Pb3M5vWz3HO82zQer86Ghon/view

// Solving Factorial and Fibonacci Problems by Recursion

import java.util.Scanner;

public class FactorialAndFibonacci {

    static int factorial(int n) {
        // base case - halting condition
        if (n == 0) return 1;
        
        // // smaller subproblem - recursive call
        // // recursion relation -> n! = (n-1)! * n
        // int smallAns = factorial(n - 1);

        // // big problem - self work
        // int ans = n * smallAns; // n * factorial(n-1)

        // return ans;

        return n * factorial(n - 1); // one liner
    }

    static int fibonacci(int n) {
        // base case - halting condition
        if (n == 0 || n == 1) return n;

        // // smaller subproblem - recursive call
        // // recursion relation -> fibonacci(n) = fibonacci(n-1) + fibonacci(n-2)
        // int prev1 = fibonacci(n - 1);
        // int prev2 = fibonacci(n - 2);

        // // big problem - self work
        // int ans = prev1 + prev2; // fibonacci(n-1) + fibonacci(n-2)

        // return ans;

        return fibonacci(n - 1) + fibonacci(n - 2); // one liner
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Program to find factorial of a number using recursion
        System.out.println("Enter a number : ");
        int n = sc.nextInt();

        System.out.println("Factorial : " + factorial(n));

        // Recursion Tree for n = 4
        // factorial(4) -> factorial(3) -> factorial(2) -> factorial(1) -> factorial(0)
        // factorial(0) returns 1
        // factorial(1) returns 1 * 1 = 1
        // factorial(2) returns 2 * 1 = 2
        // factorial(3) returns 3 * 2 = 6
        // factorial(4) returns 4 * 6 = 24
        
        // Time Complexity = No of recursive calls * Time taken in each recursive call
        // No of recursive calls = n+1 (0 to n) = n
        // Time taken in each recursive call = constant
        // T(n) = n * c = O(n) - Linear Time Complexity

        // Space Complexity = No of stack frames * Space taken by each stack frame
        // No of stack frames = No of recursive calls = n+1 (0 to n) = n
        // Space taken by each stack frame = constant
        // S(n) = n * c = O(n) - Linear Space Complexity


        // Program to find nth Fibonacci number using recursion
        System.out.println("\nEnter the position of Fibonacci number : ");
        n = sc.nextInt();

        System.out.println("Fibonacci number : " + fibonacci(n));

        // Program to print Fibonacci Series using recursion
        System.out.println("\nFibonacci Series : ");
        for (int i = 0; i <= n; i++) {
            System.out.print(fibonacci(i) + " ");
        }

        // Recursion Tree for n = 4
        // fibonacci(4) -> fibonacci(3) -> fibonacci(2) -> fibonacci(1) -> fibonacci(0)
        // fibonacci(0) returns 0
        // fibonacci(1) returns 1
        // fibonacci(2) returns 1
        // fibonacci(3) returns 2
        // fibonacci(4) returns 3

        // Time Complexity = No of recursive calls * Time taken in each recursive call
        // T(n) =2^n * c = O(2^n) - Exponential Time Complexity

        // Space Complexity = No of stack frames * Space taken by each stack frame
        // S(n) = n * c = O(n) - Linear Space Complexity



        sc.close();

    }
}
