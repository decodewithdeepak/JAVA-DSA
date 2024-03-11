// Notes: https://drive.google.com/file/d/1T3B6lzkP0NVxgyF1mgs_Z2HZTzc1CF_j/view

// Implementation of Doubly Linked List

public class DoublyLinkedList {

    // Node class
    public static class Node {
        int data;
        Node next;
        Node prev;
        Node(int data) {
            this.data = data;
        }
    }

    // Traversing the linked list
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println(); // New line for next output
    }

    // Traversing the linked list in reverse order
    public static void printListRev(Node tail) {
        Node temp = tail;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
        System.out.println();
    }

    // Traversing the linked list with any random node
    public static void printListRandom(Node random) {
        Node temp = random;
        // Move temp backwards to head
        while (temp.prev != null) {
            temp = temp.prev;
        }
        // Print the list from head to tail
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Inserting a node at head (beginning)
    public static Node insertAtHead(Node head, int data) {
        Node newNode = new Node(data);
        if (head == null) return newNode; // If list is empty
        newNode.next = head;
        head.prev = newNode;
        return newNode;
    }

    // Inserting a node at tail (end) 
    // When tail is given - O(1)
    // When only head is given - O(n)

    // public static void insertAtTail(Node tail, int data) { // TC- O(1)
    //     Node newNode = new Node(data);
    //     if (tail == null) return; // If list is empty
    //     tail.next = newNode;
    //     newNode.prev = tail;
    // }

    public static void insertAtTail(Node head, int data) { // TC- O(n)
        Node newNode = new Node(data);
        if (head == null) return; // If list is empty
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
    }

    // Inserting a node at any index
    public static void insertAtIdx(Node head, int data, int idx) {
        if (idx < 0) return;
        if (idx == 0) {
            head = insertAtHead(head, data);
            return;
        }
        if (head == null) return;

        Node newNode = new Node(data);
        Node temp = head;
        for (int i = 0; i < idx-1; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        newNode.prev = temp;
        newNode.next.prev = newNode;
    }

    // Deleting a node at head (beginning)
    public static Node deleteAtHead(Node head) {
        if (head == null || head.next == null) return null; // If list is empty or has only one node
        head = head.next;
        head.prev = null;
        return head;
    }

    // Deleting a node at tail (end)
    // When only head is given - O(n)
    // When tail is given - O(1)

    // public static void deleteAtTail(Node head) {
    //     if (head == null || head.next == null) return; // If list is empty or has only one node
    //     Node temp = head;
    //     while (temp.next.next != null) {
    //         temp = temp.next;
    //     }
    //     temp.next = null;
    // }

    public static void deleteAtTail(Node tail) {
        if (tail == null || tail.prev == null) return; // If list is empty or has only one node
        tail = tail.prev;
        tail.next = null;
    }

    // Deleting a node at any index
    public static void deleteAtIdx(Node head, int idx) {
        if (idx < 0) return;
        if (idx == 0) {
            head = deleteAtHead(head);
            return;
        }
        if (head == null) return;

        Node temp = head;
        for (int i = 0; i < idx-1; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        temp.next.prev = temp;
    }

    public static void main(String[] args) {
    
        // Node class object
        Node a = new Node(10); // Head node
        Node b = new Node(20);
        Node c = new Node(30);
        Node d = new Node(40);
        Node e = new Node(50); // Tail node

        // Linking the nodes 10<->20<->30<->40<->50
        a.next = b; // 10->20
        b.prev = a; // 10<->20
        b.next = c; // 10<->20->30
        c.prev = b; // 10<->20<->30
        c.next = d; // 10<->20<->30->40
        d.prev = c; // 10<->20<->30<->40
        d.next = e; // 10<->20<->30<->40->50
        e.prev = d; // 10<->20<->30<->40<->50

        // Traversing the linked list
        printList(a);

        // Traversing the linked list in reverse order
        printListRev(e);

        // Traversing the linked list with any random node
        printListRandom(c);

        // Inserting a node at head
        // Node newHead = insertAtHead(a, 5); // 5<->10<->20<->30<->40<->50
        // printList(newHead);

        // Inserting a node at tail
        // insertAtTail(e, 55); // 10<->20<->30<->40<->50<->55
        // printList(a);
        // insertAtTail(a, 55); // 10<->20<->30<->40<->50<->55
        // printList(a);

        // Inserting a node at any index
        insertAtIdx(a, 25, 2); // 10<->20<->25<->30<->40<->50
        printList(a);


    }
}
