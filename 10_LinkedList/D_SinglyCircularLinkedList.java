// Notes: https://drive.google.com/file/d/1T3B6lzkP0NVxgyF1mgs_Z2HZTzc1CF_j/view

// Circular Linked List - tail points to head

// Singly Circular Linked List - tail.next = head
// Doubly Circular Linked List - tail.next = head | head.prev = tail

// Implementation of Circular Linked List
// Similar to Singly Linked List and Doubly Linked List
// Only difference is that tail.next points to head and head.prev points to tail

public class D_SinglyCircularLinkedList {
    
    // Node class
    public static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }

    // Linked List class
    public static class CircularLinkedList {
        Node head = null;
        Node tail = null;
        int size = 0;

        // Traversing the linked list
        void printList() {
            if (head == null) return;
            Node temp = head;
            do {
                System.out.print(temp.data + " ");
                temp = temp.next;
            } while (temp != head);
            System.out.println(); // New line for next output
        }

        // Insert at the end (tail)
        void insertAtEnd(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                tail = newNode;
                newNode.next = head;
            } else {
                tail.next = newNode;
                tail = newNode;
                tail.next = head;
            }
            size++;
        }

        // Insert at the beginning
        void insertAtBeginning(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                tail = newNode;
                newNode.next = head;
            } else {
                newNode.next = head;
                head = newNode;
                tail.next = head;
            }
            size++;
        }

        // Delete at the end
        void deleteAtEnd() {
            if (head == null) return; // empty list
            if (head.next == head) { // only one node
                head = null;
                tail = null;
            } else {
                Node temp = head;
                while (temp.next != tail) {
                    temp = temp.next;
                }
                temp.next = head;
                tail = temp;
            }
            size--;
        }

        // Delete at the beginning
        void deleteAtBeginning() {
            if (head == null) return; // empty list
            if (head.next == head) { // only one node
                head = null;
                tail = null;
            } else {
                head = head.next;
                tail.next = head;
            }
            size--;
        }
    }

    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.printList(); // Output: 10 20 30
        
        list.insertAtBeginning(5);
        list.printList(); // Output: 5 10 20 30
        
        list.deleteAtEnd();
        list.printList(); // Output: 5 10 20
        
        list.deleteAtBeginning();
        list.printList(); // Output: 10 20
    }
}
