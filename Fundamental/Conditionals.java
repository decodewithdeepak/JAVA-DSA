// Notes 5 : https://drive.google.com/file/d/1by_nWkcCbcqDrAU8H5RB3gMehLLDgmdt/view

// Conditional Statements : if, if-else, if-else-if, nested if-else, switch-case

import java.util.Scanner;

public class Conditionals {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // if statement
        System.out.println("Enter your age: ");
        int age = sc.nextInt();
        if (age >= 18) {
            System.out.println("You are eligible to vote!");
        }

        // if-else statement
        System.out.println("Enter a number: ");
        int num = sc.nextInt();
        if (num % 2 == 0) {
            System.out.println("Even");
        } else {
            System.out.println("Odd");
        }

        // if-else-if statement
        System.out.println("Enter your marks: ");
        int marks = sc.nextInt();
        if (marks >= 90) {
            System.out.println("Grade A");
        } else if (marks >= 80) {
            System.out.println("Grade B");
        } else if (marks >= 70) {
            System.out.println("Grade C");
        } else if (marks >= 60) {
            System.out.println("Grade D");
        } else if (marks >= 50) {
            System.out.println("Grade E");
        } else {
            System.out.println("Grade F");
        }

        // nested if-else statement
        System.out.println("Enter your age: ");
        age = sc.nextInt();
        if (age >= 18) {
            System.out.println("You are eligible to vote!");
            if (age >= 60) {
                System.out.println("You are a senior citizen!");
            } else {
                System.out.println("You are not a senior citizen!");
            }
        } else {
            System.out.println("You are not eligible to vote!");
        }

        // switch-case statement
        System.out.println("Enter your grade (A-E): ");
        char grade = sc.next().charAt(0);
        switch (grade) {
            case 'A':
                System.out.println("Excellent!");
                break;
            // break will terminate the switch-case block if the condition is met
            case 'B':
                System.out.println("Good!");
                break;
            case 'C':
                System.out.println("Average!");
                break;
            case 'D':
                System.out.println("Poor!");
                break;
            case 'E':
                System.out.println("Fail!");
                break;
            default:
                System.out.println("Invalid Grade!");
        }

        sc.close(); // not mandatory but good practice

    }
}
