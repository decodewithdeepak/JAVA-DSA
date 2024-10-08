// Notes 2: https://drive.google.com/file/d/1F6ecJOFRYWf_1UUtyiWD7PFAm8OpoSxB/view

import java.util.Scanner; 
// import - keyword used to import a package
// java.util - package
// Scanner - class in java.util package

public class TakingInput {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); // Creating an object of Scanner class
        // Scanner - class in java.util package to take input from user
        // sc- object of Scanner class
        // new - create an object of Scanner class
        // Scanner() - constructor of Scanner class
        // System.in - standard input stream (keyboard)


        // Taking integer input from the user

        // System.out.println("Enter your lucky number: ");
        // int num = sc.nextInt(); // nextInt() is a method of Scanner class which is used to take integer input
        // System.out.println("Your lucky number is: " + num);


        // Taking float input from the user

        // System.out.println("Enter a float number: ");
        // float f = sc.nextFloat();
        // System.out.println("You entered: " + f);
        
        // Similarly, we can take double, long, short, byte, boolean input from the user


        // Taking string input from the user

        // System.out.println("Enter your name: ");
        // // String name = sc.next();
        // String name = sc.nextLine(); // nextLine() is used to take input with spaces
        // System.out.println("Your name is: " + name);


        // Taking character input from the user

        //String can be read using next() or nextLine()
        //char can be read using next().charAt(0)
        
        // System.out.println("Enter a character: ");
        // char ch = sc.next().charAt(0);
        // System.out.println("You entered: " + ch);


        // // Sum of user input numbers
        // System.out.println("Enter first number: ");
        // int num1 = sc.nextInt();
        // System.out.println("Enter second number: ");
        // int num2 = sc.nextInt();

        // int sum = num1 + num2;
        // System.out.println("Sum of " + num1 + " and " + num2 + " is " + sum);


        // //Calculate simple interest using user input
        // System.out.println("Enter principal: ");
        // int principal = sc.nextInt();
        // System.out.println("Enter rate: ");
        // float rate = sc.nextFloat();
        // System.out.println("Enter time: ");
        // int time = sc.nextInt();

        // float simpleInterest = (principal * rate * time) / 100;
        // System.out.println("Simple Interest is: " + simpleInterest);


        // Error handling in user input
        System.out.println("Enter roll: ");
        int roll = sc.nextInt();
        System.out.println("Roll: " + roll);

        sc.nextLine(); // Consuming the newline character

        // nextInt() only reads the integer value and not the newline character (\n)
        // nextLine() reads the newline character and consumes it 

        System.out.println("Enter name");
        String name = sc.nextLine();
        System.out.println("Name: " + name);



        // Closing the Scanner class to avoid memory leak (not necessary but good practice)
        sc.close();
        
    }
}
