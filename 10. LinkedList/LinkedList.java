// Notes: https://drive.google.com/file/d/1DnjM6vQs1YdrEGJ3O9gjSVhoxPKVZ1bW/view

// Basics of Linked List

public class LinkedList {
    
    // Node class of linked list
    public static class Node {
        int data; // Value
        Node next; // Address of next Node

        Node (int data) { // Constructor
            this.data = data;
        }
    }

    // Traversing the linked list
    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println(); // New line for next output
        // Note: It's better to use a temporary variable for preserving the head node
    }

    // Traversing the linked list with recursion
    public static void printListRec(Node head) {
        if (head == null) return;
        // System.out.print(head.data + " ");
        printListRec(head.next);
        System.out.print(head.data + " "); // For reverse order
    }

    // Length (Size) of linked list
    public static int lengthOfList(Node head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    // Insert at the end only if head is given | TC- O(n) | SC- O(1)
    public static Node insertAtEnd(Node head, int data) {
        Node newNode = new Node(data);
        if (head == null) return newNode; // If list is empty
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
        return head;
    }


    public static void main(String[] args) {

        // Node class object

        Node n1 = new Node(10); // head node
        // System.out.println(n1.data + " " + n1.next); // 10 null
        Node n2 = new Node(20);
        Node n3 = new Node(30);
        Node n4 = new Node(40);
        Node n5 = new Node(50); // tail node


        // Linking Nodes : n1 -> n2 -> n3 -> n4 -> n5

        n1.next = n2; // 10 -> 20 30 40 50
        n2.next = n3; // 10 -> 20 -> 30 40 50
        n3.next = n4; // 10 -> 20 -> 30 -> 40 50 
        n4.next = n5; // 10 -> 20 -> 30 -> 40 -> 50


        // Displaying the linked list
        // System.out.println(n1.data);
        // System.out.println(n1.next.data);
        // System.out.println(n1.next.next.data);
        // System.out.println(n1.next.next.next.data);
        // System.out.println(n1.next.next.next.next.data);
        

        // Traversing the linked list
        printList(n1); // Passing head node as argument
        // printListRec(n1);


        // Length of linked list
        System.out.println(lengthOfList(n1));

        // Inserting a node at the end if only head is given
        insertAtEnd(n1, 100); // 10->20->30->40->50->100
        printList(n1);

    }

}
