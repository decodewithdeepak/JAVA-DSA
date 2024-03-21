// Postfix to Infix Conversion using Stack

// Example: Postfix: 953+4*6/- -> Infix: 9-(5+3)*4/6
// Example: Postfix: ABC+*D/ -> Infix: A*(B+C)/D

import java.util.Stack;

public class PostfixToInfix {

    // Method to convert postfix expression to infix expression
    public static String postfixToInfix(String postfix) {
        // Create stack for operands
        Stack<String> stack = new Stack<>();

        // Iterate through each character of the postfix expression
        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);
            int ascii = (int) c;
            // '0'->48, '9'->57, 'a'->97, 'z'->122, 'A'->65, 'Z'->90

            // If character is a digit, push it onto the stack
            if (ascii >= 48 && ascii <= 57 || ascii >= 97 && ascii <= 122 || ascii >= 65 && ascii <= 90) {
                stack.push(c + ""); // "" to convert char to string
            }
            // If character is an operator, pop two operands from the stack and push the result onto the stack
            else {
                String val1 = stack.pop();
                String val2 = stack.pop();
                stack.push("(" + val2 + c + val1 + ")");
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        String postfix = "953+4*6/-";
        System.out.println("Postfix: " + postfix);
        System.out.println("Infix: " + postfixToInfix(postfix)); // 9-(5+3)*4/6

        postfix = "ABC+*D/";
        System.out.println("\nPostfix: " + postfix);
        System.out.println("Infix: " + postfixToInfix(postfix)); // A*(B+C)/D
    }
}
