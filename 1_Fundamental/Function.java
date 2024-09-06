// Difference between Function and Method
// Any function defined inside a class which has to be called using object of that class is called a method.
// As everything in Java is inside a class, every function is a method.

// Types of Methods/Functions:
// 1. Built-in / Pre-defined / Standard library Methods Ex. println(), nextInt(), sqrt(), etc.
// 2. User-defined Methods Ex. main(), sum(), etc.

// Formal parameters(Parameters) - defined during function/method definition.
// Actual parameters(Arguments) - passed during the function/method call in other Function.


import java.util.Scanner;

public class Function {

    static void welcome() { // function definition (method)
        System.out.println("Welcome to SAITM");
    }

    static void sum(int a, int b) { // a and b are parameters (formal parameters)
        int result = a + b;
        System.out.println("Sum of " + a + " and " + b + " is " + result);
    }

    public static void main(String[] args) { // Static is used to call a method without creating an object of class (function)
        welcome(); // Calling function
        welcome();

        // Program to find sum of two user input numbers Using Function
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int num1 = sc.nextInt();
        System.out.print("Enter second number: ");
        int num2 = sc.nextInt();

        sum(num1, num2); // Calling function with arguments (actual parameters) num1 and num2

        
        System.out.println("\nBuilt-in Methods:");
        // Math is a built-in class so no need to import

        // Math.sqrt() - returns square root of a number
        System.out.println(Math.sqrt(24));
        System.out.println(Math.sqrt(16)); 

        // Math.ceil() - returns the smallest integer greater than or equal to a number
        System.out.println(Math.ceil(4.7));

        // Math.floor() - returns the largest integer less than or equal to a number
        System.out.println(Math.floor(4.7));

        // Math.pow() - returns the value of a number raised to the power of another number
        System.out.println(Math.pow(2, 3));

        // Math.abs() - returns absolute value of a number
        System.out.println(Math.abs(-4.7));
        System.out.println(Math.abs(4.7));

        // Math.max() - returns the largest of two numbers
        System.out.println(Math.max(24, 16));
        
        // Math.min() - returns the smallest of two numbers
        System.out.println(Math.min(24, 16));
        
        // Math.round() - returns the rounded value of a number
        System.out.println(Math.round(4.7));
        
        // Math.random() - returns a random number between 0.0 and 1.0
        System.out.println(Math.random());
        


    }

}
