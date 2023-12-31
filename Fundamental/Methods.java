// Notes 10 : https://drive.google.com/file/d/1hEH9ud8RJCUDLtqQ8Lh8ELuNRN7WUkXO/view

// Difference between Function and Method
// Any function defined inside a class which has to be called using object of that class is called a method.
// As everything in Java is inside a class, every function is a method.

// Types of Methods:
// 1. Built-in / Pre-defined / Standard library Methods Ex. println(), nextInt(), sqrt(), etc.
// 2. User-defined Methods Ex. main(), sum(), etc.

// Syntax:
// <Access Modifier> <Return Type> <Method Name>(<Parameter List>) { // Method Header
//     // body of method ( code to be executed )
// }

// Calling a Method: <Object Name>.<Method Name>(<Parameter List>);

// Method Signature: <Return Type> <Method Name>(<Parameter List>)
// Access Specifiers: public, private, protected, default
// Return Type: void, int, float, double, char, String, etc.


public class Methods {
    public static void main(String[] args) { // main is also a method (function)

        class Greet { // Creating a class

            // void Welcome() { // Method (function)
            //     System.out.println("Welcome to SAITM"); // Method body
            // }

            // Static methods can be called without creating an object of class
            static void Welcome() {
                System.out.println("Welcome to SAITM");
            }

        }

        // Greet obj = new Greet(); // Creating an object of class
        // obj.Welcome(); // Calling a method

        Greet.Welcome(); // Calling a method without creating object

        class Student {
            String name = "Deepak"; // Attributes
            int rollno = 223100;

            void desc() { // Method (function)
                System.out.println("My name is " + name + " Rollno. " + rollno);
            }
        }

        Student student1 = new Student(); // Creating an object of class
        student1.desc(); // Calling a method
        

    }
}

