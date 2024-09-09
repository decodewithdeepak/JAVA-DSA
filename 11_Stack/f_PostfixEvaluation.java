// Postfix Expression Evaluation Using Stacks

// Example: Postfix: 953+4*6/- -> Postfix Evaluation: 4

import java.util.Stack;

public class f_PostfixEvaluation {

    // Method to evaluate postfix expression
    public static int postfixEvaluation(String postfix) {
        // Create a stack for operands
        Stack<Integer> val = new Stack<>(); // Value - Operand

        // Iterate through each character of the postfix expression
        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);
            int ascii = (int) c;
            // '0'->48, '9'->57

            // Skip spaces
            if (c == ' ') continue;

            // If character is a digit, push it onto the operand stack
            if (ascii >= 48 && ascii <= 57) {
                val.push(ascii - 48);
            }
            // If current character is an operator, perform operations
            else {
                int val2 = val.pop();
                int val1 = val.pop();
                if (c == '+') val.push(val1 + val2);
                if (c == '-') val.push(val1 - val2);
                if (c == '*') val.push(val1 * val2);
                if (c == '/') val.push(val1 / val2);
            }
        }

        // Return the result
        return val.pop();
    }
    
    public static void main(String[] args) {
        String postfix = "953+4*6/-";
        System.out.println("Postfix Evaluation: " + postfixEvaluation(postfix));
    }

}
