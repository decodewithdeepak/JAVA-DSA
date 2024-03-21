// Infix to Postfix Conversion Using Stacks

// Example: Infix: 9-(5+3)*4/6 -> Postfix: 953+4*6/-
// Example: Infix: A*(B+C)/D -> Postfix: ABC+*D/

import java.util.Stack;

public class InfixToPostfix {

    // Method to return precedence of operators
    public static int precedence(char operator) {
        if (operator == '+' || operator == '-') return 1;
        if (operator == '*' || operator == '/') return 2;
        return 0;
    }

    // Method to convert infix expression to postfix expression
    public static String infixToPostfix(String str) {
        // Create stacks for operands and operators
        Stack<Character> op = new Stack<>(); // Operator
        Stack<String> val = new Stack<>(); // Postfix Value - Operand

        // Iterate through each character of the infix expression
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int ascii = (int) c;
            // '0'->48, '9'->57, 'a'->97, 'z'->122, 'A'->65, 'Z'->90

            // Skip spaces
            if (c == ' ') continue;

            // If character is a digit, push it onto the postfix stack
            if (ascii >= 48 && ascii <= 57 || ascii >= 97 && ascii <= 122 || ascii >= 65 && ascii <= 90) {
                val.push(c + ""); // "" to convert char to string
            }
            // If operator stack is empty or current character is '(', push it onto the operator stack
            else if (op.isEmpty() || c == '(' || op.peek() == '(') {
                op.push(c);
            }
            // If current character is ')', perform operations until '(' is encountered
            else if (c == ')') {
                while (op.peek() != '(') {
                    String val2 = val.pop();
                    String val1 = val.pop();
                    char operator = op.pop();
                    val.push(val1 + val2 + operator);
                }
                op.pop(); // Remove '('
            }
            // If current character is an operator, perform operations based on precedence
            else {
                while (!op.isEmpty() && precedence(c) <= precedence(op.peek())) {
                    String val2 = val.pop();
                    String val1 = val.pop();
                    char operator = op.pop();
                    val.push(val1 + val2 + operator);
                }
                op.push(c);
            }
        }

        // Perform remaining operations
        while (!op.isEmpty()) {
            String val2 = val.pop();
            String val1 = val.pop();
            char operator = op.pop();
            val.push(val1 + val2 + operator);
        }

        // Return the postfix expression which is at the top of the postfix stack
        return val.pop();
    }

    public static void main(String[] args) {
        String infix = "9-(5+3)*4/6";
        System.out.println("Infix: " + infix);
        System.out.println("Postfix: " + infixToPostfix(infix)); // Output: 953+4*6/-

        infix = "A*(B+C)/D";
        System.out.println("\nInfix: " + infix);
        System.out.println("Postfix: " + infixToPostfix(infix)); // Output: ABC+*D/
    }
}
