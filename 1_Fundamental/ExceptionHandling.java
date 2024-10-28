// Exception Handling in Java -
// try - block of code which may throw an exception
// catch - block of code which handles the exception
// finally - block of code which executes always
// throw - keyword used to manually throw an exception
// throws - keyword used to declare multiple exceptions in method signature

import java.io.*;

public class ExceptionHandling {

    // try-catch-finally block
    public static void divide(int a, int b) {
        try {
            int c = a / b;
            System.out.println(c);
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero");
        } finally {
            System.out.println("Finally block");
        }
    }

    // throw keyword
    public static void checkAge(int age) {
        if (age < 18) {
            throw new ArithmeticException("Not eligible to vote");
        } else {
            System.out.println("Eligible to vote");
        }
    }

    // throws keyword



    public static void main(String[] args) {
        // try-catch-finally block
        divide(10, 0);

        // throw keyword
        checkAge(15);

        // throws keyword
    }

}
