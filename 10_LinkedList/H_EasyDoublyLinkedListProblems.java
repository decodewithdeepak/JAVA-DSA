// 1. Array to Doubly Linked List (GFG) - [https://www.geeksforgeeks.org/problems/introduction-to-doubly-linked-list/1]
// 2. Doubly linked list Insertion at given position (GFG) - [https://www.geeksforgeeks.org/problems/insert-a-node-in-doubly-linked-list/1]
// 3. Delete node in Doubly Linked List (GFG) - [https://www.geeksforgeeks.org/problems/delete-node-in-doubly-linked-list/1]
// 4. Reverse a Doubly Linked List (GFG) - [https://www.geeksforgeeks.org/problems/reverse-a-doubly-linked-list/1]

public class H_EasyDoublyLinkedListProblems {

    // Node class of doubly linked list
    public static class Node {
        int data; // Value
        Node prev; // Address of previous Node
        Node next; // Address of next Node

        Node (int data) { // Constructor
            this.data = data;
        }
    }

    // 1. Array to Doubly Linked List (GFG)
    public static Node constructDLL(int arr[]) {
        Node head = new Node(arr[0]);
        Node temp = head;
        for (int i = 1; i < arr.length; i++) {
            Node newNode = new Node(arr[i]);
            temp.next = newNode;
            newNode.prev = temp;
            temp = temp.next;
        }
        return head;
    }

    // 2. Doubly linked list Insertion at given position (GFG)
    static void addNode(Node head, int pos, int data) {
        if (head == null) return;

        // traverse to the p-th node
        Node temp = head;
        for (int i = 0; i < pos; i++) {
            temp = temp.next;
        }

        Node newNode = new Node(data);

        newNode.next = temp.next;
        newNode.prev = temp;
        temp.next = newNode;
        if (temp.next != null) { // to avoid null pointer exception
            temp.next.prev = newNode;
        }
    }

    // 3. Delete node in Doubly Linked List (GFG)
    public static Node deleteNode(Node head, int x) {
        // position (x) starts from 1
        if (head == null) return null;

        Node temp = head;
        for (int i = 1; i < x; i++) {
            temp = temp.next;
        }

        if (temp == head) {
            head = head.next;
            head.prev = null;
        } 
        else {
            temp.prev.next = temp.next;
            if (temp.next != null) { // to avoid null pointer exception
                temp.next.prev = temp.prev;
            }
        }
        return head;
    }

    // 4. Reverse a Doubly Linked List (GFG)
    public static Node reverseDLL(Node head) {
        if (head == null) return null;
    
        Node prev = null;
        Node current = head;
        Node next = null;
    
        // swap next and prev for all nodes
        while (current != null) {
            next = current.next;
            current.next = prev;
            current.prev = next;
            prev = current;
            current = next;
        }
        return prev;
    }


}
