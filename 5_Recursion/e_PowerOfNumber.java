// Program to find power of a number using recursion
// Given two numbers p and q, find p^q using recursion.

import java.util.Scanner;

public class e_PowerOfNumber {

    static int power(int p, int q) { // O(q)
        // base case - halting condition
        if (q == 0) return 1;

        // // smaller subproblem - recursive call
        // recursion relation -> p^q = p^(q-1) * p
        // int smallAns = power(p, q - 1);

        // // big problem - self work
        // int ans = smallAns * p; // power(p, q - 1) * p

        // return ans;

        return power(p, q - 1) * p; // one liner
    }

    // Alternate Approach (Optimized)
    static int pow(int p, int q) { // O(log(q))
        // base case - halting condition
        if (q == 0) return 1;

        // recursion relation -> even q -> p^q = p^(q/2) * p^(q/2)
        //                        odd q -> p^q = p^(q/2) * p^(q/2) * p

        int smallPow = pow(p, q / 2); // If we call pow(p, q/2) twice, it will take O(q) time

        if (q % 2 == 0) return smallPow * smallPow; // even q
        else return smallPow * smallPow * p; // odd q
        
    }

    // LeetCode 50. Pow(x, n)
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
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter base : ");
        int p = sc.nextInt();

        System.out.println("Enter exqonent : ");
        int q = sc.nextInt();

        System.out.println("Power : " + power(p, q));

        // Time Complexity = No of recursive calls * Time taken in each recursive call
        // No of recursive calls = q
        // Time taken in each recursive call = constant
        // T(n) = q * c = O(q) - Linear Time Complexity

        System.out.println("Power : " + pow(p, q));

        // Time Complexity = No of recursive calls * Time taken in each recursive call
        // No of recursive calls = log(q) (base 2)
        // Time taken in each recursive call = constant
        // T(n) = log(q) * c = O(log(q)) - Logarithmic Time Complexity

        
        
        sc.close();

    }

}
