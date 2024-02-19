// Implemention of Singly Linked List

public class SinglyLinkedList {

    // Node class
    public static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }

    // Linked List class
    public static class LinkedList {

        Node head = null;
        Node tail = null;
        int size = 0;


        // Traversing the linked list | TC- O(n) | SC- O(1)
        void printList() { 
            Node curr = head; // Current temp node
            while (curr != null) {
                System.out.print(curr.data + " ");
                curr = curr.next;
            }
            System.out.println(); // New line for next output
        }


        // Size (length) of the linked list
        //  If only head is given - O(n)
        // If linked list class is given - O(1)

        int size() {
            // Node curr = head;
            // int count = 0;
            // while (curr != null) { // O(n)
            //     count++;
            //     curr = curr.next;
            // }
            // return count;
            return size; // O(1)
        }


        // Inserting a node at the end (tail) | TC- O(1) | SC- O(1)
        // If tail is given - O(1)
        // If only head is given - O(n)
        void insertAtEnd(int data) { // TC- O(1) 
            Node newNode = new Node(data);
            if (head == null) { // empty list
                head = newNode;
                tail = newNode;
            } 
            else { // non-empty list
                tail.next = newNode;
                tail = newNode;
            }
            size++;
        }


        // Inserting a node at the beginning (head)
        void insertAtBeginning(int data) { // TC- O(1) | SC- O(1)
            Node newNode = new Node(data);
            if (head == null) { // empty list
                head = newNode;
                tail = newNode;
            } 
            else { // non-empty list
                newNode.next = head;
                head = newNode;
            }
            size++;
        }


        // Inserting a node at a given index (random)
        void insertAtIndex(int idx, int data) { // TC- O(n) | SC- O(1)
            if(idx < 0 || idx > size) { // invalid index
                System.out.println("Invalid index");
                return;
            }

            if(idx == 0) { // insert at the beginning
                insertAtBeginning(data);
                return;
            }

            if(idx == size) { // insert at the end
                insertAtEnd(data);
                return;
            }
            
            Node newNode = new Node(data);
            Node curr = head;
            // Traverse to the node before the index
            for (int i = 0; i < idx - 1; i++) {
                curr = curr.next;
            }
            newNode.next = curr.next;
            curr.next = newNode;
            size++;
        }


        // Deleting a node at the end | TC- O(n) | SC- O(1)
        void deleteAtEnd() {
            if (head == null) { // empty list
                System.out.println("List is empty");
                return;
            }
            if (head.next == null) { // only one node
                head = null;
                tail = null;
                return;
            }
            Node curr = head;
            while (curr.next != tail) {
                curr = curr.next;
            }
            curr.next = null;
            tail = curr;
            size--;
        }


        // Deleting a node at the beginning | TC- O(1) | SC- O(1)
        void deleteAtBeginning() {
            if (head == null) { // empty list
                System.out.println("List is empty");
                return;
            }
            if (head.next == null) { // only one node
                head = null;
                tail = null;
                return;
            }
            head = head.next;
            size--;
        }


        // Deleting a node at a given index (random) | TC- O(n) | SC- O(1)
        void deleteAtIndex(int idx) { 
            if(idx < 0 || idx >= size) { // invalid index
                System.out.println("Invalid index");
                return;
            }

            if(idx == 0) { // delete at the beginning
                deleteAtBeginning();
                return;
            }

            if(idx == size - 1) { // delete at the end
                deleteAtEnd();
                return;
            }

            Node curr = head;
            // Traverse to the node before the index
            for (int i = 0; i < idx - 1; i++) {
                curr = curr.next;
            }
            curr.next = curr.next.next;
            size--;
        }


        // getElemetAtIndex method | TC- O(n) | SC- O(1)
        int getElementAtIndex(int idx) {
            if(idx < 0 || idx >= size) { // invalid index
                System.out.println("Invalid index");
                return -1;
            }
            Node curr = head;
            for (int i = 0; i < idx; i++) {
                curr = curr.next;
            }
            return curr.data;
        }


        // Reverse the linked list | TC- O(n) | SC- O(1)
        void reverseList() {
            Node prev = null;
            Node curr = head;
            Node next = null;
            while (curr != null) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            head = prev;
        }

    }
    
    public static void main(String[] args) {

        // Creating a object of LinkedList class
        LinkedList list = new LinkedList();

        list.insertAtEnd(10); // head node 10
        list.insertAtEnd(20); // 10->20
        list.insertAtEnd(30); // 10->20->30
        // list.printList();

        // System.out.println(list.size);

        list.insertAtBeginning(5); // 5->10->20->30
        // list.printList();

        list.insertAtIndex(2, 15); // 5->10->15->20->30
        // list.printList();

        list.deleteAtEnd(); // 5->10->15->20
        // list.printList();

        list.deleteAtBeginning(); // 10->15->20
        // list.printList();

        list.deleteAtIndex(1); // 10->20
        // list.printList();

        // System.out.println(list.size); // 2

        System.out.println(list.getElementAtIndex(1)); // 20

        list.reverseList(); // 20->10
        list.printList();

    
    }
    
}
