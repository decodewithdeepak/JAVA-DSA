// Implementation of stack using a linked list

public class LikedListImplementationOfStack {

    // Stack Class Node
    public static class Node {
        int data; // Data to be stored in the node
        Node next; // Pointer to the next node

        // Constructor for the node
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Class for the stack
    public static class Stack {
        private Node top = null; // Pointer to the top of the stack
        private int size = 0; // Size of the stack

        // Push elements into the stack
        public void push(int value) {
            Node newNode = new Node(value);
            if (top == null) {
                top = newNode;
            } else {
                newNode.next = top;
                top = newNode;
            }
            size++;
        }

        // Pop elements from the stack
        public void pop() {
            if (top == null) {
                System.out.println("Stack is empty");
            } else {
                top = top.next;
                size--;
            }
        }

        // Peek the top of the stack
        public void peek() {
            if (top == null) {
                System.out.println("Stack is empty");
            } else {
                System.out.println("Top element: " + top.data);
            }
        }

        // Print the stack
        public void printStack() {
            Node temp = top;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }

        // Check if the stack is empty
        public boolean isEmpty() {
            return (top == null);
        }

        // Check if the stack is full - Not applicable for dynamic stack

        // Get the size of the stack
        public int getSize() {
            return size;
        }

    }

    public static void main(String[] args) {
        Stack st = new Stack();

        // Push elements into the stack
        st.push(10);
        st.push(20);
        st.push(30);

        // Print the stack
        st.printStack(); // 30 20 10

        // Pop elements from the stack
        st.pop();
        st.printStack(); // 20 10

        // Peek the top element of the stack
        st.peek();

        // Get the size of the stack
        System.out.println("Size of the stack: " + st.getSize()); // 2

        // Check if the stack is empty
        System.out.println("Is the stack empty? " + st.isEmpty()); // false
    }


}
