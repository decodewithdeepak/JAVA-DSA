// Notes 7 : https://drive.google.com/file/d/1qQICceEqqdmCI8BHemB_3p0R9bq-gQwF/view

// Problems on Loops-
// 1. Print the multiplication table of a number
// 2. Print the Fibonacci series upto n terms
// 3. Count the number of digits in a number
// 4. Find the sum of digits of a number
// 5. Reverse a number
// 6. Check if a number is palindrome or not
// 7. Find the sum of the digits of a number until the sum is reduced to a single digit
// 8. Find the sum of S = 1-2+3-4+5-6+...n
// 9. Print the factorial of a number
// 10. Print the first n factorial numbers
// 11. Given two numbers x and y, find x^y
// 12. Check if a Number if Prime or not
// 13. Print the first n prime numbers


import java.util.Scanner;

public class ProblemsOnLoops {

    // 1. Print the multiplication table of a number
    public static void printMultiplicationTable(int n) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(n + " x " + i + " = " + (n * i));
        }
    }

    // 2. Print the Fibonacci series upto n terms
    public static void printFibonacciSeries(int n) {
        int a = 0, b = 1, c;
        System.out.println("Fibonacci series upto " + n + " terms is: ");
        for (int i = 1; i <= n; i++) {
            System.out.print(a + " ");
            c = a + b;
            a = b;
            b = c;
        }
        System.out.println();
    }

    // 3. Count the number of digits in a number
    public static int countDigits(int n) {
        int count = 0;
        while (n != 0) {
            n = n / 10;
            count++;
        }
        return count;
    }

    // 4. Find the sum of digits of a number
    public static int sumOfDigits(int n) {
        int sum = 0;
        while (n != 0) {
            sum = sum + n % 10;
            n = n / 10;
        }
        return sum;
    }

    // 5. Reverse a number
    public static int reverseNumber(int n) {
        int rev = 0;
        while (n != 0) {
            int digit = n % 10;
            rev = rev * 10 + digit;
            n = n / 10;
        }
        return rev;
    }

    // 6. Check if a number is palindrome or not
    public static boolean isPalindrome(int n) {
        return n == reverseNumber(n);
    }

    // 7. Find the sum of the digits of a number until the sum is reduced to a single digit
    public static int sumToSingleDigit(int n) {
        int sum;
        while (n > 9) {
            sum = 0;
            while (n != 0) {
                sum = sum + n % 10;
                n = n / 10;
            }
            n = sum;
        }
        return n;
    }

    // 8. Find the sum of S = 1-2+3-4+5-6+...n
    public static int alternatingSum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                sum -= i;
            } else {
                sum += i;
            }
        }
        return sum;
    }

    // 9. Print the factorial of a number
    public static int factorial(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }

    // 10. Print the first n factorial numbers
    public static void printFactorials(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact = fact * i;
            System.out.println("Factorial of " + i + " is " + fact);
        }
    }

    // 11. Given two numbers x and y, find x^y
    public static int power(int x, int y) {
        int ans = 1;
        for (int i = 1; i <= y; i++) {
            ans = ans * x;
        }
        return ans;
    }

    // 12. Check if a Number if Prime or not
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i*i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // 13. Print the first n prime numbers
    public static void printFirstNPrimes(int n) {
        int count = 0, num = 2;
        while (count < n) {
            if (isPrime(num)) {
                System.out.print(num + "  ");
                count++;
            }
            num++;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Call the methods here for testing:

        // 1. Multiplication table
        System.out.println("\nEnter a number for multiplication table: ");
        int n = sc.nextInt();
        printMultiplicationTable(n);

        // 2. Fibonacci series
        System.out.println("\nEnter number of terms for Fibonacci series: ");
        n = sc.nextInt();
        printFibonacciSeries(n);

        // 3. Count digits
        System.out.println("\nEnter a number to count digits: ");
        n = sc.nextInt();
        System.out.println("Number of digits: " + countDigits(n));

        // 4. Sum of digits
        System.out.println("\nEnter a number to find sum of digits: ");
        n = sc.nextInt();
        System.out.println("Sum of digits: " + sumOfDigits(n));

        // 5. Reverse a number
        System.out.println("\nEnter a number to reverse: ");
        n = sc.nextInt();
        System.out.println("Reversed number: " + reverseNumber(n));

        // 6. Palindrome check
        System.out.println("\nEnter a number to check palindrome: ");
        n = sc.nextInt();
        if (isPalindrome(n)) {
            System.out.println(n + " is a palindrome");
        } else {
            System.out.println(n + " is not a palindrome");
        }

        // 7. Sum to single digit
        System.out.println("\nEnter a number to reduce sum of digits to single digit: ");
        n = sc.nextInt();
        System.out.println("Reduced sum: " + sumToSingleDigit(n));

        // 8. Alternating sum
        System.out.println("\nEnter a number to find sum of S = 1-2+3-4...: ");
        n = sc.nextInt();
        System.out.println("Alternating sum: " + alternatingSum(n));

        // 9. Factorial of a number
        System.out.println("\nEnter a number to find factorial: ");
        n = sc.nextInt();
        System.out.println("Factorial: " + factorial(n));

        // 10. First n factorials
        System.out.println("\nEnter a number to print first n factorials: ");
        n = sc.nextInt();
        printFactorials(n);

        // 11. Power x^y
        System.out.println("\nEnter base: ");
        int x = sc.nextInt();
        System.out.println("Enter exponent: ");
        int y = sc.nextInt();
        System.out.println(x + "^" + y + " = " + power(x, y));

        // 12. Prime check
        System.out.println("\nEnter a number to check if prime: ");
        n = sc.nextInt();
        if (isPrime(n)) {
            System.out.println(n + " is a prime number");
        } else {
            System.out.println(n + " is not a prime number");
        }

        // 13. First n primes
        System.out.println("\nEnter a number to print first n primes: ");
        n = sc.nextInt();
        printFirstNPrimes(n);


        

        sc.close();
    }
}
