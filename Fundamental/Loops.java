// Notes 6 : https://drive.google.com/file/d/1dSHyYOTtBq-mutB61QWUOOo1d_XeenNl/view

// Loops : for, while, do-while
// break and continue statements

import java.util.Scanner;

public class Loops {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;

        
        // for loop
        System.out.println("For loop");
        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
        }

        // while loop
        System.out.println("\nWhile loop");
        int i = 1;
        while (i <= 5) {
            System.out.println(i);
            i++;
        }

        // do-while loop
        System.out.println("\nDo-while loop");
        i = 1;
        do {
            System.out.println(i);
            i++;
        } while (i <= 5);

        // break statement
        System.out.println("\nBreak statement");
        for (i = 1; i <= 5; i++) {
            if (i == 3) {
                break; // exit the loop when i = 3
            }
            System.out.println(i);
        }

        // continue statement
        System.out.println("\nContinue statement");
        for (i = 1; i <= 5; i++) {
            if (i == 3) {
                continue; // skip the current iteration when i = 3
            }
            System.out.println(i);
        }

        // Print the sum of first n natural numbers
        System.out.println("\nEnter a number upto which you want to find the sum: ");
        n = sc.nextInt();

        int sum = 0;
        for (i = 1; i <= n; i++) {
            sum += i;
        }
        System.out.println("Sum of first " + n + " natural numbers is " + sum);

        // Print the sum of the stream of numbers in the input until the user enters 0
        System.out.println("\nEnter a stream of numbers (0 to stop): ");
        n = sc.nextInt();
        sum = 0;
        // while (n != 0) {
        // sum += n;
        // n = sc.nextInt();
        // }
        // System.out.println("Sum of the stream of numbers is " + sum);

        do {
            sum += n;
            n = sc.nextInt();
        } while (n != 0);
        System.out.println("Sum of the stream of numbers is " + sum);

        // Print the first multiple of 5 which is also a muliple of 7
        int num = 1;

        while (true) {
            if (num % 5 == 0 && num % 7 == 0) {
                System.out.println("The first multiple of 5 which is also a muliple of 7 is " + num);
                break; // exit the loop when the condition is met and prevent infinite loop
            }
            num++;
        }

        // Print all the values between 1 and 50 except for the multiples of 3
        for (i = 1; i <= 50; i++) {
            if (i % 3 == 0) {
                continue; // skip the current iteration when the condition is met
            }
            System.out.println(i);
        }

        
    }
}
