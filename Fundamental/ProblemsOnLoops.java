// Notes 7 : https://drive.google.com/file/d/1qQICceEqqdmCI8BHemB_3p0R9bq-gQwF/view

import java.util.Scanner;

public class ProblemsOnLoops {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, i, sum;


        // Print the multiplication table of a number
        System.out.println("\nEnter a number whose multiplication table you want to print: ");
        n = sc.nextInt();

        for (i = 1; i <= 10; i++) {
            System.out.println(n + " x " + i + " = " + (n * i));
        }



        // Print the Fibonacci series upto n terms
        System.out.println("\nEnter the number of terms upto which you want to print the Fibonacci series: ");
        n = sc.nextInt();

        int a = 0, b = 1, c;
        System.out.println("Fibonacci series upto " + n + " terms is: ");
        for (i = 1; i <= n; i++) {
            System.out.print(a + " ");
            c = a + b;
            a = b;
            b = c;
        }




        // Count the number of digits in a number
        System.out.println("\n\nEnter a number whose number of digits you want to count: ");
        n = sc.nextInt();

        int count = 0;
        while (n != 0) {
            n = n / 10;
            // any number / 10 removes the last digit of that number
            count++;
        }
        System.out.println("Number of digits in the given number is " + count);




        // Find the sum of digits of a number
        System.out.println("\nEnter a number whose sum of digits you want to find: ");
        n = sc.nextInt();

        sum = 0;
        while (n != 0) {
            sum = sum + n % 10;
            // any number % 10 gives the last digit of that number
            n = n / 10;
        }
        System.out.println("Sum of digits of the given number is " + sum);




        // Reverse a number
        System.out.println("\nEnter a number which you want to reverse: ");
        n = sc.nextInt();

        int rev = 0;
        while (n != 0) {
            rev = rev * 10 + n % 10;
            // it will add the last digit of the number to the rev variable
            n = n / 10;
        }
        System.out.println("Reverse of the given number is " + rev);




        // Check if a number is palindrome or not
        // A number is said to be palindrome if it is equal to its reverse
        System.out.println("\nEnter a number which you want to check if it is palindrome or not: ");
        n = sc.nextInt();

        int temp = n;
        rev = 0;
        while (temp != 0) {
            rev = rev * 10 + temp % 10;
            temp = temp / 10;
        }
        if (rev == n) {
            System.out.println(n + " is a palindrome number");
        } else {
            System.out.println(n + " is not a palindrome number");
        }




        // Find the sum of the digits of a number until the sum is reduced to a single digit
        System.out.println("\nEnter a number whose sum of digits you want to find until it is reduced to a single digit: ");
        n = sc.nextInt();

        sum = 0;
        while (n > 9) {
            sum = 0;
            while (n != 0) {
                sum = sum + n % 10;
                n = n / 10;
            }
            n = sum;
        }
        System.out.println("Sum of digits of the given number until it is reduced to a single digit is " + sum);




        // Find the sum of S = 1-2+3-4+5-6+...n
        System.out.println("\nEnter a number upto which you want to find the sum of S = 1-2+3-4+5-6+...n: ");
        n = sc.nextInt();

        sum = 0;
        for (i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                sum -= i;
            } else {
                sum += i;
            }
        }
        System.out.println("Sum of S = 1-2+3-4+5-6+...n is " + sum);




        // Print the factorial of a number
        System.out.println("\nEnter a number whose factorial you want to print: ");
        n = sc.nextInt();

        int fact = 1;
        for (i = 1; i <= n; i++) {
            fact = fact * i;
        }
        System.out.println("Factorial of " + n + " is " + fact);




        // Print the first n factorial numbers
        System.out.println("\nEnter a number upto which you want to print the factorial numbers: ");
        n = sc.nextInt();

        fact = 1;
        for (i = 1; i <= n; i++) {
            fact = fact * i;
            System.out.println("Factorial of " + i + " is " + fact);
        }




        // Given two numbers x and y, find x^y
        System.out.println("\nEnter the base: ");
        int x = sc.nextInt();
        System.out.println("Enter the exponent: ");
        int y = sc.nextInt();

        int ans = 1;
        for (i = 1; i <= y; i++) {
            ans = ans * x;
        }
        System.out.println("Answer: " + x + "^" + y + " = " + ans);




    }
}
