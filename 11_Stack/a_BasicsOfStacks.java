// Notes: https://drive.google.com/file/d/1BE_LujAxEda4qooIhfh4v8vjYt2iXk7f/view

// Stacks - LIFO (Last In First Out) linear data structure

// Operations: push, pop, peek, isEmpty, isFull
// 1. Push - Add an element to the top of the stack
// 2. Pop - Remove an element from the top of the stack
// 3. Peek - Get the top element of the stack
// 4. isEmpty - Check if the stack is empty
// 5. isFull - Check if the stack is full - Not applicable for dynamic stack
// 6. Size - Get the number of elements in the stack

// Stack Errors:
// 1. Stack Overflow - When we try to push an element to a full stack
// 2. Stack Underflow - When we try to pop an element from an empty stack

import java.util.Scanner;
import java.util.Stack; // Standard Java library for Stack

public class a_BasicsOfStacks {
    public static void main(String[] args) {

        // Create a stack using the Stack class
        Stack<Integer> st = new Stack<>();

        // Check if the stack is empty
        System.out.println("Is stack empty: " + st.isEmpty()); // true

        // Size of the stack
        System.out.println("Size of the stack: " + st.size()); // 0

        // Push elements to the stack
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        st.push(50);

        // Print the stack
        System.out.println("Stack: " + st); // [10, 20, 30, 40, 50]

        // Pop elements from the stack
        st.pop();
        st.pop();

        // Print the stack
        System.out.println("Stack: " + st); // [10, 20, 30]

        // Peek the top element of the stack
        System.out.println("Top element: " + st.peek()); // 30

        // Check if the stack is empty
        System.out.println("Is stack empty: " + st.isEmpty()); // false

        // Check if the stack is full
        // System.out.println("Is stack full: " + st.isFull()); // Not applicable for dynamic stack

        // Size of the stack
        System.out.println("Size of the stack: " + st.size()); // 3

        // Stack Underflow - stack.pop() or stack.peek() on an empty stack
        st.pop(); // [10, 20]
        st.pop(); // [10]
        st.pop(); // [] - Empty stack
        System.out.println("Is stack empty: " + st.isEmpty()); // true
        // st.pop(); // Exception in thread "main" java.util.EmptyStackException
        // st.peek(); // Exception in thread "main" java.util.EmptyStackException

        // Stack Overflow - When we try to push an element to a full stack
        // Only applicable for static stack (array implementation)
        // Not applicable for dynamic stack (linked list implementation)
        
        
        // Taking input from the user
        Scanner sc = new Scanner(System.in);
        st = new Stack<>(); // Re-initialize the stack
        int n;
        System.out.println("Enter the number of elements:");
        n = sc.nextInt();

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            st.push(sc.nextInt());
        }

        // Print the stack
        System.out.println("Stack: " + st);




        sc.close();
    }
}
