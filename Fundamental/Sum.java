
import java.util.Scanner;

// // Program to find sum of two user input numbers
// public class Sum {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         System.out.print("Enter first number: ");
//         int num1 = sc.nextInt();
//         System.out.print("Enter second number: ");
//         int num2 = sc.nextInt();

//         int sum = num1 + num2;
//         System.out.println("Sum of " + num1 + " and " + num2 + " is " + sum);

//     }
// }


// // Program to find sum of two user input numbers Using Function
// public class Sum{
//     static void sum(int a, int b) { // a and b are parameters (formal parameters)
//         int result = a + b;
//         System.out.println("Sum of " + a + " and " + b + " is " + result);
//     }

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         System.out.print("Enter first number: ");
//         int num1 = sc.nextInt();
//         System.out.print("Enter second number: ");
//         int num2 = sc.nextInt();

//         sum(num1, num2); // Calling function with arguments (actual parameters) num1 and num2
//     }

// }


// Program to find sum of two user input numbers Using Method (OOPs Concept)
public class Sum {
    // Constructor
    Sum() {
        System.out.println("Constructor called");
    }

    int sum(int a, int b) {
        return a + b;
    }
    
    // using static keyword to call method without creating an object of class
    // static int sum(int a, int b) {
    //     return a + b;
    // }
    
}

// Only one class can be public and the name of that class should be the name of the file

class Main {
public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int num1 = sc.nextInt();
        System.out.print("Enter second number: ");
        int num2 = sc.nextInt();

        Sum obj = new Sum();
        int result = obj.sum(num1, num2);

        // int result = Sum.sum(num1, num2); // calling static method without creating an object of class

        System.out.println("Sum of " + num1 + " and " + num2 + " is " + result);
        


    }

}
