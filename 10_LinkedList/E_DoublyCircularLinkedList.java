public class E_DoublyCircularLinkedList {
    
    // Node class
    public static class Node {
        int data;
        Node next;
        Node prev;
        Node(int data) {
            this.data = data;
        }
    }

    // Linked List class
    public static class CircularDoublyLinkedList {
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

        // Traversing in reverse
        void printListRev() {
            if (tail == null) return;
            Node temp = tail;
            do {
                System.out.print(temp.data + " ");
                temp = temp.prev;
            } while (temp != tail);
            System.out.println(); // New line for next output
        }

        // Insert at the end (tail)
        void insertAtEnd(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                tail = newNode;
                newNode.next = head;
                newNode.prev = tail;
                head.prev = tail;
                tail.next = head;
            } else {
                newNode.next = head;
                newNode.prev = tail;
                tail.next = newNode;
                head.prev = newNode;
                tail = newNode;
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
                newNode.prev = tail;
                head.prev = tail;
                tail.next = head;
            } else {
                newNode.next = head;
                newNode.prev = tail;
                head.prev = newNode;
                tail.next = newNode;
                head = newNode;
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
                Node temp = tail.prev;
                temp.next = head;
                head.prev = temp;
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
                Node temp = head.next;
                temp.prev = tail;
                tail.next = temp;
                head = temp;
            }
            size--;
        }
    }

    public static void main(String[] args) {
        CircularDoublyLinkedList list = new CircularDoublyLinkedList();
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.printList(); // Output: 10 20 30
        list.printListRev(); // Output: 30 20 10
        
        list.insertAtBeginning(5);
        list.printList(); // Output: 5 10 20 30
        list.printListRev(); // Output: 30 20 10 5
        
        list.deleteAtEnd();
        list.printList(); // Output: 5 10 20
        list.printListRev(); // Output: 20 10 5
        
        list.deleteAtBeginning();
        list.printList(); // Output: 10 20
        list.printListRev(); // Output: 20 10
    }
}
