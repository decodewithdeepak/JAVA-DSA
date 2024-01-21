// Notes : https://drive.google.com/file/d/1HGRuMq54SdTtCsMQsyDLjL74Sk3qhJVk/view

// Intrduction to Recursion and recursive functions

// Recursion is a process in which a function calls itself directly or indirectly and the corresponding function is called as recursive function.

// Call Stack : It maintains a record of all the function calls made during the execution of a program.
// Stack is a LIFO (Last In First Out) data structure, so the function which is called last will be executed first.

// A function calling itself with different parameters and halting condition (base case) to terminate the infinite calls is called as recursive function.
// In recursion, we solve a bigger problem by solving smaller subproblems.

// Solving the recursion problems :
// 1. Identify the smaller problem - Let recursion solve it using reccurence relation
// 2. Self work - Do your work
// 3. Identify the base case - Smallest problem for which the answer is known

// Note : Identify whi is going to be executed first self work or recursive call, then write the code accordingly.

import java.util.Scanner;

public class Recursion {

    static void printIncreasing(int n) {
        if (n == 1) { // base case (when to stop) - halting condition
            System.out.print(1);
            return;
        }
        printIncreasing(n - 1); // recursive call (function calling itself) - smaller subproblem
        System.out.print(n); // print or return statement (what to do) - self work
    }

    static void printDecreasing(int n) {
        if (n == 1) { // halting condition
            System.out.print(1);
            return;
        }
        System.out.print(n); // self work
        printDecreasing(n - 1); // smaller subproblem
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Program to print n natural numbers using recursion

        System.out.println("Enter a natural number : ");
        int n = sc.nextInt();

        System.out.println("Natural numbers from 1 to " + n + " are : ");
        printIncreasing(n);

        // Function call sequence in stackframe for n = 4
        // main() -> printIncreasing(4) -> printIncreasing(3) -> printIncreasing(2) -> printIncreasing(1)
        
        // Output will be given by the stack in LIFO order, so output will be in reverse order of function calls
        // 1 2 3 4


        // Program to print n natural numbers in reverse order using recursion

        System.out.println("\nEnter a natural number : ");
        n = sc.nextInt();

        System.out.println("Natural numbers from " + n + " to 1 are : ");
        printDecreasing(n);

        // Function call sequence in stackframe for n = 4
        // main() -> printDecreasing(4) -> printDecreasing(3) -> printDecreasing(2) -> printDecreasing(1)

        // Output will be given by the stack in LIFO order, so output will be in reverse order of function calls
        // 4 3 2 1



        sc.close();

    }
}
